public class Board {
    public static Piece[][] board = new Piece[8][8];

    // public Board() {
    // this.resetBoard();
    // }

    public static void startBoard() {
        board[0][0] = new Rook(0, 0, false, true);
        board[0][1] = new Knight(0, 1, false, true);
        board[0][2] = new Bishop(0, 2, false, true);
        board[0][3] = new Queen(0, 3, false, true);
        board[0][4] = new King(0, 4, false, true);
        board[0][5] = new Bishop(0, 5, false, true);
        board[0][6] = new Knight(0, 6, false, true);
        board[0][7] = new Rook(0, 7, false, true);

        board[1][0] = new Pawn(1, 0, false, true);
        board[1][1] = new Pawn(1, 1, false, true);
        board[1][2] = new Pawn(1, 2, false, true);
        board[1][3] = new Pawn(1, 3, false, true);
        board[1][4] = new Pawn(1, 4, false, true);
        board[1][5] = new Pawn(1, 5, false, true);
        board[1][6] = new Pawn(1, 6, false, true);
        board[1][7] = new Pawn(1, 7, false, true);

        board[7][0] = new Rook(7, 0, true, true);
        board[7][1] = new Knight(7, 1, true, true);
        board[7][2] = new Bishop(7, 2, true, true);
        board[7][3] = new Queen(7, 3, true, true);
        board[7][4] = new King(7, 4, true, true);
        board[7][5] = new Bishop(7, 5, true, true);
        board[7][6] = new Knight(7, 6, true, true);
        board[7][7] = new Rook(7, 7, true, true);

        board[6][0] = new Pawn(6, 0, true, true);
        board[6][1] = new Pawn(6, 1, true, true);
        board[6][2] = new Pawn(6, 2, true, true);
        board[6][3] = new Pawn(6, 3, true, true);
        board[6][4] = new Pawn(6, 4, true, true);
        board[6][5] = new Pawn(6, 5, true, true);
        board[6][6] = new Pawn(6, 6, true, true);
        board[6][7] = new Pawn(6, 7, true, true);

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = null;
            }
        }

    }

    public static void print() {
        System.out.println("    --------------------------------");
        for (int i = 0; i < 8; i++) {
            System.out.print("  " + i + " |");
            for (int f = 0; f < 8; f++) {
                if (board[i][f] == null) {
                    System.out.print("   |");
                } else {
                    System.out.print(" " + board[i][f].toString() + " |");
                }
            }
            System.out.println();
            System.out.println("    --------------------------------");
        }
        System.out.println("[:)]  0   1   2   3   4   5   6   7 ");
    }

    public static boolean validMove(String move, boolean isWhite, boolean inCheck) {
        // String[] validPieces = { "wB", "bB", "wP", "bP", "wK", "bK", "wN", "bN",
        // "wQ", "bQ", "wR", "bR" };
        String[] splitMove = move.split(" ");
        if (move.length() != 5) {
            System.out.println("Follow the format - ex. 06 05");
            return false;
        }
        if (splitMove.length != 2) {
            System.out.println("Follow the format - use 2 coordinates");
            return false;
        }

        String first = splitMove[0];
        String second = splitMove[1];

        if (first.length() != 2 || second.length() != 2) {
            System.out.println("Follow the format ex. 66 11");
            return false;
        }

        int firstX = first.charAt(0) - '0';
        int firstY = first.charAt(1) - '0';
        int secondX = second.charAt(0) - '0';
        int secondY = second.charAt(1) - '0';

        if (firstX < 0 || firstX > 7 || firstY < 0 || firstY > 7 || secondX < 0 || secondX > 7 || secondY < 0
                || secondY > 7) {
            System.out.println("Pick coordinates that are on the board");
            return false;
        }

        if (firstX == secondX && firstY == secondY) {
            System.out.println("Can not move onto same spot");
            return false;
        }
        Piece selected = board[firstX][firstY];
        Piece other = board[secondX][secondY];

        if (selected == null) {
            System.out.println("Tile is empty");
            return false;
        }
        if (selected.getIsWhite() != isWhite) {
            System.out.println("Can not move opponents piece");
            return false;
        }

        if (inCheck) {
            if (inCheckTest(firstX, firstY, secondX, secondY, isWhite)) {
                System.out.println("King is still in check");
                return false;
            }
        }
        if (other != null) {
            if (other.getIsWhite() == isWhite) {
                System.out.println("Can not capture own piece");
                return false;
            }
        }

        if (kingInDanger(firstX, firstY, secondX, secondY, isWhite)) {
            System.out.println("Can not leave King in check");
            return false;
        }
        if (!selected.possibleMove(secondX, secondY)) {
            System.out.println("Piece can not do that");
            return false;
        }
        return true;

    }

    public static boolean isNotBlocked(int x1, int y1, int x2, int y2) {
        int diffX = x2 - x1;
        int diffY = y2 - y1;
        int wayX = 0;
        int wayY = 0;
        int size = 0;

        if (diffX < 0) {
            wayX = -1;
        } else if (diffX > 0) {
            wayX = 1;
        }

        if (diffY < 0) {
            wayY = -1;
        } else if (diffY > 0) {
            wayY = 1;
        }

        if (diffX != 0) {
            size = Math.abs(diffX) - 1;
        } else {
            size = Math.abs(diffY) - 1;
        }

        for (int i = 0; i < size; i++) {
            x1 += wayX;
            y1 += wayY;

            if (board[x1][y1] != null) {
                return false;
            }
        }
        return true;
    }

    public static Piece getPiece(int x, int y) {
        return board[x][y];
    }

    public static void playMove(String move) {
        String[] splitMove = move.split(" ");

        String first = splitMove[0];
        String second = splitMove[1];

        int firstX = first.charAt(0) - '0';
        int firstY = first.charAt(1) - '0';
        int secondX = second.charAt(0) - '0';
        int secondY = second.charAt(1) - '0';

        board[secondX][secondY] = board[firstX][firstY];
        board[firstX][firstY] = null;

        board[secondX][secondY].setX(secondX);
        board[secondX][secondY].setY(secondY);

        if (board[secondX][secondY] instanceof Pawn && board[secondX][secondY].getIsWhite() == true) {
            if (secondX == 0) {
                board[secondX][secondY] = new Queen(0, secondY, true, true);
            }
        } else if (board[secondX][secondY] instanceof Pawn && board[secondX][secondY].getIsWhite() == false) {
            if (secondX == 7) {
                board[secondX][secondY] = new Queen(7, secondY, false, true);
            }
        }
    }

    public static boolean kingInDanger(int x1, int y1, int x, int y, boolean isWhite) { // checks if move exposes king

        if (board[x1][y1] instanceof King) {
            for (int i = 0; i < 8; i++) {
                for (int f = 0; f < 8; f++) {
                    if (board[i][f] != null) {
                        if (board[i][f].getIsWhite() != isWhite && board[i][f].possibleMove(x, y)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else {
            Piece temp = board[x][y];
            board[x][y] = board[x1][y1];
            board[x1][y1] = null;
            board[x][y].setX(x);
            board[x][y].setY(y);
            int kingX = -1;
            int kingY = -1;
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    if (board[j][k] instanceof King && board[j][k].getIsWhite() == isWhite) {
                        kingX = j;
                        kingY = k;
                    }
                }
            }

            for (int i = 0; i < 8; i++) {
                for (int f = 0; f < 8; f++) {
                    if (board[i][f] != null) {
                        if (board[i][f].getIsWhite() != isWhite && board[i][f].possibleMove(kingX, kingY)) {
                            board[x1][y1] = board[x][y];
                            board[x][y] = temp;
                            board[x1][y1].setX(x1);
                            board[x1][y1].setY(y1);
                            return true;
                        }
                    }
                }
            }

            board[x1][y1] = board[x][y];
            board[x][y] = temp;
            board[x1][y1].setX(x1);
            board[x1][y1].setY(y1);
            return false;
        }
    }

    public static boolean kingInCheck(boolean isWhite) {// checks if you put enemy king in check
        int kingX = -1;
        int kingY = -1;
        for (int j = 0; j < 8; j++) {
            for (int k = 0; k < 8; k++) {
                if (board[j][k] instanceof King && board[j][k].getIsWhite() != isWhite) {
                    kingX = j;
                    kingY = k;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int f = 0; f < 8; f++) {
                if (board[i][f] != null) {
                    if (board[i][f].getIsWhite() == isWhite && board[i][f].possibleMove(kingX, kingY)) {

                        return true;
                    }
                }
            }
        }

        return false;

    }

    public static boolean inCheckTest(int firstX, int firstY, int secondX, int secondY, boolean isWhite) {
        Piece temp = board[secondX][secondY];// tests if move makes king out of check
        board[secondX][secondY] = board[firstX][firstY];
        board[firstX][firstY] = null;
        board[secondX][secondY].setX(secondX);
        board[secondX][secondY].setY(secondY);

        int kingX = -1;
        int kingY = -1;
        for (int j = 0; j < 8; j++) {
            for (int k = 0; k < 8; k++) {
                if (board[j][k] instanceof King && board[j][k].getIsWhite() == isWhite) {
                    kingX = j;
                    kingY = k;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int f = 0; f < 8; f++) {
                if (board[i][f] != null) {
                    if (board[i][f].getIsWhite() != isWhite && board[i][f].possibleMove(kingX, kingY)) {

                        board[firstX][firstY] = board[secondX][secondY];
                        board[secondX][secondY] = temp;
                        board[firstX][firstY].setX(firstX);
                        board[firstX][firstY].setY(firstY);
                        return true;
                    }
                }
            }
        }
        board[firstX][firstY] = board[secondX][secondY];
        board[secondX][secondY] = temp;
        board[firstX][firstY].setX(firstX);
        board[firstX][firstY].setY(firstY);
        return false;

    }

    public static boolean isCheckmate() {
        return true;
    }
}