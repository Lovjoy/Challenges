//          Ray Joy
//          11/10/2024
//          SLOTS WITH METHODS
//        25% banana - 2 $ per banana. no matches required.
//        21% carrot - 10$ for 2 in a row. 15$ for 3 in a row.
//        18% fox - 25$ for 3 in a row.
//        10% bear - 50$ for 3 in a row.
//        8% stars - 100$ for 3 in a row.
//        7% tiger - 300$ for 3 in a row.
//        6% roses - 500$ for 3 in a row
//        5% sauce - 1000$ for 3 in a row
//        bets: min 5$ med 10$ max 15$    start with 1k cash
//        on min bets, only the middle three rows will be counted when looking for winning matches.
//        on med bets, all 3 rows are active but only horizontally.
//        on max bets, all rows are active in all directions.
//        Game ends when player has double the original amount or is unable to make a new bet

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public enum Symbol {Banana, Carrot, Foxes, Bears, Stars, Tiger, Roses, Sauce}

    public static void printRandomSlots(String[][] slotMachine) {
        Random rand = new Random();
        double random;

        for (int i = 0; i < slotMachine.length; i++) {
            for (int j = 0; j < slotMachine[i].length; j++) {
                random = rand.nextDouble();
                if (random <= 0.25) {
                    slotMachine[i][j] = String.valueOf(Symbol.Banana); // 25% Chance
                } else if (random <= 0.46) {
                    slotMachine[i][j] = String.valueOf(Symbol.Carrot); // 21% Chance
                } else if (random <= 0.64) {
                    slotMachine[i][j] = String.valueOf(Symbol.Foxes); // 18% Chance
                } else if (random <= 0.74) {
                    slotMachine[i][j] = String.valueOf(Symbol.Bears); // 10% Chance
                } else if (random <= 0.82) {
                    slotMachine[i][j] = String.valueOf(Symbol.Stars); // 8% Chance
                } else if (random <= 0.89) {
                    slotMachine[i][j] = String.valueOf(Symbol.Tiger); // 7% Chance
                } else if (random <= 0.95) {
                    slotMachine[i][j] = String.valueOf(Symbol.Roses); // 6% Chance
                } else {
                    slotMachine[i][j] = String.valueOf(Symbol.Sauce); // 5% Chance
                }
            }
        }
        System.out.println("| " + slotMachine[0][0] + " | " + slotMachine[0][1] + " | " + slotMachine[0][2] + " |" +
                "\n| " + slotMachine[1][0] + " | " + slotMachine[1][1] + " | " + slotMachine[1][2] + " |" +
                "\n| " + slotMachine[2][0] + " | " + slotMachine[2][1] + " | " + slotMachine[2][2] + " |");
    }

    public static int bannanas(String[][] slotMachine, int bet) {
        Random rand = new Random();
        int winnings = 0;
        String[] banana = {"Banana +$2", "BaNaNa +$2", "bAnAnA +$2", "Nanners +$2", "banana +$2", "BAAANNANA +$2"};

        if (bet == 2 || bet == 3) {
            for (int i = 0; i < slotMachine.length; i++) {
                for (int j = 0; j < slotMachine[i].length; j++) {
                    if (slotMachine[i][j].equals(String.valueOf(Symbol.Banana))) {
                        System.out.println(banana[rand.nextInt(banana.length - 1)]);
                        winnings += 2;
                    }
                }
            }
        } else if (bet == 1) {
            for (int i = 0; i < slotMachine[1].length; i++) {
                if (slotMachine[1][i].equals(String.valueOf(Symbol.Banana))) {
                    System.out.println(banana[rand.nextInt(banana.length - 1)]);
                    winnings += 2;
                }
            }
        }
        return winnings;
    }
    public static int carrots(String[][] slotMachine, int bet) {
        int winnings = 0;
        if (bet == 3) {
            //FIRST COLUMN (0,0), (1,0), (2,0)
            if (slotMachine[0][0].equals(String.valueOf(Symbol.Carrot)) && slotMachine[0][0].equals(slotMachine[1][0])
                    && slotMachine[1][0].equals(slotMachine[2][0])) {
                System.out.println("Triple Carrot! +$15");
            } else if (slotMachine[1][0].equals(String.valueOf(Symbol.Carrot)) && (slotMachine[0][0].equals(slotMachine[1][0])
                    || slotMachine[1][0].equals(slotMachine[2][0]))) {
                winnings += 10;
                System.out.println("Double Carrot! +$10");
            }
            // MIDDLE COLUMN (0,1), (1,1), (2,1)
            if (slotMachine[0][1].equals(String.valueOf(Symbol.Carrot)) && (slotMachine[0][1].equals(slotMachine[1][1])
                    && slotMachine[1][1].equals(slotMachine[2][1]))) {
                System.out.println("Triple Carrot! +$15");
            } else if (slotMachine[1][1].equals(String.valueOf(Symbol.Carrot)) && (slotMachine[0][1].equals(slotMachine[1][1])
                    || slotMachine[1][1].equals(slotMachine[2][1]))) {
                winnings += 10;
                System.out.println("Double Carrot! +$10");
            }
        }
        // RIGHT COLUMN (0,2), (1,2), (2,2)
        if (slotMachine[0][2].equals(String.valueOf(Symbol.Carrot)) && slotMachine[0][2].equals(slotMachine[1][2])
                && slotMachine[1][2].equals(slotMachine[2][2])) {
            System.out.println("Triple Carrot! +$15");
        } else if (slotMachine[1][2].equals(String.valueOf(Symbol.Carrot)) && (slotMachine[0][2].equals(slotMachine[1][2])
                || slotMachine[1][2].equals(slotMachine[2][2]))) {
            winnings += 10;
            System.out.println("Double Carrot! +$10");
        }
        // TOP ROW (0,0), (0,1), (0,2)
        if (bet == 2 || bet == 3) {
            if (slotMachine[0][0].equals(String.valueOf(Symbol.Carrot)) && slotMachine[0][0].equals(slotMachine[0][1])
                    && slotMachine[0][1].equals(slotMachine[0][2])) {
                System.out.println("Triple Carrot! +$15");
            } else if (slotMachine[0][1].equals(String.valueOf(Symbol.Carrot)) && (slotMachine[0][0].equals(slotMachine[0][1])
                    || slotMachine[0][1].equals(slotMachine[0][2]))) {
                winnings += 10;
                System.out.println("Double Carrot! +$10");
            }
            // BOTTOM ROW (2,0), (2,1), (2,2)
            if (slotMachine[2][0].equals(String.valueOf(Symbol.Carrot)) && slotMachine[2][0].equals(slotMachine[2][1])
                    && slotMachine[2][1].equals(slotMachine[2][2])) {
                System.out.println("Triple Carrot! +$15");
            } else if (slotMachine[2][1].equals(String.valueOf(Symbol.Carrot)) && (slotMachine[2][0].equals(slotMachine[2][1])
                    || slotMachine[2][1].equals(slotMachine[2][2]))) {
                winnings += 10;
                System.out.println("Double Carrot! +$10");
            }

        }
        // MIDDLE ROW (1,0), (1, 1), (1, 2)
        if (bet == 1 || bet == 2 || bet == 3) {
            if (slotMachine[1][0].equals(String.valueOf(Symbol.Carrot)) && slotMachine[1][0].equals(slotMachine[1][1])
                    && slotMachine[1][0].equals(slotMachine[1][2])) {
                System.out.println("Triple Carrot! +$15");
            } else if (slotMachine[1][1].equals(String.valueOf(Symbol.Carrot)) && (slotMachine[1][0].equals(slotMachine[1][1])
                    || slotMachine[1][1].equals(slotMachine[1][2]))) {
                winnings += 10;
                System.out.println("Double Carrot! +$10");
            }
        }

        return winnings;
    }

    public static int winnings(String[][] slotMachine, int positionI, int positionJ) {
        int winnings = 0;
        Random rand = new Random();

        if (slotMachine[positionI][positionJ].equals(String.valueOf(Symbol.Banana))) {
            System.out.println("Triple Banana! +$4");
            winnings += 4;
        }
        if (slotMachine[positionI][positionJ].equals(String.valueOf(Symbol.Foxes))) {
            System.out.println("Clever like Foxes! +$25");
            winnings += 25;
        }
        if (slotMachine[positionI][positionJ].equals(String.valueOf(Symbol.Bears))) {
            System.out.println("Bear HUG!! +$50");
            winnings += 50;
        }
        if (slotMachine[positionI][positionJ].equals(String.valueOf(Symbol.Stars))) {
            System.out.println("Shine bright like the stars!! +$100");
            winnings += 100;
        }
        if (slotMachine[positionI][positionJ].equals(String.valueOf(Symbol.Tiger))) {
            System.out.println("Who would cuddle with a tiger? +$300");
            winnings += 300;
        }
        if (slotMachine[positionI][positionJ].equals(String.valueOf(Symbol.Roses))) {
            System.out.println("Would a rose by any other name be worth as much? +$500!!");
            winnings += 500;
        }
        if (slotMachine[positionI][positionJ].equals(String.valueOf(Symbol.Sauce))) {
            String[] sauce = {"Hot Sauce is spicy! +$1000!!", "Smothered in chocolate sauce! +$1000!!",
                    "Swimming in red sauce! +$1000!!"};
            System.out.println(String.valueOf(sauce[rand.nextInt(sauce.length - 1)]));
            winnings += 1000;
        }
        return winnings;
    }

    public static int rows(String[][] slotMachine, int bet) {
        Random rand = new Random();
        int winnings = 0;
        if (bet == 2 || bet == 3) {
            if (Objects.equals(slotMachine[0][0], slotMachine[0][1]) && Objects.equals(slotMachine[0][1], slotMachine[0][2])) {
                winnings += winnings(slotMachine, 0, 0);
            }
            if (Objects.equals(slotMachine[2][0], slotMachine[2][1]) && Objects.equals(slotMachine[2][1], slotMachine[2][2])) {
                winnings += winnings(slotMachine, 2, 0);
            }
        }
        if (bet == 1 || bet == 2 || bet == 3) {
            if (Objects.equals(slotMachine[1][0], slotMachine[1][1]) && Objects.equals(slotMachine[1][1], slotMachine[1][2])) {
                winnings += winnings(slotMachine, 1, 0);

            }
        }
        return winnings;
    }

    public static int columns(String[][] slotMachine, int bet) {
        Random rand = new Random();
        int winnings = 0;
        if (bet == 3) {
            if (Objects.equals(slotMachine[0][0], slotMachine[1][0]) && Objects.equals(slotMachine[1][0], slotMachine[2][0])) {
                winnings += winnings(slotMachine, 0, 0);

            }
            if (Objects.equals(slotMachine[0][1], slotMachine[1][1]) && Objects.equals(slotMachine[1][1], slotMachine[2][1])) {
                winnings += winnings(slotMachine, 0, 1);
            }
        }
        if (Objects.equals(slotMachine[0][2], slotMachine[1][2]) && Objects.equals(slotMachine[1][2], slotMachine[2][2])) {
            winnings += winnings(slotMachine, 0, 2);
        }
        return winnings;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[][] slotMachine = new String[3][3];
        int cash = 1000;
        int winnings = 0;
        int betMenu = 0;
        while (cash > 4) {
            winnings = 0;
            System.out.println("Select Bet: \n1) Middle Row\n2) All Rows\n3) ALL Bets");
            betMenu = sc.nextInt();
            if (betMenu == 1 || betMenu == 2 || betMenu == 3) {


                printRandomSlots(slotMachine);

                winnings += bannanas(slotMachine, betMenu) + carrots(slotMachine, betMenu) + rows(slotMachine, betMenu)
                        + columns(slotMachine, betMenu) - betMenu * 5;
                cash += winnings;

                if (winnings >= 0) {
                    System.out.println("You WON $" + winnings + " total!!");
                } else {
                    System.out.println("You lost $" + Math.abs(winnings) + " total.");
                }
                System.out.println("Total cash is $" + cash);
            } else {
                System.out.println("Invalid bet selection.");
            }
        }
    }
}