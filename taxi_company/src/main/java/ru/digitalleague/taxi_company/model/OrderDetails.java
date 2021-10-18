package ru.digitalleague.taxi_company.model;

public class OrderDetails {

    private long clientNumber;

    private int level;

    private String city;

    public OrderDetails(long clientNumber, int level, String city) {
        this.clientNumber = clientNumber;
        this.level = level;
        this.city = city;
    }

    public OrderDetails() {
    }

    public long getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(long clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
