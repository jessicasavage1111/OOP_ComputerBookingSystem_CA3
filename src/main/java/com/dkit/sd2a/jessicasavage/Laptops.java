package com.dkit.sd2a.jessicasavage;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Laptops extends Computer{
    private int screenSize;
    private int batteryLife;

    public Laptops(String manufacturer, String processor, double ramSize, double diskSize, double weight, String assetTag, LocalDate purchaseDate, int screenSize, int batteryLife) {
        super(manufacturer, processor, ramSize, diskSize, weight, assetTag, purchaseDate);
        this.screenSize = screenSize;
        this.batteryLife = batteryLife;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    @Override
    public String toString() {
        return "Laptops{" +
                super.toString() +
                "screenSize=" + screenSize +
                ", batteryLife=" + batteryLife +
                '}';
    }
}
