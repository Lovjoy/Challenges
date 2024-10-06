package Main;
// Player battles a Queen Boar using melee attacks, spells, or special moves
// Ray Joy
// 10/3/2024
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		int playerHealth = 1000;
		int monsterHealth = 1000;
		int attackType;
		int meleeAttack = 0;
		int castSpell = 0;
		int specialAttack = 0;
		int mobAttackType;
		int mobMelee;
		int mobSpecial;
		boolean turn = true;
		int randText;

		System.out.println("After a long day of killing boars in the forest, you stumble into their "
				+ "nest and find the Queen boar.\nShe wants revenge!\n");
		System.out.println("Choose an action: \n(1) Melee Attack \n(2) Spell Cast \n(3) " + "Special Attack");
		attackType = sc.nextInt();

		while (monsterHealth > 0 && playerHealth > 0) {
			if (turn == true) {
				switch (attackType) {
				case 1:
					meleeAttack = rand.nextInt(50, 151);
					randText = rand.nextInt(4);
					switch (randText) {
					case 0:
						System.out.println("You swing your sword for a total of " + meleeAttack + " hp.");
						break;
					case 1:
						System.out.println("You stab the Queen Boar for a total of " + meleeAttack + " hp.");
						break;
					case 2:
						System.out.println("You thrust your sword for a total of " + meleeAttack + " hp.");
						break;
					case 3:
						System.out.println("You poke the Queen Boar for a total of " + meleeAttack + " hp.");
						break;
					}
					monsterHealth -= meleeAttack;
					break;
				case 2:
					castSpell = rand.nextInt(75, 121);
					randText = rand.nextInt(4);
					switch (randText) {
					case 0:
						System.out.println("You cast a fireball for a total of " + castSpell + " hp.");
						break;
					case 1:
						System.out.println("You cast a freeze the Queen Boar for a total of " + castSpell + " hp.");
						break;
					case 2:
						System.out.println("You cast a shadowbolt for a total of " + castSpell + " hp.");
						break;
					case 3:
						System.out.println("You cast a hurrican for a total of " + castSpell + " hp.");
						break;
					}
					monsterHealth -= castSpell;
					break;
				case 3:
					specialAttack = rand.nextInt(80, 111);
					randText = rand.nextInt(4);
					switch (randText) {
					case 0:
						System.out.println("You bodyslam the boar for a total of " + specialAttack + " hp.");
						break;
					case 1:
						System.out.println("You spitroast the Queen Boar for a total of " + specialAttack + " hp.");
						break;
					case 2:
						System.out.println("You ambush the boar for a total of " + specialAttack + " hp.");
						break;
					case 3:
						System.out.println("Your not so special special move does a total of " + specialAttack + " hp.");
						break;
					}
					monsterHealth -= specialAttack;
					break;
				}
			} else {
				System.out.println("The boar lives.");
				mobAttackType = rand.nextInt(3);

				switch (mobAttackType) {
				// melee attack the player (75-120 damage randomly decided)
				case 0:
					mobMelee = rand.nextInt(75, 121);
					playerHealth -= mobMelee;
					System.out.println("The boar attacks for " + mobMelee + " hp.");
					break;
				// Use a special ability on the player (1-200 damage randomly decided)
				case 1:
					mobSpecial = rand.nextInt(1, 201);
					playerHealth -= mobSpecial;
					System.out.println("The boar charges for " + mobSpecial + " hp.");
					break;
				// SUPER RUN AWAY! (0 damage)
				case 2:
					if (monsterHealth < 100) {
						System.out.println("The boar runs away, you are victorious!");
					} else {
						System.out.println("The boar cowars in fear.");
					}
					break;
				}
				System.out.println("Choose an action: \n(1) Melee Attack \n(2) Spell Cast \n(3) " + "Special Attack");
				attackType = sc.nextInt();

			}
			turn = false;
		}
		if (playerHealth <= 0) {
			System.out.println("Boars are going to be ruling the world now thanks to you.");
		} else {
			System.out.println("The Queen Boar has died! We can all rest now to fight boars another day.");
		}
	}
}