drop table if exists orders cascade;
drop table if exists visit_feedbacks cascade;
drop table if exists item_feedbacks cascade;
drop table if exists images cascade;
drop table if exists items cascade;
drop table if exists users cascade;
drop table if exists currencies cascade;
drop table if exists faqs cascade;
drop table if exists menus cascade;
create table currencies
(
    id     integer          not null auto_increment,
    name   varchar(255)     not null,
    rate   double precision not null,
    symbol varchar(255)     not null,
    primary key (id)
) engine = InnoDB;
create table faqs
(
    id       integer      not null auto_increment,
    answer   varchar(255) not null,
    question varchar(255) not null,
    primary key (id)
) engine = InnoDB;
create table images
(
    id      integer      not null auto_increment,
    path    varchar(255) not null,
    item_id integer,
    primary key (id)
) engine = InnoDB;
create table item_feedbacks
(
    id      integer  not null auto_increment,
    details longtext not null,
    rating  longblob not null,
    item_id integer,
    user_id integer,
    primary key (id)
) engine = InnoDB;
create table items
(
    id             integer          not null auto_increment,
    average_rating double precision not null,
    base_price     double precision not null,
    details        varchar(255)     not null,
    is_trending    integer          not null,
    name           varchar(255)     not null,
    sale           integer          not null,
    type           varchar(255)     not null,
    menu_id        integer,
    primary key (id)
) engine = InnoDB;
create table menus
(
    id   integer      not null auto_increment,
    name varchar(255) not null,
    primary key (id)
) engine = InnoDB;
create table orders
(
    id      integer      not null auto_increment,
    status  varchar(255) not null,
    item_id integer,
    user_id integer,
    primary key (id)
) engine = InnoDB;
create table users
(
    id         integer      not null auto_increment,
    email      varchar(255) not null,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    password   varchar(255) not null,
    role       varchar(255) not null,
    primary key (id)
) engine = InnoDB;
create table visit_feedbacks
(
    id      integer      not null auto_increment,
    details varchar(255) not null,
    rating  integer      not null,
    user_id integer,
    primary key (id)
) engine = InnoDB;
alter table images
    add constraint FK5yu3ybwgjqqj4s78xyfbr01yu foreign key (item_id) references items (id);
alter table item_feedbacks
    add constraint FKffnxpqf2089omub0m5ldqeeqb foreign key (item_id) references items (id);
alter table item_feedbacks
    add constraint FKjqb9dun9p8306vpw2g22k1shg foreign key (user_id) references users (id);
alter table items
    add constraint FKe4o8dnj04li3jpffup3essh1s foreign key (menu_id) references menus (id);
alter table orders
    add constraint FK247nnxschdfm8lre0ssvy3k1r foreign key (item_id) references items (id);
alter table orders
    add constraint FK32ql8ubntj5uh44ph9659tiih foreign key (user_id) references users (id);
alter table visit_feedbacks
    add constraint FK1d3u7urgovcypx415ynxb1agq foreign key (user_id) references users (id);
