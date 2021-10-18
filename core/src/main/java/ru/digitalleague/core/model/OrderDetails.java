package ru.digitalleague.core.model;

import lombok.*;

public class OrderDetails {

    private String clientNumber;

    public OrderDetails(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    public OrderDetails() {
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }
}
