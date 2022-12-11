create table person
(
    id          serial primary key,
    --
    first_name  text not null,
    second_name text not null,
    middle_name text
);

create table address
(
    id                             varchar(255) not null,
    person_registration_address_id int,
    person_residence_address_id    int,
    --
    country                        text not null,
    region                         text not null,
    city                           text not null,
    street                         text not null,
    building                       text not null,

    primary key (id),
    foreign key (person_registration_address_id) references person (id),
    foreign key (person_residence_address_id) references person (id)
);

create table contact
(
    id        serial primary key,
    person_id int  not null,
    --
    phone     text not null,
    email     text not null,

    foreign key (person_id) references person (id)
);

create table document
(
    id            serial primary key,
    person_id     int  not null,
    --
    document_type text not null,

    foreign key (person_id) references person (id)
);