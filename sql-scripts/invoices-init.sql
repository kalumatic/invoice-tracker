USE invoice_tracker;

DROP TABLE IF EXISTS invoices;

CREATE TABLE invoices (
	invoice_id int NOT NULL AUTO_INCREMENT,
    username varchar(50) NOT NULL,
    goods varchar(100) NOT NULL,
    amount double,
    invoice_date date NOT NULL,
    price double NOT NULL,
    PRIMARY KEY (invoice_id)
) ENGINE = InnoDB DEFAULT CHARSET = latin1;

INSERT INTO invoices
VALUES
	(1, 'nikola', 'creation of website', 2, '2023-02-01', 499.99),
    (2, 'tara', 'legal services', 1, '2023-02-01', 699.99),
    (3, 'tara', 'website maintenance', 1, '2023-02-01', 199.99),
    (4, 'nikola', 'legal services', 3, '2023-02-01', 459.99),
    (5, 'nikola', 'apartment painting', 1, '2023-02-01', 79.99),
    (6, 'tara', 'marketing consulting services', 1, '2023-02-01', 499.99)