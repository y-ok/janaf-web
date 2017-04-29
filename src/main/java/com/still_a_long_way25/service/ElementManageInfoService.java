package com.still_a_long_way25.service;

import com.still_a_long_way25.entity.ElementDetailInfoEntity;
import com.still_a_long_way25.entity.ElementManageInfoEntity;
import com.still_a_long_way25.entity.ElementThermoChemicalDataInfoEntity;
import com.still_a_long_way25.repository.ElementDetailInfoRepository;
import com.still_a_long_way25.repository.ElementManageInfoRepository;
import com.still_a_long_way25.repository.ElementThermoChemicalDataInfoRepository;
import com.still_a_long_way25.util.JsonParserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

/**
 * Created by y-ok on 2017/04/23.
 */
@Service
public class ElementManageInfoService {

    private static String PATH = "/Users/okawauchi/Documents/workspace/janaf-chemicaldata-crawler/output/json/chemical_element_info.json";

    @Autowired
    ElementManageInfoRepository elementManageInfoRepository;

    @Autowired
    ElementDetailInfoRepository elementDetailInfoRepository;

    @Autowired
    ElementThermoChemicalDataInfoRepository elementThermoChemicalDataInfoRepository;

    /**
     * @throws IOException
     */
    public void register() throws IOException {
        JsonParserUtil jsonParserUtil = new JsonParserUtil();
        List<ElementManageInfoEntity> elementManageInfoEntityList = jsonParserUtil.parser(PATH);

        for (ElementManageInfoEntity elementManageInfoEntity : elementManageInfoEntityList) {
            elementManageInfoRepository.save(elementManageInfoEntity);

            List<ElementDetailInfoEntity> elementDetailInfoEntityList = elementManageInfoEntity.getElementDetailInfoEntityList();
            for (ElementDetailInfoEntity elementDetailInfoEntity : elementDetailInfoEntityList) {
                saveElementDetailInfoWithElementManageInfo(elementManageInfoEntity, elementDetailInfoEntity);

                List<ElementThermoChemicalDataInfoEntity> elementThermoChemicalDataInfoEntityList = elementDetailInfoEntity
                        .getElementThermoChemicalDataInfoEntityList();
                for (ElementThermoChemicalDataInfoEntity elementThermoChemicalDataInfoEntity : elementThermoChemicalDataInfoEntityList) {
                    saveElementThermoChemicalDataInfoWithElementDetailInfo(elementThermoChemicalDataInfoEntity, elementDetailInfoEntity);
                }
            }
        }
    }

    /**
     * @param elementManageInfoEntity
     * @param elementDetailInfoEntity
     */
    @Transactional
    private void saveElementDetailInfoWithElementManageInfo(ElementManageInfoEntity elementManageInfoEntity,
                                                            ElementDetailInfoEntity elementDetailInfoEntity) {
        elementDetailInfoEntity.setElementManageInfoEntity(elementManageInfoEntity);
        elementDetailInfoRepository.save(elementDetailInfoEntity);
    }


    /**
     * @param elementThermoChemicalDataInfoEntity
     * @param elementDetailInfoEntity
     */
    @Transactional
    private void saveElementThermoChemicalDataInfoWithElementDetailInfo(ElementThermoChemicalDataInfoEntity elementThermoChemicalDataInfoEntity,
                                                                        ElementDetailInfoEntity elementDetailInfoEntity) {
        elementThermoChemicalDataInfoEntity.setElementDetailInfoEntity(elementDetailInfoEntity);
        elementThermoChemicalDataInfoRepository.save(elementThermoChemicalDataInfoEntity);
    }
}
