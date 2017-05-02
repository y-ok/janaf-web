package com.still_a_long_way25.domain.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.still_a_long_way25.domain.entity.ElementManageInfoEntity;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Jsonパーサーユーティリティクラス
 * <p>
 * Created by y-ok on 2017/04/23.
 */
public class JsonParserUtil {

    /**
     *
     * Jsonファイルをパースします
     *
     * @param path
     * @return
     * @throws IOException
     */
    public List<ElementManageInfoEntity> parser(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(new File(path), new TypeReference<List<ElementManageInfoEntity>>() {
        });
    }
}
