package com.kdr.CrediGo.utils;

import java.util.Random;

public class AccountUtils {

    public static final String ACCOUNT_EXISTS_CODE = "001";

    public static final String ACCOUNT_EXISTS_MESSAGE = "This user already has an account in the database.";

    public static final String ACCOUNT_CREATION_SUCCESS_CODE = "002";

    public static final String ACCOUNT_CREATION_MESSAGE = "Account creation successful";
    /**
     * Account Number format follows Luhn Checksum
     */
    private static final int accountNumberLength = 12;

    public static String generateAccountNumber() {
        int baseLength = accountNumberLength - 1;
        String baseNumber = generateBaseNumber(baseLength);
        int checkSum = luhnCheckSum(baseNumber);
        return baseNumber + checkSum;
    }



    /**
     * Generate base number that shall be used for account number generation and to which checksum shall be created from.
     * baseNumber generated is randomized.
     *
     * @return baseNumber
     */
    public static String generateBaseNumber(int baseLength) {
        Random random = new Random();
        StringBuilder baseNumber = new StringBuilder();

        for (int i = 0; i < baseLength; i++) {
            baseNumber.append(random.nextInt(10));
        }
        return baseNumber.toString();
    }

    /**
     * Implements Luhn Algorithm in determining checksum from the base number.
     *
     * @return luhnCheckSum
     */
    public static int luhnCheckSum(String baseNumber) {
        int sum = 0;
        boolean alternate = true;

        for (int i = baseNumber.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(baseNumber.charAt(i));
            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            alternate = !alternate;
            sum += digit;
        }
        return (10 - (sum % 10)) % 10;
    }
}
