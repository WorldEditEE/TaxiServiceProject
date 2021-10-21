package ru.digitalleague.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
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

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AmqpTemplate amqpTemplate;

    public TaxiServiceImpl(RestTemplateBuilder RestTemplateBuilder, TaxiInfoMapper taxiInfoMapper) {
        this.restTemplate = RestTemplateBuilder.build();
        this.taxiInfoMapper = taxiInfoMapper;
    }


    @Override
    public String notifyTaxi(OrderDetails orderDetails) {

        String message = null;
        int cityPort = taxiInfoMapper.getCityPort(orderDetails.getCity());
        String cityQueue = taxiInfoMapper.getCityQueue(orderDetails.getCity());


        String url = String.format("http://localhost:%s/receive", cityPort);
//        HttpEntity<OrderDetails> orderDetailsHttpEntity = new HttpEntity<>(orderDetails);

        try {
             message = objectMapper.writeValueAsString(orderDetails);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        amqpTemplate.convertAndSend(cityQueue,message);
//        String driverName = restTemplate.exchange(url, HttpMethod.POST,orderDetailsHttpEntity,String.class).getBody();

        return "Заказ принят";
    }
}
