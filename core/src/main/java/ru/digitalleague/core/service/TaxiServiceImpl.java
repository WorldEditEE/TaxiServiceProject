package ru.digitalleague.core.service;

import org.springframework.stereotype.Service;
import ru.digitalleague.core.api.TaxiService;
import ru.digitalleague.core.model.OrderDetails;

@Service
public class TaxiServiceImpl implements TaxiService {
    @Override
    public String notifyTaxi(OrderDetails orderDetails) {
        String number = orderDetails.getClientNumber();
        return number;
    }
}
