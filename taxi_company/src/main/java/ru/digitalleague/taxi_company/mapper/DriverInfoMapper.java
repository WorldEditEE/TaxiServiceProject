package ru.digitalleague.taxi_company.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import ru.digitalleague.taxi_company.model.Order;
import ru.digitalleague.taxi_company.model.TaxiDriverInfo;

@Repository
@Mapper
public interface DriverInfoMapper {

    @Results(id = "drivers", value = {
            @Result(property = "driverId", column = "driver_id"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "level", column = "level"),
            @Result(property = "carModel", column = "car_model"),
            @Result(property = "createDttm", column = "create_dttm"),
            @Result(property = "city_id", column = "city_id"),
            @Result(property = "isFree", column = "is_free"),
            @Result(property = "minuteCost", column = "minute_cost"),
            @Result(property = "rating", column = "rating"),
    })
    @Select("SELECT driver_id, last_name, first_name, level, car_model, create_dttm, city_id, is_free, minute_cost, rating " +
            "FROM test.taxi_drive_info WHERE city_id=#{cityID} AND level=#{level} AND is_free=true" +
            " order by rating desc limit 1")
    TaxiDriverInfo findDriver(long cityID, int level);

    @Select("SELECT last_name FROM test.taxi_drive_info WHERE driver_id=#{driverID}")
    String getDriverName(long driverID);

    @Select("SELECT city_id FROM test.city_queue WHERE name=#{city}")
    int getCityID(String city);

    @Update("UPDATE test.taxi_drive_info SET is_free=false WHERE driver_id=#{driverID}")
    void setBusy(long driverID);

    @Update("UPDATE test.taxi_drive_info SET is_free=true WHERE driver_id=#{driverID}")
    void setFree(long driverID);

    @Results(id = "driver", value = {
            @Result(property = "driverId", column = "driver_id"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "level", column = "level"),
            @Result(property = "carModel", column = "car_model"),
            @Result(property = "createDttm", column = "create_dttm"),
            @Result(property = "city_id", column = "city_id"),
            @Result(property = "isFree", column = "is_free"),
            @Result(property = "minuteCost", column = "minute_cost"),
            @Result(property = "rating", column = "rating"),
    })
    @Select("SELECT driver_id, last_name, first_name, level, car_model, create_dttm, city_id, is_free, minute_cost, rating " +
            "FROM test.taxi_drive_info WHERE driver_id=#{driverID}")
    TaxiDriverInfo findDriverById(long driverID);

    @Update("UPDATE test.taxi_drive_info SET rating=#{AVGRating}")
    void updateRating(int AVGRating);

}
