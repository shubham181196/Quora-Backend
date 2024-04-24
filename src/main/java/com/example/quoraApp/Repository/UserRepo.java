package com.example.quoraApp.Repository;

import com.example.quoraApp.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {

}