import java.util.Random;
import java.util.Scanner;

//          Ray Joy
//          10/24/2024
//          SLOTS WITH ARRAYS
//        25% banana - 2 $ per banana. no matches required.
//        21% carrot - 10$ for 2 in a row. 15$ for 3 in a row.
//        18% fox - 25$ for 3 in a row.
//        10% bear - 50$ for 3 in a row.
//        8% stars - 100$ for 3 in a row.
//        7% tiger - 300$ for 3 in a row.
//        6% roses - 500$ for 3 in a row
//        5% hot sauce - 1000$ for 3 in a row
//        bets: min 5$ med 10$ max 15$    start with 1k cash
//        on min bets, only the middle three rows will be counted when looking for winning matches.
//        on med bets, all 3 rows are active but only horizontally.
//        on max bets, all rows are active in all directions.
public class Main {

    public enum Symbol {Banana, Carrot, Foxes, Bears, Stars, Tiger, Roses, Sauce}


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String[][] slotMachine = new String[3][3];
        int cash = 1000;
        int winnings;
        int betMenu;

        //Random Text outputs for winning
        String[] banana = {"Banana +$2", "BaNaNa +$2", "bAnAnA +$2", "Nanners +$2", "banana +$2", "BAAANNANA +$2"};
        String[] sauce = {"Hot Sauce is spicy! +$1000", "Smothered in chocolate sauce! +$1000",
                "Swimming in red sauce! +$1000"};
        while (cash > 4) {
            if (cash > 2000) {
                break;
            }
            System.out.println("Current cash is $" + cash);
            System.out.println("Enter bet:\n1) Middle Row -$5\n2) All Rows -$10\n3) All Bets -$15\n4) Key");
            betMenu = sc.nextInt();

            if (betMenu == 2 && cash < 10) {
                System.out.println("You do not have enough cash.");
                continue;
            }
            if (betMenu == 3 && cash < 15) {
                System.out.println("You do not have enough cash.");
                continue;
            }
            // See top for icons probability breakdown
            if (rand.nextDouble() <= 0.05) {
                slotMachine[0][0] = String.valueOf(Symbol.Sauce);
            } else if (rand.nextDouble() <= 0.06) {
                slotMachine[0][0] = String.valueOf(Symbol.Roses);
            } else if (rand.nextDouble() <= 0.07) {
                slotMachine[0][0] = String.valueOf(Symbol.Tiger);
            } else if (rand.nextDouble() <= 0.08) {
                slotMachine[0][0] = String.valueOf(Symbol.Stars);
            } else if (rand.nextDouble() <= 0.10) {
                slotMachine[0][0] = String.valueOf(Symbol.Bears);
            } else if (rand.nextDouble() <= 0.18) {
                slotMachine[0][0] = String.valueOf(Symbol.Foxes);
            } else if (rand.nextDouble() <= 0.21) {
                slotMachine[0][0] = String.valueOf(Symbol.Carrot);
            } else {
                slotMachine[0][0] = String.valueOf(Symbol.Banana);
            }
            if (rand.nextDouble() <= 0.05) {
                slotMachine[0][1] = String.valueOf(Symbol.Sauce);
            } else if (rand.nextDouble() <= 0.06) {
                slotMachine[0][1] = String.valueOf(Symbol.Roses);
            } else if (rand.nextDouble() <= 0.07) {
                slotMachine[0][1] = String.valueOf(Symbol.Tiger);
            } else if (rand.nextDouble() <= 0.08) {
                slotMachine[0][1] = String.valueOf(Symbol.Stars);
            } else if (rand.nextDouble() <= 0.10) {
                slotMachine[0][1] = String.valueOf(Symbol.Bears);
            } else if (rand.nextDouble() <= 0.18) {
                slotMachine[0][1] = String.valueOf(Symbol.Foxes);
            } else if (rand.nextDouble() <= 0.21) {
                slotMachine[0][1] = String.valueOf(Symbol.Carrot);
            } else {
                slotMachine[0][1] = String.valueOf(Symbol.Banana);
            }
            if (rand.nextDouble() <= 0.05) {
                slotMachine[0][2] = String.valueOf(Symbol.Sauce);
            } else if (rand.nextDouble() <= 0.06) {
                slotMachine[0][2] = String.valueOf(Symbol.Roses);
            } else if (rand.nextDouble() <= 0.07) {
                slotMachine[0][2] = String.valueOf(Symbol.Tiger);
            } else if (rand.nextDouble() <= 0.08) {
                slotMachine[0][2] = String.valueOf(Symbol.Stars);
            } else if (rand.nextDouble() <= 0.10) {
                slotMachine[0][2] = String.valueOf(Symbol.Bears);
            } else if (rand.nextDouble() <= 0.18) {
                slotMachine[0][2] = String.valueOf(Symbol.Foxes);
            } else if (rand.nextDouble() <= 0.21) {
                slotMachine[0][2] = String.valueOf(Symbol.Carrot);
            } else {
                slotMachine[0][2] = String.valueOf(Symbol.Banana);
            }

            if (rand.nextDouble() <= 0.05) {
                slotMachine[1][0] = String.valueOf(Symbol.Sauce);
            } else if (rand.nextDouble() <= 0.06) {
                slotMachine[1][0] = String.valueOf(Symbol.Roses);
            } else if (rand.nextDouble() <= 0.07) {
                slotMachine[1][0] = String.valueOf(Symbol.Tiger);
            } else if (rand.nextDouble() <= 0.08) {
                slotMachine[1][0] = String.valueOf(Symbol.Stars);
            } else if (rand.nextDouble() <= 0.10) {
                slotMachine[1][0] = String.valueOf(Symbol.Bears);
            } else if (rand.nextDouble() <= 0.18) {
                slotMachine[1][0] = String.valueOf(Symbol.Foxes);
            } else if (rand.nextDouble() <= 0.21) {
                slotMachine[1][0] = String.valueOf(Symbol.Carrot);
            } else {
                slotMachine[1][0] = String.valueOf(Symbol.Banana);
            }
            if (rand.nextDouble() <= 0.05) {
                slotMachine[1][1] = String.valueOf(Symbol.Sauce);
            } else if (rand.nextDouble() <= 0.06) {
                slotMachine[1][1] = String.valueOf(Symbol.Roses);
            } else if (rand.nextDouble() <= 0.07) {
                slotMachine[1][1] = String.valueOf(Symbol.Tiger);
            } else if (rand.nextDouble() <= 0.08) {
                slotMachine[1][1] = String.valueOf(Symbol.Stars);
            } else if (rand.nextDouble() <= 0.10) {
                slotMachine[1][1] = String.valueOf(Symbol.Bears);
            } else if (rand.nextDouble() <= 0.18) {
                slotMachine[1][1] = String.valueOf(Symbol.Foxes);
            } else if (rand.nextDouble() <= 0.21) {
                slotMachine[1][1] = String.valueOf(Symbol.Carrot);
            } else {
                slotMachine[1][1] = String.valueOf(Symbol.Banana);
            }
            if (rand.nextDouble() <= 0.05) {
                slotMachine[1][2] = String.valueOf(Symbol.Sauce);
            } else if (rand.nextDouble() <= 0.06) {
                slotMachine[1][2] = String.valueOf(Symbol.Roses);
            } else if (rand.nextDouble() <= 0.07) {
                slotMachine[1][2] = String.valueOf(Symbol.Tiger);
            } else if (rand.nextDouble() <= 0.08) {
                slotMachine[1][2] = String.valueOf(Symbol.Stars);
            } else if (rand.nextDouble() <= 0.10) {
                slotMachine[1][2] = String.valueOf(Symbol.Bears);
            } else if (rand.nextDouble() <= 0.18) {
                slotMachine[1][2] = String.valueOf(Symbol.Foxes);
            } else if (rand.nextDouble() <= 0.21) {
                slotMachine[1][2] = String.valueOf(Symbol.Carrot);
            } else {
                slotMachine[1][2] = String.valueOf(Symbol.Banana);
            }
            if (rand.nextDouble() <= 0.05) {
                slotMachine[2][0] = String.valueOf(Symbol.Sauce);
            } else if (rand.nextDouble() <= 0.06) {
                slotMachine[2][0] = String.valueOf(Symbol.Roses);
            } else if (rand.nextDouble() <= 0.07) {
                slotMachine[2][0] = String.valueOf(Symbol.Tiger);
            } else if (rand.nextDouble() <= 0.08) {
                slotMachine[2][0] = String.valueOf(Symbol.Stars);
            } else if (rand.nextDouble() <= 0.10) {
                slotMachine[2][0] = String.valueOf(Symbol.Bears);
            } else if (rand.nextDouble() <= 0.18) {
                slotMachine[2][0] = String.valueOf(Symbol.Foxes);
            } else if (rand.nextDouble() <= 0.21) {
                slotMachine[2][0] = String.valueOf(Symbol.Carrot);
            } else {
                slotMachine[2][0] = String.valueOf(Symbol.Banana);
            }
            if (rand.nextDouble() <= 0.05) {
                slotMachine[2][1] = String.valueOf(Symbol.Sauce);
            } else if (rand.nextDouble() <= 0.06) {
                slotMachine[2][1] = String.valueOf(Symbol.Roses);
            } else if (rand.nextDouble() <= 0.07) {
                slotMachine[2][1] = String.valueOf(Symbol.Tiger);
            } else if (rand.nextDouble() <= 0.08) {
                slotMachine[2][1] = String.valueOf(Symbol.Stars);
            } else if (rand.nextDouble() <= 0.10) {
                slotMachine[2][1] = String.valueOf(Symbol.Bears);
            } else if (rand.nextDouble() <= 0.18) {
                slotMachine[2][1] = String.valueOf(Symbol.Foxes);
            } else if (rand.nextDouble() <= 0.21) {
                slotMachine[2][1] = String.valueOf(Symbol.Carrot);
            } else {
                slotMachine[2][1] = String.valueOf(Symbol.Banana);
            }
            if (rand.nextDouble() <= 0.05) {
                slotMachine[2][2] = String.valueOf(Symbol.Sauce);
            } else if (rand.nextDouble() <= 0.06) {
                slotMachine[2][2] = String.valueOf(Symbol.Roses);
            } else if (rand.nextDouble() <= 0.07) {
                slotMachine[2][2] = String.valueOf(Symbol.Tiger);
            } else if (rand.nextDouble() <= 0.08) {
                slotMachine[2][2] = String.valueOf(Symbol.Stars);
            } else if (rand.nextDouble() <= 0.10) {
                slotMachine[2][2] = String.valueOf(Symbol.Bears);
            } else if (rand.nextDouble() <= 0.18) {
                slotMachine[2][2] = String.valueOf(Symbol.Foxes);
            } else if (rand.nextDouble() <= 0.21) {
                slotMachine[2][2] = String.valueOf(Symbol.Carrot);
            } else {
                slotMachine[2][2] = String.valueOf(Symbol.Banana);
            }
            System.out.println("| " + slotMachine[0][0] + " | " + slotMachine[0][1] + " | " + slotMachine[0][2] + " |" +
                    "\n| " + slotMachine[1][0] + " | " + slotMachine[1][1] + " | " + slotMachine[1][2] + " |" +
                    "\n| " + slotMachine[2][0] + " | " + slotMachine[2][1] + " | " + slotMachine[2][2] + " |");
            winnings = 0;
            switch (betMenu) {
                case 3:
                    winnings -= 5;

                    //FIRST COLUMN (0,0), (1,0), (2,0)
                    if (slotMachine[0][0].equals(String.valueOf(Symbol.Banana))
                            && slotMachine[0][0].equals(slotMachine[1][0]) && slotMachine[1][0].equals(slotMachine[2][0])) {
                        winnings += 4;
                        System.out.println("Triple Banana! +$4");
                    }
                    if (slotMachine[0][0].equals(String.valueOf(Symbol.Carrot))
                            && slotMachine[0][0].equals(slotMachine[1][0]) && slotMachine[1][0].equals(slotMachine[2][0])) {
                        winnings += 15;
                        System.out.println("Triple Carrot! +$15");
                    } else if (slotMachine[0][0].equals(String.valueOf(Symbol.Carrot)) && slotMachine[0][0].equals(slotMachine[1][0])
                            || slotMachine[1][0].equals(String.valueOf(Symbol.Carrot)) && slotMachine[1][0].equals(slotMachine[2][0])) {
                        winnings += 10;
                        System.out.println("Double Carrot! +$10");
                    }
                    if (slotMachine[0][0].equals(String.valueOf(Symbol.Foxes))
                            && slotMachine[0][0].equals(slotMachine[1][0]) && slotMachine[1][0].equals(slotMachine[2][0])) {
                        winnings += 25;
                        System.out.println("Cleaver like Foxes! +$25");
                    }
                    if (slotMachine[0][0].equals(String.valueOf(Symbol.Bears))
                            && slotMachine[0][0].equals(slotMachine[1][0]) && slotMachine[1][0].equals(slotMachine[2][0])) {
                        winnings += 50;
                        System.out.println("Bear HUG! +$50");
                    }
                    if (slotMachine[0][0].equals(String.valueOf(Symbol.Stars))
                            && slotMachine[0][0].equals(slotMachine[1][0]) && slotMachine[1][0].equals(slotMachine[2][0])) {
                        winnings += 100;
                        System.out.println("Shine bright like the stars! +$100");
                    }
                    if (slotMachine[0][0].equals(String.valueOf(Symbol.Tiger))
                            && slotMachine[0][0].equals(slotMachine[1][0]) && slotMachine[1][0].equals(slotMachine[2][0])){
                        winnings += 300;
                        System.out.println("Who would cuddle with a tiger? +$300");
                    }
                    if (slotMachine[0][0].equals(String.valueOf(Symbol.Roses))
                            && slotMachine[0][0].equals(slotMachine[1][0]) && slotMachine[1][0].equals(slotMachine[2][0])) {
                        winnings += 500;
                        System.out.println("Would a rose by any other name be worth as much? +$500");
                    }
                    if (slotMachine[0][0].equals(String.valueOf(Symbol.Sauce))
                            && slotMachine[0][0].equals(slotMachine[1][0]) && slotMachine[1][0].equals(slotMachine[2][0])) {
                        winnings += 1000;
                        System.out.println(sauce[rand.nextInt(sauce.length)]);
                    }

                    // MIDDLE COLUMN (0,1), (1,1), (2,1)
                    if (slotMachine[0][1].equals(String.valueOf(Symbol.Banana))
                            && slotMachine[0][1].equals(slotMachine[1][1]) && slotMachine[1][1].equals(slotMachine[2][1])) {
                        winnings += 4;
                        System.out.println("Triple Banana! +$4");
                    }
                    if (slotMachine[0][1].equals(String.valueOf(Symbol.Carrot))
                            && slotMachine[0][1].equals(slotMachine[1][1]) && slotMachine[1][1].equals(slotMachine[2][1])) {
                        winnings += 15;
                        System.out.println("Triple Carrot! +$15");
                    } else if (slotMachine[0][1].equals(String.valueOf(Symbol.Carrot)) && slotMachine[0][1].equals(slotMachine[1][1])
                            || slotMachine[1][1].equals(String.valueOf(Symbol.Carrot)) && slotMachine[1][1].equals(slotMachine[2][1])) {
                        winnings += 10;
                        System.out.println("Double Carrot! +$10");
                    }
                    if (slotMachine[0][1].equals(String.valueOf(Symbol.Foxes))
                            && slotMachine[0][1].equals(slotMachine[1][1]) && slotMachine[1][1].equals(slotMachine[2][1])) {
                        winnings += 25;
                        System.out.println("Cleaver like Foxes! +$25");
                    }
                    if (slotMachine[0][1].equals(String.valueOf(Symbol.Bears))
                            && slotMachine[0][1].equals(slotMachine[1][1]) && slotMachine[1][1].equals(slotMachine[2][1])) {
                        winnings += 50;
                        System.out.println("Bear HUG! +$50");
                    }
                    if (slotMachine[0][1].equals(String.valueOf(Symbol.Stars))
                            && slotMachine[0][1].equals(slotMachine[1][1]) && slotMachine[1][1].equals(slotMachine[2][1])) {
                        winnings += 100;
                        System.out.println("Shine bright like the stars! +$100");
                    }
                    if (slotMachine[0][1].equals(String.valueOf(Symbol.Tiger))
                            && slotMachine[0][1].equals(slotMachine[1][1]) && slotMachine[1][1].equals(slotMachine[2][1])){
                        winnings += 300;
                        System.out.println("Who would cuddle with a tiger? +$300");
                    }
                    if (slotMachine[0][1].equals(String.valueOf(Symbol.Roses))
                            && slotMachine[0][1].equals(slotMachine[1][1]) && slotMachine[1][1].equals(slotMachine[2][1])) {
                        winnings += 500;
                        System.out.println("Would a rose by any other name be worth as much? +$500");
                    }
                    if (slotMachine[0][1].equals(String.valueOf(Symbol.Sauce))
                            && slotMachine[0][1].equals(slotMachine[1][1]) && slotMachine[1][1].equals(slotMachine[2][1])) {
                        winnings += 1000;
                        System.out.println(sauce[rand.nextInt(sauce.length)]);
                    }

                    // RIGHT COLUMN (0,2), (1,2), (2,2)
                    if (slotMachine[0][2].equals(String.valueOf(Symbol.Banana))
                            && slotMachine[0][2].equals(slotMachine[1][2]) && slotMachine[1][2].equals(slotMachine[2][2])) {
                        winnings += 4;
                        System.out.println("Triple Banana! +$4");
                    }
                    if (slotMachine[0][2].equals(String.valueOf(Symbol.Carrot))
                            && slotMachine[0][2].equals(slotMachine[1][2]) && slotMachine[1][2].equals(slotMachine[2][2])) {
                        winnings += 15;
                        System.out.println("Triple Carrot! +$15");
                    } else if (slotMachine[0][2].equals(String.valueOf(Symbol.Carrot)) && slotMachine[0][2].equals(slotMachine[1][2])
                            || slotMachine[1][2].equals(String.valueOf(Symbol.Carrot)) && slotMachine[1][2].equals(slotMachine[2][2])) {
                        winnings += 10;
                        System.out.println("Double Carrot! +$10");
                    }
                    if (slotMachine[0][2].equals(String.valueOf(Symbol.Foxes))
                            && slotMachine[0][2].equals(slotMachine[1][2]) && slotMachine[1][2].equals(slotMachine[2][2])) {
                        winnings += 25;
                        System.out.println("Cleaver like Foxes! +$25");
                    }
                    if (slotMachine[0][2].equals(String.valueOf(Symbol.Bears))
                            && slotMachine[0][2].equals(slotMachine[1][2]) && slotMachine[1][2].equals(slotMachine[2][2])) {
                        winnings += 50;
                        System.out.println("Bear HUG! +$50");
                    }
                    if (slotMachine[0][2].equals(String.valueOf(Symbol.Stars))
                            && slotMachine[0][2].equals(slotMachine[1][2]) && slotMachine[1][2].equals(slotMachine[2][2])) {
                        winnings += 100;
                        System.out.println("Shine bright like the stars! +$100");
                    }
                    if (slotMachine[0][2].equals(String.valueOf(Symbol.Tiger))
                            && slotMachine[0][2].equals(slotMachine[1][2]) && slotMachine[1][2].equals(slotMachine[2][2])){
                        winnings += 300;
                        System.out.println("Who would cuddle with a tiger? +$300");
                    }
                    if (slotMachine[0][2].equals(String.valueOf(Symbol.Roses))
                            && slotMachine[0][2].equals(slotMachine[1][2]) && slotMachine[1][2].equals(slotMachine[2][2])) {
                        winnings += 500;
                        System.out.println("Would a rose by any other name be worth as much? +$500");
                    }
                    if (slotMachine[0][2].equals(String.valueOf(Symbol.Sauce))
                            && slotMachine[0][2].equals(slotMachine[1][2]) && slotMachine[1][2].equals(slotMachine[2][2])) {
                        winnings += 1000;
                        System.out.println(sauce[rand.nextInt(sauce.length)]);
                    }
                case 2:
                    winnings -= 5;

                    // TOP ROW (0,0), (0,1), (0,2)
                    if (slotMachine[0][0].equals(String.valueOf(Symbol.Banana))) {
                        winnings += 2;
                        System.out.println(banana[rand.nextInt(banana.length)]);
                    }
                    if (slotMachine[0][1].equals(String.valueOf(Symbol.Banana))) {
                        winnings += 2;
                        System.out.println(banana[rand.nextInt(banana.length)]);
                    }
                    if (slotMachine[0][2].equals(String.valueOf(Symbol.Banana))) {
                        winnings += 2;
                        System.out.println(banana[rand.nextInt(banana.length)]);
                    }
                    if (slotMachine[0][0].equals(String.valueOf(Symbol.Banana))
                            && slotMachine[0][0].equals(slotMachine[0][1]) && slotMachine[0][1].equals(slotMachine[0][2])) {
                        winnings += 4;
                        System.out.println("Triple Banana! +$4");
                    }
                    if (slotMachine[0][0].equals(String.valueOf(Symbol.Carrot))
                            && slotMachine[0][0].equals(slotMachine[0][1]) && slotMachine[0][1].equals(slotMachine[0][2])) {
                        winnings += 15;
                        System.out.println("Triple Carrot! +$15");
                    } else if (slotMachine[0][0].equals(String.valueOf(Symbol.Carrot)) && slotMachine[0][0].equals(slotMachine[0][1])
                            || slotMachine[0][1].equals(String.valueOf(Symbol.Carrot)) && slotMachine[0][1].equals(slotMachine[0][2])) {
                        winnings += 10;
                        System.out.println("Double Carrot! +$10");
                    }
                    if (slotMachine[0][0].equals(String.valueOf(Symbol.Foxes))
                            && slotMachine[0][0].equals(slotMachine[0][1]) && slotMachine[0][1].equals(slotMachine[0][2])) {
                        winnings += 25;
                        System.out.println("Cleaver like Foxes! +$25");
                    }
                    if (slotMachine[0][0].equals(String.valueOf(Symbol.Bears))
                            && slotMachine[0][0].equals(slotMachine[0][1]) && slotMachine[0][1].equals(slotMachine[0][2])) {
                        winnings += 50;
                        System.out.println("Bear HUG! +$50");
                    }
                    if (slotMachine[0][0].equals(String.valueOf(Symbol.Stars))
                            && slotMachine[0][0].equals(slotMachine[0][1]) && slotMachine[0][1].equals(slotMachine[0][2])) {
                        winnings += 100;
                        System.out.println("Shine bright like the stars! +$100");
                    }
                    if (slotMachine[0][0].equals(String.valueOf(Symbol.Tiger))
                            && slotMachine[0][0].equals(slotMachine[0][1]) && slotMachine[0][1].equals(slotMachine[0][2])){
                        winnings += 300;
                        System.out.println("Who would cuddle with a tiger? +$300");
                    }
                    if (slotMachine[0][0].equals(String.valueOf(Symbol.Roses))
                            && slotMachine[0][0].equals(slotMachine[0][1]) && slotMachine[0][1].equals(slotMachine[0][2])) {
                        winnings += 500;
                        System.out.println("Would a rose by any other name be worth as much? +$500");
                    }
                    if (slotMachine[0][0].equals(String.valueOf(Symbol.Sauce))
                            && slotMachine[0][0].equals(slotMachine[0][1]) && slotMachine[0][1].equals(slotMachine[0][2])) {
                        winnings += 1000;
                        System.out.println(sauce[rand.nextInt(sauce.length)]);
                    }

                    // BOTTOM ROW (2,0), (2,1), (2,2)
                    if (slotMachine[2][0].equals(String.valueOf(Symbol.Banana))) {
                        winnings += 2;
                        System.out.println(banana[rand.nextInt(banana.length)]);
                    }
                    if (slotMachine[2][1].equals(String.valueOf(Symbol.Banana))) {
                        winnings += 2;
                        System.out.println(banana[rand.nextInt(banana.length)]);
                    }
                    if (slotMachine[2][2].equals(String.valueOf(Symbol.Banana))) {
                        winnings += 2;
                        System.out.println(banana[rand.nextInt(banana.length)]);
                    }
                    if (slotMachine[2][0].equals(String.valueOf(Symbol.Banana))
                            && slotMachine[2][0].equals(slotMachine[2][1]) && slotMachine[2][0].equals(slotMachine[2][2])) {
                        winnings += 4;
                        System.out.println("Triple Banana! +$4");
                    }
                    if (slotMachine[2][0].equals(String.valueOf(Symbol.Carrot))
                            && slotMachine[2][0].equals(slotMachine[2][1]) && slotMachine[2][0].equals(slotMachine[2][2])) {
                        winnings += 15;
                        System.out.println("Triple Carrot! +$15");
                    } else if (slotMachine[2][0].equals(String.valueOf(Symbol.Carrot)) && slotMachine[2][0].equals(slotMachine[2][1])
                            || slotMachine[2][1].equals(String.valueOf(Symbol.Carrot)) && slotMachine[2][1].equals(slotMachine[2][2])) {
                        winnings += 10;
                        System.out.println("Double Carrot! +$10");
                    }
                    if (slotMachine[2][0].equals(String.valueOf(Symbol.Foxes))
                            && slotMachine[2][0].equals(slotMachine[2][1]) && slotMachine[2][0].equals(slotMachine[2][2])) {
                        winnings += 25;
                        System.out.println("Cleaver like Foxes! +$25");
                    }
                    if (slotMachine[2][0].equals(String.valueOf(Symbol.Bears))
                            && slotMachine[2][0].equals(slotMachine[2][1]) && slotMachine[2][0].equals(slotMachine[2][2])) {
                        winnings += 50;
                        System.out.println("Bear HUG! +$50");
                    }
                    if (slotMachine[2][0].equals(String.valueOf(Symbol.Stars))
                            && slotMachine[2][0].equals(slotMachine[2][1]) && slotMachine[2][0].equals(slotMachine[2][2])) {
                        winnings += 100;
                        System.out.println("Shine bright like the stars! +$100");
                    }
                    if (slotMachine[2][0].equals(String.valueOf(Symbol.Tiger))
                            && slotMachine[2][0].equals(slotMachine[2][1]) && slotMachine[2][0].equals(slotMachine[2][2])){
                        winnings += 300;
                        System.out.println("Who would cuddle with a tiger? +$300");
                    }
                    if (slotMachine[2][0].equals(String.valueOf(Symbol.Roses))
                            && slotMachine[2][0].equals(slotMachine[2][1]) && slotMachine[2][0].equals(slotMachine[2][2])) {
                        winnings += 500;
                        System.out.println("Would a rose by any other name be worth as much? +$500");
                    }
                    if (slotMachine[2][0].equals(String.valueOf(Symbol.Sauce))
                            && slotMachine[2][0].equals(slotMachine[2][1]) && slotMachine[2][0].equals(slotMachine[2][2])) {
                        winnings += 1000;
                        System.out.println(sauce[rand.nextInt(sauce.length)]);
                    }
                case 1:
                    winnings -= 5;

                    // MIDDLE ROW
                    if (slotMachine[1][0].equals(String.valueOf(Symbol.Banana))) {
                        winnings += 2;
                        System.out.println(banana[rand.nextInt(banana.length)]);
                    }
                    if (slotMachine[1][1].equals(String.valueOf(Symbol.Banana))) {
                        winnings += 2;
                        System.out.println(banana[rand.nextInt(banana.length)]);
                    }
                    if (slotMachine[1][2].equals(String.valueOf(Symbol.Banana))) {
                        winnings += 2;
                        System.out.println(banana[rand.nextInt(banana.length)]);
                    }
                    if (slotMachine[1][0].equals(String.valueOf(Symbol.Banana))
                            && slotMachine[1][0].equals(slotMachine[1][1]) && slotMachine[1][0].equals(slotMachine[1][2])) {
                        winnings += 4;
                        System.out.println("Triple Banana! +$4");
                    }
                    if (slotMachine[1][0].equals(String.valueOf(Symbol.Carrot))
                            && slotMachine[1][0].equals(slotMachine[1][1]) && slotMachine[1][0].equals(slotMachine[1][2])) {
                        winnings += 15;
                        System.out.println("Triple Carrot! +$15");
                    } else if (slotMachine[1][0].equals(String.valueOf(Symbol.Carrot)) && slotMachine[1][0].equals(slotMachine[1][1])
                            || slotMachine[1][1].equals(String.valueOf(Symbol.Carrot)) && slotMachine[1][1].equals(slotMachine[1][2])) {
                        winnings += 10;
                        System.out.println("Double Carrot! +$10");
                    }
                    if (slotMachine[1][0].equals(String.valueOf(Symbol.Foxes))
                            && slotMachine[1][0].equals(slotMachine[1][1]) && slotMachine[1][0].equals(slotMachine[1][2])) {
                        winnings += 25;
                        System.out.println("Cleaver like Foxes! +$25");
                }
                    if (slotMachine[1][0].equals(String.valueOf(Symbol.Bears))
                            && slotMachine[1][0].equals(slotMachine[1][1]) && slotMachine[1][0].equals(slotMachine[1][2])) {
                        winnings += 50;
                        System.out.println("Bear HUG! +$50");
                    }
                    if (slotMachine[1][0].equals(String.valueOf(Symbol.Stars))
                            && slotMachine[1][0].equals(slotMachine[1][1]) && slotMachine[1][0].equals(slotMachine[1][2])) {
                        winnings += 100;
                        System.out.println("Shine bright like the stars! +$100");
                }
                    if (slotMachine[1][0].equals(String.valueOf(Symbol.Tiger))
                            && slotMachine[1][0].equals(slotMachine[1][1]) && slotMachine[1][0].equals(slotMachine[1][2])){
                        winnings += 300;
                        System.out.println("Who would cuddle with a tiger? +$300");
                    }
                    if (slotMachine[1][0].equals(String.valueOf(Symbol.Roses))
                            && slotMachine[1][0].equals(slotMachine[1][1]) && slotMachine[1][0].equals(slotMachine[1][2])) {
                        winnings += 500;
                        System.out.println("Would a rose by any other name be worth as much? +$500");
                    }
                    if (slotMachine[1][0].equals(String.valueOf(Symbol.Sauce))
                            && slotMachine[1][0].equals(slotMachine[1][1]) && slotMachine[1][0].equals(slotMachine[1][2])) {
                        winnings += 1000;
                        System.out.println(sauce[rand.nextInt(sauce.length)]);
                    }


                    if (winnings > 0) {
                        System.out.println("You WIN $" + winnings + " total, congratulations!!");
                    } else {
                        System.out.println("You lost $" + Math.abs(winnings) + " total, better luck next time.");
                    }
                    cash += winnings;
                    break;
                case 4:
                    System.out.println("KEY:\nBanana $2 per, $4 bonus for 3 in a row\nCarrot $10 for two in row, $15 for 3 in row" +
                            "\nFoxes $25 for 3 in row\nBears $40 for 3 in row\nStars $100 for 3 in row\nTiger $300 for 3 in row" +
                            "\nRoses $500 for 3 in row\nSauce $1000 for 3 in row");
                    break;

                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
        if (cash < 5) {
            System.out.println("You are out of cash, goodbye");
        } else {
            System.out.println("Congratulations!! Your total payout is $" + cash + ". Thank you for playing.");
        }
    }
}