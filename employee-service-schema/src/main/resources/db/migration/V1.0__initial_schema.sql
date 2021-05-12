CREATE TABLE IF NOT EXISTS EMPLOYEE
(
    id          NUMERIC NOT NULL,
    name        VARCHAR(255),
    last_name    VARCHAR(255),
    phone       VARCHAR(15),
    address     VARCHAR(255),
    email       VARCHAR(100),
    CONSTRAINT employee_pk PRIMARY KEY (id)
    );

CREATE SEQUENCE employee_seq START 1 INCREMENT BY 1;
