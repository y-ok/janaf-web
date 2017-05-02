package com.still_a_long_way25.authentification.service;

import com.still_a_long_way25.authentification.entity.CurrentLoginUser;
import com.still_a_long_way25.authentification.entity.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by y-ok on 2017/05/03.
 */
@Service
public class CurrentLoginUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentLoginUserDetailsService.class);
    private final LoginUserService loginUserService;

    @Autowired
    public CurrentLoginUserDetailsService(LoginUserService loginUserService) {
        this.loginUserService = loginUserService;
    }

    @Override
    public CurrentLoginUser loadUserByUsername(String email) throws UsernameNotFoundException {
        LOGGER.debug("Authenticating user with email={}", email.replaceFirst("@.*", "@***"));
        LoginUser user = loginUserService.getUserByEmail(email)
                                         .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)));
        return new CurrentLoginUser(user);
    }

}
