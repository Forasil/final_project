-- create-currency-table.sql
CREATE TABLE currency (
    id SERIAL PRIMARY KEY,
    code VARCHAR(255) NOT NULL,
    rate NUMERIC(10,4) NOT NULL
);