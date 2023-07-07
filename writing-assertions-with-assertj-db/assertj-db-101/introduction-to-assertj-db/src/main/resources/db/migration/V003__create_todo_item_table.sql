CREATE TABLE enum_todo_item_resolution(
    id bigserial NOT NULL,
    enum_value text NOT NULL,
    value_description text NOT NULL,
    CONSTRAINT enum_todo_item_resolution_pk PRIMARY KEY (id),
    CONSTRAINT enum_todo_item_resolution_unique UNIQUE (enum_value)
);

CREATE TABLE enum_todo_item_status(
    id bigserial NOT NULL,
    enum_value text NOT NULL,
    value_description text NOT NULL,
    CONSTRAINT enum_todo_item_status_pk PRIMARY KEY (id),
    CONSTRAINT enum_todo_item_status_unique UNIQUE (enum_value)
);

CREATE TABLE todo_item(
    id bigserial NOT NULL,
    created_by_user_id bigint NOT NULL,
    creation_time timestamp with time zone NOT NULL DEFAULT now(),
    description text NOT NULL,
    modification_time timestamp with time zone NOT NULL DEFAULT now(),
    modified_by_user_id bigint NOT NULL,
    resolution text NOT NULL,
    status text NOT NULL,
    title text NOT NULL,
    version bigint NOT NULL DEFAULT 0,
    CONSTRAINT todo_item_pk PRIMARY KEY (id),
    CONSTRAINT todo_item_created_by_user_fk FOREIGN KEY (created_by_user_id) REFERENCES user_account(id),
    CONSTRAINT todo_item_modified_by_user_fk FOREIGN KEY (modified_by_user_id) REFERENCES user_account(id),
    CONSTRAINT todo_item_resolution_fk FOREIGN KEY (resolution) REFERENCES enum_todo_item_resolution(enum_value),
    CONSTRAINT todo_item_status_fk FOREIGN KEY (status) REFERENCES enum_todo_item_status(enum_value)
);