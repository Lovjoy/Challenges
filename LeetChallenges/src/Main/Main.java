package Main;

import java.util.Scanner;

public class  Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] jerseyArr = new int[5];
        int[] playerRatingArr = new int[5];
        char menu;
        int jerseyNum;
        int playerRating;
        boolean exit = false;

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter player " + (i + 1) + "'s jersey number: ");
            jerseyArr[i] = sc.nextInt();
            System.out.println("Enter player " + (i + 1) + "'s rating: ");
            playerRatingArr[i] = sc.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("Player " + (i + 1) + " -- Jersey number: " + jerseyArr[i] + ", Rating: " + playerRatingArr[i]);
        }

        while (!exit) {
            System.out.println("MENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - " +
                    "Output roster\nq - Quit");
            System.out.print("\nChoose an option: ");
            menu = sc.next().charAt(0);

            switch (menu) {
                case 'u':
                case 'U':
                    System.out.println("Enter a jersey number: ");
                    jerseyNum = sc.nextInt();

                    for (int i = 0; i < 5; i++) {
                        if (jerseyArr[i] == jerseyNum) {
                            System.out.println("Enter a new rating for player:");
                            playerRatingArr[i] = sc.nextInt();
                        }
                    }
                    break;
                case 'a':
                case 'A':
                    System.out.println("Enter a rating: ");
                    playerRating = sc.nextInt();
                    System.out.println("ABOVE " + playerRating);
                    for (int i = 0; i < 5; i++) {
                        if (playerRatingArr[i] > playerRating) {
                            System.out.println("Player " + (i + 1) + " -- Jersey number: " + jerseyArr[i] + ", Rating: " + playerRatingArr[i]);
                            System.out.println();
                        }
                    }
                    break;
                case 'r':
                case 'R':
                    System.out.println("Enter a jersey number: ");
                    jerseyNum = sc.nextInt();
                    for (int i = 0; i < 5; i++) {
                        if (jerseyArr[i] == jerseyNum) {
                            System.out.println("Enter a new jersey number:");
                            jerseyArr[i] = sc.nextInt();
                            System.out.println("Enter a rating for the new player: ");
                            playerRatingArr[i] = sc.nextInt();
                        }
                    }
                    break;
                case 'o':
                case 'O':
                    for (int i = 0; i < 5; i++) {
                        System.out.println("Player " + (i + 1) + " -- Jersey number: " + jerseyArr[i] + ", Rating: " + playerRatingArr[i]);
                    }
                    break;
                case 'q':
                case 'Q':
                    exit = true;
                default:
                    break;

            }
        }
    }
}