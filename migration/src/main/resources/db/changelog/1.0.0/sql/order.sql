CREATE SEQUENCE if not exists order_seq
    start 1;

CREATE TABLE IF NOT EXISTS orders
(
    order_id bigint NOT NULL default nextval('order_seq' :: regclass),
    client_number bigint,
    driver_id bigint NOT NULL,
    start_trip timestamp,
    end_trip timestamp,
    CONSTRAINT order_pk PRIMARY KEY (order_id)
);

ALTER TABLE orders
    add CONSTRAINT order_driver_id_fk FOREIGN KEY (driver_id)
    REFERENCES taxi_drive_info (driver_id);

comment on table orders is 'Заказы';
comment on column orders.order_id is 'Идентификатор заказа';
comment on column orders.client_number is 'Идентификатор клиента';
comment on column orders.driver_id is 'Идентификатор водителя';
comment on column orders.start_trip is 'Время начало поездки';
comment on column orders.end_trip is 'Время завершения поездки';