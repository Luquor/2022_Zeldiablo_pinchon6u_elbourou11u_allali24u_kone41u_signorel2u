package gameLaby.laby;

public class CasePieges extends Position {

    private boolean etatCasePieges;


    /**
     * Constructeur de la classe CasePieges
     * @param x position x
     * @param y position y
     */
    public CasePieges(int x, int y) {
        super(x, y);
        this.etatCasePieges = false;
    }


    /**
     * Permet de recuperer l'etat de la case pieges
     * @return l'etat de la case pieges
     */
    public boolean estDecouverte() {
        return this.etatCasePieges;
    }

    /**
     * Permet de recuperer les coordonnees X de la case pieges
     * @return les coordonnees X de la case pieges
     */
    public int getX() {
        return super.getX();
    }

    /**
     * Permet de recuperer les coordonnees Y de la case pieges
     * @return les coordonnees Y de la case pieges
     */
    public int getY() {
        return super.getY();
    }
}
