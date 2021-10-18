package ru.digitalleague.taxi_company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitalleague.taxi_company.api.OrderService;
import ru.digitalleague.taxi_company.mapper.DriverInfoMapper;
import ru.digitalleague.taxi_company.mapper.OrderMapper;
import ru.digitalleague.taxi_company.model.Order;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.TaxiDriverInfo;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    DriverInfoMapper driverMapper;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public String findDriver(OrderDetails orderDetails) {

        long cityID = driverMapper.getCityID(orderDetails.getCity());
        TaxiDriverInfo driver = driverMapper.findDriver(cityID, orderDetails.getLevel());
        String driverName = driverMapper.getDriverName(driver.getDriverId());

        orderMapper.makeOrder(orderDetails.getClientNumber(),driver.getDriverId());


        return driverName;
    }
}
