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

SELECT * FROM books;

CREATE TABLE orders (
	reader_id int NOT NULL,
	librarian_id int NOT NULL,
	book_id int NOT NULL,
	date Date NOT NULL,
	returnDate Date NOT NULL,
	FOREIGN KEY(reader_id) REFERENCES users(id)
	ON DELETE CASCADE,
	FOREIGN KEY(librarian_id) REFERENCES users(id)
	ON DELETE CASCADE,
	FOREIGN KEY(book_id) REFERENCES books(id)
	ON DELETE CASCADE
);

INSERT INTO orders VALUES
(2, 3, 1, TO_DATE('20200119','YYYYMMDD'), TO_DATE('20200124','YYYYMMDD'))

SELECT users.login AS reader_login, t1.login AS 
librarian_login, books.name, books.author, books.edition, 
books.date AS edition_date,
orders.date, orders.returndate FROM orders
JOIN users ON orders.reader_id = users.id
JOIN (SELECT * FROM users) AS t1
ON orders.librarian_id = t1.id
JOIN books ON orders.book_id = books.id

