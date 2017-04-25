create table element_detail_info
(
	element_detail_info_id bigint not null auto_increment
		primary key,
	janaftable_url longtext not null,
	cas_number varchar(50) not null,
	formula varchar(10) not null,
	name varchar(30) not null,
	state varchar(30) not null,
	update_time timestamp default CURRENT_TIMESTAMP not null,
	id bigint null,
	constraint FKop0do0y0dhif0ug2nn89k5p3o
		foreign key (id) references janaf.element_manage_info (id)
)
;

create index FKop0do0y0dhif0ug2nn89k5p3o
	on element_detail_info (id)
;

