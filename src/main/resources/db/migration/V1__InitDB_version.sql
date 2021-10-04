create table if not exists t_advertiser (
    id  bigserial not null,
    advertiser_name varchar(255),
    phone_number varchar(255),
    primary key (id));

create table if not exists t_advertiser_company (
        id  bigserial not null,
        link_for_presentation varchar(255),
        advertiser_id int8,
        primary key (id));

create table if not exists t_campaigns (
    id  bigserial not null,
    campaigns_name varchar(255),
    language varchar(255),
    link_on_photo varchar(255),
    location varchar(255),
    target_countries varchar(255),
    is_delete boolean default false,
    advertiser_id int8,
    primary key (id));


create table if not exists t_role (
    id int8 not null,
    name varchar(255),
    primary key (id));

create table if not exists t_user (
    id  bigserial not null,
    password varchar(255),
    username varchar(255),
    primary key (id));

create table if not exists t_user_roles (
    user_id int8 not null,
    roles_id int8 not null,
    primary key (user_id, roles_id));


alter table if exists t_advertiser_company
        add constraint FKb7wck4lotjfw915aodi639kxb foreign key (advertiser_id) references t_advertiser;
alter table if exists t_campaigns
        add constraint FK3jmrpqidm7x6rhp0d8fo0kxxs foreign key (advertiser_id) references t_advertiser;
alter table if exists t_user_roles
        add constraint FKj47yp3hhtsoajht9793tbdrp4 foreign key (roles_id) references t_role;
alter table if exists t_user_roles
        add constraint FKpqntgokae5e703qb206xvfdk3 foreign key (user_id) references t_user;
