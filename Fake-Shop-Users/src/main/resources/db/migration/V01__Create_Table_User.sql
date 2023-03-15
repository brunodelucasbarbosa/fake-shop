CREATE TABLE public.users (
                       id SERIAL PRIMARY KEY,
                       full_name TEXT NOT NULL,
                       email TEXT UNIQUE NOT NULL,
                       password TEXT NOT NULL,
                       tax_id character varying(14) UNIQUE NOT NULL,
                       phone character varying(11) UNIQUE NOT NULL,
                       cep character varying(8) NOT NULL
);