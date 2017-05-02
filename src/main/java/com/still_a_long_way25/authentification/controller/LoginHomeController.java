package com.still_a_long_way25.authentification.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by y-ok on 2017/05/03.
 */
@Controller
public class LoginHomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginHomeController.class);

    @RequestMapping("/")
    public String getLoginHomePage() {
        LOGGER.debug("Getting Login home page");
        return "login_home";
    }
}
