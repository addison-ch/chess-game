import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner inputs = new Scanner(System.in);

        while (true) {
            System.out.println("* How to play:");
            System.out.println("* Enter the piece you want to move by referring to its tile then");
            System.out.println("* enter a space and then provide a valid tile to move to.");
            System.out.println("* Tiles must be referred to by its coordinate, made of 2 digits.");
            System.out.println("* First digit is the vertical location, then second digit is the horizontal");
            System.out.println("* EXAMPLE: '60 40' moves the left most white pawn up two units.");
            System.out.println("* Pawns auto-promote to queens. CAPITALS are WHITE. LOWER case are BLACK.");
            System.out.println("* type in \"START\" to continue");

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
                    if (inCheck) {
                        System.out.println("You are currently in CHECK.");
                    }

                    if (inCheck) {
                        if (Board.isMated(isWhite)) {
                            System.out.println("Checkmate has occured.");
                            System.out.printf("%s has LOST \n", isWhite ? "WHITE" : "BLACK");
                            System.out.printf("Type 'RESTART' to return to game start. Type anything else to exit.");
                            String end = inputs.nextLine();
                            if (end.equals("RESTART")) {
                                break;
                            } else {
                                System.exit(0);
                            }
                        }
                    }
                    String move = inputs.nextLine();
                    while (!Board.validMove(move, isWhite, inCheck)) {
                        System.out.println("Please enter a valid move.");
                        move = inputs.nextLine();
                    }

                    Board.playMove(move);
                    turn += 1;

                    inCheck = Board.kingInCheck(isWhite);

                }
            }

        }

    }
}