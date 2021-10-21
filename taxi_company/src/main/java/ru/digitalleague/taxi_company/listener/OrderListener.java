package ru.digitalleague.taxi_company.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import ru.digitalleague.taxi_company.mapper.CityMapper;
import ru.digitalleague.taxi_company.model.OrderDetails;

import java.io.IOException;

@EnableRabbit
@Component

public class OrderListener {

    private final RestTemplate restTemplate;

    @Autowired
    private CityMapper cityMapper;

    public OrderListener(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @RabbitListener(queues = "${application.broker.receive-queue}")
    public void onMessage(Message message){

        ObjectMapper objectMapper = new ObjectMapper();
        byte[] body = message.getBody();
        try {
            OrderDetails orderDetails = objectMapper.readValue(body, OrderDetails.class);

            if(orderDetails != null){
                int cityPort = cityMapper.getCityPort(orderDetails.getCity());

                String url = String.format("http://localhost:%s/receive", cityPort);

                HttpEntity<OrderDetails> orderDetailsHttpEntity = new HttpEntity<>(orderDetails);
                String driverName = restTemplate.exchange(url, HttpMethod.POST,orderDetailsHttpEntity,String.class).getBody();
                System.out.println(driverName);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
