package com.example.quoraApp.Controller;

import com.example.quoraApp.DTOS.RequestDTO;
import com.example.quoraApp.Entities.LikedEntityType;
import com.example.quoraApp.Service.likeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/{type}/{id}/likes")
    public ResponseEntity<?>saveLike(@RequestBody RequestDTO requestDTO, @PathVariable LikedEntityType type, @PathVariable UUID id){

        String resp=null;
        if(requestDTO.getUserId()!=null) resp=likeservice.saveLike(type,id,requestDTO.getUserId());
        if(resp!=null){
            return ResponseEntity.ok(resp);
        }
        return ResponseEntity.status(400).body("Bad Request");
    }


}
