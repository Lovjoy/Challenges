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
        int[][] arr = new int[4][5];
        int[][] arrSorted = new int[4][5];
        int[] sumArray = new int[4];

        int sum = 0;
        int minIndex = 0;

        for (int k = 0, j = 0; k < 4; k++, j++) {
            System.out.println("Enter the size of the array 2 - 5: ");
            size = sc.nextInt();
            sum = 0;
            for (int i = 0; i < size; i++) {
                arr[j][i] = rand.nextInt(10) + 1;
                sum += arr[j][i];
            }
            sumArray[k] = sum;
        }
        System.out.println("\nTrue Values: ");
        System.out.println(Arrays.toString(sumArray));


        for (int m = 0; m < 4; m++) {
            for (int k = 0; k < 4; k++) {
                for (int j = 0; j < 5; j++) {
                    for (int i = 0; i < sumArray.length; i++) {
                        if (sumArray[i] < sumArray[minIndex]) {
                            minIndex = i;
                        }
                    }
                    arrSorted[m][j] = arr[minIndex][j];
                }
            }
            sumArray[minIndex] = 999999999;
        }
        System.out.println("Original Array: ");
        System.out.println(Arrays.deepToString(arr));
        System.out.println("Sorted Array: ");
        System.out.println(Arrays.deepToString(arrSorted));
    }
}