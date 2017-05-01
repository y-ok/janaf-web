package com.still_a_long_way25.service;

import com.still_a_long_way25.entity.ElementDetailInfoEntity;
import com.still_a_long_way25.repository.ElementManageInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by y-ok on 2017/05/01.
 */
@Service("elementDetailInfoService")
public class ElementDetailInfoServiceImpl implements ElementDetailInfoService {

    @Autowired
    ElementManageInfoRepository elementManageInfoRepository;

    @Override
    public List<ElementDetailInfoEntity> getElementDetailInfo(Long id) {
        return elementManageInfoRepository.findOne(id)
                                          .getElementDetailInfoEntityList();
    }

}
