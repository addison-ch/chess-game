import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner inputs = new Scanner(System.in);

        while (true) {
            System.out.println("How to play:");
            System.out.println("Enter the name of a piece as seen on the board then");
            System.out.println("provide a space and then enter a valid spot to move. For example, '11 11'");
            System.out.println(
                    "Pawns auto-promote to queens. The new queens are indicated by an asterix symbol. Like, \"wP3*\"");
            System.out.println("type in \"START\" to continue");

            String starting = inputs.nextLine();
            if (starting.equals("START")) {
                Board.startBoard();
                int turn = 1;
                boolean inCheck = false;
                while (true) {

                    boolean isWhite = true;
                    if (turn % 2 == 0) {
                        isWhite = false;
                    }
                    Board.print();
                    System.out.printf("Enter a move, %s turn \n", isWhite ? "WHITE" : "BLACK");

                    String move = inputs.nextLine();

                    while (!Board.validMove(move, isWhite)) {
                        System.out.println("Please enter a valid move.");
                        move = inputs.nextLine();
                    }

                    Board.playMove(move);
                    turn += 1;

                    inCheck = Board.kingInCheck(isWhite);
<<<<<<< HEAD
                    if (inCheck) {
                        if (Board.isCheckmate(isWhite)) {
                            System.out.println("Checkmate has occured.");
                            System.out.printf("%s has WON \n", isWhite ? "WHITE" : "BLACK");
                            System.out.printf("Type 'RESTART' to return to game start. Type anything else to exit.");
                            String end = inputs.nextLine();
                            if (end.equals("RESTART")) {
                                break;
                            } else {
                                System.exit(0);
                            }
                        }
                    }
=======
>>>>>>> parent of b32de7f (checking mechanic implemented)
                }
            }

        }

    }
}
