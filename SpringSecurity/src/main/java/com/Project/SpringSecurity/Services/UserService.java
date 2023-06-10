package com.Project.SpringSecurity.Services;

import com.Project.SpringSecurity.Dto.UserRegisterDto;
import com.Project.SpringSecurity.Models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService extends UserDetailsService {
    public User save(UserRegisterDto userRegisterDto);
    public List<User> ListUsers();


}
