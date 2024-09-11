package com.example.quoraApp.Service;


import com.example.CentralRepository.models.Like;
import com.example.CentralRepository.models.LikedEntityType;
import com.example.CentralRepository.models.Users;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public interface likeService {
    String saveLike(LikedEntityType like, UUID id, UUID userId);
    String deleteLike(LikedEntityType liketype, UUID id, UUID userId);
    Optional<Like> findLike(Users user, LikedEntityType liketype , UUID id);
}
