package com.still_a_long_way25.service;

import com.still_a_long_way25.entity.ElementDetailInfoEntity;

import java.util.List;

/**
 * Created by y-ok on 2017/05/01.
 */
public interface ElementDetailInfoService {
    List<ElementDetailInfoEntity> getElementDetailInfo(Long id);
}
