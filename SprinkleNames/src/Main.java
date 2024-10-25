// Ray Joy
// 10/25/2024
// Create names using sprinkles

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int menu;
        boolean exit = false;

        String[] animals = {"Cat", "Dog", "Fox", "Dolphin", "Elephant", "Bee", "Alligator", "Worm", "Pig", "Horse",
                "Zebra", "Racoon", "Fish", "Turtle", "Monkey", "Otter", "Bird", "Owl", "Squirrel", "Butterfly", "Sheep",
                "Frog", "Wolf", "Dinosaur", "Bunny"};
        String[] objects = {"Carrot", "Coffee", "Blanket", "Shield", "Plane", "Apple", "Gem", "Trophy", "FireHydrant" +
                "Tree", "Flag", "Hat", "Lemon", "Book", "Scroll", "Berry", "Marble", "Tomato", "Candy", "Sprinkles",};
        String[] accessories = {"Clouds", "Flowers", "Stars", "Gems", "Glasses", "ShootingStar", "ChocSauce", "Snow",
                "Moon", "Sun", "Water"};

        while (!exit) {

            System.out.println("1) New Name\n2) Exit");
            menu = sc.nextInt();
            switch (menu) {
                case 1:

                    String name = "";

                    name = animals[rand.nextInt(animals.length)] + objects[rand.nextInt(objects.length)] +
                            accessories[rand.nextInt(accessories.length)];
                    if (name.length()>12){
                        name = name.substring(0, 12);
                    }
                    System.out.println(name);
                    break;
                case 2:
                    exit = true;
                    break;

            }
        }
    }
}