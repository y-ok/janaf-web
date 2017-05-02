package com.still_a_long_way25.domain.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.still_a_long_way25.domain.entity.ElementDetailInfoEntity;
import com.still_a_long_way25.domain.entity.ElementView;
import com.still_a_long_way25.domain.service.ElementDetailInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 元素詳細情報RESTコントローラクラス
 * Created by y-ok on 2017/05/01.
 */
@RestController
public class ElementDetailInfoRestController {

    @Autowired
    ElementDetailInfoService elementDetailInfoService;

    /**
     * 元素詳細情報をJSON形式で取得します
     * @param id
     * @return
     */
    @JsonView(ElementView.class)
    @RequestMapping(value = "/data/elements/{id}", method = RequestMethod.GET)
    public List<ElementDetailInfoEntity> getElementDetailInfo(@PathVariable Long id) {
        return elementDetailInfoService.getElementDetailInfo(id);
    }
}
