package ru.digitalleague.taxi_company.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "Модель сформированного заказа")
public class Order {

    private long orderID;

    private long clientNumber;

    private long driverID;

    private Date startTrip;

    private Date endTrip;

    public Order(long orderID, long clientNumber, long driverID, Date startTrip, Date endTrip) {
        this.orderID = orderID;
        this.clientNumber = clientNumber;
        this.driverID = driverID;
        this.startTrip = startTrip;
        this.endTrip = endTrip;
    }

    public Order() {
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public long getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(long clientNumber) {
        this.clientNumber = clientNumber;
    }

    public long getDriverID() {
        return driverID;
    }

    public void setDriverID(long driverID) {
        this.driverID = driverID;
    }

    public Date getStartTrip() {
        return startTrip;
    }

    public void setStartTrip(Date startTrip) {
        this.startTrip = startTrip;
    }

    public Date getEndTrip() {
        return endTrip;
    }

    public void setEndTrip(Date endTrip) {
        this.endTrip = endTrip;
    }
}
