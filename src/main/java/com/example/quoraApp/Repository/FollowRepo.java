package com.example.quoraApp.Repository;

import com.example.quoraApp.Entities.Follow;
import com.example.quoraApp.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FollowRepo extends JpaRepository<Follow, UUID> {
    @Query("SELECT f.follower FROM Follow f WHERE f.follower = :followerId")
    List<UUID> findByFollowerId(UUID followerId);


}
