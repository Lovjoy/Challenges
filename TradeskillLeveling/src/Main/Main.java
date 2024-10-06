package Main;
//Ray Joy
//10/4/2024
//simulates skillups from tradeskills making 40 leather belts
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		Random rand = new Random();
		int skill = 1;
		double percent;

		for (int i = 1; i <= 40; ++i) {
			if (skill <= 10) {
				skill++;
			} else if (skill <= 20) {
				percent = rand.nextDouble();
				if (percent >= 0.5) {
					skill++;
				} 
			} else if (skill <= 40) {
				percent = rand.nextDouble();
				if (percent >= 0.90) {
					skill++;
				} 
			}
		}
		System.out.println("You leveled up " + skill + " times.");
	}
}
