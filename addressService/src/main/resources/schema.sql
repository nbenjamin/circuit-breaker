CREATE TABLE Address
(
    street VARCHAR(100) NOT NULL,
    city VARCHAR(30) DEFAULT NULL,
    state VARCHAR(2) DEFAULT NULL,
    country VARCHAR(2) DEFAULT NULL,
    customerId INTEGER NOT NULL
);