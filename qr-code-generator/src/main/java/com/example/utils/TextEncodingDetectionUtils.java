package com.example.utils;

import com.example.domain.Modes;
import com.example.exceptions.InvalidModeException;

/*
 * https://stackoverflow.com/questions/19899554/unicode-range-for-japanese#:~:text=To%20summarize%20the%20ranges%3A%201%20Japanese-style%20punctuation%20%28,Common%20and%20uncommon%20kanji%20%28%204e00%20-%209faf%29
 * https://segno.readthedocs.io/en/latest/qrcode-modes.html
 */

public class TextEncodingDetectionUtils {
    private static final String NUMERIC_TEXT_PATTERN = "\\d+";
    private static final String ALPHANUMERIC_TEXT_PATTERN = "[A-Za-z0-9 $%*+-./:]+";
    private static final String BYTE_TEXT_PATTERN = "[\\u0020-\\u007E\\u00A0-\\u00FF]+";
    private static final String KANJI_TEXT_PATTERN = "[\\u3400-\\u4DB5\\u4E00-\\u9FCB\\uF900-\\uFA6A]"; //"[\\x00-\\x7F\\xA1-\\xDF]|[\\x81-\\x9F\\xE0-\\xEF][\\x40-\\x7E\\x80-\\xFC]+";

    private static boolean isNumericMode(String inputText) {
        return inputText.matches(NUMERIC_TEXT_PATTERN);
    }

    private static boolean isAlphaNumericMode(String inputText) {
        return inputText.matches(ALPHANUMERIC_TEXT_PATTERN);
    }

    private static boolean isByteMode(String inputText) {
        return inputText.matches(BYTE_TEXT_PATTERN);
    }

    private static boolean isKanjiMode(String inputText) {
        return inputText.matches(KANJI_TEXT_PATTERN);
    }

    public static Modes detectTextMode(String inputText) {
        if (isNumericMode(inputText)) {
            System.out.println("Numeric mode");
            return Modes.NUMERIC;
        } else if (isAlphaNumericMode(inputText)) {
            System.out.println("Alphanumeric mode");
            return Modes.ALPHANUMERIC;
        } else if (isByteMode(inputText)) {
            System.out.println("Byte mode");
            return Modes.BYTE;
        } else if (isKanjiMode(inputText)){
            System.out.println("Kanji encoding mode");
            return Modes.KANJI;
        } else {
            throw new InvalidModeException();
        }
    }
}
