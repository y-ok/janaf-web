package com.still_a_long_way25.authentification.service;

import com.still_a_long_way25.authentification.entity.LoginUser;
import com.still_a_long_way25.authentification.form.LoginUserCreateForm;
import com.still_a_long_way25.authentification.repository.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by y-ok on 2017/05/02.
 */
@Service
public class LoginUserServiceImpl implements LoginUserService {

    private final LoginUserRepository loginUserRepository;

    @Autowired
    public LoginUserServiceImpl(LoginUserRepository userRepository) {
        this.loginUserRepository = userRepository;
    }

    @Override
    public Optional<LoginUser> getUserById(long id) {
        return Optional.ofNullable(loginUserRepository.findOne(id));
    }

    @Override
    public Optional<LoginUser> getUserByEmail(String email) {
        return loginUserRepository.findOneByEmail(email);
    }

    @Override
    public Collection<LoginUser> getAllUsers() {
        return loginUserRepository.findAll(new Sort("email"));
    }

    @Override
    public LoginUser create(LoginUserCreateForm form) {
        LoginUser user = new LoginUser();
        user.setEmail(form.getEmail());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(form.getRole());
        return loginUserRepository.save(user);
    }
}
