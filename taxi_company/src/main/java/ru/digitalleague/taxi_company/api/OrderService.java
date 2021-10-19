package ru.digitalleague.taxi_company.api;

import ru.digitalleague.taxi_company.model.Order;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.RateOrder;

public interface OrderService {

    String findDriver(OrderDetails orderDetails);

    String startTrip(Order order);

    String endTrip(Order order);

    int rateOrder(RateOrder rateOrder);
}
