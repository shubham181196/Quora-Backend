package com.example.quoraApp.Repository;

import com.example.CentralRepository.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<Users, UUID> {
    @Query("SELECT u FROM Users u WHERE u.id IN :userIds")
    List<Users> findUsersByUserIds(List<UUID> userIds);
}