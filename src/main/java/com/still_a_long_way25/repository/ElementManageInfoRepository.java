package com.still_a_long_way25.repository;

import com.still_a_long_way25.entity.ElementManageInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 元素管理情報リポジトリクラス
 * Created by y-ok on 2017/05/01.
 */
public interface ElementManageInfoRepository extends JpaRepository<ElementManageInfoEntity, Long> {
}
