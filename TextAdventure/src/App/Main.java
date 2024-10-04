package App;

// This simulates an attack with a boar with a melee, spell, or special attack.
// Personal practice project
// 10/1/24
// Ray Joy


import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		int playerHealth = 100;
		int monsterHealth = 100;
		int attackType;
		int meleeAttack;
		int castSpell;
		int specialAttack;
		int mobAttackType;
		int mobMelee;
		int mobSpecial;

		System.out.println("A wild boar appears.\n");
		System.out.println("Choose an action: \n(1) Melee Attack \n(2) Spell Cast \n(3) Special Attack");
		attackType = sc.nextInt();

		switch (attackType) {
		case 1:
			meleeAttack = rand.nextInt(50, 151);
			System.out.println("You swing your sword for a total of " + meleeAttack + " hp.");
			monsterHealth -= meleeAttack;
			break;
		case 2:
			castSpell = rand.nextInt(75, 121);
			System.out.println("You cast a fireball for a total of " + castSpell + " hp.");
			monsterHealth -= castSpell;
			break;
		case 3:
			specialAttack = rand.nextInt(80, 111);
			System.out.println("You bodyslam the boar for a total of " + specialAttack + " hp.");
			monsterHealth -= specialAttack;
			break;
		}

		if (monsterHealth <= 0) {
			System.out.println("You have defeated the boar, off to fight more boars!");

		} else if (monsterHealth > 0) {
			System.out.println("The boar lives.\n");
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
				System.out.println("The boar runs away, you are victorious!");
				break;

			}
			if (playerHealth <= 0) {
				System.out.println("You have been defeated by a boar, feel bad.");
			}
			if (playerHealth > 0 && monsterHealth > 0 && mobAttackType != 2) {
				System.out.println("\nYou both lived, prepare for another attack. Hit the boar like you "
						+ "you mean it this time.\n");
				System.out.println("Choose an action: \n(1) Melee Attack \n(2) Spell Cast \n(3) Special Attack");
				attackType = sc.nextInt();

				switch (attackType) {
				case 1:
					meleeAttack = rand.nextInt(50, 151);
					System.out.println("You stab the boar for a total of " + meleeAttack + " hp.");
					monsterHealth -= meleeAttack;
					System.out.println("Try picking on someone your own size!");
					break;
				case 2:
					castSpell = rand.nextInt(75, 121);
					System.out.println("You freeze the boar for a total of " + castSpell + " hp.");
					monsterHealth -= castSpell;
					System.out.println("Try picking on someone your own size!");
					break;
				case 3:
					specialAttack = rand.nextInt(80, 111);
					System.out.println("You spitroast the boar for a total of " + specialAttack + " hp.");
					monsterHealth -= specialAttack;
					System.out.println("Try picking on someone your own size!");
					break;
				}
			}

		}
	}
}
