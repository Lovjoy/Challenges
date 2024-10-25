// Ray Joy
// 10/25/2024
// you are given three arrays
//int[] numbers // an array with 5 elements all randomly generated
//int[] numbers2 // an array with 7 elements all randomly generated
//int[] numbers3 // an array with 9 elements all randomly generated
//You must make an array that will hold all elements in those 3 arrays.

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();

        int[] numbers = new int[5];
        int[] numbers2 = new int [7];
        int[] numbers3 = new int[9];
        int[] combined = new int[21];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(401) - 200;   // Random int -200, 200
        }
        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < numbers2.length; i++) {
            numbers2[i] = rand.nextInt(401) - 200;
        }
        System.out.println(Arrays.toString(numbers2));
        for (int i = 0; i < numbers3.length; i++) {
            numbers3[i] = rand.nextInt(401) - 200;
        }
        System.out.println(Arrays.toString(numbers3));

        for (int i = 0; i < numbers.length; i++) {
            combined[i] = numbers[i];
        }
        for (int i = 0; i < numbers2.length; i++) {
            combined[i + 5] = numbers2[i]; // off set by size of numbers
        }
        for (int i = 0; i < numbers3.length; i++) {
            combined[i + 12] = numbers3[i]; // off set by size of numbers and numbers2
        }

        System.out.println(Arrays.toString(combined));
    }
}