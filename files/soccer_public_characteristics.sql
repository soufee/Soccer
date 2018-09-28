create table characteristics
(
	id serial not null
		constraint characteristics_pkey
			primary key,
	speed integer,
	strength integer,
	major_foot varchar(5),
	pick_skills integer,
	kick_power integer,
	kick_accuracy integer,
	pass_accuracy integer
)
;

create unique index characteristics_id_uindex
	on characteristics (id)
;

