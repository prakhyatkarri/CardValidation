import java.util.Scanner;

public class CardValidation {

    public static void main(String[] args) {
        System.out.println("Please enter a 16 digit Credit Card number:");
        long cardNumber = new Scanner(System.in).nextLong();
        boolean result = new CardValidation().isCardNumberValid(cardNumber);
        String status = result ? "valid" : "invalid";
        System.out.println("Entered Credit Card Number " + cardNumber + " is " + status);
    }

    private boolean isCardNumberValid(long cardNumber) {
        String number = String.valueOf(cardNumber);
        int length = number.length();
        boolean isValidLength = length >= 13 && length <= 16;
        boolean isPopularVendor = number.startsWith("4") || number.startsWith("5") || number.startsWith("37") || number.startsWith("6");
        long sumOfEvenPositions = step12(number);
        long sumOfOddPositions = step3(number);
        boolean isDivisibleBy10 = (sumOfEvenPositions + sumOfOddPositions) % 10 == 0;
        return isValidLength && isPopularVendor && isDivisibleBy10;
    }

    private long step12(String number) {
        long result = 0;
        for (int j = number.length() - 2; j >= 0; j = j - 2) {
            result += step1(number.charAt(j));
        }
        return result;
    }

    private long step1(char value) {
        int nextValue = Integer.parseInt(String.valueOf(value)) * 2;
        return nextValue > 9 ? nextValue / 10 + nextValue % 10 : nextValue;
    }

    private long step3(String number) {
        long result = 0;
        for (int j = number.length() - 1; j >= 0; j = j - 2) {
            result += Integer.parseInt(String.valueOf(number.charAt(j)));
        }
        return result;
    }
}
