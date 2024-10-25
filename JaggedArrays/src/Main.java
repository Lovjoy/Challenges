// Ray Joy
// 10/25/2025
// Jagged Arrays

/*You start with an array
int[] numbers;

it has 5 elements.

the first element is another integer array with 5 elements.
the second element is another integer array with 7 elements.
the third element is another integer array with 2 elements. Both of these elements are also arrays.
the fourth element is another integer array with 3 elements.
the fifth element is another integer array with 4 elements.

You will set the value of all elements mentioned. it does not matter what value, so long as it isn't the same number over and over.

Your task is to print out the values of all the elements within the following code block

for(int i = 0; i < numbers.length; i++) {
        }*/

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[][] sprinkles = new String[5][];
        String[] school = {"fox", "hat", "coffee", "scrolls", "coins"};
        sprinkles[0] = school;
        String[] mornings = {"coffee", "turtle", "blanket", "bear", "tiger", "sauce", "otter"};
        sprinkles[1] = mornings;

        String[][] night = new String[2][];
        String[] sauce = {"hot sauce", "lion", "pepper", "donut"};
        night[0] = sauce;
        String[] bed = {"full moon", "tiger", "otter"};
        night[1] = bed;
        String[] tempNight = new String[7];
        for (int i = 0; i < night.length; i++) {
            for (int k = 0, j = 0; k < night[i].length; j++, k++) {
                if (i == 0) {
                    tempNight[k] = night[i][j];
                }
                if (i == 1) {
                    tempNight[k + sauce.length] = night[i][j];
                }
            }
        }
        sprinkles[2] = tempNight;

        String[] games = {"trophy", "coins", "fish"};
        sprinkles[3] = games;
        String[] work = {"bee", "hydrant", "fireman's hat", "flowers"};
        sprinkles[4] = work;

        for (int i = 0; i < sprinkles.length; i++) {
            System.out.println(Arrays.toString(sprinkles[i]));
        }
    }
}