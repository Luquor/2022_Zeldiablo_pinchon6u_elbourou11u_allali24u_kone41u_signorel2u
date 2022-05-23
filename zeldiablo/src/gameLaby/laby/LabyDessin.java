package gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import static gameLaby.laby.Labyrinthe.*;

public class LabyDessin implements DessinJeu {

    private LabyJeu labyjeu;
    private Labyrinthe LABY;

    char getChar(int x, int y) {
        char res=VIDE;
        if ((x == labyjeu.getPj().getX()) && (y == labyjeu.getPj().getY())) res=PJ;
        if (LABY.getMur(x,y)) res=MUR;
        return res;
    }

    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {

        labyjeu = (LabyJeu) jeu;

        //recuperer un pinceau pour dessiner
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //recuperation des données
        LABY = labyjeu.getLaby();
        boolean[][] murs = LABY.murs;

        //creation d un toString du labyrinthe
        String res="";
        for(int i=0;i<murs.length;i++){
            for(int j=0;j<murs[i].length;j++){
                res+=getChar(i,j);
            }
            res+="\n";
        }

        //dessin selon le string precedent
        int h=0,v=0;
        int i = 0;
        int taille = 30;
        while(i<res.length()){
            char c = res.charAt(i);
            switch (c){
                case'X':
                    gc.setFill(Color.BLACK);
                    gc.fillRect(h,v,taille,taille);
                    h=h+taille;
                    break;
                case'.':
                    gc.setFill(Color.LIGHTGRAY);
                    gc.fillRect(h,v,taille,taille);
                    h=h+taille;
                    break;
                case'\n':
                    v=v+taille;
                    h=0;
                    break;
                case'P':
                    gc.setFill(Color.LIGHTGRAY);
                    gc.fillOval(h,v,taille,taille);
                    gc.setFill(Color.RED);
                    gc.fillOval(h,v,taille,taille);
                    h=h+taille;
                    break;
            }
            i++;
        }
    }
}
