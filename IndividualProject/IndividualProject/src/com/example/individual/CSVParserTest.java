package com.example.individual;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CSVParserTest {

    private CSVParser csvParserUnderTest;

    @Before
    public void setUp() {
        csvParserUnderTest = new CSVParser();
        csvParserUnderTest.tokens = new ArrayList<>(List.of("value"));
    }

    @Test
    public void testParse() {
        // Setup
        // Run the test
        final ArrayList<String> result = csvParserUnderTest.parse("C:/Users/Checkout/Downloads/input_file-1.csv");

        // Verify the results
        assertThat(result).isEqualTo(new ArrayList<>(List.of("value", "5567894523129080",
                "59012345678901234567890",
                "4123456789123",
                "347856341908126",
                "6011111100007756",
                "3601112345678789",
                "5167894523129089",
                "4123456789123999",
                "377856341908126",
                "5367894523129089",
                "",
                "")));
    }

    @Test
    public void testWrite() {
        // Setup
        // Run the test
        csvParserUnderTest.write("file", new ArrayList<>(List.of("value")));

        // Verify the results
    }
}
