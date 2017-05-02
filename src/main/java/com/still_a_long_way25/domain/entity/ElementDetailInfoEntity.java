package com.still_a_long_way25.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 元素詳細情報エンティティクラス
 */
@Entity
@Table(name = "element_detail_info")
@Data
@NoArgsConstructor
public class ElementDetailInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "element_detail_info_id")
    @JsonProperty("elementDetailInfoId")
    @JsonView(ElementView.class)
    public Long elementDetailInfoId;

    @Column(name = "casNumber", length = 50, nullable = false)
    @JsonProperty("casNumber")
    @JsonView(ElementView.class)
    public String casNumber;

    @Column(name = "formula", length = 10, nullable = false)
    @JsonProperty("formula")
    @JsonView(ElementView.class)
    public String formula;

    @Column(name = "name", length = 30, nullable = false)
    @JsonProperty("name")
    @JsonView(ElementView.class)
    public String name;

    @Column(name = "state", length = 30, nullable = false)
    @JsonProperty("state")
    @JsonView(ElementView.class)
    public String state;

    @Column(name = "JANAFTableUrl", length = 300, nullable = false)
    @JsonProperty("JANAFTableUrl")
    @JsonView(ElementView.class)
    public String JANAFTableUrl;

    @ManyToOne
    @JoinColumn(name = "id")
    public ElementManageInfoEntity elementManageInfoEntity;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "elementDetailInfoEntity")
    @JsonProperty("thermochemicalDataList")
    public List<ElementThermoChemicalDataInfoEntity> elementThermoChemicalDataInfoEntityList;

    @Column(name = "update_time", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("updateTime")
    @JsonView(ElementView.class)
    public Date updateTime;
}
