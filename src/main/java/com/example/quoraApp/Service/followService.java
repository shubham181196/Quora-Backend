package com.example.quoraApp.Service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface followService {
    String saveFollow(UUID userId, UUID targetId);
}
