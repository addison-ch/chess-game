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