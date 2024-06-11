CREATE TABLE IF NOT EXISTS products(
    id UUID PRIMARY KEY NOT NULL DEFAULT(gen_random_uuid()),
    description character varying(255) NOT NULL,
    image_url character varying(255),
    price double precision NOT NULL
);