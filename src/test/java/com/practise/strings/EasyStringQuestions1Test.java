package com.practise.strings;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EasyStringQuestions1Test {

    private EasyStringQuestions1 easyStringQuestions1;

    @Before
    public void setup() {
        this.easyStringQuestions1 = new EasyStringQuestions1();
    }

    @Test
    public void camelCasingString_string_with_no_space() {
        String a = "Thisisit";
        String b = this.easyStringQuestions1.camelCasingString(a);
        Assert.assertEquals(a,b);
    }

    @Test
    public void camelCasingString_string_with_multiple_space_between_words() {
        String a = "This   isit";
        String b = this.easyStringQuestions1.camelCasingString(a);
        Assert.assertEquals("ThisIsit",b);
    }

    @Test
    public void camelCasingString_string_with_multiple_space_between_multiple_words() {
        String a = "This   is    it";
        String b = this.easyStringQuestions1.camelCasingString(a);
        Assert.assertEquals("ThisIsIt",b);
    }

    @Test
    public void printingInPlusFormat_odd_size_string() {
        String a = "TOP";
        String[] output = this.easyStringQuestions1.printingInPlusFormat(a);
        Assert.assertEquals(output[1], a);
    }

    @Test
    public void printingInPlusFormat_even_size_string() {
        String a = "TOPP";
        String[] output = this.easyStringQuestions1.printingInPlusFormat(a);
        Assert.assertNull(output);
    }

    @Test
    public void printingInPlusFormat_odd_size_5() {
        String a = "JATIN";
        String[] output = this.easyStringQuestions1.printingInPlusFormat(a);
        Assert.assertEquals(output[2], a);
        Assert.assertEquals(output[0], "XXJXX");
        Assert.assertEquals(output[1], "XXAXX");
        Assert.assertEquals(output[3], "XXIXX");
        Assert.assertEquals(output[4], "XXNXX");
    }

    @Test
    public void isValidISBN_valid_isbn() {
        String sample = "007462542X";
        Assert.assertTrue(this.easyStringQuestions1.isValidISBN(sample));
    }

    @Test
    public void isValidISBN_invalid_isbn() {
        String sample = "0112112425";
        Assert.assertFalse(this.easyStringQuestions1.isValidISBN(sample));
    }

    @Test
    public void isValidISBN_invalid_isbn_contains_char() {
        String sample = "011211a425";
        Assert.assertFalse(this.easyStringQuestions1.isValidISBN(sample));
    }


    @Test
    public void strengthOfPassword_weak_password1_with_small_len() {
        String pass = "aA1@";
        String strength = this.easyStringQuestions1.strengthOfPassword(pass);
        Assert.assertEquals("Weak", strength);
    }

    @Test
    public void strengthOfPassword_moderate_password1_with_small_len() {
        String pass = "aA1@JJ";
        String strength = this.easyStringQuestions1.strengthOfPassword(pass);
        Assert.assertEquals("Moderate", strength);
    }

    @Test
    public void strengthOfPassword_weak_password1_with_large_len() {
        String pass = "a1@@@@ccccc";
        String strength = this.easyStringQuestions1.strengthOfPassword(pass);
        Assert.assertEquals("Weak", strength);
    }

    @Test
    public void strengthOfPassword_strong_password1() {
        String pass = "a1@@@@ccA";
        String strength = this.easyStringQuestions1.strengthOfPassword(pass);
        Assert.assertEquals("Strong", strength);
    }

    @Test
    public void strengthOfPassword_Moderate_password1_with_all_condition_and_no_digit() {
        String pass = "a@@@@ccAAAA";
        String strength = this.easyStringQuestions1.strengthOfPassword(pass);
        Assert.assertEquals("Moderate", strength);
    }

    @Test
    public void lexicographicallyNextString_with_empty_string() {
        Assert.assertEquals("a", this.easyStringQuestions1.lexicographicallyNextString(""));
    }

    @Test
    public void lexicographicallyNextString_with_all_Zs_string() {
        Assert.assertEquals("zzza", this.easyStringQuestions1.lexicographicallyNextString("zzz"));
    }

    @Test
    public void lexicographicallyNextString_with_string() {
        Assert.assertEquals("abd", this.easyStringQuestions1.lexicographicallyNextString("abc"));
    }

    @Test
    public void lexicographicallyNextString_with_string_suffix_Zs() {
        Assert.assertEquals("abdzz", this.easyStringQuestions1.lexicographicallyNextString("abczz"));
    }
}
