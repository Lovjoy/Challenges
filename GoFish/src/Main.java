import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        String[] unshuffled =
                {"1Bear", "2Bear", "3Bear", "4Bear", "5Bear", "6Bear", "7Bear", "8Bear", "9Bear", "10Bear", "JBear", "QBear", "KBear",
                        "1Cat", "2Cat", "3Cat", "4Cat", "5Cat", "6Cat", "7Cat", "8Cat", "9Cat", "10Cat", "JCat", "QCat", "KCat",
                        "1Dog", "2Dog", "3Dog", "4Dog", "5Dog", "6Dog", "7Dog", "8Dog", "9Dog", "10Dog", "JDog", "QDog", "KDog",
                        "1Fox", "2Fox", "3Fox", "4Fox", "5Fox", "6Fox", "7Fox", "8Fox", "9Fox", "10Fox", "JFox", "QFox", "KFox"};
        String[] index = new String[52];
        String[] shuffle = new String[52];
        int shuffleIndex;
        int handSizePlayer = 5;
        int handSizeAi = 5;
        String[] playerHand = new String[52];
        String playerHandPrint = "";
        String[] aiHand = new String[52];
        String aiHandPrint = "";
        String[] playerDiscard = new String[52];
        String[] aiDiscard = new String[52];
        String cardChoice;
        boolean aiMatch;
        boolean playerMatch;

        for (int i = 0; i < unshuffled.length; i++) {
            shuffleIndex = rand.nextInt(unshuffled.length);
            if (index[shuffleIndex] == null) {
                shuffle[i] = unshuffled[shuffleIndex];
                index[shuffleIndex] = "-1";
            } else i--;
        }
        System.out.println(Arrays.toString(shuffle));

        for (int i = 0; i < handSizePlayer; i++) {
            playerHand[i] = shuffle[i];
            shuffle[i] = null;
        }
        playerHandPrint = "";
        for (int i = 0; i < handSizePlayer; i++) {
            playerHandPrint += playerHand[i] + ", ";
        }
        System.out.println(playerHandPrint.substring(0, playerHandPrint.length() - 2));

        for (int i = 0, j = 0; j < handSizeAi; i++) {
            if (shuffle[i] != null) {
                aiHand[j] = shuffle[i];
                shuffle[i] = null;
                j++;
            }
        }
        aiHandPrint = "";
        for (int i = 0; i < handSizeAi; i++) {
            aiHandPrint += aiHand[i] + ", ";
        }
        System.out.println(aiHandPrint.substring(0, aiHandPrint.length() - 2));

        while (handSizePlayer != 0 && handSizeAi != 0) {
            System.out.println("You ask \"Do you have any of theses?\" (Enter number 1-10, J, Q, or K)");
            cardChoice = sc.next();

            if (!Objects.equals(cardChoice, "1") && !Objects.equals(cardChoice, "2") && !Objects.equals(cardChoice, "3")
                    && !Objects.equals(cardChoice, "4") && !Objects.equals(cardChoice, "5") && !Objects.equals(cardChoice, "6")
                    && !Objects.equals(cardChoice, "7") && !Objects.equals(cardChoice, "8") && !Objects.equals(cardChoice, "9")
                    && !Objects.equals(cardChoice, "10") && !Objects.equals(cardChoice, "J") && !Objects.equals(cardChoice, "Q")
                    && !Objects.equals(cardChoice, "K") && !Objects.equals(cardChoice, "j") && !Objects.equals(cardChoice, "q")
                    && !Objects.equals(cardChoice, "k"))
            {
                System.out.println("Invalid choice");
            }

            for (int i = 0; i < handSizePlayer; i++) {
                if (playerHand[i].contains(cardChoice.toUpperCase())) {

                }
            }

            aiMatch = false;
            for (int i = 0; i < handSizeAi; i++) {
                if (aiHand[i].contains(cardChoice.toUpperCase())) {
                    aiMatch = true;
                    System.out.println("AI has card " + aiHand[i] + " in hand.");
                    aiHand[i] = aiHand[handSizeAi - 1];
                    handSizeAi--;
                    i--;
                }
            }
            aiHandPrint = "";
            for (int i = 0; i < handSizeAi; i++) {
                aiHandPrint += (aiHand[i] + ", ");
            }
            System.out.println(aiHandPrint.substring(0, aiHandPrint.length() - 2));

            if (!aiMatch) {
                System.out.println("AI does not have card a " + cardChoice + " in hand. Draw.");
                handSizePlayer++;
                for (int j = 0; j < 52; j++) {
                    if (shuffle[j] != null) {
                        playerHand[handSizePlayer] = shuffle[j];
                        break;
                    }

                }
                playerHandPrint = "";
                for (int i = 0; i < handSizePlayer; i++) {
                    playerHandPrint += playerHand[i] + ", ";
                }
                System.out.println(playerHandPrint.substring(0, playerHandPrint.length() - 2));
            }
        }
    }
}