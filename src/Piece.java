public abstract class Piece {
    private int x;
    private int y;
    private boolean isWhite;
    private boolean isAlive;

    public Piece(int x, int y, boolean isWhite, boolean isAlive) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
        this.isAlive = isAlive;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean getIsWhite() {
        return this.isWhite;
    }

    public void setIsWhite(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean getIsAlive() {
        return this.isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public abstract boolean possibleMove(int x, int y);

    public abstract String toString();

    public boolean canMove() {
        for (int i = 0; i < 8; i++) {
            for (int f = 0; f < 8; f++) {
                if (this.possibleMove(i, f)) {
                    if (!Board.inCheckTest(this.getX(), this.getY(), i, f, this.getIsWhite())) {
                        return true;
                    }

                }
            }
        }
        return false;
    }
}
