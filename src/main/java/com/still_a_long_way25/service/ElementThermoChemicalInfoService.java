package com.still_a_long_way25.service;

import com.still_a_long_way25.entity.ElementThermoChemicalDataInfoEntity;

import java.util.List;

/**
 * Created by y-ok on 2017/05/01.
 */
public interface ElementThermoChemicalInfoService {
    List<ElementThermoChemicalDataInfoEntity> getElementThermoChemicalDetailInfo(Long id);
}
