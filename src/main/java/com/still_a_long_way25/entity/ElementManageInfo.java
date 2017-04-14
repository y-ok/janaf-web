package com.still_a_long_way25.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@MappedSuperclass
@Table(name = "element_manage_info")
@ToString(exclude = "elementDetailInfoList")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementManageInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column(name = "element_name", length = 50, nullable = false)
	@JsonProperty("element_name")
	private String element_name;

	@Column(name = "element_url", length = 300, nullable = false)
	@JsonProperty("element_url")
	private String element_url;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "elementManageInfo")
	private List<ElementDetailInfo> elementDetailInfoList;

	@Column(name = "update_time", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_time;

}
