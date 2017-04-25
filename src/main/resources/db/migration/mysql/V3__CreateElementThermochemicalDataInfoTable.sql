create table element_thermochemical_data_info
(
	element_thermo_chemical_data_info_id bigint not null auto_increment
		primary key,
	enthalpy varchar(20) not null,
	entropy varchar(20) not null,
	gibbs varchar(20) not null,
	specific_heat varchar(20) not null,
	temperature varchar(20) not null,
	update_time timestamp default CURRENT_TIMESTAMP not null,
	element_detail_info_id bigint null,
	constraint FK4mn3rmfecj49nx7eist0ggh4y
		foreign key (element_detail_info_id) references janaf.element_detail_info (element_detail_info_id)
)
;

create index FK4mn3rmfecj49nx7eist0ggh4y
	on element_thermochemical_data_info (element_detail_info_id)
;

