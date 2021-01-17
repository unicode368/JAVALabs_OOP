create function check_role(p_input text)
  returns boolean
as
$$
declare
  l_allowed text[] := array['reader', 'librarian', 'admin'];
begin
  if p_input = any(l_allowed) then 
    return true;
  end if;
  raise 'The only allowed values are: %', array_to_string(l_allowed, ', ');
end;
$$
language plpgsql
immutable;

CREATE TABLE users (
	id SERIAL PRIMARY KEY NOT NULL,
    login varchar(255) NOT NULL,
    password varchar(255),
	role varchar(255) CHECK(check_role(role)),
	blocked boolean
);

TRUNCATE TABLE users;

SELECT * FROM users;

INSERT INTO users (login, password, role, blocked) VALUES
('admin', 'admin', 'admin', false),
('reader', 'reader', 'reader', false),
('librarian', 'librarian', 'librarian', false)

UPDATE users SET id=10000+nextval('users_id_seq');

ALTER SEQUENCE users_id_seq RESTART WITH 1;

UPDATE users SET id=nextval('users_id_seq');