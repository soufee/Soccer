create table league
(
	id serial not null
		constraint league_pkey
			primary key,
	country_id integer not null,
	team_capacity integer,
	name_of_league varchar(256) not null
)
;

create unique index league_id_uindex
	on league (id)
;



INSERT INTO public.league (id, country_id, team_capacity, name_of_league) VALUES (0, 1, 20, 'Primera');