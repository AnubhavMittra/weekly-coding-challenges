package com.example.domain;

/*
 * QR Codes support four text encoding modes: numeric, alphanumeric, byte, and Kanji.
 * Numeric mode is for the digits 0 through 9. 
 * Alphanumeric mode is for the decimal digits 0 through 9, as well as uppercase letters, and the symbols $, %, *, +, -, ., /,:, and space. 
 * Byte mode is for characters from the ISO-8859-1 character set.
 * Kanji mode is for the double-byte characters from the Shift JIS character set.
 */
public enum Modes {
    NUMERIC,
    ALPHANUMERIC,
    BYTE,
    KANJI
}
