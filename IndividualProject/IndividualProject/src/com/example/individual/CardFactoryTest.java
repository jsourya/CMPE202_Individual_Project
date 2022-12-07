package com.example.individual;

import org.junit.Before;
import org.junit.Test;

public class CardFactoryTest {

    private CardFactory cardFactoryUnderTest;

    @Before
    public void setUp() {
        cardFactoryUnderTest = new CardFactory();
    }

    @Test
    public void testGetCard() {
        // Setup
        // Run the test
        final CreditCard result = cardFactoryUnderTest.getCard(0, "aCard");

        // Verify the results
    }
}
