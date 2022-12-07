package com.example.individual;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JSONParserTest {

    private JSONParser jsonParserUnderTest;

    @Before
    public void setUp() {
        jsonParserUnderTest = new JSONParser();
    }

    @Test
    public void testParse() {
        assertThat(jsonParserUnderTest.parse("C:/Users/Checkout/Downloads/input_file.json")).isEqualTo(new ArrayList<>(List.of("5567894523129089",
                "59012345678901234567890",
                "4123456789123",
                "347856341908126",
                "6011111100007756",
                "3601112345678789",
                "5167894523129089",
                "4123456789123999",
                "377856341908126",
                "5367894523129089",
                "6011*890HJrt6789",
                "")));
           }

    @Test
    public void testWrite() throws Exception {
        // Setup
        // Run the test
        jsonParserUnderTest.write("file", new ArrayList<>(List.of("value, value")));

        // Verify the results
    }

}
