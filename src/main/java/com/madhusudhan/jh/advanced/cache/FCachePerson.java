package com.madhusudhan.jh.advanced.cache;

// the first level caching, which available during the lifespan of that session
// or in the conversations only. This caching is provided by default by the framework
public class FCachePerson {
    private int id;
    private String firstName = null;
    private String lastName = null;
    private String nickName = null;

    public FCachePerson() {
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
