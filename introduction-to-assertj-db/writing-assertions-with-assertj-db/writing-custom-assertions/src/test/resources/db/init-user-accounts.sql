INSERT INTO user_account (
    id,
    creation_time,
    date_of_birth,
    email_address,
    grant_marketing_permission,
    modification_time,
    name,
    password,
    status,
    version
)
VALUES (
    1,
    '2023-05-09 10:46:00+00',
    '2000-01-05',
    'anne.owens@example.com',
    true,
    '2023-05-09 10:46:00+00',
    'Anne Owens',
    '$2a$12$7lPnFLWzaITkzOXHL62AI.NHkkdP52Nbea3HwJMYy2.NUGQAcu9T.',
    'ACTIVE',
    0
);

INSERT INTO user_account (
    id,
    creation_time,
    date_of_birth,
    email_address,
    grant_marketing_permission,
    modification_time,
    name,
    password,
    status,
    version
)
VALUES (
    2,
    '2023-05-10 12:46:00+00',
    null,
    'leo.virtanen@example.com',
    false,
    '2023-05-10 12:46:00+00',
    'Leo Virtanen',
    '$2a$12$bH/96o9j919FaFCe9iN0h.91MyFF5CWlHrhp5YyRepwrRsVeK9uKO',
    'ACTIVE',
    0
);