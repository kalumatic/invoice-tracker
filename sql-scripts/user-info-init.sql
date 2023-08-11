USE fakturica;

DROP TABLE IF EXISTS user_info;

CREATE TABLE user_info (
	username varchar(50) NOT NULL,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    PRIMARY KEY (username)
) ENGINE = InnoDB DEFAULT CHARSET = latin1;

INSERT INTO user_info
VALUES 
	('kalu', 'Luka', 'Matic', 'maticluka@gmail.com'),
    ('srki', 'Srdjan', 'Matic', 'srki@gmail.com'),
    ('nikola', 'Nikola', 'Antic', 'antnik@yahoo.com'),
    ('tara', 'Tara', 'Simic', 'tapa@hotmail.com');
    