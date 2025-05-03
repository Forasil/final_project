-- create-currency-table.sql
CREATE TABLE currency (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    base_currency TEXT NOT NULL,
    price_change_range TEXT NOT NULL,
    description TEXT NOT NULL
);