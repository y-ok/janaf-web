package com.still_a_long_way25.authentification.repository;

import com.still_a_long_way25.authentification.entity.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by y-ok on 2017/05/02.
 */
public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {
    Optional<LoginUser> findOneByEmail(String email);
}
