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

create sequence gadget_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists gadget;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists gadget_seq;

