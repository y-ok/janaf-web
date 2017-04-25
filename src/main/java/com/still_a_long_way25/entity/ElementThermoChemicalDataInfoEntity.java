package com.still_a_long_way25.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
	@JsonIgnore
	public Long element_thermo_chemical_data_info_id;

	@Column(name = "temperature", length = 20, nullable = false)
	@JsonProperty("temperature")
	public String temperature;

	@Column(name = "specificHeat", length = 20, nullable = false)
	@JsonProperty("specificHeat")
	public String specificHeat;

	@Column(name = "entropy", length = 20, nullable = false)
	@JsonProperty("entropy")
	public String entropy;

	@Column(name = "gibbs", length = 20, nullable = false)
	@JsonProperty("gibbs")
	public String gibbs;

	@Column(name = "enthalpy", length = 20, nullable = false)
	@JsonProperty("enthalpy")
	public String enthalpy;

	@ManyToOne
	@JoinColumn(name = "element_detail_info_id")
	@JsonIgnore
	public ElementDetailInfoEntity elementDetailInfoEntity;

	@Column(name = "update_time", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	public Date update_time;
}
