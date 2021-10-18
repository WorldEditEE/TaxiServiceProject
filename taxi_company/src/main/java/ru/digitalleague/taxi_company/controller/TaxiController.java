package ru.digitalleague.taxi_company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.digitalleague.taxi_company.api.OrderService;
import ru.digitalleague.taxi_company.model.Order;
import ru.digitalleague.taxi_company.model.OrderDetails;

@RestController
public class TaxiController {

    @Autowired
    OrderService orderService;

    @PostMapping("/receive")
    public ResponseEntity<String> receive(@RequestBody OrderDetails orderDetails){

        String driverName = orderService.findDriver(orderDetails);

        return ResponseEntity.ok(driverName);
    }

    @PostMapping("/start-trip")
    public ResponseEntity<String> startTrip(@RequestBody Order order){

        String startTrip = orderService.startTrip(order);

        return ResponseEntity.ok(startTrip);
    }

    @PostMapping("/end-trip")
    public ResponseEntity<String> endTrip(@RequestBody Order order){

        String endTrip = orderService.endTrip(order);

        return ResponseEntity.ok(endTrip);
    }

}
