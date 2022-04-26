package com.company;

import java.time.LocalDateTime;

public class getterSetter {
    private int TaxiId;
    private String start;
    private LocalDateTime startTime;
    private int duration;
    private double distance;
    private double price;
    private double tip;
    private String paymentMethod;

    public getterSetter(String s) {
        String[] ride = s.split(";");
        this.TaxiId = Integer.parseInt(ride[0]);
        this.start = ride[1];
        String[] datarow = s.split(";");
        String[] t = datarow[1].split(" ");
        this.startTime = LocalDateTime.of(Integer.parseInt(t[0].split("-")[0]),Integer.parseInt(t[0].split("-")[1]),Integer.parseInt(t[0].split("-")[2]),Integer.parseInt(t[1].split(":")[0]),Integer.parseInt(t[1].split(":")[1]),Integer.parseInt(t[1].split(":")[2]) );
        this.duration = Integer.parseInt(ride[2]);
        this.distance = Double.parseDouble(ride[3].replaceAll(",","."));
        this.price = Double.parseDouble(ride[4].replaceAll(",","."));
        this.tip = Double.parseDouble(ride[5].replaceAll(",","."));
        this.paymentMethod = ride[6];
    }

    public int getTaxiId() {
        return TaxiId;
    }

    public void setTaxiId(int taxiId) {
        this.TaxiId = taxiId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return String.format("Taxi id:%-4d, travel time:%-4d, distance:%-3s, price:%-3s, tip:%-3s, payment:%-11s\n"
                ,TaxiId,duration,distance,price,tip,paymentMethod);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
}
