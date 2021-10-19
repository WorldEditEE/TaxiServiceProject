package ru.digitalleague.taxi_company.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DriverRatingMapper {

    @Insert("INSERT INTO test.driver_rating (driver_id, rating) " +
            "VALUES (#{driverID}, #{rating})")
    void rateOrder(long driverID, int rating);

    @Select("SELECT AVG(rating) FROM test.driver_rating WHERE driver_id=#{driverID}")
    int getAVGRating(long driverID);
}
