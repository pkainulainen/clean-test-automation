CREATE TABLE enum_user_account_status(
    id bigserial NOT NULL,
    enum_value text NOT NULL,
    value_description text NOT NULL,
    CONSTRAINT enum_user_account_status_pk PRIMARY KEY (id),
    CONSTRAINT enum_user_account_status_unique UNIQUE (enum_value)
);

CREATE TABLE user_account (
    id bigserial NOT NULL,
    creation_time timestamp with time zone NOT NULL DEFAULT now(),
    email_address text NOT NULL,
    modification_time timestamp with time zone NOT NULL DEFAULT now(),
    name text NOT NULL,
    password text NOT NULL,
    status text NOT NULL,
    version bigint NOT NULL DEFAULT 0,
    CONSTRAINT user_account_pk PRIMARY KEY (id),
    CONSTRAINT user_account_status_fk FOREIGN KEY (status) REFERENCES enum_user_account_status(enum_value)
);