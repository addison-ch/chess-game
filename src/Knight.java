package src;

public class Knight extends Piece {

    public Knight(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
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
        if (Board.board[x][y] != null) {
            if (Board.board[x][y].getIsWhite() == this.getIsWhite()) {
                return false;
            }
        }

        if (this.getX() == x && this.getY() == y) {
            return false;
        }
        if (Math.abs(this.getY() - y) == 2 && Math.abs(this.getX() - x) == 1
                || Math.abs(this.getY() - y) == 1 && Math.abs(this.getX() - x) == 2) {
            return true;
        }

        return false;
    }

}