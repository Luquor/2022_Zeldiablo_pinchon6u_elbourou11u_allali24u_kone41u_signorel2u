package gameLaby.laby;

public class Activation extends Position{

    private PassageSecret passageSecret;
    private boolean estActive;


    /**
     * Constructeur de la classe Activation utilisant le super() de la classe Position
     * @param x coordonnee x
     * @param y coordonnee y
     */
    public Activation(int x, int y) {
        super(x, y);
        this.estActive = false;
    }


    public void activer() {
        this.estActive = true;
        this.passageSecret.ouvrir();
    }

    public void setPassageSecret(PassageSecret passage) {
        this.passageSecret = passage;
    }

    public boolean getEtat() {
        return this.estActive;
    }

    public int getPassageX(){
        return this.passageSecret.getX();
    }
    public int getPassageY(){
        return this.passageSecret.getY();
    }
}

