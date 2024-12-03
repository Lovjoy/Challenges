import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String playerName = "Lovejoy";
        int totalHp = 100;
        int currentHp = 100;
        int level= 1;
        int currentXP = 0;
        int strength = 5;
        int agility = 5;
        int intelligence = 5 ;
        boolean needsADougnut = true;

//        String playerName;
//        int totalHp;
//        int currentHp;
//        int level;
//        int currentXP;
//        int strength;
//        int agility;
//        int intelligence;
//        boolean needsADoughnut;


        File file = new File("Savegame.txt");
        if (file.createNewFile()) {
            System.out.println("File created");
        } else {
            System.out.println("File already exists");
        }
        FileWriter fw = new FileWriter("Savegame.txt");
        fw.write(playerName + "\n");
        fw.write(totalHp + "\n");
        fw.write(currentHp + "\n");
        fw.write(level + "\n");
        fw.write(currentXP + "\n");
        fw.write(strength + "\n");
        fw.write(agility + "\n");
        fw.write(intelligence + "\n");
        fw.write(needsADougnut + "\n");
        fw.close();
        System.out.println("Saved file");

        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            playerName = sc.nextLine();
            totalHp = sc.nextInt();
            currentHp = sc.nextInt();
            level = sc.nextInt();
            currentXP = sc.nextInt();
            strength = sc.nextInt();
            agility = sc.nextInt();
            intelligence = sc.nextInt();
            needsADougnut = sc.nextBoolean();
        }
        fw.close();
        sc.close();
    }
}