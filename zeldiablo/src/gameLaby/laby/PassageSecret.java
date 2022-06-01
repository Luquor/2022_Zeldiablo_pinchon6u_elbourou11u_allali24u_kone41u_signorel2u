package gameLaby.laby;

public class PassageSecret extends Position {

    private boolean estOuvert;


    public PassageSecret(int x, int y) {
        super(x, y);
        this.estOuvert = false;
    }

    public void ouvrir() {
        this.estOuvert = true;
    }

    public boolean getEtat() {
        return this.estOuvert;
    }
}
