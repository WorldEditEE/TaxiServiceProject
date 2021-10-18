package ru.digitalleague.core.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.digitalleague.core.api.TaxiService;
import ru.digitalleague.core.model.OrderDetails;

@RestController
public class OrderController {

    @Autowired
    private TaxiService taxiService;

    @PostMapping("/order-taxi")
    public ResponseEntity<String> receive(@RequestBody OrderDetails orderDetails){

        System.out.println(orderDetails.getClientNumber());
        String result = taxiService.notifyTaxi(orderDetails);

        return ResponseEntity.ok(result);
    }

}
