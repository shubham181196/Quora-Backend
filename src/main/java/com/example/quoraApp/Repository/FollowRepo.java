package com.example.quoraApp.Repository;

import com.example.CentralRepository.models.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FollowRepo extends JpaRepository<Follow, UUID> {
    @Query("SELECT f.from FROM Follow f WHERE f.to = :followerId")
    List<UUID> findByFollowerId(UUID followerId);


}
