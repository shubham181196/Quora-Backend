package com.example.quoraApp.Repository;

import com.example.quoraApp.Entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LikeRepo extends JpaRepository<Like, UUID> {
}
