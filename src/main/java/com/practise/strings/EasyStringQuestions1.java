package com.practise.strings;

import java.util.HashSet;

/**
 * Following are some of the easy String questions (http://www.geeksforgeeks.org/easy/c-strings/):
 * 1. http://www.geeksforgeeks.org/camel-case-given-sentence/
 * 2. http://www.geeksforgeeks.org/printing-string-plus-pattern-matrix/
 * 3. http://www.geeksforgeeks.org/program-check-isbn/
 * 4. http://www.geeksforgeeks.org/program-check-strength-password/
 * 5. http://www.geeksforgeeks.org/minimum-move-end-operations-make-strings-equal/
 * 6. http://www.geeksforgeeks.org/lexicographically-next-string/
 * 7. http://www.geeksforgeeks.org/length-longest-balanced-subsequence/
 * 8. http://www.geeksforgeeks.org/lexicographically-smallest-string-whose-hamming-distance-given-string-exactly-k/
 * 9. http://www.geeksforgeeks.org/luhn-algorithm/
 * 10. http://www.geeksforgeeks.org/sorting-array-strings-words-using-trie/
 * 11. http://www.geeksforgeeks.org/concatenated-string-uncommon-characters-two-strings/
 * 12. http://www.geeksforgeeks.org/given-two-strings-check-string-makes-palindrome-first/
 * 13. http://www.geeksforgeeks.org/find-array-contains-string-one-mismatch/
 * 14. http://www.geeksforgeeks.org/roll-characters-string/
 * 15. http://www.geeksforgeeks.org/longest-possible-chunked-palindrome/
 * 16. http://www.geeksforgeeks.org/minimum-rotations-required-get-string/
 * 17. http://www.geeksforgeeks.org/program-check-input-integer-string/
 * 18. http://www.geeksforgeeks.org/nth-even-length-palindrome/
 * 19. http://www.geeksforgeeks.org/print-string-ignoring-alternate-occurrences-character/
 * 20. http://www.geeksforgeeks.org/lexicographically-smallest-rotated-sequence-set-2/
 * 21. http://www.geeksforgeeks.org/urlify-given-string-replace-spaces/
 * 22. http://www.geeksforgeeks.org/sum-substrings-string-representing-number-set-2-constant-extra-space/
 * 23. http://www.geeksforgeeks.org/program-remove-vowels-string/
 */
public class EasyStringQuestions1 {

    /**
     *
     * @param a
     * @return
     */
    public String camelCasingString(String a) {
        StringBuilder sb = new StringBuilder();
        boolean capitalize = false;
        for (int i =0; i < a.length(); i++) {
            if (a.charAt(i) != ' ') {
                if (capitalize) {
                    sb.append(Character.toUpperCase(a.charAt(i)));
                    capitalize = false;
                } else {
                    sb.append(a.charAt(i));
                }
            } else {
                capitalize = true;
            }
        }
        return sb.toString();
    }


    /**
     * http://www.geeksforgeeks.org/printing-string-plus-pattern-matrix/
     *
     * Given a string, print it inside a matrix in such a way that a ‘plus’ is formed.
     *
     * Input: TOP
     * Output:
     * X    T    X
     * T    O    P
     * X    P    X
     *
     * @param a
     * @return array that needs to printed on new line
     */
    public String[] printingInPlusFormat(String a) {
        if (a.length()%2 == 0) {
            return null;
        }
        int n = a.length()/2;
        StringBuilder sb = new StringBuilder();
        for (int i= 0; i < n; i++) {
            sb.append("X");
        }
        String rep = sb.toString();
        String[] output = new String[a.length()];
        for (int i =0; i < a.length(); i++) {
            if (i == n) {
                output[i] = a;
            } else {
                output[i] = rep + a.charAt(i) + rep;
            }
        }
        return output;
    }

    /**
     * 3. http://www.geeksforgeeks.org/program-check-isbn/
     *
     *
     * @param isbn
     * @return
     */
    public boolean isValidISBN(String isbn) {
        if(isbn.length() != 10) {
            return false;
        }
        int sum = 0;
        for(int i = 0; i < 10; i++) {
            char s = isbn.charAt(i);
            int number;
            try {
                if (i != 9) {
                    number = Character.getNumericValue(s);
                } else {
                    if (s == 'X') {
                        number = 10;
                    } else {
                        number = Character.getNumericValue(s);
                    }
                }
            } catch (NumberFormatException e) {
                return false;
            }
            sum += number * (10-i);
        }
        return sum%11 == 0;
    }

    /**
     * http://www.geeksforgeeks.org/program-check-strength-password/
     *
     * A password is said to be strong if it satisfies the following criteria:
     *
     * 1. It contains at least one lowercase English character.
     * 2. It contains at least one uppercase English character.
     * 3. It contains at least one special character. The special characters are: !@#$%^&*()-+
     * 4. Its length is at least 8.
     * 5. It contains at least one digit.
     *
     * Given a string, find its strength. Let a strong password is one that satisfies
     * all above conditions. A moderate password is one that satisfies
     * first three conditions and has length at least 6. Otherwise password is week.
     *
     * @param pass - password string
     * @return Weak/ Strong / Moderate
     */
    public String strengthOfPassword(String pass) {
        int passwordLength = pass.length();
        if (passwordLength < 6) return "Weak";
        HashSet<Character> specialCharSet = new HashSet<>(12);
        specialCharSet.add('!');
        specialCharSet.add('@');
        specialCharSet.add('#');
        specialCharSet.add('$');
        specialCharSet.add('%');
        specialCharSet.add('^');
        specialCharSet.add('&');
        specialCharSet.add('*');
        specialCharSet.add('(');
        specialCharSet.add(')');
        specialCharSet.add('-');
        specialCharSet.add('+');
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasSpecialCharacter = false;
        boolean hasDigit = false;
        boolean hasStrongLength = passwordLength >= 8;

        for (int i= 0; i < passwordLength; i++) {
            char s = pass.charAt(i);
            if (!hasLowerCase &&  Character.isLowerCase(s)) hasLowerCase = true;
            if (!hasUpperCase &&  Character.isUpperCase(s)) hasUpperCase = true;
            if (!hasSpecialCharacter &&  specialCharSet.contains(s)) hasSpecialCharacter = true;

            if(hasStrongLength) {
                if (!hasDigit &&  Character.isDigit(s)) hasDigit = true;
            }
        }

        if(hasDigit && hasLowerCase && hasSpecialCharacter && hasUpperCase) return "Strong";
        if (hasLowerCase && hasUpperCase && hasSpecialCharacter) return "Moderate";
        return "Weak";
    }

    /**
     * http://www.geeksforgeeks.org/lexicographically-next-string/
     *
     * Given a string, find lexicographically next string.
     *
     * @param s1
     * @return
     */
    public String lexicographicallyNextString(String s1) {
        if (s1.length() == 0) {
            return "a";
        }
        boolean incremented = false;
        char[] sb = new char[s1.length()];
        for (int i = s1.length()-1; i >= 0; i--) {
            char c = s1.charAt(i);
            if (incremented || c == 'z') {
                sb[i] = c;
            } else  {
                sb[i] = ++c;
                incremented = true;
            }
        }
        return incremented ? new String(sb) : s1 + "a";
    }
}
