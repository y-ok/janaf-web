package com.still_a_long_way25.authentification.service;

import com.still_a_long_way25.authentification.entity.LoginUser;
import com.still_a_long_way25.authentification.form.LoginUserCreateForm;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by y-ok on 2017/05/02.
 */
public interface LoginUserService {

    Optional<LoginUser> getUserById(long id);

    Optional<LoginUser> getUserByEmail(String email);

    Collection<LoginUser> getAllUsers();

    LoginUser create(LoginUserCreateForm form);
}
