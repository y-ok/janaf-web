package com.still_a_long_way25.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "element_detail_info")
@ToString(exclude = "elementThermoChemicalDataList")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementDetailInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column(name = "casNumber", length = 50, nullable = false)
	@JsonProperty("casNumber")
	private String casNumber;

	@Column(name = "formula", length = 10, nullable = false)
	@JsonProperty("formula")
	private String formula;

	@Column(name = "name", length = 30, nullable = false)
	@JsonProperty("name")
	private String name;

	@Column(name = "state", length = 30, nullable = false)
	@JsonProperty("state")
	private String state;

	@Column(name = "JANAFTableUrl", length = 300, nullable = false)
	@JsonProperty("JANAFTableUrl")
	private String JANAFTableUrl;

	@OneToMany(mappedBy = "elementDetailInfo")
	private List<ElementThermoChemicalDataInfo> elementThermoChemicalDataList;

	@Column(name = "update_time", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_time;
}
