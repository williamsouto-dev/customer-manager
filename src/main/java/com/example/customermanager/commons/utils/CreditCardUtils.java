package com.example.customermanager.commons.utils;

import java.util.Objects;
import java.util.Random;

public class CreditCardUtils {

    public static String NUMBER_CARD = "number-card";
    public static String NUMBER_CVV = "number-cvv";

    private static CreditCardUtils instance;

    private CreditCardUtils() {}

    public static synchronized CreditCardUtils instance() {
        if (Objects.isNull(instance)) {
            instance = new CreditCardUtils();
        }

        return instance;
    }

    public String generate(String type) {
        int lenghtNumber = Objects.equals(type, NUMBER_CARD) ? 16 : 3;

        Random random = new Random(System.currentTimeMillis());

        String bin = "2";
        int randomNumberLength = lenghtNumber - ("2".length() + 1);

        StringBuilder builder = new StringBuilder(bin);
        for (int i = 0; i < randomNumberLength; i++) {
            int digit = random.nextInt(10);
            builder.append(digit);
        }
        int checkDigit = this.getCheckDigit(builder.toString());
        builder.append(checkDigit);

        return builder.toString();
    }

    private int getCheckDigit(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {

            int digit = Integer.parseInt(number.substring(i, (i + 1)));

            if ((i % 2) == 0) {
                digit = digit * 2;
                if (digit > 9) {
                    digit = (digit / 10) + (digit % 10);
                }
            }
            sum += digit;
        }

        int mod = sum % 10;
        return ((mod == 0) ? 0 : 10 - mod);
    }
}
