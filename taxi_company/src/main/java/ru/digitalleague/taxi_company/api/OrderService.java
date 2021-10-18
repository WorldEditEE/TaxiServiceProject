package ru.digitalleague.taxi_company.api;

import ru.digitalleague.taxi_company.model.OrderDetails;

public interface OrderService {

    String findDriver(OrderDetails orderDetails);
}
