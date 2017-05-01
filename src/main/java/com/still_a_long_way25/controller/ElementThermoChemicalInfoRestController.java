package com.still_a_long_way25.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.still_a_long_way25.entity.ElementThermoChemicalDataInfoEntity;
import com.still_a_long_way25.entity.ElementView;
import com.still_a_long_way25.service.ElementThermoChemicalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 元素熱化学情報RESTコントローラクラス
 * Created by y-ok on 2017/05/01.
 */
@RestController
public class ElementThermoChemicalInfoRestController {

    @Autowired
    ElementThermoChemicalInfoService elementThermoChemicalDataInfoService;

    /**
     * 元素熱化学情報をJSON形式で取得します
     * @param id
     * @return
     */
    @JsonView(ElementView.class)
    @RequestMapping(value = "/data/thermochemical-data/{id}", method = RequestMethod.GET)
    public List<ElementThermoChemicalDataInfoEntity> getElementThermoChemicalInfo(@PathVariable Long id) {
        return elementThermoChemicalDataInfoService.getElementThermoChemicalDetailInfo(id);
    }
}
