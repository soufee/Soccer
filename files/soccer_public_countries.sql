create table countries
(
	id serial not null
		constraint countries_pkey
			primary key,
	country_name varchar(64) not null
)
;

create unique index countries_id_uindex
	on countries (id)
;

create unique index countries_country_name_uindex
	on countries (country_name)
;



INSERT INTO public.countries (id, country_name) VALUES (0, 'Spain');
INSERT INTO public.countries (id, country_name) VALUES (1, 'England');
INSERT INTO public.countries (id, country_name) VALUES (2, 'France');
INSERT INTO public.countries (id, country_name) VALUES (3, 'Germany');
INSERT INTO public.countries (id, country_name) VALUES (4, 'Italy');
INSERT INTO public.countries (id, country_name) VALUES (5, 'Russia');