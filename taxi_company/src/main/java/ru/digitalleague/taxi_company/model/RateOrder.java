package ru.digitalleague.taxi_company.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "Модель оценки заказа")
public class RateOrder {

    private long orderID;

    private int rating;

    public RateOrder(long orderID, int rating) {
        this.orderID = orderID;
        this.rating = rating;
    }

    public RateOrder() {
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
