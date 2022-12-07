package com.example.individual;

public class MasterCard extends CreditCard{


    public MasterCard(String cardNumber) {
        super.number = cardNumber;
    }

    @Override
    public String toString() {
        return "MasterCard ["+super.number+"]";
    }

}