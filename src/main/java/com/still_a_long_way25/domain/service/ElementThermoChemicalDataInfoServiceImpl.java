package com.still_a_long_way25.domain.service;

import com.still_a_long_way25.domain.entity.ElementThermoChemicalDataInfoEntity;
import com.still_a_long_way25.domain.repository.ElementDetailInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by y-ok on 2017/05/01.
 */
@Service
public class ElementThermoChemicalDataInfoServiceImpl implements ElementThermoChemicalInfoService {

    @Autowired
    ElementDetailInfoRepository elementDetailInfoRepository;

    @Override
    public List<ElementThermoChemicalDataInfoEntity> getElementThermoChemicalDetailInfo(Long id) {
        return elementDetailInfoRepository.findOne(id)
                                          .getElementThermoChemicalDataInfoEntityList();
    }
}
