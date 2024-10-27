// Ray Joy
// 10/26/2024
// Stats, 5 number summary, mean, and mode

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();

        int n = 30;
        int[] numbers = new int[n];
        int temp;
        String modes = "";
        int[] mode = new int[n];
        int modeCounter;
        double sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (rand.nextInt(201) - 100);
        }
        System.out.println(Arrays.toString(numbers));

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i; j < numbers.length - 1; j++) {
                if (numbers[j + 1] < numbers[i]) {
                    temp = numbers[j + 1];
                    numbers[j + 1] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        for (int i = 0; i < numbers.length - 2; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    mode[i]++;
                }
            }
        }
        modeCounter = 1;
        for (int i = 0; i < mode.length - 1; i++) {
            if (mode[i] > modeCounter) {
                modeCounter = mode[i];
            }
        }
        for (int i = 0; i < mode.length - 1; i++) {
            if (mode[i] == modeCounter) {
                modes += (numbers[i] + ", ");
            }
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println("Min: " + numbers[0]);
        System.out.println("Q1: " + numbers[n / 4]);
        System.out.println("Median: " + numbers[n / 2]);
        System.out.println("Q3: " + numbers[(3 * n) / 4]);
        System.out.println("Max: " + numbers[n - 1]);
        System.out.printf("Mean: %.2f\n", (sum / n));
        if (modeCounter == 1) {
            System.out.println("No Mode.");
        } else {
            System.out.println("Mode: " + modes.substring(0, modes.length() - 2));
        }
    }
}