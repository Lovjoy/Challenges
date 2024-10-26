// Ray Joy
// 10/26/2024
// Takes an order pair and apply a rotation about the origin and prints the new order pair

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] rotate90 = {{0, -1}, {1, 0}};    // 90 counterclockwise
        int[][] rotate270 = {{-1, 0}, {0, -1}};  // 270 counterclockwise = 90 clockwise
        int[][] rotate180 = {{-1, 0}, {0, -1}};
        int[][] transformation = new int[2][2];
        int[] array = new int[2];
        int[] transformedArray = new int[2];
        int menu = 0;

        while (menu != 4) {
            System.out.println("\nSelect Transformation\n1) 90 Degrees Clockwise\n2) 180 Degrees\n3) 90 Degrees Counterclockwise\n4) Exit");
            menu = sc.nextInt();
            System.out.print("Enter x coordinate: ");
            array[0] = sc.nextInt();
            System.out.print("Enter y coordinate: ");
            array[1] = sc.nextInt();

            // Takes the transformation choice and apply to the transformation array and resets the transformed array to 0
            switch (menu) {

                case 1:
                    for (int i = 0; i < 2; i++) {
                        transformedArray[i] = 0;
                        for (int j = 0; j < 2; j++) {
                            transformation[i][j] = rotate270[i][j];
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 2; i++) {
                        transformedArray[i] = 0;
                        for (int j = 0; j < 2; j++) {
                            transformation[i][j] = rotate180[i][j];
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 2; i++) {
                        transformedArray[i] = 0;
                        for (int j = 0; j < 2; j++) {
                            transformation[i][j] = rotate90[i][j];
                        }
                    }
                    break;
                case 4:
                    System.out.println("Terminated.");
                    break;
            }

            // Matrix Multiplication to create new array with order pair for new point
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    transformedArray[i] += (transformation[i][j] * array[j]);
                }
            }
            System.out.println("New coordinates are: " + Arrays.toString(transformedArray));
        }
    }
}