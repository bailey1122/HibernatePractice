package com.madhusudhan.jh.advanced.component;

// components
public class Person {
    private int id;
    private String firstName = null;
    private String nickName = null;
    private String lastName = null;
    // Multiple phone details
    private PhoneNumber homePhone = null;
    private PhoneNumber mobilePhone = null;

    public Person() {
    }

    public Person(String firstName, String nickName, String lastName, PhoneNumber homePhone, PhoneNumber mobilePhone) {
        this.firstName = firstName;
        this.nickName = nickName;
        this.lastName = lastName;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PhoneNumber getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(PhoneNumber homePhone) {
        this.homePhone = homePhone;
    }

    public PhoneNumber getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(PhoneNumber mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}