create table users
(
	user_id serial not null
		constraint users_pkey
			primary key,
	user_name varchar(128) not null,
	password varchar(256) not null,
	name varchar(128),
	email varchar(64),
	date_of_birth timestamp,
	team_id integer
		constraint users_team_id_fk
			references team
)
;

create unique index users_user_id_uindex
	on users (user_id)
;

create unique index users_user_name_uindex
	on users (user_name)
;

