public class Rook extends Piece {

    public Rook(int x, int y, boolean isWhite, boolean isAlive) {
        super(x, y, isWhite, isAlive);
    }

    @Override
    public String toString() {
        if (this.getIsWhite() == true) {
            return "R";
        } else {
            return "r";
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
        if (Math.abs(this.getX() - x) != 0 && Math.abs(this.getY() - y) != 0) {
            return false;
        }

        if (Board.isNotBlocked(this.getX(), this.getY(), x, y)) {
            return true;
        }

        System.out.println("Path is blocked");
        return false;
    }

}