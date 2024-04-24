package com.example.quoraApp.Service;

import com.example.quoraApp.Entities.LikedEntityType;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface likeService {
    public String saveLike(LikedEntityType like, UUID id, UUID userId);
}
