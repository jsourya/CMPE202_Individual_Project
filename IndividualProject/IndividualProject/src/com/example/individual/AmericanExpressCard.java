package com.example.individual;

public class AmericanExpressCard extends CreditCard {


    public AmericanExpressCard(String cardNumber) {
        super.number = cardNumber;
    }

    @Override
    public String toString() {
        return "AmericanExpressCard ["+super.number+"]";
    }

}