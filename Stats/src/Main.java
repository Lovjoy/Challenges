// Ray Joy
// 10/26/2024
// Stats, 5 number summary, mean, and mode

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int n;              // Total number of random elements

        int temp;
        String modes = "";  // Used to print list of modes

        int modeCounter;
        double sum = 0;     // used for mean
        int max;            // largest value element can be
        int min;            // smallest value element can be

        System.out.print("Enter total number of elements: ");
        n = sc.nextInt();

        int[] numbers = new int[n];
        int[] mode = new int[n];

        System.out.print("Enter highest possible value: ");
        max = sc.nextInt();

        System.out.print("Enter lowest possible value: ");
        min = sc.nextInt();

        // Creates random array with size of input n and possible range of min - max
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (rand.nextInt(max - min) + min);
        }
        System.out.println(Arrays.toString(numbers));   // Unsorted numbers

        // Sorts numbers from least to greatest
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i; j < numbers.length - 1; j++) {
                if (numbers[j + 1] < numbers[i]) {
                    temp = numbers[j + 1];
                    numbers[j + 1] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        // Used for mean
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        // Creates new array that counts is used to count how many of that kind of element in the array
        for (int i = 0; i < numbers.length - 2; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    mode[i]++;
                }
            }
        }
        // Finds the largest number in mode list
        modeCounter = 1;
        for (int i = 0; i < mode.length - 1; i++) {
            if (mode[i] > modeCounter) {
                modeCounter = mode[i];
            }
        }
        // Adds all modes with that amount of modeCounter to modes list
        for (int i = 0; i < mode.length - 1; i++) {
            if (mode[i] == modeCounter) {
                modes += (numbers[i] + ", ");
            }
        }
        // Prints sorted numbers
        System.out.println(Arrays.toString(numbers));

        System.out.println("Min: " + numbers[0]);

        if (n % 2 == 0) {
            System.out.println("Q1: " + numbers[n / 4]);
            System.out.println("Median: " + (double)((numbers[(n - 1) / 2] + (numbers[((n - 1)/ 2) + 1])) / 2));
            System.out.println("Q3: " + numbers[(3 * n) / 4]);
        } else {
            System.out.println("Q1: " + (numbers[n / 4]));
            System.out.println("Median: " + ((numbers[n / 2] )));
            System.out.println("Q3: " + (numbers[(3 * n) / 4 ]));
        }
        System.out.println("Max: " + numbers[n - 1]);
        System.out.printf("Mean: %.2f\n", (sum / n));

        if (modeCounter == 1) {
            System.out.println("No Mode.");
        } else {
            System.out.println("Mode: " + modes.substring(0, modes.length() - 2));
        }
    }
}