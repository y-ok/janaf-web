package com.still_a_long_way25.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.still_a_long_way25.entity.ElementManageInfoEntity;
import com.still_a_long_way25.entity.ElementView;
import com.still_a_long_way25.service.ElementManageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 元素管理情報RESTコントローラクラス
 * Created by y-ok on 2017/04/29.
 */
@RestController
public class ElementManageInfoRestController {

    @Autowired
    ElementManageInfoService elementManageInfoService;

    /**
     * 元素管理情報をJSON形式で取得します
     * @return
     */
    @JsonView(ElementView.class)
    @RequestMapping(value = "/data/elements", method = RequestMethod.GET)
    public List<ElementManageInfoEntity> getAllElements() {
        return elementManageInfoService.getAllElements();
    }
}
