package com.example.individual;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmericanExpressCardTest {

    private AmericanExpressCard americanExpressCardUnderTest;

    @Before
    public void setUp() {
        americanExpressCardUnderTest = new AmericanExpressCard("123");
    }

    @Test
    public void testToString() {
        assertThat(americanExpressCardUnderTest.toString()).isEqualTo("AmericanExpressCard [123]");
    }
}
