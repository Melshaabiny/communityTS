# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table gadget (
  id                        bigint not null,
  title                     varchar(255),
  body                      varchar(255),
  rating                    bigint,
  category                  varchar(255),
  constraint pk_gadget primary key (id))
;

create table users (
  username                  varchar(255) not null,
  id                        varchar(255),
  name                      varchar(255),
  password_hash             varchar(255),
  constraint pk_users primary key (username))
;

create sequence gadget_seq;

create sequence users_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists gadget;

drop table if exists users;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists gadget_seq;

drop sequence if exists users_seq;

