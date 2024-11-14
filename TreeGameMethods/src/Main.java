import java.util.Random;
import java.util.Scanner;
/**
 * Ray Joy
 * 11/11/2024
 * Challenge - Tree Game
 * There are 6 different types of trees players may chop. all trees yield a maximum amount of logs. with each log
 * taken, there is an 8% chance that the tree will fall and no more logs can be harvested. Additionally, the
 * player has a starting max inventory size of 4 logs that is upgradable in the shop. If the player is chopping and the
 * inventory is full, they walk away from the tree. If a player tries to chop logs with a full inventory, it gives an
 * error message. Players will sell instead of selecting a tree type to chop. Finally, a player may only chop a tree if
 * their woodcutting level is equal to or greater than the listed level.
 * Each level of woodcutting increases the xp required to level up. the first level of woodcutting will require
 * 100 xp, and for each additional level, the required XP to level up will increase by 7.5%.
 * Player's axe will lose durability and must be repaired at the shop: durability goes down a tiny percentage x% each chop and
 * x decreases with upgraded axes. As the axe loses durability it increases the chance the axe will break to 0% durability.
 * If at 0 durability player must go to shop and repair.
 * Players may upgrade their axe, and will start with a rusty axe which provides no bonus. The player can purchase
 * the following items from the shops:
 * repair - 5% axe cost coins || may go in debt to repair || restores axe durability to 100%
 * potion of speed - 500 coins || doubles chop speed for 200 chops || stacking increases the durations of chops
 * potion of strength - 500 coins || doubles cut chance for 200 chops || stacking increases the duration of chops
 * potion of luck - 500 coins || 10% chance will chop 2 logs instead of one for 200 chops || increase chance by 10%
 * bronze axe - 200 coins || + 1% chop chance || .005% decrease of durability per chop
 * iron axe - 500 coins || +2% chop chance || .003% decrease of durability per chop
 * steel axe - 1,250 coins || +3% chop chance || .002% decrease of durability per chop
 * obsidian axe - 2,500 coins || +4% chop chance || 1% reduce chance tree will fall || .0001% decrease of durability per chop
 * mithril axe - 5,000 coins || +5% chop chance || 2% reduce chance tree will fall || .0001% decrease of durability per chop
 * adamant axe - 10,000 coins || 6% chop chance || 3% reduce chance tree will fall || .0005% decrease of durability per chop
 * runed axe - 30,000 coins || 7% chop chance || 4% reduce chance tree will fall || .0001% decrease of durability per chop
 * enchanted axe - 50,000 coins || 10% chop chance || 5% reduce chance tree will fall || .00001% decrease of durability per chop
 * bag upgrade - starts 100g and 3x price each bag upgrade || doubles bag space
 * Trees are in a forest of 4 tree options. At level there is a 50% chance that tree will appear. For every level
 * the player gains, there is an additional 3% chance that tree will appear in the forest.
 * normal tree || level 1 || 10 XP per log ||  5 log max || 20% cut chance ||  7 gp per log
 * oak tree    || level 8 || 15 XP per log || 12 log max || 18% cut chance ||  9 gp per log
 * willow tree || level 30|| 30 xp per log || 15 log max || 15% cut chance || 11 gp per log
 * maple tree  || level 45|| 45 xp per log || 19 log max || 12% cut chance || 14 gp per log
 * yew tree    || level 60|| 60 xp per log || 21 log max || 8% cut chance  || 19 gp per log
 * magic tree  || level 80|| 100xp per log || 32 log max || 3% cut chance  || 49 gp per log
 */

public class Main {
    public enum AXE {Rusty, Bronze, Iron, Steel, Obsidian, Mithril, Adamant, Runed, Enchanted}

    public enum TREE {Normal, Oak, Willow, Maple, Yew, Magic}

    static boolean axeBroken = false;

    public static TREE[] generateForest(int level) {
        TREE[] forest = new TREE[4];
        Random rand = new Random();
        double random;
        for (int i = 0; i < 4; i++) {
            random = rand.nextDouble();
            if (level < 8) { // Only Normal Trees until level 8
                forest[i] = TREE.Normal;
            } else if (level < 30) { // 5% chance for Oak tree that increase with level
                if (random < (0.05 + (level - 8) * 0.04)) {
                    forest[i] = TREE.Oak;
                } else {
                    forest[i] = TREE.Normal;
                }
            } else if (level < 45) { // 45% chance for Willow that increase per level, 5% chance Normal, rest % Oak
                if (random < (0.45 + (level - 30) * 0.02)) {
                    forest[i] = TREE.Willow;
                } else if (random < .95) {
                    forest[i] = TREE.Oak;
                } else {
                    forest[i] = TREE.Normal;
                }
            } else if (level < 60) { // 40% chance Maple that increase per level, 5% Normal, 5% Oak, rest % Willow
                if (random < (0.40 + (level - 45) * 0.02)) {
                    forest[i] = TREE.Maple;
                } else if (random < 0.90) {
                    forest[i] = TREE.Willow;
                } else if (random < 0.95) {
                    forest[i] = TREE.Oak;
                } else {
                    forest[i] = TREE.Normal;
                }
            } else if (level < 80) { // 35% chance Yew that increase per level, 2% Normal, 3% Oak, 5% Willow, rest % Maple
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
            } else { // 30% chance Magic that increase per level, 2% Normal, 3% Oak, 5% Willow, 5% Maple, rest % Yew
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
        System.out.println("You enter the forest. Select a tree to cut down.");
        System.out.println("1) " + forest[0].toString() + "\n2) " + forest[1].toString() + "\n3) " + forest[2].toString()
                + "\n4) " + forest[3].toString());
        return forest;
    }

    public static int[] cutLogs(AXE axe, TREE tree, double chanceToBreak, boolean speedPot, boolean strengthPot) {
        Random rand = new Random();

        int[] logsAndChops = new int[2];
        int logs = 0;
        int chops = 0;
        int maxLogs = 5;
        double treeCutChance = 0.20;
        int logsRemaining;
        String star = "";

        if (tree == TREE.Oak) {
            maxLogs = 12;
            treeCutChance = 0.18;
        }
        if (tree == TREE.Willow) {
            maxLogs = 15;
            treeCutChance = 0.15;
        }
        if (tree == TREE.Maple) {
            maxLogs = 19;
            treeCutChance = 0.12;
        }
        if (tree == TREE.Yew) {
            maxLogs = 21;
            treeCutChance = 0.08;
        }
        if (tree == TREE.Magic) {
            maxLogs = 32;
            treeCutChance = 0.03;
        }
        logsRemaining = maxLogs;
        while (logsRemaining > 0) {
            double x = 1;
            if (speedPot) {
                x = 0.5;
            }
            try {
                Thread.sleep((long) (450 * x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Chop.");
            chanceToBreak += durabilityLost(axe);
            chops++;

            int y = 1;
            if (strengthPot) {
                y = 2;
            }

            if (rand.nextDouble() <= (treeCutChance + axeBonusPercent(axe) * y)) {
                logs++;
                logsRemaining--;
                star += "*";
                System.out.println(star);

                if (rand.nextDouble() < chanceToBreak) {
                    System.out.println("Your axe breaks into pieces.");
                    axeBroken = true;
                    break;
                }
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
                    break;
                }
            }
        }
        logsAndChops[0] = logs;
        logsAndChops[1] = chops;
        return logsAndChops;
    }

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
            fallChance = 0.04;
        }
        if (axe == AXE.Enchanted) {
            fallChance = 0.03;
        }
        return fallChance;
    }

    public static int goldValueOfLogs(TREE tree, int logs) {
        int gold = 0;
        if (tree == TREE.Normal) {
            gold = logs * 7;
        }
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

    public static double durabilityLost(AXE axe) {
        double durabilityLost = 0;
        if (axe == AXE.Bronze) {
            durabilityLost = .00005;
        }
        if (axe == AXE.Iron) {
            durabilityLost = .00003;
        }
        if (axe == AXE.Steel) {
            durabilityLost = .00002;
        }
        if (axe == AXE.Obsidian) {
            durabilityLost = .00001;
        }
        if (axe == AXE.Mithril) {
            durabilityLost = .00001;
        }
        if (axe == AXE.Adamant) {
            durabilityLost = .000005;
        }
        if (axe == AXE.Runed) {
            durabilityLost = .000001;
        }
        if (axe == AXE.Enchanted) {
            durabilityLost = .0000001;
        }
        return durabilityLost;
    }

    public static int axeGoldValue(AXE axe) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int playerLevel = 1;
        int coins = 0;
        int playerTotalXp = 0;
        int totalXpToLevel = 100;
        int newLogs;
        int goldValueOfLogs = 0;
        int menu = 6;
        TREE[] forest = new TREE[4];
        int treeSelect;
        double axeBreakChance = 0;
        AXE playerAxe = AXE.Rusty;
        char exit = 'n';
        int shopMenu = 0;
        int[] logsAndChops = new int[2];
        //TEST
//        int playerLevel = 69;
//        int coins = 10000;
//        int playerTotalXp = 0;
//        int totalXpToLevel = 1000;
//        int newLogs;
//        int goldValueOfLogs = 0;
//        int menu = 6;
//        TREE[] forest = new TREE[4];
//        int treeSelect;
//        double axeBreakChance = 0;
//        AXE playerAxe = AXE.Obsidian;
//        char exit = 'n';
//        int shopMenu = 0;
//        int[] logsAndChops = new int[2];
//        int bagSize = 32;
//        int costDoubleBag = 1000;
//        int logsInBag = 0;

        int bagSize = 8;
        int costDoubleBag = 200;
        int logsInBag = 0;
        boolean speedPot = false;
        boolean strengthPot = false;
        int speedPotCountLeft = 0;
        int strPotCountLeft = 0;

        TREE treeSelected;
        while (playerLevel < 100) {

            switch (menu) {
                case 1: // Explore forest
                    forest = generateForest(playerLevel);
                    treeSelect = sc.nextInt();

                    treeSelected = forest[treeSelect - 1];
                    logsAndChops = cutLogs(playerAxe, treeSelected, axeBreakChance, speedPot, strengthPot);
                    newLogs = logsAndChops[0];
                    axeBreakChance += durabilityLost(playerAxe) * logsAndChops[1];

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

                    if (newLogs < (bagSize - logsInBag)) {
                        goldValueOfLogs += goldValueOfLogs(treeSelected, newLogs);
                        playerTotalXp += experienceGained(treeSelected, newLogs);
                        logsInBag += newLogs;
                        System.out.println(newLogs + " new logs added to bag. " + logsInBag + "/" + bagSize + " total logs in bag.");
                    } else {
                        System.out.println("You have " + bagSize + " logs and the bag is full, you leave behind " +
                                (logsInBag + newLogs - bagSize) + " logs behind.");
                        goldValueOfLogs += goldValueOfLogs(treeSelected, bagSize - logsInBag);
                        playerTotalXp += experienceGained(treeSelected, bagSize - logsInBag);
                        logsInBag = bagSize;
                    }
                    if (playerTotalXp >= totalXpToLevel) {
                        playerLevel++;
                        System.out.println("You have reached Level " + playerLevel + "!");
                        playerTotalXp -= totalXpToLevel;
                        totalXpToLevel = (int) (100 * Math.pow(1.075, (playerLevel - 1)));
                    }
                    break;
                case 2: // Sell Logs
                    coins += goldValueOfLogs;
                    System.out.print("You sold " + logsInBag + " logs for " + goldValueOfLogs + "g and have a total of ");
                    System.out.printf("%,d gold.", coins);
                    goldValueOfLogs = 0;
                    logsInBag = 0;

                    break;
                case 3: // Repair
                    axeBroken = false;
                    axeBreakChance = 0;
                    coins -= (int) 0.05 * axeGoldValue(playerAxe);
                    System.out.println("Your " + String.valueOf(playerAxe) + " axe has been repaired for " + 0.05 * axeGoldValue(playerAxe)
                            + " gold. You now have a total of " + coins + " gold.");
                    break;
                case 4: // Axe Upgrade
                    AXE axePurchased = AXE.Rusty;
                    System.out.printf("Total Coins: %,d gold", coins);
                    System.out.printf("\nCurrent Axe: " + String.valueOf(playerAxe));
                    System.out.println("\nSelect an Axe or Exit");
                    System.out.printf("1) %s Axe %,dg\n2) %s Axe %,dg\n3) %s Axe %,dg\n4) %s Axe %,dg\n5) %s Axe %,dg\n6) %s Axe %,dg\n7) %s Axe %,dg\n8) %s Axe %,dg\n9) Exit\n"
                            , String.valueOf(AXE.Bronze), axeGoldValue(AXE.Bronze), String.valueOf(AXE.Iron), axeGoldValue(AXE.Iron), String.valueOf(AXE.Steel)
                            , axeGoldValue(AXE.Steel), String.valueOf(AXE.Obsidian), axeGoldValue(AXE.Obsidian), String.valueOf(AXE.Mithril), axeGoldValue(AXE.Mithril)
                            , String.valueOf(AXE.Adamant), axeGoldValue(AXE.Adamant), String.valueOf(AXE.Runed), axeGoldValue(AXE.Runed), String.valueOf(AXE.Enchanted)
                            , axeGoldValue(AXE.Enchanted));
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
                            System.out.println("No Purchase");
                            break;
                    }
                    if (axeGoldValue(playerAxe) < axeGoldValue(axePurchased) && axeGoldValue(axePurchased) < coins) {
                        coins -= axeGoldValue(axePurchased);
                        playerAxe = axePurchased;
                        System.out.println("You purchased " + String.valueOf(axePurchased) + " for " + axeGoldValue(axePurchased) + " gold.");
                        System.out.printf("Axe Bonus: %.0f%%\nChance tree will fall: %.0f%%", 100 * axeBonusPercent(playerAxe), 100 * fallChance(playerAxe));
                    } else {
                        System.out.println("Invalid Purchase");
                    }
                    break;
                case 5: // Shop
                    System.out.println("LOG SHOP\n");
                    System.out.printf("Total Coins: %,d gold", coins);
                    System.out.printf("\nTotal Bag Space is " + bagSize);
                    System.out.println("\n1) Double Bag Size " + costDoubleBag + "g\n2) Speed Potion 500g\n3) Strength Potion 500g\n4) Exit");
                    shopMenu = sc.nextInt();

                    if (shopMenu == 1 && coins >= costDoubleBag) {
                        bagSize *= 2;
                        coins -= costDoubleBag;
                        System.out.println("You purchased " + bagSize + " slot bag for " + costDoubleBag + " gold.");
                        costDoubleBag *= 3;
                    } else if (shopMenu == 2 && coins >= 500) {
                        speedPot = true;
                        speedPotCountLeft += 200;
                        coins -= 500;
                        System.out.println("You purchased a potion of speed for 500g. Additional purchases increase the duration.");
                        System.out.println("You now chop twice as fast for the next " + speedPotCountLeft + " chops.");
                    } else if (shopMenu == 3 && coins >= 500) {
                        strengthPot = true;
                        strPotCountLeft += 200;
                        coins -= 500;
                        System.out.println("You purchased a potion of strength for 500g. Additional purchases increase the duration.");
                        System.out.println("You now chop double the chance of receiving a log for the next " + strPotCountLeft + " chops.");
                    } else {
                        System.out.println("No Purchase");
                    }
                    break;
                case 6: // See Stats
                    System.out.println("\nPLAYER STATS:\nPlayerLevel: " + playerLevel);
                    System.out.printf("Total Coins: %,d gold", coins);
                    System.out.println("\nAxe: " + String.valueOf(playerAxe));
                    System.out.printf("Axe Bonus: %.0f%%\nChance Axe will break: %.2f%%\nChance tree will fall: %.0f%%",
                            100 * axeBonusPercent(playerAxe), axeBreakChance, 100 * fallChance(playerAxe));
                    System.out.println("\nBag: " + logsInBag + "/" + bagSize + "\nXP to level: " + playerTotalXp + "/"
                            + totalXpToLevel + " XP");
                    break;
                case 7: // Exit
                    System.out.println("Are you sure you want to quit? Y or N");
                    exit = sc.next().charAt(0);
                    break;
                default: // Error Message
                    System.out.println("INVALID INPUT");
                    break;
            }
            if (exit == 'y' || exit == 'Y') {
                System.out.println("You have reached level " + playerLevel + ". Thank you for playing.");
                break;
            }
            if (axeBroken) {
                System.out.println("You must repair your axe.");
            }
            System.out.println("\nMENU: \n1) Explore Forest\n2) Sell Logs\n3) Repair Axe \n4) Upgrade Axe\n5) Shop\n6) See Stats\n7) Exit");
            try {
                sc = new Scanner(System.in);
                menu = sc.nextInt();
            } catch (Exception e) {
                System.out.println("ERROR: Invalid Menu Option, please try again.");
            }
        }
    }
}