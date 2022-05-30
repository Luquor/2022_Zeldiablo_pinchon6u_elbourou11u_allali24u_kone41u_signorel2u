package gameLaby.laby;

public class Position {
    private int x, y;


    /**
     * Constructeur de la classe Position
     * @param x
     * @param y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    /**
     * Retourne la position x
     * @return l'attribut x
     */
    public int getX() {
        return x;
    }

    /**
     * Retourne la position y
     * @return l'attribut y
     */
    public int getY() {
        return y;
    }
}
