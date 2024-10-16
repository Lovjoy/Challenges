import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public enum Axe {RUSTY, BRONZE, IRON, STEEL, OBSIDIAN, MITHRIL, ADAMANT, RUNED, ENCHANTED}

    public enum Tree {NORMAL, OAK, WILLOW, MAPLE, YEW, MAGIC}

    public static void main(String[] args) {
//      Ray Joy
//      10/12/2024
        /* Challenge - Tree Game
        There are 6 different types of trees players may chop. all trees yield a maximum amount of logs. with each log
        taken, there is an 8% chance that the tree will fall and no more logs can be harvested. Additionally, the
        player has a max inventory size of 32 logs. If the player is chopping and the inventory is full, they walk away
        from the tree. If a player tries to chop logs with a full inventory, it gives an error message. Players will
        have the option to sell instead of selecting a tree type to chop. Finally, a player may only chop a tree if
        their woodcutting level is equal to or greater than the listed level.
        Each level of woodcutting increases the xp required to level up. the first level of woodcutting will require
        100 xp, and for each additional level, the required XP to level up will increase by 10%.
        Players may upgrade their axe, and will start with a rusty axe which provides no bonus. The player can purchase
        the following axes from the shops
        bronze axe - 200 coins || + 1% chop chance
        iron axe - 500 coins || +2% chop chance
        steel axe - 1250 coins || +3% chop chance
        obsidian axe - 2500 coins || +4% chop chance || 1% reduce chance tree will fall
        mithril axe - 2000 coins || +5% chop chance || 2% reduce chance tree will fall
        adamant axe - 10000 coins || 6% chop chance || 3% reduce chance tree will fall
        runed axe - 30000 coins || 7% chop chance || 4% reduce chance tree will fall
        enchanted axe - 50000 coins || 10% chop chance || 5% reduce chance tree will fall
        Trees are in a forest of 4 tree options. At level there is a 50% chance that tree will appear. For every level
        the player gains, there is an additional 3% chance that tree will appear in the forest.
        normal tree || level 1 || 10 XP per log ||  5 log max || 20% cut chance ||  7 gp per log
        oak tree    || level 15|| 15 XP per log || 12 log max || 18% cut chance ||  9 gp per log
        willow tree || level 30|| 30 xp per log || 15 log max || 15% cut chance || 11 gp per log
        maple tree  || level 45|| 45 xp per log || 19 log max || 12% cut chance || 14 gp per log
        yew tree    || level 60|| 60 xp per log || 21 log max || 8% cut chance  || 19 gp per log
        magic tree  || level 80|| 100xp per log || 32 log max || 3% cut chance  || 49 gp per log*/

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int coins = 0;                  // Total gold
        int playerLevel = 1;            // Current player level, game over at level 100
        int playerTotalXp = 0;          // XP earned for logs chopped at current level
        int totalXpToLevel = 100;       // Total xp needed to level. Will increase by 6% each level.
        int axeCost = 0;                // How much an axe cost to buy
        int axeMenu;                    // Menu to buy axes
        double axeBonus = 0;            // Starts with rusty axe no bonus
        int newLogs = 0;                // How many logs collected from one tree
        int logsInBag = 0;              // How many logs in player bag, max 32 logs
        int goldValueOfLogs = 0;        // logs in bag coin value before sold
        int treeMenu = 4;               // menu to explore forest, sell logs, to buy axe, see stats, and quit
        Tree treeOne = null;            // First tree
        Tree treeTwo = null;            // Second tree
        Tree treeThree = null;          // Third tree
        Tree treeFour = null;           // Fourth tree
        Tree tree = null;               // Current tree
        String star = "";               // Progress bar for logs from current tree
        int treeSelect;                 // Select which of the four trees in fours
        double treeCutChance = 0.20;    // Normal trees start at 20% chance then decreases with tree type
        double treeFallChance = 0.08;   // 8% chance that the tree will fall and no more logs can be harvested
        double decreaseFallChance = 0;  // Best axes reduces chance tree will fall
        int maxLogs = 5;                // Max logs a tree can hold depending on tree type, Normal only 5 logs
        int logsRemaining;              // How many logs left in the tree
        int goldPerLog = 7;             // Gold per log when sold, depends on tree type
        int xpPerLog = 10;              // XP per log when chopped, depends on tree type
        Axe axe = Axe.RUSTY;            // Type of axe, default is rusty axe with no stat bonuses
        Axe oldAxeHold = axe;           // Temporary hold of axe

       
        // Welcome Message
        System.out.println("Welcome to the Tree Game! \nYou are to explore the forest and collect logs. Logs can be " +
                "sold and coins can be used to upgrade your axe.");

        // Winning condition level 100
        while (playerLevel < 100) {
            switch (treeMenu) {
                case 1: // Explore Forest of four trees player can pick from
                    // Logic for random tree types based on level
                    if (playerLevel < 8) {
                        treeOne = Tree.NORMAL;
                        treeTwo = Tree.NORMAL;
                        treeThree = Tree.NORMAL;
                        treeFour = Tree.NORMAL;
                    }
                    if (playerLevel >= 8 && playerLevel < 30) {
                        if (rand.nextDouble() < (0.05 + (playerLevel - 8) * 0.04)) {
                            treeOne = Tree.OAK;
                        } else {
                            treeOne = Tree.NORMAL;
                        }
                        if (rand.nextDouble() < (0.05 + (playerLevel - 8) * 0.04)) {
                            treeTwo = Tree.OAK;
                        } else {
                            treeTwo = Tree.NORMAL;
                        }
                        if (rand.nextDouble() < (0.05 + (playerLevel - 8) * 0.04)) {
                            treeThree = Tree.OAK;
                        } else {
                            treeThree = Tree.NORMAL;
                        }
                        if (rand.nextDouble() < (0.05 + (playerLevel - 8) * 0.04)) {
                            treeFour = Tree.OAK;
                        } else {
                            treeFour = Tree.NORMAL;
                        }
                    }
                    if (playerLevel >= 30 && playerLevel < 45) {
                        if (rand.nextDouble() < (0.45 + (playerLevel - 30) * 0.02)) {
                            treeOne = Tree.WILLOW;
                        } else if (rand.nextDouble() < (0.50 - (playerLevel - 15) * 0.02)) {
                            treeOne = Tree.OAK;
                        } else {
                            treeOne = Tree.NORMAL;
                        }
                        if (rand.nextDouble() < (0.45 + (playerLevel - 30) * 0.02)) {
                            treeTwo = Tree.WILLOW;
                        } else if (rand.nextDouble() < (0.50 - (playerLevel - 30) * 0.02)) {
                            treeTwo = Tree.OAK;
                        } else {
                            treeTwo = Tree.NORMAL;
                        }
                        if (rand.nextDouble() < (0.45 + (playerLevel - 30) * 0.02)) {
                            treeThree = Tree.WILLOW;
                        } else if (rand.nextDouble() < (0.50 - (playerLevel - 30) * 0.02)) {
                            treeThree = Tree.OAK;
                        } else {
                            treeThree = Tree.NORMAL;
                        }
                        if (rand.nextDouble() < (0.45 + (playerLevel - 30) * 0.02)) {
                            treeFour = Tree.WILLOW;
                        } else if (rand.nextDouble() < (0.50 - (playerLevel - 30) * 0.02)) {
                            treeFour = Tree.OAK;
                        } else {
                            treeFour = Tree.NORMAL;
                        }
                    }
                    if (playerLevel >= 45 && playerLevel < 60) {
                        if (rand.nextDouble() < (0.40 + (playerLevel - 45) * 0.02)) {
                            treeOne = Tree.MAPLE;
                        } else if (rand.nextDouble() < (0.50 - (playerLevel - 45) * 0.02)) {
                            treeOne = Tree.WILLOW;
                        } else if (rand.nextDouble() < 0.05) {
                            treeOne = Tree.OAK;
                        } else {
                            treeOne = Tree.NORMAL;
                        }
                        if (rand.nextDouble() < (0.40 + (playerLevel - 45) * 0.02)) {
                            treeTwo = Tree.MAPLE;
                        } else if (rand.nextDouble() < (0.50 - (playerLevel - 45) * 0.02)) {
                            treeTwo = Tree.WILLOW;
                        } else if (rand.nextDouble() < 0.05) {
                            treeTwo = Tree.OAK;
                        } else {
                            treeTwo = Tree.NORMAL;

                        }
                        if (rand.nextDouble() < (0.40 + (playerLevel - 45) * 0.02)) {
                            treeThree = Tree.MAPLE;
                        } else if (rand.nextDouble() < (0.50 - (playerLevel - 45) * 0.02)) {
                            treeThree = Tree.WILLOW;
                        } else if (rand.nextDouble() < 0.05) {
                            treeThree = Tree.OAK;
                        } else {
                            treeThree = Tree.NORMAL;

                        }

                        if (rand.nextDouble() < (0.40 + (playerLevel - 45) * 0.02)) {
                            treeFour = Tree.MAPLE;
                        } else if (rand.nextDouble() < (0.50 - (playerLevel - 45) * 0.02)) {
                            treeFour = Tree.WILLOW;
                        } else if (rand.nextDouble() < 0.05) {
                            treeFour = Tree.OAK;
                        } else {
                            treeFour = Tree.NORMAL;
                        }
                    }
                    if (playerLevel >= 60 && playerLevel < 80) {
                        if (rand.nextDouble() < (0.35 + (playerLevel - 60) * 0.02)) {
                            treeOne = Tree.YEW;
                        } else if (rand.nextDouble() < (0.55 - (playerLevel - 60) * 0.02)) {
                            treeOne = Tree.MAPLE;
                        } else if (rand.nextDouble() < 0.05) {
                            treeOne = Tree.WILLOW;
                        } else if (rand.nextDouble() < 0.03) {
                            treeOne = Tree.OAK;
                        } else {
                            treeOne = Tree.NORMAL;
                        }
                        if (playerLevel >= 60 && playerLevel < 80) {
                            if (rand.nextDouble() < (0.35 + (playerLevel - 60) * 0.02)) {
                                treeTwo = Tree.YEW;
                            } else if (rand.nextDouble() < (0.55 - (playerLevel - 60) * 0.02)) {
                                treeTwo = Tree.MAPLE;
                            } else if (rand.nextDouble() < 0.05) {
                                treeTwo = Tree.WILLOW;
                            } else if (rand.nextDouble() < 0.03) {
                                treeTwo = Tree.OAK;
                            } else {
                                treeTwo = Tree.NORMAL;
                            }
                        }
                        if (playerLevel >= 60 && playerLevel < 80) {
                            if (rand.nextDouble() < (0.35 + (playerLevel - 60) * 0.02)) {
                                treeThree = Tree.YEW;
                            } else if (rand.nextDouble() < (0.55 - (playerLevel - 60) * 0.02)) {
                                treeThree = Tree.MAPLE;
                            } else if (rand.nextDouble() < 0.05) {
                                treeThree = Tree.WILLOW;
                            } else if (rand.nextDouble() < 0.03) {
                                treeThree = Tree.OAK;
                            } else {
                                treeThree = Tree.NORMAL;
                            }
                        }
                        if (playerLevel >= 60 && playerLevel < 80) {
                            if (rand.nextDouble() < (0.35 + (playerLevel - 60) * 0.02)) {
                                treeFour = Tree.YEW;
                            } else if (rand.nextDouble() < (0.55 - (playerLevel - 60) * 0.02)) {
                                treeFour = Tree.MAPLE;
                            } else if (rand.nextDouble() < 0.05) {
                                treeFour = Tree.WILLOW;
                            } else if (rand.nextDouble() < 0.03) {
                                treeFour = Tree.OAK;
                            } else {
                                treeFour = Tree.NORMAL;
                            }
                        }
                    }
                    if (playerLevel >= 80) {
                        if (rand.nextDouble() < (0.30 + (playerLevel - 80) * 0.01)) {
                            treeOne = Tree.MAGIC;
                        } else if (rand.nextDouble() < (0.60 - (playerLevel - 80) * 0.01)) {
                            treeOne = Tree.YEW;
                        } else if (rand.nextDouble() < 0.03) {
                            treeOne = Tree.MAPLE;
                        } else if (rand.nextDouble() < 0.03) {
                            treeOne = Tree.WILLOW;
                        } else if (rand.nextDouble() < 0.03) {
                            treeOne = Tree.OAK;
                        } else {
                            treeOne = Tree.NORMAL;
                        }
                        if (rand.nextDouble() < (0.30 + (playerLevel - 80) * 0.01)) {
                            treeTwo = Tree.MAGIC;
                        } else if (rand.nextDouble() < (0.60 - (playerLevel - 80) * 0.01)) {
                            treeTwo = Tree.YEW;
                        } else if (rand.nextDouble() < 0.03) {
                            treeTwo = Tree.MAPLE;
                        } else if (rand.nextDouble() < 0.03) {
                            treeTwo = Tree.WILLOW;
                        } else if (rand.nextDouble() < 0.03) {
                            treeTwo = Tree.OAK;
                        } else {
                            treeTwo = Tree.NORMAL;
                        }
                        if (rand.nextDouble() < (0.30 + (playerLevel - 80) * 0.01)) {
                            treeThree = Tree.MAGIC;
                        } else if (rand.nextDouble() < (0.60 - (playerLevel - 80) * 0.01)) {
                            treeThree = Tree.YEW;
                        } else if (rand.nextDouble() < 0.03) {
                            treeThree = Tree.MAPLE;
                        } else if (rand.nextDouble() < 0.03) {
                            treeThree = Tree.WILLOW;
                        } else if (rand.nextDouble() < 0.03) {
                            treeThree = Tree.OAK;
                        } else {
                            treeThree = Tree.NORMAL;
                        }
                        if (rand.nextDouble() < (0.30 + (playerLevel - 80) * 0.01)) {
                            treeFour = Tree.MAGIC;
                        } else if (rand.nextDouble() < (0.60 - (playerLevel - 80) * 0.01)) {
                            treeFour = Tree.YEW;
                        } else if (rand.nextDouble() < 0.03) {
                            treeFour = Tree.MAPLE;
                        } else if (rand.nextDouble() < 0.03) {
                            treeFour = Tree.WILLOW;
                        } else if (rand.nextDouble() < 0.03) {
                            treeFour = Tree.OAK;
                        } else {
                            treeFour = Tree.NORMAL;
                        }
                    }
                    System.out.println("You enter the forest. Select a tree to cut down." +
                            "\n1) " + String.valueOf(treeOne) + "\n2) " + String.valueOf(treeTwo) + "\n3) "
                            + String.valueOf(treeThree) + "\n4) " + String.valueOf(treeFour));
                    treeSelect = sc.nextInt();
                    switch (treeSelect) {
                        case 1:
                            tree = treeOne;
                            break;
                        case 2:
                            tree = treeTwo;
                            break;
                        case 3:
                            tree = treeThree;
                            break;
                        case 4:
                            tree = treeFour;
                            break;
                        default:
                            break;
                    }
                    // normal tree || level 1 || 10 XP per log ||  5 log max || 20% cut chance ||  7 gp per log
                    if (tree == Tree.NORMAL) {
                        xpPerLog = 10;
                        maxLogs = 5;
                        treeCutChance = 0.20;
                        goldPerLog = 7;
                    }
                    // oak tree    || level 8|| 15 XP per log || 12 log max || 18% cut chance ||  9 gp per log
                    if (tree == Tree.OAK) {
                        xpPerLog = 15;
                        maxLogs = 12;
                        treeCutChance = 0.18;
                        goldPerLog = 9;
                    }
//                    willow tree || level 30|| 30 xp per log || 15 log max || 15% cut chance || 11 gp per log
                    if (tree == Tree.WILLOW) {
                        xpPerLog = 30;
                        maxLogs = 15;
                        treeCutChance = 0.15;
                        goldPerLog = 11;
                    }
//                    maple tree  || level 45|| 45 xp per log || 19 log max || 12% cut chance || 14 gp per log
                    if (tree == Tree.MAPLE) {
                        xpPerLog = 45;
                        maxLogs = 19;
                        treeCutChance = 0.12;
                        goldPerLog = 14;
                    }
//                    yew tree    || level 60|| 60 xp per log || 21 log max || 8% cut chance  || 19 gp per log
                    if (tree == Tree.YEW) {
                        xpPerLog = 60;
                        maxLogs = 21;
                        treeCutChance = 0.08;
                        goldPerLog = 19;
                    }
//                    magic tree  || level 80|| 100xp per log || 32 log max || 3% cut chance  || 49 gp per log
                    if (tree == Tree.MAGIC) {
                        xpPerLog = 100;
                        maxLogs = 32;
                        treeCutChance = 0.03;
                        goldPerLog = 49;
                    }
                    logsRemaining = maxLogs;
                    newLogs = 0;
                    star = "";
                    while (logsRemaining > 0) {
                        if (logsInBag + newLogs >= 32) {
                            System.out.println("Your bag is full. ");
                            break;
                        }
                        try {
                            Thread.sleep(450);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Chop.");
                        if (rand.nextDouble() <= (treeCutChance + axeBonus)) {
                            newLogs++;
                            logsRemaining--;
                            playerTotalXp += xpPerLog;
                            star += '*';
                            System.out.println(star);
                            if (rand.nextDouble() < (treeFallChance - decreaseFallChance)) {
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
                            }
                        }
                    }
                    // Temporary hold value of logs until they are sold and added to coins
                    goldValueOfLogs += goldPerLog * newLogs;
                    logsInBag += newLogs;
                    System.out.println("You have chopped " + newLogs + " logs and have a " + logsInBag + "/32 logs" +
                            " in bag. You gained " + xpPerLog * newLogs + " XP.");
                    break;
                case 2: // Sell Logs
                    coins += goldValueOfLogs;
                    System.out.print("You sold " + logsInBag + " logs for " + goldValueOfLogs + "g and have "
                            + "total coins of ");
                            System.out.printf("%,dg", coins);
                    logsInBag = 0;
                    goldValueOfLogs = 0;
                    break;
                case 3: // Buy Axe
                    System.out.printf("Total Coins: %,dg.", coins);
                    System.out.println("\nCurrent Axe: " + String.valueOf(axe));
                    System.out.println("Select an Axe to buy or select Exit.");
                    System.out.println("1) " + String.valueOf(Axe.BRONZE) + " 200g\n2) " + String.valueOf(Axe.IRON)
                            + " 500g\n3) " + String.valueOf(Axe.STEEL) + " 1,250g\n4) " + String.valueOf(Axe.OBSIDIAN)
                            + " 2,500g\n5) " + String.valueOf(Axe.MITHRIL) + " 5,000g\n6) " + String.valueOf(Axe.ADAMANT)
                            + " 10,000g\n7) " + String.valueOf(Axe.RUNED) + " 30,000g\n8) " + String.valueOf(Axe.ENCHANTED)
                            + " 50,000g\n9) Exit");
                    axeMenu = sc.nextInt();
                    oldAxeHold = axe;
                    switch (axeMenu) {
                        case 1:
                            if (axe != Axe.IRON && axe != Axe.STEEL && axe != Axe.OBSIDIAN && axe != Axe.MITHRIL
                                    && axe != Axe.ADAMANT && axe != Axe.RUNED && axe != Axe.ENCHANTED && axe != Axe.BRONZE) {
                                axe = Axe.BRONZE;
                            } else {
                                System.out.println("Invalid purchase.");
                                axeMenu = 9;
                            }
                            break;
                        case 2:
                            if (axe != Axe.IRON && axe != Axe.STEEL && axe != Axe.OBSIDIAN && axe != Axe.MITHRIL
                                    && axe != Axe.ADAMANT && axe != Axe.RUNED && axe != Axe.ENCHANTED) {
                                axe = Axe.IRON;
                            } else {
                                System.out.println("Invalid purchase.");
                                axeMenu = 9;
                            }
                            break;
                        case 3:
                            if (axe != Axe.STEEL && axe != Axe.OBSIDIAN && axe != Axe.MITHRIL
                                    && axe != Axe.ADAMANT && axe != Axe.RUNED && axe != Axe.ENCHANTED) {
                                axe = Axe.STEEL;
                            } else {
                                System.out.println("Invalid purchase.");
                                axeMenu = 9;
                            }
                            break;
                        case 4:
                            if (axe != Axe.OBSIDIAN && axe != Axe.MITHRIL
                                    && axe != Axe.ADAMANT && axe != Axe.RUNED && axe != Axe.ENCHANTED) {
                                axe = Axe.OBSIDIAN;
                            } else {
                                System.out.println("Invalid purchase.");
                                axeMenu = 9;
                            }
                            break;
                        case 5:
                            if (axe != Axe.MITHRIL && axe != Axe.ADAMANT && axe != Axe.RUNED
                                    && axe != Axe.ENCHANTED) {
                                axe = Axe.MITHRIL;
                            } else {
                                System.out.println("Invalid purchase.");
                                axeMenu = 9;
                            }
                            break;
                        case 6:
                            if (axe != Axe.ADAMANT && axe != Axe.RUNED && axe != Axe.ENCHANTED) {
                                axe = Axe.ADAMANT;
                            } else {
                                System.out.println("Invalid purchase.");
                                axeMenu = 9;
                            }
                            break;
                        case 7:
                            if (axe != Axe.RUNED && axe != Axe.ENCHANTED) {
                                axe = Axe.RUNED;
                            } else {
                                System.out.println("Invalid purchase.");
                                axeMenu = 9;
                            }
                            break;
                        case 8:
                            if (axe != Axe.ENCHANTED) {
                                axe = Axe.ENCHANTED;
                            } else {
                                System.out.println("Invalid purchase.");
                                axeMenu = 9;
                            }
                            break;
                        case 9:
                        default:
                            axeMenu = 9;
                            break;
                    }
                    if (axeMenu == 9) {
                        break;
                    }
                    if (axe == Axe.BRONZE) {
                        axeBonus = 0.01;
                        axeCost = 200;
                    }
                    if (axe == Axe.IRON) {
                        axeBonus = 0.02;
                        axeCost = 500;
                    }
                    if (axe == Axe.STEEL) {
                        axeBonus = 0.04;
                        axeCost = 1250;
                    }
                    if (axe == Axe.OBSIDIAN) {
                        axeBonus = 0.05;
                        axeCost = 2500;
                        decreaseFallChance = 0.01;
                    }
                    if (axe == Axe.MITHRIL) {
                        axeBonus = 0.06;
                        axeCost = 5000;
                        decreaseFallChance = 0.02;
                    }
                    if (axe == Axe.ADAMANT) {
                        axeBonus = 0.07;
                        axeCost = 10000;
                        decreaseFallChance = 0.03;
                    }
                    if (axe == Axe.RUNED) {
                        axeBonus = 0.10;
                        axeCost = 30000;
                        decreaseFallChance = 0.04;
                    }
                    if (axe == Axe.ENCHANTED) {
                        axeBonus = 0.14;
                        axeCost = 50000;
                        decreaseFallChance = 0.05;
                    }
                    if (coins >= axeCost) {
                        coins -= axeCost;
                    } else {
                        axe = oldAxeHold;
                        System.out.println("You do not have enough gold to purchase.");
                    }
                    System.out.println("Player Axe: " + axe);
                    System.out.printf("Axe Bonus: %.0f%%", 100 * axeBonus);
                    System.out.printf("\nChance tree fall: %.0f%%", 100 * (treeFallChance - decreaseFallChance));
                    break;
                case 4: // See Stats
                    System.out.println("\nPLAYER STATS: " + "\nPlayer Level: " + playerLevel);
                            System.out.printf("Total Coins: %,dg", coins);
                    System.out.println("\nAxe: " + String.valueOf(axe));
                    System.out.printf("Axe Bonus: %.0f%%\nChance tree fall: %.0f%%", axeBonus * 100,
                            100 * (treeFallChance - decreaseFallChance));
                    System.out.println("\nBag: " + logsInBag + "/32 logs" + "\nXP to level: " + playerTotalXp
                            + "/" + totalXpToLevel + " XP");
                    break;
                case 5: // Quit Game
                    break;
                default: // Error Message
                    System.out.println("Invalid menu option, please try again.");
                    break;
            }
            // Quit the Game and exit the while loop
            if (treeMenu == 5) {
                break;
            }
            // Main menu options
            System.out.println("\nMENU: \n1) Explore Forest\n2) Sell Logs\n3) Buy Axe\n4) See Stats\n5) Exit");
            try {
                sc = new Scanner(System.in);
                treeMenu = sc.nextInt();
            }
            catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
                continue;
            }
            if (playerTotalXp >= totalXpToLevel) {
                playerLevel++;
                System.out.println("You have reached Level " + playerLevel + "!");
                playerTotalXp -= totalXpToLevel;
                totalXpToLevel = (int) (100 * Math.pow(1.075, (playerLevel - 1)));
            }
        }
        System.out.println("Congratulations you reached level " + playerLevel + "! Thank you for playing. Goodbye.");
    }
}