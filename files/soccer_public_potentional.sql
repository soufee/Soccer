create table potentional
(
	id serial not null
		constraint potentional_pkey
			primary key,
	pot_tobe_star integer,
	age_to_finish integer
)
;

create unique index potentional_id_uindex
	on potentional (id)
;

