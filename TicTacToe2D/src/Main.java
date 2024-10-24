import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[][] board = {
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}
        };

        boolean winner = false;
        boolean turn = true;
        int row;
        int col;

        System.out.println("Welcome to TicTacToe2D!");

        while (!winner) {

            if (turn) {
                System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
                System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
                System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);


                System.out.print("Row: ");
                row = (sc.nextInt() - 1);
                System.out.print("Column: ");
                col = (sc.nextInt() - 1);



                if (board[row][col].equals(" ")) {
                    board[row][col] = "X";
                    turn = false;
                } else {
                    System.out.println("Invalid Move.");
                }
            }

            if (!board[0][0].equals(" ") && board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
                winner = true;
                if (board[0][0].equals("X")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lost!");
                }
                break;
            }
            if (!board[1][0].equals(" ") && board[1][0] == board[1][1] && board[1][1] == board[1][2]) {
                winner = true;

                if (board[1][0].equals("X")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lost!");
                }
                break;
            }
            if (!board[2][0].equals(" ") && board[2][0] == board[2][1] && board[2][1] == board[2][2]) {
                winner = true;
                if (board[2][0].equals("X")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lost!");
                }
                break;
            }
            if (!board[0][0].equals(" ") && board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
                winner = true;
                if (board[0][0].equals("X")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lost!");
                }
                break;
            }
            if (!board[0][1].equals(" ") && board[0][1] == board[1][1] && board[0][1] == board[2][1]) {
                winner = true;
                if (board[0][1].equals("X")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lost!");
                }
                break;
            }
            if (!board[0][2].equals(" ") && board[0][2] == board[1][2] && board[1][2] == board[2][2]) {
                winner = true;
                if (board[0][2].equals("X")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lost!");
                }
                break;
            }
            if (!board[0][0].equals(" ") && board[0][0] == board[1][1] && board[01][1] == board[2][2]) {
                winner = true;
                if (board[0][0].equals("X")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lost!");
                }
                break;
            }
            if (!board[0][2].equals(" ") && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                winner = true;
                if (board[0][2].equals("X")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lost!");
                }
                break;
            }

            if (!turn && !winner) {
                row = rand.nextInt(3);
                col = rand.nextInt(3);

                if (board[row][col].equals(" ")) {
                    board[row][col] = "O";
                    turn = true;
                }
            }
            if (!board[0][0].equals(" ") && board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
                winner = true;
                if (board[0][0].equals("X")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lost!");
                }
                break;
            }
            if (!board[1][0].equals(" ") && board[1][0] == board[1][1] && board[1][1] == board[1][2]) {
                winner = true;

                if (board[1][0].equals("X")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lost!");
                }
                break;
            }
            if (!board[2][0].equals(" ") && board[2][0] == board[2][1] && board[2][1] == board[2][2]) {
                winner = true;
                if (board[2][0].equals("X")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lost!");
                }
                break;
            }
            if (!board[0][0].equals(" ") && board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
                winner = true;
                if (board[0][0].equals("X")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lost!");
                }
                break;
            }
            if (!board[0][1].equals(" ") && board[0][1] == board[1][1] && board[0][1] == board[2][1]) {
                winner = true;
                if (board[0][1].equals("X")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lost!");
                }
                break;
            }
            if (!board[0][2].equals(" ") && board[0][2] == board[1][2] && board[1][2] == board[2][2]) {
                winner = true;
                if (board[0][2].equals("X")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lost!");
                }
                break;
            }
            if (!board[0][0].equals(" ") && board[0][0] == board[1][1] && board[01][1] == board[2][2]) {
                winner = true;
                if (board[0][0].equals("X")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lost!");
                }
                break;
            }
            if (!board[0][2].equals(" ") && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                winner = true;
                if (board[0][2].equals("X")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lost!");
                }
                break;
            }
            if (!board[0][0].equals(" ") && !board[0][1].equals(" ") && !board[0][2].equals(" ")
                    && !board[1][0].equals(" ") && !board[1][1].equals(" ") && !board[1][2].equals(" ")
                    && !board[2][0].equals(" ") && !board[2][1].equals(" ") && !board[2][2].equals(" ")) {
                System.out.println("Cat's Game.");
                winner = true;
            }


        }
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }
}