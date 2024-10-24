// Ray Joy
// 10/24/2024
// Practice for Arrays
package Main;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] values = new int[8];
        int input;
        int temp;
        // Warm up square and cube the array
/*        double square;
          double cube;

        for (int i = 0; i < values.length; i++) {
            square = pow(values[i], 2);
            System.out.println(values[i] + " squared is " + square);
            cube = pow(values[i], 3);
            System.out.println(values[i] + " cubed is " + cube);
        }*/

        //Take input from user and put into array in left spot and shift every element right one
/*        while (true){
            System.out.print("\nEnter an integer: ");
            input = sc.nextInt();
            values[4] = values[3];
            values[3] = values[2];
            values[2] = values[1];
            values[1] = values[0];
            values[0] = input;
            System.out.print(Arrays.toString(values));
        }*/

        // Create an Array of 8 integers
        for (int i = 0; i < 8; i++) {
            System.out.print("Enter an integer: ");
            values[i] = sc.nextInt();
        }
//    int[] values = {10, 22, 11, 15, 9, -1, 12, 25};  Test Array
//      Sort elements from least to greatest
        System.out.println(Arrays.toString(values));
        for (int i = 0; i < values.length; i++) {
            for (int j = 1; j < 8; j++) {
                if (values[j] < values[j - 1]) {
                    temp = values[j - 1];
                    values[j - 1] = values[j];
                    values[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(values));
    }
}