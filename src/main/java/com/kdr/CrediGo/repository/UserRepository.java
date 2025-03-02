package com.kdr.CrediGo.repository;

import com.kdr.CrediGo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
