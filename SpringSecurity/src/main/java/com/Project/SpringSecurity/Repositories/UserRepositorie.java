package com.Project.SpringSecurity.Repositories;

import com.Project.SpringSecurity.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositorie extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
