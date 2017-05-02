package com.still_a_long_way25.authentification.service;

import com.still_a_long_way25.authentification.entity.CurrentLoginUser;
import com.still_a_long_way25.authentification.type.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by y-ok on 2017/05/03.
 */
@Service
public class CurrentLoginUserServiceImpl implements CurrentLoginUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentLoginUserDetailsService.class);

    @Override
    public boolean canAccessUser(CurrentLoginUser currentLoginUser, Long userId) {
        LOGGER.debug("Checking if user={} has access to user={}", currentLoginUser, userId);
        return currentLoginUser != null && (currentLoginUser.getRole() == Role.ADMIN || currentLoginUser.getId()
                                                                                                        .equals(userId));
    }
}
