package gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static gameLaby.laby.Labyrinthe.*;

public class LabyDessin implements DessinJeu {

    private LabyJeu lab;
    public static int taille=30;
    
    //Création d'une liste d'image
    private ArrayList<Image> lImages; // murs,floor,trap,button,buttonPressed,doorClosed,doorOpen
    private int lancement;

    public LabyDessin() {
        lImages = new ArrayList<Image>();
    }

    char getChar(int x, int y) {
        char res=VIDE;
        if ((x == lab.getPerso().getX()) && (y == lab.getPerso().getY())) res=PJ;
        else if (x==this.lab.getLaby().getActivation().getX() && y==this.lab.getLaby().getActivation().getY()) res =ACTIVATION;
        else if (x==this.lab.getLaby().getActivation().getPassageX() && y==this.lab.getLaby().getActivation().getPassageY()) res=PASSAGE_SECRET;
        else if (lab.getLaby().getMur(x,y)) res=MUR;
        return res;
    }

    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        //recuperation des donnees
        lab = (LabyJeu) jeu;
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //effacer l ancien
        gc.clearRect(0,0,lab.getLaby().getLength()*taille,lab.getTailleHeight()*taille);

        if (lancement<1){
            lImages.add(new Image("/gameLaby/ressources/images/wall.png"));
            lImages.add(new Image("/gameLaby/ressources/images/floor.png"));
            lImages.add(new Image("/gameLaby/ressources/images/trap.png"));
            lImages.add(new Image("/gameLaby/ressources/images/hearth.png"));
            lImages.add(new Image("/gameLaby/ressources/images/button.png"));
            lImages.add(new Image("/gameLaby/ressources/images/buttonPressed.png"));
            lImages.add(new Image("/gameLaby/ressources/images/doorClosed.png"));
            lImages.add(new Image("/gameLaby/ressources/images/doorOpen.png"));

            this.lab.getPerso().creerComposantGraphiques();
            lancement++;
        }

        //dessin
        for (int i=0;i<lab.getLaby().murs.length;i++){ //colonnes
            for (int j=0;j<lab.getLaby().murs[i].length;j++){ //lignes
                switch (getChar(i,j)){
                    case PJ:
                        boolean b=false;
                        Image img;
                        for (int k = 0; k < this.lab.getLaby().CasePieges.size(); k++) {
                            b = b || this.lab.getLaby().CasePieges.get(k).estDecouverte() ;
                        }
                        if (b) {
                            img =lImages.get(2);
                        } else
                            img=lImages.get(1);
                        gc.drawImage(img,i*taille,j*taille,taille,taille);
                        gc.drawImage(this.lab.getLaby().pj.getAffichage(),i*taille,j*taille,taille,taille);
                        break;
                    case VIDE:
                        gc.drawImage(lImages.get(1),i*taille,j*taille,taille,taille);
                        break;
                    case PASSAGE_SECRET:
                        int k;
                        if (this.lab.getLaby().getActivation().getEtat()) k=7;
                        else k=6;
                        gc.drawImage(lImages.get(1),i*taille,j*taille,taille,taille);
                        gc.drawImage(lImages.get(k),i*taille,j*taille,taille,taille);
                        break;
                    case ACTIVATION:
                        int l;
                        if (this.lab.getLaby().getActivation().getEtat()) l=5;
                        else l=4;
                        gc.drawImage(lImages.get(1),i*taille,j*taille,taille,taille);
                        gc.drawImage(lImages.get(l),i*taille,j*taille,taille,taille);
                        break;
                    case MUR:
                        gc.drawImage(lImages.get(0),i*taille,j*taille,taille,taille);
                        break;
                }
            }
        }
        afficherVie(gc,this.lab.getPerso());
    }

    private void afficherVie(GraphicsContext gc, Perso perso) {
        for (int i = 0; i < perso.getPv(); i++) {
            gc.drawImage(lImages.get(3),i*taille+i*5,this.lab.getLaby().getLengthY()*taille,taille,taille);
        }
    }


}
