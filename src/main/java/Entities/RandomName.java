package Entities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomName {
    public static String getRandomName() {
        int length = 255;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        return generatedString;
    }
}

