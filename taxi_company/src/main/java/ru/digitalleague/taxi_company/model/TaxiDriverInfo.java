package ru.digitalleague.taxi_company.model;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@ApiModel(value = "Модель водителя")
public class TaxiDriverInfo {


    private Long driverId;

    /**
     * Фамилия.
     */
    private String lastName;

    /**
     * Имя.
     */
    private String firstName;

    /**
     * Уровень.
     */
    private int level;

    /**
     * Модель авто (должна быть ENUM).
     */
    private String carModel;

    /**
     * Дата создания.
     */
    private Date createDttm;

    private int city_id;

    private boolean isFree;

    private int minuteCost;

    private int rating;

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Date getCreateDttm() {
        return createDttm;
    }

    public void setCreateDttm(Date createDttm) {
        this.createDttm = createDttm;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public int getMinuteCost() {
        return minuteCost;
    }

    public void setMinuteCost(int minuteCost) {
        this.minuteCost = minuteCost;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public TaxiDriverInfo() {
    }

    public TaxiDriverInfo(Long driverId, String lastName, String firstName, int level, String carModel, Date createDttm, int city_id, boolean isFree, int minuteCost, int rating) {
        this.driverId = driverId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.level = level;
        this.carModel = carModel;
        this.createDttm = createDttm;
        this.city_id = city_id;
        this.isFree = isFree;
        this.minuteCost = minuteCost;
        this.rating = rating;
    }
}
