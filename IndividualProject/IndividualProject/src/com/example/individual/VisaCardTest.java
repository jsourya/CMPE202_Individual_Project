package com.example.individual;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VisaCardTest {

    private VisaCard visaCardUnderTest;

    @Before
    public void setUp() {
        visaCardUnderTest = new VisaCard("cardNumber");
    }

    @Test
    public void testToString() {
        assertThat(visaCardUnderTest.toString()).isEqualTo("VisaCard [cardNumber]");
    }
}
