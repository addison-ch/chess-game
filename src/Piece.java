package src;

public abstract class Piece {
    private int x;
    private int y;
    private boolean isWhite;
    private boolean isAlive;

    public Piece(int x, int y, boolean isWhite) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
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
}