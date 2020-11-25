package com.dkit.sd2a.jessicasavage;

public class RaspberryPi extends Computer{
    private int gpioPins;
    private int sdStorage;

    public RaspberryPi(String manufacturer, String processor, int ramSize, int diskSize, int weight, String assetTag, String purchaseDate, int gpioPins, int sdStorage) {
        super(manufacturer, processor, ramSize, diskSize, weight, assetTag, purchaseDate);
        this.gpioPins = gpioPins;
        this.sdStorage = sdStorage;
    }

    public int getGpioPins() {
        return gpioPins;
    }

    public int getSdStorage() {
        return sdStorage;
    }

    @Override
    public String toString() {
        return "RaspberryPi{" +
                super.toString() +
                "gpioPins=" + gpioPins +
                ", sdStorage=" + sdStorage +
                '}';
    }
}
