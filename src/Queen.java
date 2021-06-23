public class Queen extends Piece {

    public Queen(int x, int y, boolean isWhite, boolean isAlive) {
        super(x, y, isWhite, isAlive);
    }

    @Override
    public String toString() {
        if (this.getIsWhite() == true) {
            return "Q";
        } else {
            return "q";
        }
    }

    @Override
    public boolean possibleMove(int x, int y) {
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
        if (!Board.isNotBlocked(this.getX(), this.getY(), x, y)) {
            System.out.println("Path is blocked");
            return false;
        }
        if (Math.abs(this.getX() - x) == Math.abs(this.getY() - y)) {
            return true;
        }

        if (Math.abs(this.getX() - x) != 0 && Math.abs(this.getY() - y) == 0
                || Math.abs(this.getX() - x) == 0 && Math.abs(this.getY() - y) != 0) {
            return true;
        }
        return false;
    }

}