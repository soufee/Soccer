create table team
(
	id serial not null
		constraint team_pkey
			primary key,
	name varchar(128) not null,
	city varchar(128),
	country varchar(64),
	league_id integer
		constraint team_league_id_fk
			references league
)
;

create unique index team_id_uindex
	on team (id)
;


INSERT INTO public.team (name, city, country, league_id) VALUES ('Barselona FC', 'Barselona', 'Spain', 0);
INSERT INTO public.team (name, city, country, league_id) VALUES ('Real Madrid', 'Madrid', 'Spain', 0);
INSERT INTO public.team (name, city, country, league_id) VALUES ('Atletico Madrid', 'Madrid', 'Spain', 0);
INSERT INTO public.team (name, city, country, league_id) VALUES ('Sevilla FC', 'Sevilla', 'Spain', 0);
COMMIT ;