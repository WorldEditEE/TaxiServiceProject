create sequence if not exists driver_rating_seq
    start 1;

create table if not exists driver_rating
(
    driver_id bigint not null default nextval('driver_rating_seq' :: regclass),
    rating      int not null
);

comment on table driver_rating is 'Сводная информация по рейтингам водителей';
comment on column driver_rating.driver_id is 'Идентификатор водителя';
comment on column driver_rating.rating is 'Рейтинг за поездку';

alter table driver_rating
    add constraint order_id_fk foreign key (driver_id)
        references test.taxi_drive_info (driver_id);