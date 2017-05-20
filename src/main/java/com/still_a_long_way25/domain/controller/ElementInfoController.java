package com.still_a_long_way25.domain.controller;

import com.still_a_long_way25.domain.service.ElementManageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

/**
 * 元素情報コントローラクラス
 * Created by y-ok on 2017/04/23.
 */
@Controller
public class ElementInfoController {

    @Autowired
    ElementManageInfoService elementManageInfoService;

    /**
     * @return
     */
    @RequestMapping(value = "/elements", method = RequestMethod.GET)
    public String index() {
        return "elements";
    }

    /**
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/element", method = RequestMethod.GET)
    public String element(@RequestParam(value = "id") String id, Model model) {
        model.addAttribute("id", id);
        return "element";
    }

    /**
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/thermochemical-data", method = RequestMethod.GET)
    public String thermochemicalData(@RequestParam(value = "id") String id, Model model) {
        model.addAttribute("id", id);
        return "thermochemical-data";
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

    /**
     * フォーム画面を表示します
     *
     * @return
     */
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form() {
        return "form";
    }
}
