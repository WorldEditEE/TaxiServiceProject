package ru.digitalleague.taxi_company.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.digitalleague.taxi_company.api.OrderService;
import ru.digitalleague.taxi_company.model.Order;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.RateOrder;

@RestController
public class TaxiController {

    @Autowired
    OrderService orderService;

    @PostMapping("/receive")
    public ResponseEntity<String> receive(@RequestBody OrderDetails orderDetails){

        String driverName = orderService.findDriver(orderDetails);

        return ResponseEntity.ok("Ваш водитель - " + driverName);
    }

    @PostMapping("/start-trip")
    @ApiOperation(value = "Контроллер для начала поездки")
    public ResponseEntity<String> startTrip(@RequestBody Order order){

        String startTrip = orderService.startTrip(order);

        return ResponseEntity.ok(startTrip);
    }

    @PostMapping("/end-trip")
    @ApiOperation(value = "Контроллер для завершения поездки")
    public ResponseEntity<String> endTrip(@RequestBody Order order){

        String endTrip = orderService.endTrip(order);

        return ResponseEntity.ok(endTrip);
    }

    @PostMapping("/rate-driver")
    @ApiOperation(value = "Контроллер для оценки поездки клиентом")
    public ResponseEntity<String> rateDriver(@RequestBody RateOrder rateOrder){


        if(rateOrder.getRating() >= 1 && rateOrder.getRating() <= 5){
            int rate = orderService.rateOrder(rateOrder);
            return ResponseEntity.ok("Ваша оценка - " + rate );

        }else{
            return ResponseEntity.ok("Некорректная оценка! Вы должны использовать число из диапазона (1-5)");
        }

    }

}
