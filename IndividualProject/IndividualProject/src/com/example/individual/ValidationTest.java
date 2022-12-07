package com.example.individual;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {

    @Test
    public void testValidCC() throws Exception {
        assertThat(Validation.validCC("number")).isFalse();
        ;
    }

    @Test
    public void testGetCardID() {
        assertThat(Validation.getCardID("number")).isEqualTo(-1);
    }

    @Test
    public void testIsNumber() {
        assertThat(Validation.isNumber("n")).isFalse();
    }

    @Test
    public void testGetCardName() {
        assertThat(Validation.getCardName(0)).isEqualTo("Visa");
    }

    @Test
    public void testValidCCNumber() {
        assertThat(Validation.validCCNumber("n")).isFalse();
    }

    @Test
    public void testMain() throws Exception {
        // Setup
        // Run the test
        Validation.main(new String[]{"args"});

        // Verify the results
    }

}
