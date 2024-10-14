public class Main {
    public static void main(String[] args) {

        String charters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String newNumbers = "";
        char newDigit = '0';
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                if ((i % 2) < j) {
                    newDigit = charters.charAt(j);
                    newNumbers += newDigit;
                } else {
                    newDigit = charters.charAt(j);
                    newNumbers = newNumbers.substring(0, (newNumbers.length()-1));
                    newNumbers += newDigit;
                }

                System.out.println(newNumbers);
            }
        }
        }
    }
