package com.example.auth.repositories;

import com.example.auth.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser, Long> {
}
