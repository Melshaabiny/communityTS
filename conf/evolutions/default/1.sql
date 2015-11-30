# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table users (
  username                  varchar(255) not null,
  id                        varchar(255),
  name                      varchar(255),
  password_hash             varchar(255),
  constraint pk_users primary key (username))
;


# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists users;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists users_seq;

drop table if exists users cascade;

