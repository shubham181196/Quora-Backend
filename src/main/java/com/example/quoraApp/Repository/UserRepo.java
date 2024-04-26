package com.example.quoraApp.Repository;

import com.example.quoraApp.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {
    @Query("SELECT u FROM User u WHERE u.id IN :userIds")
    List<User> findUsersByUserIds(List<UUID> userIds);
}