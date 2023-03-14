CREATE TABLE public.users (
                       id SERIAL PRIMARY KEY,
                       full_name TEXT NOT NULL,
                       email TEXT NOT NULL,
                       password TEXT NOT NULL,
                       tax_id character varying(14) NOT NULL,
                       phone character varying(11) NOT NULL,
                       cep character varying(8) NOT NULL
);