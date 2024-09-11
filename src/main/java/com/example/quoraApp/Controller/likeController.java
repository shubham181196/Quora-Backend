package com.example.quoraApp.Controller;

import com.example.CentralRepository.models.LikedEntityType;
import com.example.quoraApp.DTOS.RequestDTO;
import com.example.quoraApp.Service.likeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class likeController {
    private final likeService likeservice;
    @Autowired
    public likeController(likeService likeservice){
        this.likeservice=likeservice;
    }

    @PostMapping("like/{type}/{id}")
    public ResponseEntity<?>saveLike(@RequestBody RequestDTO requestDTO, @PathVariable String type, @PathVariable UUID id,@RequestParam Boolean likeaction){

        String resp=null;
        if(requestDTO.getUserId()!=null) {
            try{
                LikedEntityType likedEntityType=LikedEntityType.valueOf(type);
                if(likeaction){
                    resp=likeservice.saveLike(likedEntityType,id,requestDTO.getUserId());
                }else{

                    resp=likeservice.deleteLike(likedEntityType,id,requestDTO.getUserId());
                }

                return ResponseEntity.ok(resp);
            }catch(RuntimeException e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(type + " is already liked by user" );
            }

        }

        return ResponseEntity.status(400).body("Bad Request");
    }


}
