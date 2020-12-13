package com.dkit.sd2a.jessicasavage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Computer {
    private String manufacturer;
    private String processor;
    private double ramSize;
    private double diskSize;
    private double weight;
    private String assetTag;
    private LocalDate purchaseDate;

    public Computer(String manufacturer, String processor, double ramSize, double diskSize, double weight, String assetTag, LocalDate purchaseDate) {
        this.manufacturer = manufacturer;
        this.processor = processor;
        this.ramSize = ramSize;
        this.diskSize = diskSize;
        this.weight = weight;
        this.assetTag = assetTag;
        this.purchaseDate = purchaseDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getProcessor() {
        return processor;
    }

    public double getRamSize() {
        return ramSize;
    }

    public double getDiskSize() {
        return diskSize;
    }

    public double getWeight() {
        return weight;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public LocalDate getPurchaseDate() { return purchaseDate; }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRamSize(double ramSize) {
        this.ramSize = ramSize;
    }

    public void setDiskSize(double diskSize) {
        this.diskSize = diskSize;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "manufacturer='" + manufacturer + '\'' +
                ", processor='" + processor + '\'' +
                ", ramSize=" + ramSize +
                ", diskSize=" + diskSize +
                ", weight=" + weight +
                ", assetTag='" + assetTag + '\'' +
                ", purchaseDate='" + purchaseDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return ramSize == computer.ramSize &&
                diskSize == computer.diskSize &&
                Double.compare(computer.weight, weight) == 0 &&
                Objects.equals(manufacturer, computer.manufacturer) &&
                Objects.equals(processor, computer.processor) &&
                Objects.equals(assetTag, computer.assetTag) &&
                Objects.equals(purchaseDate, computer.purchaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, processor, ramSize, diskSize, weight, assetTag, purchaseDate);
    }
}
