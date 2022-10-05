package app.service;

public class Luhn {
    public static Boolean validate(String number) {
        int nDigits = number.length();
        int nSum = 0;
        boolean isSecond = false;

        for (int i = nDigits - 1; i >= 0; i--) {
    
            int d = number.charAt(i) - '0';
    
            if (isSecond == true) {
                d = d * 2;
            }
    
            nSum += d / 10;
            nSum += d % 10;
    
            isSecond = !isSecond;
        }

        return (nSum % 10 == 0);
    }
}