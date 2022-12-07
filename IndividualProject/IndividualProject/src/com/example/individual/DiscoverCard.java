package com.example.individual;

public class DiscoverCard extends CreditCard{

    public DiscoverCard(String cardNumber) {
        super.number=cardNumber;
    }

    @Override
    public String toString() {
        return "DiscoverCard ["+super.number+"]";
    }

}