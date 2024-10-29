// Ray Joy
// 10/27/2024
// Creates Jagged Arrays then sorts them by their true values

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int size;
        int[][] originalArr = new int[4][5];
        int[][] arrSorted = new int[4][5];
        int[] sumArray = new int[4];

        int sum = 0;
        int minIndex = 0;

        for (int i = 0; i < 4; i++) {
            System.out.println("Enter the size of the array 2 - 5: ");
            size = sc.nextInt();
            sum = 0;
            for (int k = 0; k < size; k++) {
                originalArr[i][k] = rand.nextInt(10) + 1;
                sum += originalArr[i][k];
            }
            sumArray[i] = sum;
        }
        System.out.println("Original Array: ");
        System.out.println(Arrays.deepToString(originalArr));
        System.out.println("True Values: ");
        System.out.println(Arrays.toString(sumArray));


        for (int i = 0; i < 4; i++) {
                for (int j = 0; j< 5; j++) {
                    for (int k = 0; k < sumArray.length; k++) {
                        if (sumArray[k] < sumArray[minIndex]) {
                            minIndex = k;
                        }
                    }
                    arrSorted[i][j] = originalArr[minIndex][j];
                }
            sumArray[minIndex] = 999999999;
        }
        System.out.println("Sorted Array: ");
        System.out.println(Arrays.deepToString(arrSorted));
    }
}