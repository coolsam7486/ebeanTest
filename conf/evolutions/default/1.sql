# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table bi_app (
  app_id                    bigserial not null,
  app_name                  varchar(255),
  company_company_id        bigint,
  constraint pk_bi_app primary key (app_id))
;

create table bi_company (
  company_id                bigserial not null,
  company_name              varchar(255),
  constraint pk_bi_company primary key (company_id))
;

create table bi_groups (
  group_id                  bigserial not null,
  group_name                varchar(255),
  constraint pk_bi_groups primary key (group_id))
;

create table bi_query_groups (
  id                        bigserial not null,
  query_id_query_id         bigint,
  app_id_app_id             bigint,
  group_id_group_id         bigint,
  constraint pk_bi_query_groups primary key (id))
;

create table queryObjects (
  query_id                  bigserial not null,
  app_app_id                bigint,
  chart_type                varchar(255),
  query_title               varchar(255),
  query_desc                varchar(255),
  query_text                varchar(5000),
  constraint uq_queryObjects_1 unique (app_app_id,chart_type,query_title,query_desc,query_text),
  constraint pk_queryObjects primary key (query_id))
;

create table bi_users (
  user_id                   bigserial not null,
  user_name                 varchar(255),
  email                     varchar(255),
  pass_word                 varchar(255),
  constraint uq_bi_users_email unique (email),
  constraint pk_bi_users primary key (user_id))
;


create table bi_users_groups (
  bi_users_user_id               bigint not null,
  bi_groups_group_id             bigint not null,
  constraint pk_bi_users_groups primary key (bi_users_user_id, bi_groups_group_id))
;

create table bi_users_company (
  bi_users_user_id               bigint not null,
  bi_company_company_id          bigint not null,
  constraint pk_bi_users_company primary key (bi_users_user_id, bi_company_company_id))
;

create table bi_users_app (
  bi_users_user_id               bigint not null,
  bi_app_app_id                  bigint not null,
  constraint pk_bi_users_app primary key (bi_users_user_id, bi_app_app_id))
;
alter table bi_app add constraint fk_bi_app_company_1 foreign key (company_company_id) references bi_company (company_id);
create index ix_bi_app_company_1 on bi_app (company_company_id);
alter table bi_query_groups add constraint fk_bi_query_groups_queryId_2 foreign key (query_id_query_id) references queryObjects (query_id);
create index ix_bi_query_groups_queryId_2 on bi_query_groups (query_id_query_id);
alter table bi_query_groups add constraint fk_bi_query_groups_appId_3 foreign key (app_id_app_id) references bi_app (app_id);
create index ix_bi_query_groups_appId_3 on bi_query_groups (app_id_app_id);
alter table bi_query_groups add constraint fk_bi_query_groups_groupId_4 foreign key (group_id_group_id) references bi_groups (group_id);
create index ix_bi_query_groups_groupId_4 on bi_query_groups (group_id_group_id);
alter table queryObjects add constraint fk_queryObjects_app_5 foreign key (app_app_id) references bi_app (app_id);
create index ix_queryObjects_app_5 on queryObjects (app_app_id);



alter table bi_users_groups add constraint fk_bi_users_groups_bi_users_01 foreign key (bi_users_user_id) references bi_users (user_id);

alter table bi_users_groups add constraint fk_bi_users_groups_bi_groups_02 foreign key (bi_groups_group_id) references bi_groups (group_id);

alter table bi_users_company add constraint fk_bi_users_company_bi_users_01 foreign key (bi_users_user_id) references bi_users (user_id);

alter table bi_users_company add constraint fk_bi_users_company_bi_compan_02 foreign key (bi_company_company_id) references bi_company (company_id);

alter table bi_users_app add constraint fk_bi_users_app_bi_users_01 foreign key (bi_users_user_id) references bi_users (user_id);

alter table bi_users_app add constraint fk_bi_users_app_bi_app_02 foreign key (bi_app_app_id) references bi_app (app_id);

# --- !Downs

drop table if exists bi_app cascade;

drop table if exists bi_users_app cascade;

drop table if exists bi_company cascade;

drop table if exists bi_users_company cascade;

drop table if exists bi_groups cascade;

drop table if exists bi_users_groups cascade;

drop table if exists bi_query_groups cascade;

drop table if exists queryObjects cascade;

drop table if exists bi_users cascade;

