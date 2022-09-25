create table person
(
    id          bigint not null,
    --
    first_name  text   not null,
    second_name text   not null,
    middle_name text,


    primary key (id)
)

create table address
(
    id        bigint not null,
    person_id bigint not null,
    --
    country   text   not null,
    region    text   not null,
    city      text   not null,
    street    text   not null,
    building  text   not null,

    primary key (id)
);

create table contact
(
    id        bigint not null,
    person_id bigint not null,
    --
    phone     text   not null,
    email     text   not null,

    primary key (id)
);

create table document
(
    id            bigint not null,
    person_id     bigint not null,
    --
    document_type text   not null,

    primary key (id)
);