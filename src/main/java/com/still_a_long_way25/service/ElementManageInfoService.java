package com.still_a_long_way25.service;

import com.still_a_long_way25.entity.ElementManageInfoEntity;

import java.io.IOException;
import java.util.List;

/**
 * Created by y-ok on 2017/04/30.
 */
public interface ElementManageInfoService {

    void register() throws IOException;
    List<ElementManageInfoEntity> getAllElements();
}
