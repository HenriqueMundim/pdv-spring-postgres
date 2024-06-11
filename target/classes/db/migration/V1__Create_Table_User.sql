CREATE TABLE public.users (
    id UUID PRIMARY KEY NOT NULL DEFAULT(gen_random_uuid()),
    username character varying(25) UNIQUE NOT NULL,
    email character varying(255) UNIQUE NOT NULL,
    name character varying(100) NOT NULL,
    password character varying(255) NOT NULL,
    role smallint NOT NULL,
    CONSTRAINT users_role_check CHECK (((role >= 0) AND (role <= 1)))
);

