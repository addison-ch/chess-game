package src;

public class Rook extends Piece {

    public Rook(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
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
        if (Board.board[x][y] != null) {
            if (Board.board[x][y].getIsWhite() == this.getIsWhite()) {
                return false;
            }
        }

        if (this.getX() == x && this.getY() == y) {
            return false;
        }
        if (Math.abs(this.getX() - x) != 0 && Math.abs(this.getY() - y) != 0) {
            return false;
        }

        if (Board.isNotBlocked(this.getX(), this.getY(), x, y)) {
            return true;
        }

        return false;
    }

}