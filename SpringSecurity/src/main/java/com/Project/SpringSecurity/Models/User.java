package com.Project.SpringSecurity.Models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "Users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="Users_rols",
            joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
    )
    private Collection<Rol> rols;

    public User() {
    }

    public User(String name, String lastname, String email, String password, Collection<Rol> rols) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.rols = rols;
    }

    public User(Long id, String name, String lastname, String email, String password, Collection<Rol> rols) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.rols = rols;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Rol> getRols() {
        return rols;
    }

    public void setRols(Collection<Rol> rols) {
        this.rols = rols;
    }
}
