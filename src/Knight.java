public class Knight extends Piece {

    public Knight(int x, int y, boolean isWhite, boolean isAlive) {
        super(x, y, isWhite, isAlive);
    }

    @Override
    public String toString() {
        if (this.getIsWhite() == true) {
            return "N";
        } else {
            return "n";
        }
    }

    @Override
    public boolean possibleMove(int x, int y) {
<<<<<<< HEAD
<<<<<<< HEAD
        if (Board.board[x][y] != null) {
            if (Board.board[x][y].getIsWhite() == this.getIsWhite()) {
                return false;
            }
        }

        if (this.getX() == x && this.getY() == y) {
            return false;
        }
=======
>>>>>>> parent of b32de7f (checking mechanic implemented)
=======
>>>>>>> parent of b32de7f (checking mechanic implemented)
        if (Math.abs(this.getY() - y) == 2 && Math.abs(this.getX() - x) == 1
                || Math.abs(this.getY() - y) == 1 && Math.abs(this.getX() - x) == 2) {
            return true;
        }

        return false;
    }

}