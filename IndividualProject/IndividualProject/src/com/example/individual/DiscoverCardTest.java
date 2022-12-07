package com.example.individual;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscoverCardTest {

    private DiscoverCard discoverCardUnderTest;

    @Before
    public void setUp() {
        discoverCardUnderTest = new DiscoverCard("cardNumber");
    }

    @Test
    public void testToString() {
        assertThat(discoverCardUnderTest.toString()).isEqualTo("DiscoverCard [cardNumber]");
    }
}
