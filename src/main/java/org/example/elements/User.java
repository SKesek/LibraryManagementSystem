package org.example.elements;

public class User {

    private String name;
    private Integer userCardNumber;

    public User(String name, Integer cardNumber){
        this.name = name;
        this.userCardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public Integer getUserCardNumber() {
        return userCardNumber;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setUserCardNumber(int userCardNumber) {
        this.userCardNumber = userCardNumber;
    }

    @Override
    public String toString(){
        return "User{" +
                "Name='" + name + '\'' +
                ", Card Number='" + userCardNumber + '\'' +
                '}';
    }

}
