
create Table products (
    id bigint primary key auto_increment,
    name varchar(255) not null,
    price integer not null,
    description text not null
);

create table variants (
    id bigint primary key auto_increment,
    product_id bigint not null,
    attribute varchar(255) not null,
    value varchar(255) not null,
    foreign key (product_id) references products(id)
);

create table providers (
    id bigint primary key auto_increment,
    name varchar(255) not null
);

create table product_provider (
    id bigint primary key auto_increment,
    product_id bigint not null,
    provider_id bigint not null,
    foreign key (product_id) references products(id),
    foreign key (provider_id) references providers(id)
);