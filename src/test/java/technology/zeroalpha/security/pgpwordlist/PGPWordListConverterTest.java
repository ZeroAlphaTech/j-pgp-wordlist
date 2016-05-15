/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016  Zero Alpha Technology Limited
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package technology.zeroalpha.security.pgpwordlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests to ensure the correct operation of {@link PGPWordListConverter}.
 *
 * @author Chris Rowe
 */
public class PGPWordListConverterTest {

    /** Instance of {@link PGPWordListConverter} to test. */
    private final PGPWordListConverter converterUnderTest = new PGPWordListConverter();

    /**
     * Ensure that calls to {@link PGPWordListConverter#getEvenWordForHexValue(String)} return the correct word.
     */
    @Test
    public void getEvenWordForHexValue_returns_correct_word() throws InvalidHexValueException {
        // given

        // when
        final String word = converterUnderTest.getEvenWordForHexValue("0A");

        // then
        assertEquals("allow", word); // Even word for 0A is 'allow'
    }

    /**
     * Ensure that calls to {@link PGPWordListConverter#getEvenWordForHexValue(String)} throw an
     * {@link InvalidHexValueException} if null is passed as the parameter.
     */
    @Test (expected = InvalidHexValueException.class)
    public void getEvenWordForHexValue_throws_InvalidHexValueException_if_null_parameter_received()
            throws InvalidHexValueException {
        // given

        // when
        converterUnderTest.getEvenWordForHexValue(null);

        // then
    }

    /**
     * Ensure that calls to {@link PGPWordListConverter#getEvenWordForHexValue(String)} throw an
     * {@link InvalidHexValueException} if an empty string is passed as the parameter.
     */
    @Test (expected = InvalidHexValueException.class)
    public void getEvenWordForHexValue_throws_InvalidHexValueException_if_parameter_is_empty_string()
            throws InvalidHexValueException {
        // given

        // when
        converterUnderTest.getEvenWordForHexValue("");

        // then
    }

    /**
     * Ensure that calls to {@link PGPWordListConverter#getEvenWordForHexValue(String)} throw an
     * {@link InvalidHexValueException} if the provided hexadecimal value is too large - i.e. > 0xFF.
     */
    @Test (expected = InvalidHexValueException.class)
    public void getEvenWordForHexValue_throws_InvalidHexValueException_if_hex_value_is_too_large()
            throws InvalidHexValueException {
        // given

        // when
        converterUnderTest.getEvenWordForHexValue("100");

        // then
    }

    /**
     * Ensure that calls to {@link PGPWordListConverter#getEvenWordForHexValue(String)} throw an
     * {@link InvalidHexValueException} if the String passed in as a parameter is not a valid hexadecimal number.
     */
    @Test (expected = InvalidHexValueException.class)
    public void getEvenWordForHexValue_throws_InvalidHexValueException_if_string_is_not_valid_hex()
            throws InvalidHexValueException {
        // given

        // when
        converterUnderTest.getEvenWordForHexValue("GG");

        // then
    }

    /**
     * Ensure that calls to {@link PGPWordListConverter#getOddWordForHexValue(String)} return the correct word.
     */
    @Test
    public void getOddWordForHexValue_returns_correct_word() throws InvalidHexValueException {
        // given

        // when
        final String word = converterUnderTest.getOddWordForHexValue("21");

        // then
        assertEquals("Camelot", word); // Odd word for 21 is 'Camelot'
    }

    /**
     * Ensure that calls to {@link PGPWordListConverter#getOddWordForHexValue(String)} throw an
     * {@link InvalidHexValueException} if null is passed as the parameter.
     */
    @Test (expected = InvalidHexValueException.class)
    public void getOddWordForHexValue_throws_InvalidHexValueException_if_null_parameter_received()
            throws InvalidHexValueException {
        // given

        // when
        converterUnderTest.getOddWordForHexValue(null);

        // then
    }

    /**
     * Ensure that calls to {@link PGPWordListConverter#getOddWordForHexValue(String)} throw an
     * {@link InvalidHexValueException} if an empty string is passed as the parameter.
     */
    @Test (expected = InvalidHexValueException.class)
    public void getOddWordForHexValue_throws_InvalidHexValueException_if_parameter_is_empty_string()
            throws InvalidHexValueException {
        // given

        // when
        converterUnderTest.getOddWordForHexValue("  ");

        // then
    }

    /**
     * Ensure that calls to {@link PGPWordListConverter#getOddWordForHexValue(String)} throw an
     * {@link InvalidHexValueException} if the hexadecimal value provided is too large i.e. > 0xFF.
     */
    @Test (expected = InvalidHexValueException.class)
    public void getOddWordForHexValue_throws_InvalidHexValueException_if_hex_value_is_too_large()
            throws InvalidHexValueException {
        // given

        // when
        converterUnderTest.getOddWordForHexValue("100");

        // then
    }

    /**
     * Ensure that calls to {@link PGPWordListConverter#getOddWordForHexValue(String)} throw an
     * {@link InvalidHexValueException} if the provided String is not a valid hexadecimal number.
     */
    @Test (expected = InvalidHexValueException.class)
    public void getOddWordForHexValue_throws_InvalidHexValueException_if_string_is_not_valid_hex()
            throws InvalidHexValueException {
        // given

        // when
        converterUnderTest.getOddWordForHexValue("GG");

        // then
    }
}
