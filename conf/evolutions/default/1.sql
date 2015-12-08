# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table gadget (
  id                        bigint not null,
  title                     varchar(255),
  body                      varchar(255),
  rating                    bigint,
  category                  varchar(255),
  tooltype_id               bigint,
  constraint pk_gadget primary key (id))
;

create table tool_type (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_tool_type primary key (id))
;

create table users (
  username                  varchar(255) not null,
  id                        varchar(255),
  name                      varchar(255),
  password_hash             varchar(255),
  constraint pk_users primary key (username))
;

create sequence gadget_seq;

create sequence tool_type_seq;

create sequence users_seq;

alter table gadget add constraint fk_gadget_tooltype_1 foreign key (tooltype_id) references tool_type (id) on delete restrict on update restrict;
create index ix_gadget_tooltype_1 on gadget (tooltype_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists gadget;

drop table if exists tool_type;

drop table if exists users;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists gadget_seq;

drop sequence if exists tool_type_seq;

drop sequence if exists users_seq;

