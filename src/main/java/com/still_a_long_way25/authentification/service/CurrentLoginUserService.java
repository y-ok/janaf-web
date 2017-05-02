package com.still_a_long_way25.authentification.service;

import com.still_a_long_way25.authentification.entity.CurrentLoginUser;

/**
 * Created by y-ok on 2017/05/03.
 */
public interface CurrentLoginUserService {

    boolean canAccessUser(CurrentLoginUser currentLoginUser, Long userId);

}
