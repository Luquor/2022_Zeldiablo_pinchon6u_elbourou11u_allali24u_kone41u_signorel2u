package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;

public class LabyJeu implements Jeu {


    private Labyrinthe laby;
    private Perso perso;


    public LabyJeu() throws IOException {
        this.laby = new Labyrinthe("labySimple/laby1.txt");
        this.perso = new Perso(laby.pj.x, laby.pj.y);
    }


    @Override
    public void update(double secondes, Clavier clavier) {
        if (clavier.droite) {
            this.laby.deplacerPerso(Labyrinthe.DROITE);

        } else if (clavier.gauche) {
            this.laby.deplacerPerso(Labyrinthe.GAUCHE);

        } else if (clavier.haut) {
            this.laby.deplacerPerso(Labyrinthe.HAUT);

        } else if (clavier.bas) {
            this.laby.deplacerPerso(Labyrinthe.BAS);

        }
        //mettre a jour le personnage de this
        this.perso=this.laby.pj;
    }

    @Override
    public void init() {
        // pas d'initialisation particuliere comme pour Akanoid
    }

    @Override
    public boolean etreFini() {
        return false;
    }

    public Labyrinthe getLaby() {
        return laby;
    }

    public Perso getPerso() {
        return perso;
    }
}
