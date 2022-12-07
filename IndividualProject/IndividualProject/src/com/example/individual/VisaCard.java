package com.example.individual;

public class VisaCard extends CreditCard {

    public VisaCard(String cardNumber) {
        super.number = cardNumber;
    }

    @Override
    public String toString() {
        return "VisaCard ["+super.number+"]";
    }

}

