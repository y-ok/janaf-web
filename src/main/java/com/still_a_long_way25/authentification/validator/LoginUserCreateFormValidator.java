package com.still_a_long_way25.authentification.validator;

import com.still_a_long_way25.authentification.form.LoginUserCreateForm;
import com.still_a_long_way25.authentification.service.LoginUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by y-ok on 2017/05/02.
 */
@Component
public class LoginUserCreateFormValidator implements Validator {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginUserCreateFormValidator.class);
    private final LoginUserService loginuserService;

    @Autowired
    public LoginUserCreateFormValidator(LoginUserService loginUserService) {
        this.loginuserService = loginUserService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(LoginUserCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("Validating {}", target);
        LoginUserCreateForm form = (LoginUserCreateForm) target;
        validatePasswords(errors, form);
        validateEmail(errors, form);
    }

    private void validatePasswords(Errors errors, LoginUserCreateForm form) {
        if (!form.getPassword().equals(form.getPasswordRepeated())) {
            errors.reject("password.no_match", "Passwords do not match");
        }
    }

    private void validateEmail(Errors errors, LoginUserCreateForm form) {
        if (loginuserService.getUserByEmail(form.getEmail()).isPresent()) {
            errors.reject("email.exists", "User with this email already exists");
        }
    }
}

