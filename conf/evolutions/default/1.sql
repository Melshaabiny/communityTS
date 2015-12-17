# --- Created by Ebean DDL
# --- To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table gadget (
  id                        bigserial not null,
  title                     varchar(255),
  body                      varchar(255),
  rating                    bigint,
  comment                   bigint,
  category                  varchar(255),
  tooltype_id               bigint,
  constraint pk_gadget primary key (id))
;

create table tool_type (
  id                        bigserial not null,
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

alter table gadget add constraint fk_gadget_tooltype_1 foreign key (tooltype_id) references tool_type (id);
create index ix_gadget_tooltype_1 on gadget (tooltype_id);



# --- !Downs

drop table if exists gadget cascade;

drop table if exists tool_type cascade;

drop table if exists users cascade;

