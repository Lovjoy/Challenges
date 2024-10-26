// Ray Joy
// 10/25/2024
// Lonely Numbers
// Go through an array and find any lonely elements that don't have a matching element and list them
// Some test arrays with num1, hum2, and num3.
// num4 is any user input size array with random int values 1 through (array size + 1) / 2

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

//        int[] nums1 = {1, 1, 2, 2, 3, 4, 4};
//        int[] nums2 = {1, 1, 2, 2, 3, 3, 3, 4, 4, 5};
//        int[] nums3 = {1, 2, 2, 3, 3, 4, 4, 5, 5};
        int arraySize;
        int[] nums4;
//        int lonelyNumber = 0;
        String lonelyNumbers = "";
        boolean found = false;

//        for (int i = 0; i < (nums1.length - 1); i++) {
//
//            if (nums1[i] == nums1[i + 1]) {
//                continue;
//            } else if (nums1[i] == nums1[i - 1] && i != nums1.length - 2) {
//                continue;
//            } else if (i == (nums1.length - 2)) {
//                found = true;
//                lonelyNumber = nums1[i + 1];
//                break;
//            } else {
//                found = true;
//                lonelyNumber = nums1[i];
//                break;
//            }
//        }
//        System.out.println(Arrays.toString(nums1) + "\nThe lonely Number is " + lonelyNumber);
//
//        for (int i = 0; i < (nums2.length - 1); i++) {
//
//            if (nums2[i] == nums2[i + 1]) {
//                continue;
//            } else if (nums2[i] == nums2[i - 1] && i != nums2.length - 2) {
//                continue;
//            } else if (i == (nums2.length - 2)) {
//                found = true;
//                lonelyNumber = nums2[i + 1];
//                break;
//            } else {
//                found = true;
//                lonelyNumber = nums2[i];
//                break;
//            }
//        }
//        System.out.println(Arrays.toString(nums2) + "\nThe lonely Number is " + lonelyNumber);
//
//        for (int i = 0; i < (nums3.length - 1); i++) {
//
//            if (i == 0 & nums3[i] != nums3[i + 1]) {
//                found = true;
//                lonelyNumber = nums3[i];
//                break;
//            }
//            if (nums3[i] == nums3[i + 1]) {
//                continue;
//            } else if (nums3[i] == nums3[i - 1]) {
//                continue;
//            } else {
//                found = true;
//                lonelyNumber = nums3[i];
//                break;
//            }
//        }
//        System.out.println(Arrays.toString(nums3) + "\nThe lonely Number is " + lonelyNumber);

        System.out.print("Enter Array Size: ");
        arraySize = sc.nextInt();
        nums4 = new int[arraySize];

        for (int i = 0; i < nums4.length; i++) {
            nums4[i] = (rand.nextInt((nums4.length + 1) / 2) + 1);
        }
        System.out.println(Arrays.toString(nums4));

        for (int i = 0; i < (nums4.length); i++) {
            found = true;
            for (int j = i; j < nums4.length; j++) {
                if (nums4[i] == nums4[j] && i != j) {
                    found = false;
                    nums4[j] = -1;
                }
                if (nums4[i] == -1) {
                    break;
                }
            }
            if (found && nums4[i] != -1) {
                lonelyNumbers += nums4[i] + ", ";
            }
        }

        if (!lonelyNumbers.isEmpty()) {
            System.out.println("The lonely Number(s): " + lonelyNumbers.substring(0, lonelyNumbers.length() - 2));
        } else {
            System.out.println("There are no lonely Numbers.");
        }
    }
}