public class Pawn extends Piece {

    public Pawn(int x, int y, boolean isWhite, boolean isAlive) {
        super(x, y, isWhite, isAlive);
    }

    @Override
    public String toString() {
        if (this.getIsWhite() == true) {
            return "P";
        } else {
            return "p";
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
        if (this.getIsWhite() == true && Board.board[x][y] == null) {
            if (this.getX() == 6 && x == 4 && y == this.getY()) {
                if (Board.isNotBlocked(this.getX(), this.getY(), x, y)) {
                    return true;
                }
            }
            if (x - this.getX() == -1 && y == this.getY()) {
                return true;
            }
        } else if (this.getIsWhite() == false && Board.board[x][y] == null) {
            if (this.getX() == 1 && x == 3 && y == this.getY()) {
                if (Board.isNotBlocked(this.getX(), this.getY(), x, y)) {
                    return true;
                }
            }
            if (x - this.getX() == 1 && y == this.getY()) {
                return true;
            }
        }

        if (x - this.getX() == -1 && this.getIsWhite() == true) {
            if (Math.abs(this.getY() - y) == 1 && Board.board[x][y] != null
                    && Board.board[x][y].getIsWhite() == false) {
                return true;
            }
        }
        if (x - this.getX() == 1 && this.getIsWhite() == false) {
            if (Math.abs(this.getY() - y) == 1 && Board.board[x][y] != null && Board.board[x][y].getIsWhite() == true) {
                return true;
            }
        }
        return false;
    }

}