package com.still_a_long_way25.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    //@JsonIgnore
    public Long elementDetailInfoId;

    @Column(name = "casNumber", length = 50, nullable = false)
    @JsonProperty("casNumber")
    public String casNumber;

    @Column(name = "formula", length = 10, nullable = false)
    @JsonProperty("formula")
    public String formula;

    @Column(name = "name", length = 30, nullable = false)
    @JsonProperty("name")
    public String name;

    @Column(name = "state", length = 30, nullable = false)
    @JsonProperty("state")
    public String state;

    @Column(name = "JANAFTableUrl", length = 300, nullable = false)
    @JsonProperty("JANAFTableUrl")
    public String JANAFTableUrl;

    @ManyToOne
    @JoinColumn(name = "id")
    //@JsonIgnore
    public ElementManageInfoEntity elementManageInfoEntity;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "elementDetailInfoEntity")
    @JsonProperty("thermochemicalDataList")
    public List<ElementThermoChemicalDataInfoEntity> elementThermoChemicalDataInfoEntityList;

    @Column(name = "update_time", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    public Date updateTime;
}
