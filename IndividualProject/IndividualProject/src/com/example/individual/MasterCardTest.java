package com.example.individual;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MasterCardTest {

    private MasterCard masterCardUnderTest;

    @Before
    public void setUp() {
        masterCardUnderTest = new MasterCard("cardNumber");
    }

    @Test
    public void testToString() {
        assertThat(masterCardUnderTest.toString()).isEqualTo("MasterCard [cardNumber]");
    }
}
