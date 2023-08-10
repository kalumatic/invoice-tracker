USE fakturica;

DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;


CREATE TABLE users (
	username varchar(50) NOT NULL,
    password char(68) NOT NULL,
    enabled tinyint NOT NULL,
    PRIMARY KEY (username)
) ENGINE = InnoDB DEFAULT CHARSET = latin1;

INSERT INTO users
VALUES
	('kalu', '{bcrypt}$2a$10$eZxgniGb81UC27ZzQRfk/u7/xWsSevSSoQ3Nr9GiT1lO581oM62Iu', 1),
    ('srki', '{bcrypt}$2a$10$eZxgniGb81UC27ZzQRfk/u7/xWsSevSSoQ3Nr9GiT1lO581oM62Iu', 1),
    ('nikola', '{bcrypt}$2a$10$KvdZlEGktUyFhqLURbR7KOMSVYfB0LS6qQOa5TiG8MzyNTRrXuKs.', 1),
    ('tara', '{bcrypt}$2a$10$KvdZlEGktUyFhqLURbR7KOMSVYfB0LS6qQOa5TiG8MzyNTRrXuKs.', 1);
    

CREATE TABLE authorities (
	username varchar(50) NOT NULL,
    authority varchar(50) NOT NULL,
	UNIQUE KEY authorities4_idx_1 (username, authority),
    CONSTRAINT authorities4_ibfk_1 FOREIGN KEY (username) REFERENCES users (username)
) ENGINE = InnoDB DEFAULT CHARSET = latin1;

INSERT INTO authorities 
VALUES 
	('kalu', 'ROLE_CLIENT'),
    ('kalu', 'ROLE_ADMIN'),
    ('srki', 'ROLE_CLIENT'),
    ('srki', 'ROLE_ADMIN'),
    ('nikola', 'ROLE_CLIENT'),
    ('tara', 'ROLE_CLIENT');
