package com.still_a_long_way25.authentification.controller;

import com.still_a_long_way25.authentification.entity.CurrentLoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by y-ok on 2017/05/03.
 */
@ControllerAdvice
public class CurrentLoginUserControllerAdvice {

    @ModelAttribute("currentUser")
    public CurrentLoginUser getCurrentUser(Authentication authentication) {
        return (authentication == null) ? null : (CurrentLoginUser) authentication.getPrincipal();
    }
}
