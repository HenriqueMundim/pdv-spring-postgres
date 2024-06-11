CREATE TABLE IF NOT EXISTS products(
    id UUID PRIMARY KEY NOT NULL,
    description character varying(255) NOT NULL,
    image_url character varying(255),
    price double precision NOT NULL
);