CREATE TABLE IF NOT EXISTS orders (
    id character varying(255) PRIMARY KEY NOT NULL,
    date timestamp(6) with time zone NOT NULL,
    total_price double precision NOT NULL,
    user_id character varying(255),
    FOREIGN KEY(user_id) REFERENCES users(id)
);