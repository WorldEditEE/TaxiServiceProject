package ru.digitalleague.core.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TaxiInfoMapper {

    @Select("SELECT port FROM test.city_queue WHERE name=#{city}")
    int getCityPort(String city);
}
