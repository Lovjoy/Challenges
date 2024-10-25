// Ray Joy
// 10/24/2024
// Card Shuffle
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int shuffle;
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int menu = 2;

        String[] startingDeck = new String[]
                {"Ac", "2c", "3c", "4c", "5c", "6c", "7c", "8c", "9c", "10c", "Jc", "Qc", "Kc",
                        "As", "2s", "3s", "4s", "5s", "6s", "7s", "8s", "9s", "10s", "Js", "Qs", "Ks",
                        "Ah", "2h", "3h", "4h", "5h", "6h", "7h", "8h", "9h", "10h", "Jh", "Qh", "Kh",
                        "Ad", "2d", "3d", "4d", "5d", "6d", "7d", "8d", "9d", "10d", "Jd", "Qd", "Kd"};
        String[] shuffledDeck = new String[52];

        while (menu != 3) {
            System.out.println("1) Shuffled deck\n2) Sorted deck\n3) Exit");
            menu = sc.nextInt();

            switch (menu) {
                case 1:

                    // Tracks if a card has been used, 0 is not used
                    int[] index = new int[52];
                    for (int i = 0; i < shuffledDeck.length; i++) {
                        shuffle = rand.nextInt(52); // Picks a Random Card

                        //Only changes the card in new deck at index i to unused card
                        if (index[shuffle] == 0) {
                            index[shuffle] = shuffle;
                            shuffledDeck[i] = startingDeck[shuffle];
                        } else {
                            i--; // Keeps i the same value with i++ loop if card is already used
                        }
                    }
                    System.out.println(Arrays.toString(shuffledDeck));
                    break;
                case 2:
                    System.out.println(Arrays.toString(startingDeck));
                    break;
                case 3:
                default:
                    break;
            }
        }
    }
}