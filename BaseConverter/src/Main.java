import java.util.Scanner;
// Ray Joy
// 10/14/2024
// Prints all binary numbers 0-100
// Convert a binary number into a base ten decimal
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder newNumbers = new StringBuilder();
        int oldNumber;
        int newDigit;
        String binaryNumber;
        // Prints all the Binary numbers 0-100
        System.out.println("0 = 0");
        for (int i = 1; i <= 100; i++) {
            oldNumber = i;
            while (oldNumber != 0) {
                newDigit = oldNumber % 2;
                newNumbers.insert(0, newDigit);
                oldNumber = oldNumber / 2;
            }
            System.out.println(i + " = " + newNumbers);
            newNumbers = new StringBuilder();
        }
        // Converts a Binary number into base 10 decimal
        char binaryDigit;
        double newBaseTen;
        double oldBaseTen = 0;
        System.out.println("Enter a Binary Number: ");
        binaryNumber = scanner.nextLine();

        for (int i = 1; i <= binaryNumber.length(); i++) {
            binaryDigit = binaryNumber.charAt(binaryNumber.length() - i);
            if (binaryDigit == '1') {
                newBaseTen =  Math.pow(2, i-1);
                oldBaseTen += newBaseTen;

            }
        }
        System.out.printf("%s = %.0f", binaryNumber, oldBaseTen);
    }
}