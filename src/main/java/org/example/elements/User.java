package org.example.elements;

public class User {

    private String name;
    private Integer cardNumber;

    public User(String name, int cardNumber){
        this.name = name;
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString(){
        return "User{" +
                "Name='" + name + '\'' +
                ", Card Number='" + cardNumber + '\'' +
                '}';
    }

}
