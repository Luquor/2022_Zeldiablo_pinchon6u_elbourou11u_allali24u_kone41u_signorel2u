package gameLaby.laby;


import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * gere un personnage situe en x,y
 */
public class Perso {

    /**
     * position du personnage
     */
    int x, y;
    private int pv;
    private List<Image> ImgPerso = new ArrayList<>();
    private Image affichage;

    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Perso(int dx, int dy) {
        this.x = dx;
        this.y = dy;
        this.pv = 5;
    }

    /**
     * permet de savoir si le personnage est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si le personnage est bien en (dx,dy)
     */
    public boolean etrePresent(int dx, int dy) {

        return (this.x == dx && this.y == dy);
    }

    /**
     * Permet de faire subir des dégâts au personnage
     * @param degats
     */
    public void subirDegats(int degats) {
        this.pv -= degats;
    }

    // ############################################
    // GETTER
    // ############################################

    /**
     * @return position x du personnage
     */
    public int getX() {
        // getter
        return this.x;
    }

    /**
     * @return position y du personnage
     */
    public int getY() {
        //getter
        return this.y;
    }

    /**
     * @return pv du personnage
     */
    public int getPv() {
        return this.pv;
    }

    public Image getAffichage() {
        return affichage;
    }

    public void changerDirection(String direction) {
        switch (direction){
            case Labyrinthe.HAUT:
                this.affichage = ImgPerso.get(0);
                break;
            case Labyrinthe.DROITE:
                this.affichage = ImgPerso.get(1);
                break;
            case Labyrinthe.BAS:
                this.affichage = ImgPerso.get(2);
                break;
            case Labyrinthe.GAUCHE:
                this.affichage = ImgPerso.get(3);
        }
    }

    //recuperation d'images
    public void creerComposantGraphiques(){
        this.ImgPerso.add(new Image("/gameLaby/ressources/images/perso/Haut.png"));
        this.ImgPerso.add(new Image("/gameLaby/ressources/images/perso/Droite.png"));
        this.ImgPerso.add(new Image("/gameLaby/ressources/images/perso/Bas.png"));
        this.ImgPerso.add(new Image("/gameLaby/ressources/images/perso/Gauche.png"));
        this.affichage=this.ImgPerso.get(2);
    }


}
