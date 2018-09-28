create table footbal_player
(
	id serial not null
		constraint footbal_player_pkey
			primary key,
	first_name varchar(180) not null,
	second_name varchar(180),
	team_id integer
		constraint footbal_player_team_id_fk
			references team
				on update cascade on delete cascade,
	characteristics_id integer not null
		constraint footbal_player_characteristics_id_fk
			references characteristics
				on update cascade on delete cascade,
	age integer not null,
	position varchar(32),
	potentional_id integer
		constraint footbal_player_potentional_id_fk
			references potentional,
	history_id integer
		constraint footbal_player_history_id_fk
			references history
)
;

create unique index footbal_player_id_uindex
	on footbal_player (id)
;

