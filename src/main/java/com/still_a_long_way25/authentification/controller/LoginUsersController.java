package com.still_a_long_way25.authentification.controller;

import com.still_a_long_way25.authentification.service.LoginUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by y-ok on 2017/05/02.
 */
@Controller
public class LoginUsersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginUsersController.class);
    private final LoginUserService loginUserService;

    @Autowired
    public LoginUsersController(LoginUserService loginUserService) {
        this.loginUserService = loginUserService;
    }

    @RequestMapping("/users")
    public ModelAndView getUsersPage() {
        LOGGER.debug("Getting users page");
        return new ModelAndView("users", "users", loginUserService.getAllUsers());
    }

}
