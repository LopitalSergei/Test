CREATE TABLE IF NOT EXISTS countries
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(128) NOT NULL,
    country_code VARCHAR(64)  NOT NULL,
    coordinates  VARCHAR(64)  NOT NULL,
    borders      VARCHAR(128) NOT NULL
);