package com.dkit.sd2a.jessicasavage;

public class Desktop extends Computer{
    private int numOfMonitor;
    private int monitorSize;

    public Desktop(String manufacturer, String processor, int ramSize, int diskSize, int weight, String assetTag, String purchaseDate, int numOfMonitor, int monitorSize) {
        super(manufacturer, processor, ramSize, diskSize, weight, assetTag, purchaseDate);
        this.numOfMonitor = numOfMonitor;
        this.monitorSize = monitorSize;
    }

    public int getNumOfMonitor() {
        return numOfMonitor;
    }

    public int getMonitorSize() {
        return monitorSize;
    }

    @Override
    public String toString() {
        return "Desktop{" +
                super.toString() +
                "numOfMonitor=" + numOfMonitor +
                ", monitorSize=" + monitorSize +
                '}';
    }
}
