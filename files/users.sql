create table users
(
	user_id serial not null
		constraint users_pkey
		primary key,
	user_name varchar(128),
	password varchar(256) not null,
	name varchar(128),
	email varchar(64),
	date_of_birth timestamp,
	role_id integer not null,
	date_of_registration timestamp,
	isblocked boolean default false,
	currency varchar(3),
	lang varchar(16)
)
;

alter table users owner to postgres
;

create unique index users_user_id_uindex
	on users (user_id)
;

create unique index users_user_name_uindex
	on users (user_name)
;

INSERT INTO public.users (user_id, user_name, password, name, email, date_of_birth, role_id, date_of_registration, isblocked, currency, lang) VALUES (4, 'ulaula', 'ulaula', 'Yulia', 'ula@mail.ru', '1970-01-01 03:00:06.823000', '3', '2018-09-29 14:41:16.956000', false, null, null);
INSERT INTO public.users (user_id, user_name, password, name, email, date_of_birth, role_id, date_of_registration, isblocked, currency, lang) VALUES (2, 'anzor', 'anzor', 'anzor', 'anzor-ass@mail.ru', '1978-07-24 11:42:08.871000', '2', null, false, null, null);
INSERT INTO public.users (user_id, user_name, password, name, email, date_of_birth, role_id, date_of_registration, isblocked, currency, lang) VALUES (3, 'kapper1', 'kapper1', 'kapper1', 'kapper1@mail.ru', '2000-09-29 11:43:03.614000', '3', null, false, null, null);
INSERT INTO public.users (user_id, user_name, password, name, email, date_of_birth, role_id, date_of_registration, isblocked, currency, lang) VALUES (1, 'ashamaz', 'ashamaz', 'ashamaz', 'soufee@mail.ru', '1985-04-29 11:41:14.282000', '1', null, false, null, null);