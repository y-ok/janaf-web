package com.still_a_long_way25.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 元素管理情報エンティティクラス
 */
@Entity
@Table(name = "element_manage_info")
@Data
@NoArgsConstructor
public class ElementManageInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty("id")
    @JsonView(DataTablesOutput.View.class)
    public Long id;

    @Column(name = "element_name", length = 50, nullable = false)
    @JsonProperty("elementName")
    @JsonView(DataTablesOutput.View.class)
    public String elementName;

    @Column(name = "element_url", length = 300, nullable = false)
    @JsonProperty("elementUrl")
    @JsonView(DataTablesOutput.View.class)
    public String elementUrl;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "elementManageInfoEntity")
    @JsonProperty("elementsList")
    public List<ElementDetailInfoEntity> elementDetailInfoEntityList;

    @Column(name = "update_time", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    public Date updateTime;

}