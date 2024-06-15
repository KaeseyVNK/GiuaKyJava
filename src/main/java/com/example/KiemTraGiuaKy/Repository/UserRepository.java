package com.example.KiemTraGiuaKy.Repository;

import com.example.KiemTraGiuaKy.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
