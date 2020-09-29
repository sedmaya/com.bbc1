package com.bbc1.utils;

import java.util.Random;

public class StringUtils {
    private static final String ALFA_NUMERICAL_ALL_CAPS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random random = new Random();

    public static String getRandomString(int stringLength) {
        StringBuilder stringBuilder = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++) {
            stringBuilder.append(ALFA_NUMERICAL_ALL_CAPS.charAt(random.nextInt(ALFA_NUMERICAL_ALL_CAPS.length())));
        }
        return stringBuilder.toString();
    }

    public static String generateRandomStringWithSetLength(int setLength) {
        return getRandomString(setLength);
    }

    public static String generateRandomInvalidEmailWithSetLength(int setLength) {
        return getRandomString(setLength).toUpperCase().concat("@bIgmiR.net");
    }

}
