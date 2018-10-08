create table personal_info
(
	id serial not null
		constraint personal_info_pkey
			primary key,
	user_id integer not null
		constraint personal_info_users_user_id_fk
			references users,
	photo varchar,
	about varchar
)
;

alter table personal_info owner to postgres
;

create unique index personal_info_id_uindex
	on personal_info (id)
;

INSERT INTO public.roles (role_id, role_name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO public.roles (role_id, role_name) VALUES (2, 'ROLE_USER');
INSERT INTO public.roles (role_id, role_name) VALUES (3, 'ROLE_KAPPER');