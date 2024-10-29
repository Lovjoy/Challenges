import com.sun.jdi.connect.Connector;

public class Main {
    public static void main(String[] args) {

        String[] symbol = {"Carrot", "Bunny", "Flowers", "Fox", "Money", "Bear", "Hot Sauce", "Tiger", "Moon", "Orange"};
        String[] meaning = {"Food", "Human", "Want", "Clever", "Good Luck", "Big Hug", "Naughty Things", "Cuddle", "Bed", "Proof"};
        String[] tier = {"I", "I", "II", "I", "I", "II", "III", "III", "III", "I"};
        boolean[] spicy = {false, false, false, false, false, false, true, true, true, false};

        for (int i = 0; i < symbol.length; i++) {
            String isSpicy;
            if (spicy[i]) {
                isSpicy = " is spicy.";
            } else {
                isSpicy = " is not spicy.";
            }
            System.out.println(symbol[i] + " is " + meaning[i] + ", it is a tier " + tier[i] + " and" + isSpicy);
        }
    }
}