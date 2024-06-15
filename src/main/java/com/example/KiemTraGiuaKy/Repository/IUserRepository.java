package com.example.KiemTraGiuaKy.Repository;

import com.example.KiemTraGiuaKy.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface IUserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}
