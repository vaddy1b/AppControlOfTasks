create table if not exists user
(
    id int generated by default as identity primary key,
    name varchar(100) not null ,
    email varchar(100) not null unique
);

create table if not exists comments
(
    id     int generated by default as identity primary key,
    text   varchar(255),
    author varchar(100) not null,
    user_id int,
    foreign key (user_id) references user
);

create table if not exists task
(
    id       int generated by default as identity primary key,
    number   varchar(100) not null,
    status   varchar(20)  not null check (status IN ('NOT_SIGNED,FINISHED,IN_PROGRESS,CANCELLED,IMPORTANT')),
    executor boolean      not null default false,
    author   varchar(100) not null,
    user_id int,
    foreign key (user_id) references user
);
