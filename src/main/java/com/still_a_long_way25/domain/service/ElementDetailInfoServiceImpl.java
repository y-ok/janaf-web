package com.still_a_long_way25.domain.service;

import com.still_a_long_way25.domain.entity.ElementDetailInfoEntity;
import com.still_a_long_way25.domain.repository.ElementManageInfoRepository;
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
