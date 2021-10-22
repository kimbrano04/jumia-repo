DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS country;

CREATE TABLE customer
(
    id    int,
    name  varchar(50),
    phone varchar(50)
);
CREATE TABLE country
(
    id      int,
    country varchar(50),
    code    varchar(10),
    regex   varchar(100)
);
