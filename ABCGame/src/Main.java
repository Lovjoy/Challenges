import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 * Developer Ray Hobbs
 * Date 11/11/2024
 * Challenge - Tree Game Always Be Chopping - Reach level 100 to win
 * Player has a starting max inventory size of 8 logs that is upgradable in the shop.
 * If the player is chopping and the inventory is full, they walk away from the tree and leaves extra
 * logs behind. If a player tries to chop logs with a full inventory, it gives an error message.
 * Players required to sell before selecting a tree type to chop.
 * Each level of woodcutting increases the xp required to level up. The first
 * level of woodcutting will require 100 xp, and for each additional level, the
 * required XP to level up will increase by 7.5%.
 * When the tree is successfully chopped down and yields its max logs there is a
 * chance that there will be a small speed potion, strength potion, or bag of gold.
 * The chance of a reward increases with axe upgrade.
 * If the tree falls before giving all the logs there is a chance the player will lose all the
 * logs chopped that turn. The chance decreases with upgraded axe.
 * Players may upgrade their axe, and will start with a rusty axe which provides no bonus. The player can
 * purchase the following items from the shops:
 * repair - 5% axe cost coins || may go in debt to repair || restores axe to fixed
 * potion of speed 500 coins || doubles chop speed for 200 chops || stacking increases the durations of chops
 * potion of strength - 500 coins || triples cut chance for 200 chops || stacking increases the duration of chops
 * bag upgrade - starts 200g and 3x price each bag upgrade || doubles bag space
 */

public class Main {
    public enum AXE {
        Rusty, Bronze, Iron, Steel, Obsidian, Mithril, Adamant, Runed, Enchanted
    }
    public enum TREE {
        Normal, Oak, Willow, Maple, Yew, Magic
    }
    static boolean axeBroken = false;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int playerLevel = 1; 			// Starts at level one, game won at level 100
        int playerTotalXp = 0; 			// Player current experience at current level
        int totalXpToLevel = 100; 		// Player total experience must reach to increase level by one, increases by 7.5% each level
        int newLogs; 					// How many logs received after exploring forest
        int coins = 0; 					// Total gold
        int goldValueOfLogs = 0;		// Temp hold gold value of logs before they are sold
        int menu = 6; 					// Main menu, starts with Player Stats
        TREE[] forest = new TREE[4]; 	// Four trees player to pick from to chop
        int treeMenu = 0; 				// Player picks one of 4 trees
        TREE selectedTree; 				// Tree player picked
        double axeBreakChance = 0.005; 	// Percent chance axe will break on successful chop, increases with each chop
        AXE playerAxe = AXE.Rusty; 		// Current Axe, starts with Rusty
        char exit = 'n'; 				// End Game confirmation
        int shopMenu = 0; 				// Shop menu choice
        int[] logsAndChops = new int[2];// After exploring forest, holds how many logs yield and how many total chops
        int bagSize = 8; 				// How many logs player can hold, can upgrade in shop to double size
        int costDoubleBag = 200; 		// Cost to double bag size in shop, price triples with each upgrade
        int logsInBag = 0; 				// Current logs in held in bag
        boolean speedPot = false; 		// Speed Potion Active, halves time between chops
        boolean strengthPot = false; 	// Strength Potion Active, triples chance chop will yield log
        int speedPotCountLeft = 0; 		// Potion only active at least a certain number of chops
        int strPotCountLeft = 0; 		// Potion only active at least a certain number of chops
        int quantity = 1; 				// How many potions buy in shop
        int cost = 100; 				// cost based on quantity
        String [] gameSave = new String[8]; // Used to store data from game save and load


        // TEST
//        int playerLevel = 74;           // Starts at level one, game won at level 100
//        int playerTotalXp = 0;          // Player current experience at current level
//        int totalXpToLevel = 20000;      // Player total experience must reach to increase level by one
//        int newLogs;                    // How many logs received after exploring forest
//        int coins = 50000;              // Total gold
//        int goldValueOfLogs = 0;        // Temp hold gold value of logs before they are sold
//        int menu = 6;                   // Main menu, starts with Player Stats
//        TREE[] forest = new TREE[4];    // Four trees player to pick from to chop
//        int treeMenu = 0;                 // Player picks one of 4 trees
//        TREE selectedTree;              // Tree player picked
//        double axeBreakChance = 0.0005;      // Percent chance axe will break on successful chop, increases with each chop
//        AXE playerAxe = AXE.Adamant;      // Current Axe, starts with Rusty
//        char exit = 'n';                // End Game confirmation
//        int shopMenu = 0;               // Shop menu choice
//        int[] logsAndChops = new int[2];// After exploring forest, holds how many logs yield and how many total chops
//        int bagSize = 128;               // How many logs player can hold, can upgrade in shop to double size
//        int costDoubleBag = 16200;        // Cost to double bag size in shop, price triples with each upgrade
//        int logsInBag = 0;              // Current logs in held in bag
//        boolean speedPot = true;       // Speed Potion Active, halves time between chops
//        boolean strengthPot = false;    // Strength Potion Active, triples chance chop will yield log
//        int speedPotCountLeft = 100;      // Potion only active at least a certain number of chops
//        int strPotCountLeft = 0;        // Potion only active at least a certain number of chops
//		int quantity = 1; 					// cost based on quantity
//		int cost = 100; 						// cost based on quantity

        System.out.println("\nWelcome to \nAlways Be Chopping!!!\nReach level 100 to win.");
        while (playerLevel < 100) {

            switch (menu) {
                case 1: // Explore forest
                    if (axeBroken) {
                        System.out.println("You must repair your axe.");
                        break;
                    }
                    // Deactivate Potions if no counts remaining
                    if (speedPot) {
                        speedPotCountLeft -= logsAndChops[1];
                        if (speedPotCountLeft <= 0) {
                            speedPot = false;
                            speedPotCountLeft = 0;
                        }
                    }
                    if (strengthPot) {
                        strPotCountLeft -= logsAndChops[1];
                        if (strPotCountLeft <= 0) {
                            strengthPot = false;
                            strPotCountLeft = 0;
                        }
                    }
                    // Prints Forest and Select Tree
                    forest = generateForest(playerLevel);


                    // Catches invalid tree select options
                    try {
                        sc = new Scanner(System.in);
                        treeMenu = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("ERROR: Invalid Menu Option, please try again.");
                    }
                    if (treeMenu > 4 || treeMenu  < 1) {
                        System.out.println("ERROR: Invalid Menu Option, please try again.");
                        break;
                    }
                    // Selects tree from Array
                    selectedTree = forest[treeMenu - 1];

                    // Chops Tree and assign new logs chopped and decrease durability depending on
                    // how many chops
                    logsAndChops = cutLogs(playerAxe, selectedTree, axeBreakChance, speedPot, strengthPot);
                    newLogs = logsAndChops[0];
                    axeBreakChance += durabilityLost(playerAxe) * logsAndChops[1];

                    // Chance to find potion or bag of gold when tree is fully chopped down. More likely with upgraded axe
                    if (newLogs == maxLogs(selectedTree)) {

                        if (rand.nextDouble() < axeBonusPercent(playerAxe)) {
                            int randomNumber = rand.nextInt(3);
                            if (randomNumber == 0) {
                                speedPot = true;
                                speedPotCountLeft += 100;
                                System.out.println("You find a potion of speed after the tree was chopped. You now chop twice " +
                                        "as fast for at least " + speedPotCountLeft + " chops.");
                            }
                            if (randomNumber == 1) {
                                strengthPot = true;
                                strPotCountLeft += 100;
                                System.out.println("You find a potion of strength after the tree was chopped. You now have " +
                                        "triple the chance of receiving a log for at least " + strPotCountLeft + " chops.");
                            }
                            if (randomNumber == 2) {
                                coins += (5 * playerLevel);
                                System.out.println("You found a small bag of " + (5 * playerLevel) + " coins.");
                            }
                        }
                    }
                    // If more logs than space in bag, player will leave logs behind
                    if (newLogs < (bagSize - logsInBag)) {
                        goldValueOfLogs += goldValueOfLogs(selectedTree, newLogs);
                        playerTotalXp += experienceGained(selectedTree, logsAndChops[0]);
                        logsInBag += newLogs;
                        System.out.println(newLogs + " new logs added to bag. " + logsInBag + "/" + bagSize + " total logs in bag.");
                    } else {
                        System.out.println("You have " + bagSize + " logs and the bag is full, you leave behind "
                                + (logsInBag + newLogs - bagSize) + " logs.");
                        // Only gain gold from logs in bag, gain XP from logs chopped. does not receive any gold for logs left
                        // behind
                        goldValueOfLogs += goldValueOfLogs(selectedTree, bagSize - logsInBag);
                        playerTotalXp += experienceGained(selectedTree, logsAndChops[0]);
                        logsInBag = bagSize;
                    }
                    // Player levels up
                    if (playerTotalXp >= totalXpToLevel) {
                        playerLevel++;
                        System.out.println("You have reached Level " + playerLevel + "!");
                        playerTotalXp -= totalXpToLevel;
                        totalXpToLevel = (int) (100 * Math.pow(1.075, (playerLevel - 1)));
                    }
                    break;

                // Sell Logs
                case 2:
                    coins += goldValueOfLogs;
                    System.out.print("You sold " + logsInBag + " logs for " + goldValueOfLogs + "g and have a total of ");
                    System.out.printf("%,d gold.\n", coins);
                    goldValueOfLogs = 0;
                    logsInBag = 0;
                    break;

                // Repair
                case 3:
                    axeBroken = false;
                    axeBreakChance = 0;
                    coins -= (int) (0.05 * axeGoldValue(playerAxe));
                    System.out.println("Your " + String.valueOf(playerAxe) + " axe has been repaired for "
                            + (int)(0.05 * axeGoldValue(playerAxe)) + " gold.");
                    break;

                // Axe Upgrade
                case 4:
                    AXE axePurchased = AXE.Rusty;
                    System.out.printf("Total Coins: %,d gold", coins);
                    System.out.printf("\nCurrent Axe: " + String.valueOf(playerAxe));
                    System.out.println("\nSelect an Axe or Exit");
                    System.out.printf(
                            "1) %s Axe %,dg\n2) %s Axe %,dg\n3) %s Axe %,dg\n4) %s Axe %,dg\n5) %s Axe %,dg\n6) %s Axe %,dg\n7) %s Axe %,dg\n8) %s Axe %,dg\n9) Exit\n",
                            String.valueOf(AXE.Bronze), axeGoldValue(AXE.Bronze), String.valueOf(AXE.Iron),
                            axeGoldValue(AXE.Iron), String.valueOf(AXE.Steel), axeGoldValue(AXE.Steel),
                            String.valueOf(AXE.Obsidian), axeGoldValue(AXE.Obsidian), String.valueOf(AXE.Mithril),
                            axeGoldValue(AXE.Mithril), String.valueOf(AXE.Adamant), axeGoldValue(AXE.Adamant),
                            String.valueOf(AXE.Runed), axeGoldValue(AXE.Runed), String.valueOf(AXE.Enchanted),
                            axeGoldValue(AXE.Enchanted));
                    shopMenu = sc.nextInt();

                    switch (shopMenu) {
                        case 1:
                            axePurchased = AXE.Bronze;
                            break;
                        case 2:
                            axePurchased = AXE.Iron;
                            break;
                        case 3:
                            axePurchased = AXE.Steel;
                            break;
                        case 4:
                            axePurchased = AXE.Obsidian;
                            break;
                        case 5:
                            axePurchased = AXE.Mithril;
                            break;
                        case 6:
                            axePurchased = AXE.Adamant;
                            break;
                        case 7:
                            axePurchased = AXE.Runed;
                            break;
                        case 8:
                            axePurchased = AXE.Enchanted;
                            break;
                        case 9:
                        default:
                            break;
                    }
                    // Makes sure axe purchases is an upgrade from current axe and player has enough
                    // gold. Resets durability
                    if (axeGoldValue(playerAxe) < axeGoldValue(axePurchased) && axeGoldValue(axePurchased) < coins) {
                        coins -= axeGoldValue(axePurchased);
                        playerAxe = axePurchased;
                        axeBroken = false;
                        axeBreakChance = 0;
                        System.out.println("You purchased " + String.valueOf(axePurchased) + " for "
                                + axeGoldValue(axePurchased) + " gold.");
                        System.out.printf("Axe Bonus: %.0f%%\nChance tree will fall: %.0f%%",
                                100 * axeBonusPercent(playerAxe), 100 * fallChance(playerAxe));
                    } else {
                        System.out.println("Invalid Purchase");
                    }
                    break;
                // Chop Shop for double bag size and potions
                case 5:
                    System.out.println("CHOP SHOP\n");
                    System.out.printf("Total Coins: %,d gold", coins);
                    System.out.printf("\nTotal Bag Space is " + bagSize);
                    System.out.println("\n1) Double Bag Size " + costDoubleBag
                            + "g\n2) Speed Potion " + (100 + 5 * playerLevel) + "g\n3) Strength Potion "
                            + (100 + 5 * playerLevel) + "g\n4) Exit");
                    shopMenu = sc.nextInt();
                    if (shopMenu != 1) {
                        System.out.print("Quantity: ");
                        quantity = sc.nextInt();
                        cost = (100 + 5 * playerLevel) * quantity;
                    }
                    // Double bag size, each upgrade of bag triple the price for next bag upgrade
                    if (shopMenu == 1 && coins >= costDoubleBag) {
                        bagSize *= 2;
                        coins -= costDoubleBag;
                        System.out.println("You purchased " + bagSize + " slot bag for " + costDoubleBag + " gold.");
                        costDoubleBag *= 3;
                    }
                    // Speed and Strength Pots, additional potions purchased increases the duration
                    else if (shopMenu == 2 && coins >= cost) {
                        speedPot = true;
                        speedPotCountLeft += (100 + 2 * playerLevel) * quantity;
                        coins -= cost;
                        System.out.println("You purchased a potion of speed for " +  cost + "g. Additional purchases increase the duration.");
                        System.out.println("You now chop twice as fast for at least " + speedPotCountLeft + " chops.");
                    } else if (shopMenu == 3 && coins >= cost) {
                        strengthPot = true;
                        strPotCountLeft += (100 + 2 * playerLevel) * quantity;
                        coins -= cost;
                        System.out.println("You purchased a potion of strength for " + cost + "g. Additional purchases increase the duration.");
                        System.out.println("You now have triple the chance of receiving a log for at least  "
                                + strPotCountLeft + " chops.");
                    } else {
                        System.out.println("No Purchase");
                    }
                    break;
                case 8: // Load
                    readData(gameSave);
                    playerLevel = Integer.parseInt(gameSave[0]);
                    playerTotalXp = Integer.parseInt(gameSave[1]);
                    totalXpToLevel = Integer.parseInt(gameSave[2]);
                    coins = Integer.parseInt(gameSave[3]);
                    axeBreakChance = Double.parseDouble(gameSave[4]);
                    playerAxe   = AXE.valueOf(gameSave[5]);
                    bagSize = Integer.parseInt(gameSave[6]);
                    costDoubleBag = Integer.parseInt(gameSave[7]);
                case 6: // See Stats
                    System.out.println("\nPLAYER STATS:\nPlayerLevel: " + playerLevel);
                    System.out.printf("Total Coins: %,d gold", coins);
                    System.out.println("\nAxe: " + String.valueOf(playerAxe));
                    System.out.printf("Axe Bonus: %.0f%%\nChance Axe will break: %.4f%%\nChance tree will fall: %.0f%%",
                            100 * axeBonusPercent(playerAxe), 100 * axeBreakChance, 100 * fallChance(playerAxe));
                    System.out.println("\nBag: " + logsInBag + "/" + bagSize + "\nXP to level: " + playerTotalXp + "/"
                            + totalXpToLevel + " XP\nSpeed Potion: " + speedPotCountLeft + " chops\nStrength Potion: " + strPotCountLeft + " chops");
                    break;
                case 7: // Save
                    saveData(playerLevel, playerTotalXp, totalXpToLevel, coins, axeBreakChance, playerAxe, bagSize, costDoubleBag);
                    System.out.println("Player's main stats, axe, and bag size saved.");
                    break;
                case 9: // Exit
                    System.out.println("Are you sure you want to quit? Y or N");
                    exit = sc.next().charAt(0);
                    break;
                default: // Error Message
                    System.out.println("ERROR: Invalid Menu Option, please try again.");
                    break;
            }
            if (exit == 'y' || exit == 'Y' || playerLevel == 100) {
                System.out.println("You have reached level " + playerLevel + ". Thank you for playing Always Be Chopping.");
                break;
            }

            System.out.println(
                    "\nMENU: \n1) Explore Forest\n2) Sell Logs\n3) Repair Axe \n4) Upgrade Axe\n5) Shop\n6) See Stats" +
                            "\n7) Save\n8) Load\n9) Exit");
            try {
                sc = new Scanner(System.in);
                menu = sc.nextInt();
            } catch (Exception e) {
                menu = 8;
            }
        }
    }
    /** Based on the player's level will generate the following trees
     *  There are 6 different types of trees players may chop. all trees yield a maximum amount of logs.
     *  with each log taken, there is an 8% chance that the tree will fall and no more logs can be
     *  harvested.
     *  Trees are in a forest of 4 tree options. At each level there is a chance that a type of tree will appear. For every
     *  level the player gains, there is an additional 1-3% chance the highest level tree will appear in the forest.
     *  normal tree || level 1 only normal until level 8
     *  oak tree || starting level 8, 5% chance for Oak tree that increase 4% with level
     *  willow tree || starting at level 30, 45% chance for Willow that increase 2% per level, 5% chance Normal, rest % Oak
     *  maple tree || starting at level 45, 40% chance Maple that increase 2% per level, 5% Normal, 5% Oak, rest % Willow
     *  yew tree || starting at level 60, 35% chance Yew that increase 2% per level, 2% Normal, 3% Oak, 5% Willow, rest % Maple
     *  magic tree || starting at level 80, 30% chance Magic that increase 1% per level, 2% Normal, 3% Oak, 5% Willow, 5% Maple, rest % Yew
     * @param level : player's current level
     * @return : an array of 4 random trees
     */
    public static TREE[] generateForest(int level) {
        TREE[] forest = new TREE[4];
        Random rand = new Random();
        double random;
        for (int i = 0; i < 4; i++) {
            random = rand.nextDouble();
            if (level < 8) {
                forest[i] = TREE.Normal;
            } else if (level < 30) {
                if (random < (0.05 + (level - 8) * 0.04)) {
                    forest[i] = TREE.Oak;
                } else {
                    forest[i] = TREE.Normal;
                }
            } else if (level < 45) {
                if (random < (0.45 + (level - 30) * 0.02)) {
                    forest[i] = TREE.Willow;
                } else if (random < .95) {
                    forest[i] = TREE.Oak;
                } else {
                    forest[i] = TREE.Normal;
                }
            } else if (level < 60) {
                if (random < (0.40 + (level - 45) * 0.02)) {
                    forest[i] = TREE.Maple;
                } else if (random < 0.90) {
                    forest[i] = TREE.Willow;
                } else if (random < 0.95) {
                    forest[i] = TREE.Oak;
                } else {
                    forest[i] = TREE.Normal;
                }
            } else if (level < 80) {
                if (random < (0.35 + (level - 60) * 0.02)) {
                    forest[i] = TREE.Yew;
                } else if (random < 0.90) {
                    forest[i] = TREE.Maple;
                } else if (random < 0.95) {
                    forest[i] = TREE.Willow;
                } else if (random < 0.98) {
                    forest[i] = TREE.Oak;
                } else {
                    forest[i] = TREE.Normal;
                }
            } else {
                if (rand.nextDouble() < (0.30 + (level - 80) * 0.01)) {
                    forest[i] = TREE.Magic;
                } else if (rand.nextDouble() < 0.85) {
                    forest[i] = TREE.Yew;
                } else if (rand.nextDouble() < 0.90) {
                    forest[i] = TREE.Maple;
                } else if (rand.nextDouble() < 0.95) {
                    forest[i] = TREE.Willow;
                } else if (rand.nextDouble() < 0.98) {
                    forest[i] = TREE.Oak;
                } else {
                    forest[i] = TREE.Normal;
                }
            }
        }
        // Print Forest Menu and return as an array
        System.out.println("You enter the forest. You see four trees nearby.\nSelect a tree to cut down.");
        System.out.println("1) " + forest[0].toString() + "\n2) " + forest[1].toString() + "\n3) "
                + forest[2].toString() + "\n4) " + forest[3].toString());
        return forest;
    }

    /**
     * Chops down the selected tree in the forest, can break axe, activate potions produces logs and chops
     * @param axe Player's current axe
     * @param tree Player's selected tree
     * @param chanceToBreak Player's axe chance to break with each chop
     * @param speedPot does player have speed potion activated
     * @param strengthPot does player have strength potion activated
     * @return an int array of size 2 number of logs and number of chops
     */
    public static int[] cutLogs(AXE axe, TREE tree, double chanceToBreak, boolean speedPot, boolean strengthPot) {
        Random rand = new Random();

        int[] logsAndChops = new int[2]; // outputs the number of logs and chops from the cutLogs method
        int logs = 0; // Start with no logs chopped, increase with successful chop
        int chops = 0; // Starts at 0 and increase by one with each chop
        int logsRemaining; // Max logs - logs chopped
        String star = ""; // Prints a [] for each successful log received from chop


        logsRemaining = maxLogs(tree);
        while (logsRemaining > 0) {
            // Speed Pot makes Chop animation twice as fast
            double x = 1;
            if (speedPot) {
                x = 0.5;
            }
            try {
                Thread.sleep((long) (450 * x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Prints Chop and counts Chops
            System.out.println("Chop.");
            chops++;

            // Strength Pot makes chance to yield a log from a chop 3 times as likely
            int y = 1;
            if (strengthPot) {
                y = 3;

            }
            // Chance that chop will yield a log, increased with upgraded axe, decreases with higher level tree
            if (rand.nextDouble() <= ((treeCutChance(tree) + axeBonusPercent(axe)) * y)) {
                logs++;
                logsRemaining--;
                star += "[]";
                System.out.println(star);

                // Axe will only break on successful log yield and stops the while loop
                if (rand.nextDouble() < chanceToBreak) {
                    System.out.printf("Your axe breaks into pieces. It had a %.5f%% chance to break with each chop." );
                    axeBroken = true;
                    break;
                }
                // Tree can fall before all logs are collected, decrease with upgraded axe.
                if (rand.nextDouble() < fallChance(axe)) {
                    logsRemaining = 0;
                    System.out.println("Crack.");
                    try {
                        Thread.sleep(780);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Timber!!!");
                    try {
                        Thread.sleep(1100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("CRASH!!");
                    System.out.println("The tree has fallen.");

                    // Chance on tree fall losing all logs, decreases with upgraded axe
                    if (rand.nextDouble() < 8 * fallChance(axe)) {
                        System.out.println("A beaver came and stole all the logs.");
                        logs = 0;
                    }
                    break;
                }
            }
        }
        logsAndChops[0] = logs;
        logsAndChops[1] = chops;
        return logsAndChops;
    }

    /**
     * Depending on the type of tree returns max logs a selected tree can yield
     *  normal tree  5 log max
     *  oak tree  12 log max
     *  willow tree  15 log max
     *  maple tree 19 log max
     *  yew tree  21 log max
     *  magic tree 32 log max
     * @param tree Selected Tree chopped
     * @return Number of logs the selected type of tree can hold max
     */
    public static int maxLogs (TREE tree) {
        int maxLogs = 5;
        if (tree == TREE.Oak) {
            maxLogs = 12;
        }
        if (tree == TREE.Willow) {
            maxLogs = 15;
        }
        if (tree == TREE.Maple) {
            maxLogs = 19;
        }
        if (tree == TREE.Yew) {
            maxLogs = 21;
        }
        if (tree == TREE.Magic) {
            maxLogs = 32;
        }
        return maxLogs;
    }

    /**
     *  percentage chance the selected type of tree will yield a log in a chop
     *  normal tree 20% cut chance
     *  oak tree 18% cut chance
     *  willow tree  15% cut chance
     *  maple tree  12% cut chance
     *  yew tree 8% cut chance
     *  magic tree 3% cut chance
     * @param tree Player's selected tree
     * @return percentage as double
     */
    public static double treeCutChance (TREE tree) {
        double treeCutChance = 0.20;
        if (tree == TREE.Oak) {
            treeCutChance = 0.18;
        }
        if (tree == TREE.Willow) {
            treeCutChance = 0.15;
        }
        if (tree == TREE.Maple) {
            treeCutChance = 0.12;
        }
        if (tree == TREE.Yew) {
            treeCutChance = 0.08;
        }
        if (tree == TREE.Magic) {
            treeCutChance = 0.03;
        }
        return treeCutChance;
    }

    /**
     * Increase chance the tree will yield a log depending on upgrade axe
     * Increase chance the tree will yield a reward if fully chopped down with upgraded axe
     *  rusty axe  0% bonus
     *  bronze axe + 1% chop chance
     *  iron axe +2% chop chance
     *  steel axe +3% chop chance
     *  obsidian axe  +4% chop chance
     *  mithril axe +5% chop chance
     *  adamant axe 6% chop chance
     *  runed axe 7% chop chance
     *  enchanted axe 10% chop chance
     * @param axe Player's current Axe
     * @return percent double depending on axe used
     */
    public static double axeBonusPercent(AXE axe) {
        double axeBonus = 0;
        if (axe == AXE.Bronze) {
            axeBonus = 0.01;
        }
        if (axe == AXE.Iron) {
            axeBonus = 0.02;
        }
        if (axe == AXE.Steel) {
            axeBonus = 0.04;
        }
        if (axe == AXE.Obsidian) {
            axeBonus = 0.05;
        }
        if (axe == AXE.Mithril) {
            axeBonus = 0.06;
        }
        if (axe == AXE.Adamant) {
            axeBonus = 0.07;
        }
        if (axe == AXE.Runed) {
            axeBonus = 0.10;
        }
        if (axe == AXE.Enchanted) {
            axeBonus = 0.14;
        }
        return axeBonus;
    }

    /**
     * Decrease chance the tree will fall and yield no more logs depending on upgrade axe
     *  rusty axe 0% reduce chance tree will fall
     *  bronze axe 0% reduce chance tree will fall
     *  iron axe 0% reduce chance tree will fall
     *  steel axe 0% reduce chance tree will fall
     *  obsidian axe  1% reduce chance tree will fall
     *  mithril axe 2% reduce chance tree will fall
     *  adamant axe 3% reduce chance tree will fall
     *  runed axe 4% reduce chance tree will fall
     *  enchanted axe 5% reduce chance tree will fall
     * @param axe Player's current axe
     * @return percent double depending on axe used
     */
    public static double fallChance(AXE axe) {
        double fallChance = 0.08;
        if (axe == AXE.Obsidian) {
            fallChance = 0.07;
        }
        if (axe == AXE.Mithril) {
            fallChance = 0.06;
        }
        if (axe == AXE.Adamant) {
            fallChance = 0.05;
        }
        if (axe == AXE.Runed) {
            fallChance = 0.03;
        }
        if (axe == AXE.Enchanted) {
            fallChance = 0.00;
        }
        return fallChance;
    }

    /**
     *  Takes type of tree and numbers of logs and calculates the total gold value on the new logs collected
     *  normal tree 7 gp per log
     *  oak tree 9 gp per log
     *  willow tree 11 gp per log
     *  maple tree 14 gp per log
     *  yew tree 19 gp per log
     *  magic tree 49 gp per log
     * @param tree Player's selected tree
     * @param logs Number of logs player chopped from selected tree
     * @return gold value of logs as an int
     */
    public static int goldValueOfLogs(TREE tree, int logs) {
        // Normal trees 7g per log
        int gold = logs * 7;

        if (tree == TREE.Oak) {
            gold = logs * 9;
        }
        if (tree == TREE.Willow) {
            gold = logs * 11;
        }
        if (tree == TREE.Maple) {
            gold = logs * 14;
        }
        if (tree == TREE.Yew) {
            gold = logs * 19;
        }
        if (tree == TREE.Magic) {
            gold = logs * 49;
        }
        return gold;
    }

    /**
     *  Takes type of tree and numbers of logs and calculates the total experience player gain for chopping
     *  the tree
     *  normal tree 10 XP per log
     *  oak tree 15 XP per log
     *  willow tree 30 xp per log
     *  maple tree 45 xp per log
     *  yew tree 60 xp per log
     *  magic tree 100xp per log
     * @param tree Player's selected tree
     * @param logs Number of logs player chopped from selected tree
     * @return total experience player gain for the logs chopped from the tree
     */
    public static int experienceGained(TREE tree, int logs) {
        int xpPerLog = 10;
        if (tree == TREE.Oak) {
            xpPerLog = 15;
        }
        if (tree == TREE.Willow) {
            xpPerLog = 30;
        }
        if (tree == TREE.Maple) {
            xpPerLog = 45;
        }
        if (tree == TREE.Yew) {
            xpPerLog = 60;
        }
        if (tree == TREE.Magic) {
            xpPerLog = 100;
        }
        return logs * xpPerLog;
    }
    /**
     * 	Each chop increases chance axe will break with each chop depending on axe upgrade axe.
     * 	Player's axe will break  and must be repaired at the shop,
     *  Chance axe will break will increase a tiny percentage x% each chop and x decreases with upgraded axes.
     *  If broken player must go to shop and repair.
     *  rusty axe .005%
     *  bronze axe .0005%
     *  iron axe .0003%
     *  steel axe .0001%
     *  obsidian axe .00005%
     *  mithril axe .00005%
     *  adamant axe .00001%
     *  runed axe .000005%
     *  enchanted axe .000001%
     * @param axe Player's current axe
     * @return percent as a double depending on current axe
     */
    public static double durabilityLost(AXE axe) {
        // Rust axe most likely to break but no cost
        double durabilityLost = .00005;
        if (axe == AXE.Bronze) {
            durabilityLost = .000005;
        }
        if (axe == AXE.Iron) {
            durabilityLost = .000003;
        }
        if (axe == AXE.Steel) {
            durabilityLost = .000001;
        }
        if (axe == AXE.Obsidian) {
            durabilityLost = .0000005;
        }
        if (axe == AXE.Mithril) {
            durabilityLost = .0000005;
        }
        if (axe == AXE.Adamant) {
            durabilityLost = .0000001;
        }
        if (axe == AXE.Runed) {
            durabilityLost = .00000005;
        }
        if (axe == AXE.Enchanted) {
            durabilityLost = .00000001;
        }
        return durabilityLost;
    }
    /**
     *  Takes type of axe and returns the gold value of the axe
     *  Value of axe for store and repair is 5% axe value
     *  rusty axe starting axe *can't purchase*
     *  bronze axe 200 coins
     *  iron axe 500 coins
     *  steel axe 1,250 coins
     *  obsidian axe 2,500 coins
     *  mithril axe 5,000 coins
     *  adamant axe 10,000 coins
     *  runed axe 30,000 coins
     *  enchanted axe 50,000 coins
     * @param axe selected axe
     * @return gold value of selected axe
     */
    public static int axeGoldValue(AXE axe) {
        // Rusty Axe No cost
        int goldValue = 0;
        if (axe == AXE.Bronze) {
            goldValue = 200;
        }
        if (axe == AXE.Iron) {
            goldValue = 500;
        }
        if (axe == AXE.Steel) {
            goldValue = 1250;
        }
        if (axe == AXE.Obsidian) {
            goldValue = 2500;
        }
        if (axe == AXE.Mithril) {
            goldValue = 5000;
        }
        if (axe == AXE.Adamant) {
            goldValue = 10000;
        }
        if (axe == AXE.Runed) {
            goldValue = 30000;
        }
        if (axe == AXE.Enchanted) {
            goldValue = 50000;
        }
        return goldValue;
    }
    public static void readData(String[] gameSave) throws FileNotFoundException {
        File file = new File("abc_game_save");
        Scanner fileSc = new Scanner(file);

        fileSc.nextLine();
        for (int i = 0; i < gameSave.length; i++) {
            gameSave[i] = fileSc.nextLine();
        }


    }
    public static void saveData(int playerLevel, int playerTotalXp, int totalXpToLevel, int coins, double axeBreakChance,
                                AXE playerAxe, int bagSize, int costDoubleBag) throws FileNotFoundException {
        File file = new File("abc_game_save");
        PrintWriter pw = new PrintWriter(file);

        pw.println("player_level,total_xp,xp_to_level,coins,axe_break_chance,player_axe,bag_size,cost_double_bag");
        pw.println(playerLevel);
        pw.println(playerTotalXp);
        pw.println(totalXpToLevel);
        pw.println(coins);
        pw.println(axeBreakChance);
        pw.println(playerAxe);
        pw.println(bagSize);
        pw.println(costDoubleBag);
        pw.close();
    }
}