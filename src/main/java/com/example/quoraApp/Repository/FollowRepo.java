package com.example.quoraApp.Repository;

import com.example.quoraApp.Entities.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Repository
public interface FollowRepo extends JpaRepository<Follow, UUID> {
}
