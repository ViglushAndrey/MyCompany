-- auto-generated definition
create table rental
(
    id                    bigint not null
        constraint rental_pkey
            primary key,
    number_of_rental_days bigint,
    rental_start_date     time
);

alter table rental
    owner to postgres;

-- auto-generated definition
create table sales
(
    id          bigint not null
        constraint sales_pkey
            primary key,
    day_of_sale time
);

alter table sales
    owner to postgres;

-- auto-generated definition
create table auto
(
    id                  bigint not null
        constraint auto_pkey
            primary key,
    body_color          varchar(255),
    body_type           varchar(255),
    fuel_type           varchar(255),
    number_of_doors     varchar(255),
    number_of_seats     varchar(255),
    registration_number varchar(255),
    year_of_the_car     varchar(255),
    rental_id           bigint
        constraint fkkxe46yv3vfhrc8ewhykqlam4n
            references rental,
    sales_id            bigint
        constraint fkgkne05hhjycmvurc6pl0r6i6n
            references sales
);

alter table auto
    owner to postgres;

-- auto-generated definition
create table moto
(
    id                  bigint not null
        constraint moto_pkey
            primary key,
    body_color          varchar(255),
    body_type           varchar(255),
    fuel_type           varchar(255),
    number_of_seats     varchar(255),
    registration_number varchar(255),
    year_of_the_moto    varchar(255),
    rental_id           bigint
        constraint fkis1hmkscwg5ry7kdw30c3se4j
            references rental,
    sales_id            bigint
        constraint fk5n5yuhgiq85paw4kx6g9hcc5o
            references sales
);

alter table moto
    owner to postgres;

-- auto-generated definition
create table clients
(
    id        bigint not null
        constraint clients_pkey
            primary key,
    address   varchar(255),
    name      varchar(255),
    tel       varchar(255),
    auto_id   bigint
        constraint fkctm9ol5aauvfe5vklgcx8pgn7
            references auto,
    moto_id   bigint
        constraint fkgw0k0oehh3htoq0abvf1s1gdm
            references moto,
    rental_id bigint
        constraint fk8w7l3c14umwesv503oialc7xv
            references rental,
    sales_id  bigint
        constraint fkkwkxwsgbps1267ntic0jvgkne
            references sales
);

alter table clients
    owner to postgres;

-- auto-generated definition
create table collaborator
(
    id        bigint not null
        constraint collaborator_pkey
            primary key,
    name      varchar(255),
    position  varchar(255),
    tel       varchar(255),
    auto_id   bigint
        constraint fknvaqg8dqx6rwnrx0ss7oqa30n
            references auto,
    moto_id   bigint
        constraint fkri3jfipd9s3a7m1feu90j9tp
            references moto,
    rental_id bigint
        constraint fk8d5vt0vykc1b8pgwl0kf7untd
            references rental,
    sales_id  bigint
        constraint fkrej1nl1k7n2cg000p7pian6rt
            references sales
);

alter table collaborator
    owner to postgres;

-- auto-generated definition
create table markies
(
    id       bigint not null
        constraint markies_pkey
            primary key,
    car_mark varchar(255),
    auto_id  bigint
        constraint fk763bkk5odmylyv4c3987h73cf
            references auto,
    moto_id  bigint
        constraint fkq0mwdgclotlv3h37lx25ck2dk
            references moto
);

alter table markies
    owner to postgres;

-- auto-generated definition
create table modelies
(
    id        bigint not null
        constraint modelies_pkey
            primary key,
    car_model varchar(255),
    auto_id   bigint
        constraint fkdq1c4p659mk8yq233op70ftm2
            references auto,
    moto_id   bigint
        constraint fk9g81u0h8vt8udxxm2lqpq7qt9
            references moto
);

alter table modelies
    owner to postgres;

