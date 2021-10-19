package ru.digitalleague.taxi_company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitalleague.taxi_company.api.OrderService;
import ru.digitalleague.taxi_company.mapper.DriverInfoMapper;
import ru.digitalleague.taxi_company.mapper.DriverRatingMapper;
import ru.digitalleague.taxi_company.mapper.OrderMapper;
import ru.digitalleague.taxi_company.mapper.OrderTotalMapper;
import ru.digitalleague.taxi_company.model.Order;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.RateOrder;
import ru.digitalleague.taxi_company.model.TaxiDriverInfo;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    DriverInfoMapper driverMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderTotalMapper orderTotalMapper;

    @Autowired
    DriverRatingMapper driverRatingMapper;

    @Override
    public String findDriver(OrderDetails orderDetails) {

        long cityID = driverMapper.getCityID(orderDetails.getCity());
        TaxiDriverInfo driver = driverMapper.findDriver(cityID, orderDetails.getLevel());
        String driverName = driverMapper.getDriverName(driver.getDriverId());

        orderMapper.makeOrder(orderDetails.getClientNumber(),driver.getDriverId());


        return driverName;
    }

    @Override
    public String startTrip(Order order) {

        orderMapper.startTrip(order.getOrderID());
        driverMapper.setBusy(order.getDriverID());

        return "Поездка началась";
    }

    @Override
    public String endTrip(Order order) {

        orderMapper.endTrip(order.getOrderID());
        driverMapper.setFree(order.getDriverID());

        Order totalOrder = orderMapper.getOrderById(order.getOrderID());
        long currentTime = totalOrder.getEndTrip().getTime()-totalOrder.getStartTrip().getTime();

        long totalTime = currentTime / 60000 ;

        TaxiDriverInfo driver = driverMapper.findDriverById(totalOrder.getDriverID());
        int totalSum = Integer.parseInt(String.valueOf(totalTime)) * driver.getMinuteCost();

        orderTotalMapper.addSumTrip(totalSum, totalOrder.getOrderID());

        return "Поездка завершена, цена поездки - " + totalSum;
    }

    @Override
    public int rateOrder(RateOrder rateOrder) {

        Order order = orderMapper.getOrderById(rateOrder.getOrderID());

        driverRatingMapper.rateOrder(order.getDriverID(), rateOrder.getRating());

        int AVGRating = driverRatingMapper.getAVGRating(order.getDriverID());
        driverMapper.updateRating(AVGRating);

        return rateOrder.getRating();
    }
}
