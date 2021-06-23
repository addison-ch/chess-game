public class Bishop extends Piece {

    public Bishop(int x, int y, boolean isWhite, boolean isAlive) {
        super(x, y, isWhite, isAlive);
    }

    @Override
    public String toString() {
        if (this.getIsWhite() == true) {
            return "B";
        } else {
            return "b";
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
        if (Math.abs(this.getX() - x) != Math.abs(this.getY() - y)) {
            return false;
        }

        if (Board.isNotBlocked(this.getX(), this.getY(), x, y)) {
            return true;
        } else {
            System.out.println("Path is blocked");
            return false;
        }
    }

}