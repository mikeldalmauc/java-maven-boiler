package com.example.model;

import com.example.App;
import com.github.javafaker.Faker;

public class Package {

    private String packageId;
    private String destinationAddress;
    private double weight;
    private double length;
    private double width;
    private double height;

    // Getters and setters for packageId
    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    // Getters and setters for destinationAddress
    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    // Getters and setters for weight
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Getters and setters for length
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    // Getters and setters for width
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // Getters and setters for height
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public static Package createFakePackage(){
        Package p = new Package();

        Faker fake = App.getFaker();

        p.setPackageId(fake.number().digits(15));
        p.setDestinationAddress(fake.address().fullAddress());
        p.setHeight(fake.number().numberBetween(15, 100));
        p.setLength(fake.number().numberBetween(15, 100));
        p.setWidth(fake.number().numberBetween(15, 100));
        p.setWeight(fake.number().numberBetween(500, 100000));

        return p;
    }
}
