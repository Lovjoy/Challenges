import java.util.Random;
import java.util.Scanner;

public class Main {
    public enum Axe {RUSTY, BRONZE, IRON, STEEL, OBSIDIAN, MITHRIL, ADAMANT, RUNED}

    public enum Tree {NORMAL, OAK, WILLOW, MAPLE, YEW, MAGIC}

    public static void main(String[] args) {
//      Ray Joy
//      10/12/2024

        /* Challenge - Tree Game
        You are tasked with creating a video game about chopping trees. You will have the following stats on your
        character:
        woodcutting level
        woodcutting XP
        xp until next level
        coins
        current axe type
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
        bronze axe - 100 coins || + 1% chop chance
        iron axe - 200 coins || +2% chop chance
        steel axe - 500 coins || +3% chop chance
        obsidian axe - 1000 coins || +4% chop chance
        mithril axe - 3000 coins || +5% chop chance
        adamant axe - 7500 coins || 6% chop chance
        runed axe - 12000 coins || 7% chop chance
        enchanted axe - 20000 coins || 10% chop chance
        Trees are in a forest of 4 tree options. At level there is a 50% chance that tree will apprear. For every level
        the player gains, there is an addional 3% chance that tree will appear in the forest.
        normal tree || level 1 || 10 XP per log ||  5 log max || 20% cut chance ||  7 gp per log
        oak tree    || level 15|| 15 XP per log || 12 log max || 18% cut chance ||  9 gp per log
        willow tree || level 30|| 30 xp per log || 15 log max || 15% cut chance || 11 gp per log
        maple tree  || level 45|| 45 xp per log || 19 log max || 12% cut chance || 14 gp per log
        yew tree    || level 60|| 60 xp per log || 21 log max || 8% cut chance  || 19 gp per log
        magic tree  || level 80|| 100xp per log || 32 log max || 3% cut chance  || 49 gp per log*/
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int coins = 0;
        int playerLevel = 1;
        int playerTotalXp = 0;
        int totalXpToLevel = 100;       // Total xp needed to level. Will increase by 6% each level.
        int axeCost;                    // How much an axe cost to buy
        double axeBonus = 0;            // Starts with rusty axe no bonus
        int newLogs = 0;                // How many logs collected from one tree
        int logsInBag = 0;              // How many logs in player bag, max 32 logs
        int goldValueOfLogs = 0;        // logs in bag coin value before sold
        int treeMenu = 3;               // Forest will have four trees to pick and menu to buy axe and see stats
        int treeOne;                    // First tree
        int treeTwo;                    // Second tree
        int treeThree;                  // Third tree
        int treeFour;                   // Fourth tree
        Tree tree = Tree.NORMAL;        // type of tree
        double treeCutChance = 0.20;           // Normal trees start at 20% chance then decreases with tree type
        double treeFallChance = 0.08;   // 8% chance that the tree will fall and no more logs can be harvested
        double maxLogs = 5;             // Max logs a tree can hold
        int goldPerLog = 7;             // Gold per log when sold, depends on tree type
        int xpPerLog;                   // XP per log when chopped, depends on tree type
        int treeLevel;                  // The first level that the tree will start to appear in the forest
        Axe axe = Axe.RUSTY;            // Type of axe

        // Welcome Message
        System.out.println("Welcome to the Tree Game! \nYou are to explore the forest and collect logs. Logs can be " +
                "sold and coins can be used to upgrade your axe.");

        // Winning condition level 100
        while (playerLevel < 100) {
            switch (treeMenu){
                case 1:                 // Explore Forest
                    if (playerLevel < 15){
                        tree = Tree.NORMAL;
                        }
                    if (playerLevel >= 15 && playerLevel < 30) {
                        if (rand.nextDouble() < .5) {
                        tree = Tree.NORMAL;
                        } else {
                            tree = Tree.OAK;
                        }
                    }

                    // normal tree || level 1 || 10 XP per log ||  5 log max || 20% cut chance ||  7 gp per log
                    if (tree == Tree.NORMAL) {
                        xpPerLog = 10;
                        maxLogs = 5;
                        treeCutChance = 0.20;
                        goldPerLog = 7;

                    }

                    break;
                case 2:                 // Buy Axe
                    break;
                case 3:                 // See Stats
                    System.out.println("\nPLAYER STATS: " + "\nPlayer Level: " + playerLevel + "\nCoins: " + coins + "g"
                            + "\nAxe: " + String.valueOf(axe));
                    System.out.printf("Axe Bonus: %.0f%%", axeBonus * 100);
                    System.out.println("\nBag: " + logsInBag + "/32 logs" + "\nXP to level: " + totalXpToLevel
                            + " XP" + "\nTotal XP earned: " + playerTotalXp);
                    break;
                case 4:                 // Quit Game
                    break;
                default:                // Error Message
                    System.out.println("Invalid menu option, please try again.");
                    break;
            }
            // Quit the Game and exit the while loop
            if (treeMenu == 4) {
                break;
            }
            // Main menu options
            System.out.println("\nMENU: \n1) Explore Forest\n2) Buy Axe \n3) See Stats\n4) Exit");
            treeMenu = sc.nextInt();

        }
        System.out.println("Congratulations you reached level " + playerLevel + ". Thank you for playing. Good bye.");
    }
}