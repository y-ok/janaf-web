create table element_manage_info
(
	id bigint not null auto_increment
		primary key,
	element_name varchar(50) not null,
	element_url longtext not null,
	update_time timestamp default CURRENT_TIMESTAMP not null
)
;

