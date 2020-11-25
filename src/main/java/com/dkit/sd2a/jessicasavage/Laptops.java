package com.dkit.sd2a.jessicasavage;

public class Laptops extends Computer{
    private int screenSize;
    private int batteryLife;

    public Laptops(String manufacturer, String processor, int ramSize, int diskSize, int weight, String assetTag, String purchaseDate, int screenSize, int batteryLife) {
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
