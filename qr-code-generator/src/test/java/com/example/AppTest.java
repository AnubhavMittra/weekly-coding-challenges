package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static com.example.utils.TextEncodingDetectionUtils.detectTextMode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.example.domain.Modes;
import com.example.exceptions.InvalidInputException;

public class AppTest 
{
    @ParameterizedTest
    @ValueSource(strings = {"1", "12345678901234567890", "2147483647"})
    public void shouldDetectNumericModeCorrectlyForValidNumericTextInput(String inputText) {
        assertEquals(Modes.NUMERIC, detectTextMode(inputText));
    }

    @ParameterizedTest
    @ValueSource(strings = { "-1", "12.34", "null", "1.23e4", "-2147483648", "   12353342545 ", "+12389734", "ABcd09", "$09", "£143234", "Äã", "日"})
    public void shouldDetectNumericModeCorrectlyForInvalidNumericTextInput(String inputText) {
        assertNotEquals(Modes.NUMERIC, detectTextMode(inputText));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12345678901234567890", "2147483647"})
    public void shouldDetectAlphanumericModeCorrectlyForValidNumericTextInput(String inputText) {
        assertEquals(Modes.ALPHANUMERIC, detectTextMode(inputText));
    }

    @ParameterizedTest
    @ValueSource(strings = { "-1", "12.34", "null", "1.23e4", "-2147483648", "   12353342545 ", "+12389734", "ABcd09", "$09", "£143234", "Äã", "日"})
    public void shouldDetectAlphanumericModeCorrectlyForInvalidNumericTextInput(String inputText) {
        assertNotEquals(Modes.ALPHANUMERIC, detectTextMode(inputText));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12345678901234567890", "2147483647"})
    public void shouldDetectByteModeCorrectlyForValidNumericTextInput(String inputText) {
        assertEquals(Modes.BYTE, detectTextMode(inputText));
    }

    @ParameterizedTest
    @ValueSource(strings = { "-1", "12.34", "null", "1.23e4", "-2147483648", "   12353342545 ", "+12389734", "ABcd09", "$09", "£143234", "Äã", "日"})
    public void shouldDetectByteModeCorrectlyForInvalidNumericTextInput(String inputText) {
        assertNotEquals(Modes.BYTE, detectTextMode(inputText));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12345678901234567890", "2147483647"})
    public void shouldDetectKanjiModeCorrectlyForValidNumericTextInput(String inputText) {
        assertEquals(Modes.KANJI, detectTextMode(inputText));
    }

    @ParameterizedTest
    @ValueSource(strings = { "-1", "12.34", "null", "1.23e4", "-2147483648", "   12353342545 ", "+12389734", "ABcd09", "$09", "£143234", "Äã", "日"})
    public void shouldDetectKanjiModeCorrectlyForInvalidNumericTextInput(String inputText) {
        assertNotEquals(Modes.KANJI, detectTextMode(inputText));
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    public void shouldDetectInvalidTextInput(String inputText) {
        assertThrows(InvalidInputException.class, () -> detectTextMode(inputText), "Invalid Text Input");
    }
}
