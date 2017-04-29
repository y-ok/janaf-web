package com.still_a_long_way25.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.still_a_long_way25.entity.ElementManageInfoEntity;
import com.still_a_long_way25.repository.ElementManageInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by y-ok on 2017/04/29.
 */
@RestController
public class ElementManageInfoRestController {

    @Autowired
    private ElementManageInfoRepository elementManageInfoRepository;

    @JsonView(DataTablesOutput.View.class)
    @RequestMapping(value = "/data/elements", method = RequestMethod.GET)
    public DataTablesOutput<ElementManageInfoEntity> getElementManageInfo(@Valid DataTablesInput input) {
        return elementManageInfoRepository.findAll(input);
    }
}
