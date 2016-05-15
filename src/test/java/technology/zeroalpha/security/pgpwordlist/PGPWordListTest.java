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
import static org.junit.Assert.assertNull;

/**
 * Unit tests to ensure the correct operation of {@link PGPWordList}.
 *
 * @author Chris Rowe
 */
public class PGPWordListTest {

    /** Instance of {@link PGPWordList} to test. */
    private final PGPWordList pgpWordList = new PGPWordList();

    /**
     * Ensure that calls to {@link PGPWordList#getPGPWordsForHexValue(int)} return the correct {@link PGPWords} object.
     */
    @Test
    public void getPGPWordsForHexValue_returns_correct_PGPWords_object() {
        // given

        // when
        final PGPWords pgpWords = pgpWordList.getPGPWordsForHexValue(0x55);

        // then
        assertEquals("edict", pgpWords.getEvenWord()); // Even word for 0x55
        assertEquals("equipment", pgpWords.getOddWord()); // Odd word for 0x55
    }

    /**
     * Ensure that calls to {@link PGPWordList#getPGPWordsForHexValue(int)} return null if the provided hexadecimal
     * value is too large.
     */
    @Test
    public void getPGPWordsForHexValue_returns_null_if_hex_value_is_too_large() {
        // given

        // when
        final PGPWords pgpWords = pgpWordList.getPGPWordsForHexValue(0x101);

        // then
        assertNull(pgpWords);
    }

    /**
     * Ensure that calls to {@link PGPWordList#getHexValueByPGPWord(String)} return the hexadecimal value associated
     * with the provided word.
     */
    @Test
    public void getHexValueByPGPWord_returns_correct_hex_value() {
        // given

        // when
        final Integer hexValue = pgpWordList.getHexValueByPGPWord("showgirl");

        // then
        assertEquals(Integer.valueOf(0xBC), hexValue);
    }

    /**
     * Ensure that calls to {@link PGPWordList#getHexValueByPGPWord(String)} return the hexadecimal value associated
     * with the provided word, and that comparison is case-insensitive.
     */
    @Test
    public void getHexValueByPGPWord_returns_correct_hex_value_and_ignore_case() {
        // given

        // when
        final Integer hexValue = pgpWordList.getHexValueByPGPWord("PACIFIC");

        // then
        assertEquals(Integer.valueOf(0xA2), hexValue);
    }

    /**
     * Ensure that calls to {@link PGPWordList#getHexValueByPGPWord(String)} return null if provided word is not found.
     */
    @Test
    public void getHexValueByPGPWord_returns_null_if_unrecognised_word_is_passed_in() {
        // given

        // when
        final Integer hexValue = pgpWordList.getHexValueByPGPWord("foobar");

        // then
        assertNull(hexValue);
    }

    /**
     * Ensure that calls to {@link PGPWordList#getHexValueByPGPWord(String)} return null if parameter is null.
     */
    @Test
    public void getHexValueByPGPWord_returns_null_if_supplied_parameter_is_null() {
        // given

        // when
        final Integer hexValue = pgpWordList.getHexValueByPGPWord(null);

        // then
        assertNull(hexValue);
    }
}
