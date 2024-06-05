CREATE TABLE IF NOT EXISTS users (
    id character varying(255) PRIMARY KEY NOT NULL,
    name character varying(255),
    username character varying(25) UNIQUE NOT NULL,
    email character varying(255) UNIQUE,
    password character varying(255),
    role smallint NOT NULL,
    CONSTRAINT users_role_check CHECK (((role >= 0) AND (role <= 1)))
);
