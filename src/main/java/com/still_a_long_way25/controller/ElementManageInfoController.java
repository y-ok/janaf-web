package com.still_a_long_way25.controller;

import com.still_a_long_way25.service.ElementManageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * 元素管理情報コントローラ
 * Created by y-ok on 2017/04/23.
 */
@Controller
public class ElementManageInfoController {

    @Autowired
    ElementManageInfoService elementManageInfoService;

    /**
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    /**
     * 登録処理を実施します
     *
     * @return regist
     * @throws IOException
     */
    @RequestMapping(value = "/regist", method = RequestMethod.GET)
    public String regist() throws IOException {
        elementManageInfoService.register();
        return "regist";
    }
}
