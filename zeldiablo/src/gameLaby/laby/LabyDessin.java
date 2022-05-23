package gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import static gameLaby.laby.Labyrinthe.*;

public class LabyDessin implements DessinJeu {

    private LabyJeu lab;

    char getChar(int x, int y) {
        char res=VIDE;
        if ((x == lab.getPerso().getX()) && (y == lab.getPerso().getY())) res=PJ;
        if (lab.getLaby().getMur(x,y)) res=MUR;
        return res;
    }

    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        //recuperation des donnees
        lab = (LabyJeu) jeu;
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //preparation des donnees
        int taille=30;

        //effacer l ancien
        gc.clearRect(0,0,lab.getLaby().getLength()*taille,lab.getLaby().getLengthY()*taille);

        //dessin
        for (int i=0;i<lab.getLaby().murs.length;i++){ //colonnes
            for (int j=0;j<lab.getLaby().murs[i].length;j++){ //lignes
                switch (getChar(i,j)){
                    case PJ:
                        gc.setFill(Color.WHITE);
                        gc.fillRect(i*taille,j*taille,taille,taille);
                        gc.setFill(Color.RED);
                        gc.fillOval(i*taille,j*taille,taille,taille);
                        break;
                    case VIDE:
                        gc.setFill(Color.WHITE);
                        gc.fillRect(i*taille,j*taille,taille,taille);
                        break;
                    case MUR:
                        gc.setFill(Color.BLACK);
                        gc.fillRect(i*taille,j*taille,taille,taille);
                        break;
                }
            }
        }
    }
}
