package com.example.foodcurves.brands;

public class BrandsRVModel {
    private int logo1;
    private String brand1;
    private int off1;
    private int upto1;

    private int logo2;
    private String brand2;
    private int off2;
    private int upto2;

    public BrandsRVModel(int logo1, String brand1, int off1, int upto1, int logo2, String brand2, int off2, int upto2) {
        this.logo1 = logo1;
        this.brand1 = brand1;
        this.off1 = off1;
        this.upto1 = upto1;
        this.logo2 = logo2;
        this.brand2 = brand2;
        this.off2 = off2;
        this.upto2 = upto2;
    }

    public int getLogo1() {
        return logo1;
    }

    public String getBrand1() {
        return brand1;
    }

    public int getOff1() {
        return off1;
    }

    public int getUpto1() {
        return upto1;
    }

    public int getLogo2() {
        return logo2;
    }

    public String getBrand2() {
        return brand2;
    }

    public int getOff2() {
        return off2;
    }

    public int getUpto2() {
        return upto2;
    }

    public void setLogo1(int logo1) {
        this.logo1 = logo1;
    }

    public void setBrand1(String brand1) {
        this.brand1 = brand1;
    }

    public void setOff1(int off1) {
        this.off1 = off1;
    }

    public void setUpto1(int upto1) {
        this.upto1 = upto1;
    }

    public void setLogo2(int logo2) {
        this.logo2 = logo2;
    }

    public void setBrand2(String brand2) {
        this.brand2 = brand2;
    }

    public void setOff2(int off2) {
        this.off2 = off2;
    }

    public void setUpto2(int upto2) {
        this.upto2 = upto2;
    }
}
