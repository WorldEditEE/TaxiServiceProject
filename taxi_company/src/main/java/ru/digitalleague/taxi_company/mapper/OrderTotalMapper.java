package ru.digitalleague.taxi_company.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderTotalMapper {

    @Insert("INSERT INTO test.order_total (order_id, sum) " +
            " VALUES (#{orderID}, #{totalSum})")
    void addSumTrip(int totalSum, long orderID);
}
