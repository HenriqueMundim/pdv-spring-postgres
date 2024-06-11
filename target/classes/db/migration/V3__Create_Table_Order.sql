CREATE TABLE IF NOT EXISTS orders (
    id UUID PRIMARY KEY NOT NULL DEFAULT(gen_random_uuid()),
    date timestamp(6) with time zone NOT NULL,
    total_price double precision NOT NULL,
    user_id UUID,
    FOREIGN KEY(user_id) REFERENCES users(id)
);