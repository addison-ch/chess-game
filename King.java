public class King extends Piece {

    public King(int x, int y, boolean isWhite, boolean isAlive) {
        super(x, y, isWhite, isAlive);
    }

    @Override
    public String toString() {
        if (this.getIsWhite() == true) {
            return "K";
        } else {
            return "k";
        }
    }

    @Override
    public boolean possibleMove(int x, int y) {
        if (Board.board[x][y] != null) {
            if (Board.board[x][y].getIsWhite() == this.getIsWhite()) {
                return false;
            }
        }

        if (this.getX() == x && this.getY() == y) {
            return false;
        }
        if (Math.abs(this.getX() - x) == 1 && Math.abs(this.getY() - y) == 1) {
            return true;
        }

        else if (Math.abs(this.getX() - x) == 1 && Math.abs(this.getY() - y) == 0
                || Math.abs(this.getX() - x) == 0 && Math.abs(this.getY() - y) == 1) {
            return true;
        } else {
            return false;
        }
    }
}