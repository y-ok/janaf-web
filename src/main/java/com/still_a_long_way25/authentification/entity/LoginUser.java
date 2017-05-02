package com.still_a_long_way25.authentification.entity;

import com.still_a_long_way25.authentification.type.Role;
import lombok.Data;
import javax.persistence.*;

/**
 * Created by y-ok on 2017/05/02.
 */
@Entity
@Table(name = "login_user")
@Data
public class LoginUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    public Long id;

    @Column(name = "email", nullable = false, unique = true)
    public String email;

    @Column(name = "password_hash", nullable = false)
    public String passwordHash;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    public Role role;
}
