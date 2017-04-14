package com.still_a_long_way25.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "element_thermochemical_data_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementThermoChemicalDataInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column(name = "temperature", length = 20, nullable = false)
	@JsonProperty("temperature")
	private String temperature;

	@Column(name = "specificHeat", length = 20, nullable = false)
	@JsonProperty("specificHeat")
	private String specificHeat;

	@Column(name = "entropy", length = 20, nullable = false)
	@JsonProperty("entropy")
	private String entropy;

	@Column(name = "gibbs", length = 20, nullable = false)
	@JsonProperty("gibbs")
	private String gibbs;

	@Column(name = "enthalpy", length = 20, nullable = false)
	@JsonProperty("enthalpy")
	private String enthalpy;

	@Column(name = "update_time", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_time;
}
