package ru.digitalleague.taxi_company.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import ru.digitalleague.taxi_company.model.Order;

@Repository
@Mapper
public interface OrderMapper {

    @Insert("INSERT INTO test.orders (client_number, driver_id) " +
            " VALUES (#{clientNumber}, #{driverId})")
    void makeOrder(long clientNumber, Long driverId);

    @Update("UPDATE test.orders SET start_trip= now() WHERE order_id=#{orderID}")
    void startTrip(long orderID);

    @Update("UPDATE test.orders SET end_trip= now() WHERE order_id=#{orderID}")
    void endTrip(long orderID);

    @Results(id = "orders", value = {
            @Result(property = "orderID", column = "order_id"),
            @Result(property = "clientNumber", column = "client_number"),
            @Result(property = "driverID", column = "driver_id"),
            @Result(property = "startTrip", column = "start_trip"),
            @Result(property = "endTrip", column = "end_trip"),
    })
    @Select("SELECT order_id, client_number, driver_id, start_trip, end_trip FROM orders" +
            " WHERE order_id=#{orderID}")
    Order getOrderById(long orderID);
}
