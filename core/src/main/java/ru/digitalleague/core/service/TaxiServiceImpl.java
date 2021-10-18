package ru.digitalleague.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.digitalleague.core.api.TaxiService;
import ru.digitalleague.core.mapper.TaxiInfoMapper;
import ru.digitalleague.core.model.OrderDetails;

@Service
public class TaxiServiceImpl implements TaxiService {


   private RestTemplate restTemplate;

    private final TaxiInfoMapper taxiInfoMapper;

    public TaxiServiceImpl(RestTemplateBuilder RestTemplateBuilder, TaxiInfoMapper taxiInfoMapper) {
        this.restTemplate = RestTemplateBuilder.build();
        this.taxiInfoMapper = taxiInfoMapper;
    }


    @Override
    public String notifyTaxi(OrderDetails orderDetails) {


        int cityPort = taxiInfoMapper.getCityPort(orderDetails.getCity());

        String url = String.format("http://localhost:%s/receive", cityPort);
        HttpEntity<OrderDetails> orderDetailsHttpEntity = new HttpEntity<>(orderDetails);

        String driverName = restTemplate.exchange(url, HttpMethod.POST,orderDetailsHttpEntity,String.class).getBody();

        return "Заказ принят, ваш водитель - " + driverName;
    }
}
