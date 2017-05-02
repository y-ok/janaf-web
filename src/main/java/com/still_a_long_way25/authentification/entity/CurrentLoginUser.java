package com.still_a_long_way25.authentification.entity;

import com.still_a_long_way25.authentification.type.Role;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * Created by y-ok on 2017/05/03.
 */
public class CurrentLoginUser extends User {

    private LoginUser loginUser;

    public CurrentLoginUser(LoginUser loginUser) {
        super(loginUser.getEmail(), loginUser.getPasswordHash(), AuthorityUtils.createAuthorityList(loginUser.getRole()
                                                                                                             .toString()));
        this.loginUser = loginUser;
    }

    public LoginUser getUser() {
        return loginUser;
    }

    public Long getId() {
        return loginUser.getId();
    }

    public Role getRole() {
        return loginUser.getRole();
    }


}
