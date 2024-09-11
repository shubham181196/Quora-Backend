package com.example.quoraApp.Repository;


import com.example.CentralRepository.models.Like;
import com.example.CentralRepository.models.LikedEntityType;
import com.example.CentralRepository.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface LikeRepo extends JpaRepository<Like, UUID> {
    @Query("SELECT l FROM Like l WHERE l.user = :user AND l.likedEntityId = :id AND l.likedEntityType = :likeenum")
    Optional<Like> findLike(@Param("user") Users user, @Param("likeenum") LikedEntityType like, @Param("id") UUID id);

}
