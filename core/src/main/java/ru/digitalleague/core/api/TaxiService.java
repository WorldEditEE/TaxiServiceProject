package ru.digitalleague.core.api;

import ru.digitalleague.core.model.OrderDetails;

public interface TaxiService {

    String notifyTaxi(OrderDetails orderDetails);

}
