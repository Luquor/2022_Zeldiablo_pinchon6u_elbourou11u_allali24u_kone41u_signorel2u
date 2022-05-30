package gameLaby.laby;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.util.Duration;
import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;

public class LabyJeu implements Jeu {


    private Labyrinthe laby;
    private Perso perso;
    private Position pAncien = new Position(0,0);


    public LabyJeu() throws IOException {
        this.laby = new Labyrinthe("labySimple/laby2.txt");
        this.perso = new Perso(laby.pj.x, laby.pj.y);
        System.out.println("PV : "+this.laby.pj.getPv());
    }

    public int getTailleHeight(){
        return laby.murs[0].length;
    }
    public int getTailleWidth(){
        return laby.murs.length;
    }


    @Override
    public void update(double secondes, Clavier clavier) {
        if (clavier.droite) {
            this.laby.deplacerPerso(Labyrinthe.DROITE);
            pAncien=new Position(0,0);
        } else if (clavier.gauche) {
            this.laby.deplacerPerso(Labyrinthe.GAUCHE);
            pAncien=new Position(0,0);
        } else if (clavier.haut) {
            this.laby.deplacerPerso(Labyrinthe.HAUT);
            pAncien=new Position(0,0);
        } else if (clavier.bas) {
            this.laby.deplacerPerso(Labyrinthe.BAS);
            pAncien=new Position(0,0);
        }
        //mettre a jour le personnage de this
        Position p = new Position(this.laby.pj.getX(),this.laby.pj.getY());
        for (int i=0; i<this.laby.CasePieges.size();i++) {
            if (this.laby.CasePieges.get(i).getX() == p.getX() && this.laby.CasePieges.get(i).getY() == p.getY()) {
                if (pAncien.getY() != p.getY() && pAncien.getX() != p.getX()) {
                    System.out.println("c'est un piege !!");
                    this.laby.pj.subirDegats(1);
                    System.out.println("PV : "+this.laby.pj.getPv());
                    pAncien = p;
                }
                this.laby.CasePieges.get(i).setEtatCasePieges(true);
            } else {
                this.laby.CasePieges.get(i).setEtatCasePieges(false);
            }
        }
        if (this.laby.pj.getPv()<=0) {
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.play();
            pause.setOnFinished(e -> {System.out.println("Fin, le bonhomme est mort ! ");Platform.exit();});
        }
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
