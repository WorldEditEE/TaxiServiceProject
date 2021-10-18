package ru.digitalleague.taxi_company.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
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
}
