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
        if (Math.abs(this.getY() - y) == 2 && Math.abs(this.getX() - x) == 1
                || Math.abs(this.getY() - y) == 1 && Math.abs(this.getX() - x) == 2) {
            return true;
        }

        return false;
    }

}