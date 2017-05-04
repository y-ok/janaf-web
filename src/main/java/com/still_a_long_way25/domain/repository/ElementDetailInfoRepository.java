package com.still_a_long_way25.domain.repository;

import com.still_a_long_way25.domain.entity.ElementDetailInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 元素詳細情報リポジトリクラス
 * Created by y-ok on 2017/05/01.
 */
@Repository
public interface ElementDetailInfoRepository extends JpaRepository<ElementDetailInfoEntity, Long> {
}
