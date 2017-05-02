package com.still_a_long_way25.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 元素熱化学詳細情報エンティティクラス
 */
@Entity
@Table(name = "element_thermochemical_data_info")
@Data
@NoArgsConstructor
public class ElementThermoChemicalDataInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "element_thermo_chemical_data_info_id")
    @JsonProperty("elementThermoChemicalDataInfoId")
    @JsonView(ElementView.class)
    public Long elementThermoChemicalDataInfoId;

    @Column(name = "temperature", length = 20, nullable = false)
    @JsonProperty("temperature")
    @JsonView(ElementView.class)
    public String temperature;

    @Column(name = "specificHeat", length = 20, nullable = false)
    @JsonProperty("specificHeat")
    @JsonView(ElementView.class)
    public String specificHeat;

    @Column(name = "entropy", length = 20, nullable = false)
    @JsonProperty("entropy")
    @JsonView(ElementView.class)
    public String entropy;

    @Column(name = "gibbs", length = 20, nullable = false)
    @JsonProperty("gibbs")
    @JsonView(ElementView.class)
    public String gibbs;

    @Column(name = "enthalpy", length = 20, nullable = false)
    @JsonProperty("enthalpy")
    @JsonView(ElementView.class)
    public String enthalpy;

    @ManyToOne
    @JoinColumn(name = "element_detail_info_id")
    public ElementDetailInfoEntity elementDetailInfoEntity;

    @Column(name = "update_time", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("updateTime")
    @JsonView(ElementView.class)
    public Date updateTime;
}
