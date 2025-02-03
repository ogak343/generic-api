CREATE TABLE language
(
    id          BIGSERIAL PRIMARY KEY,
    code        VARCHAR(5) UNIQUE,
    description VARCHAR(30)
);

CREATE TABLE category
(
    id    BIGSERIAL PRIMARY KEY,
    name  VARCHAR(50) NOT NULL,
    title JSONB
);

CREATE TABLE company
(
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    title       JSONB,
    category_id BIGINT      NOT NULL
);

CREATE TABLE service
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(50) NOT NULL,
    title      JSONB       NOT NULL,
    company_id BIGINT      NOT NULL
);

CREATE TABLE request_field
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(50) NOT NULL,
    title      JSONB       NOT NULL,
    service_id BIGINT      NOT NULL,
    key        VARCHAR(30) NOT NULL,
    pattern    VARCHAR(50) NOT NULL
);