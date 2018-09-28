create table history
(
	id serial not null
		constraint history_pkey
			primary key,
	player_id integer,
	changes varchar
)
;

create unique index history_id_uindex
	on history (id)
;

