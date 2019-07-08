package com.madhusudhan.jh.advanced.component;

// components
public class PhoneNumber {
    // Phone details
    private int areaCode = 0;
    private int phoneNumber = 0;
    private String name = null;

    public PhoneNumber() {
    }

    public PhoneNumber(int areaCode, int phoneNumber, String name) {
        this.areaCode = areaCode;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
