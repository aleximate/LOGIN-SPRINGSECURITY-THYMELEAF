package com.Project.SpringSecurity.Services;

import com.Project.SpringSecurity.Dto.UserRegisterDto;
import com.Project.SpringSecurity.Models.Rol;
import com.Project.SpringSecurity.Models.User;
import com.Project.SpringSecurity.Repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private UserRepositorie userRepositorie;

    public UserServiceImpl(UserRepositorie userRepositorie) {
        this.userRepositorie = userRepositorie;
    }

    @Override
    public User save(UserRegisterDto userRegisterDto) {
        User user= new User(userRegisterDto.getName(),userRegisterDto.getLastname(),
                userRegisterDto.getEmail(),passwordEncoder.encode(userRegisterDto.getPassword()), Arrays.asList(new Rol("ROLE_USER")));
        return userRepositorie.save(user);
    }

    @Override
    public List<User> ListUsers() {
        return userRepositorie.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepositorie.findByEmail(username);
        if(user==null){
            throw new UsernameNotFoundException("USER OR PASSWORD INVALID");
        }
        return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),mapAuthoritiesRols(user.getRols()));
    }

    private Collection<? extends GrantedAuthority> mapAuthoritiesRols(Collection<Rol> rols){
        return rols.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
