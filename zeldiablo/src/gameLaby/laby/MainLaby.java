package gameLaby.laby;

import moteurJeu.MoteurJeu;

import java.io.IOException;

public class MainLaby
{
    public static void main(String[] args) throws IOException {
        int width = 800;
        int height = 600;
<<<<<<< HEAD
        int fps = 10;
=======
        int fps = 5;
>>>>>>> 3bbd6983ed67f1cc6e6e226447dc084f519508f4

        //création du jeu et du dessin:
        LabyDessin ld = new LabyDessin();
        LabyJeu lj = new LabyJeu();

        //set du moteur jeu :
        MoteurJeu.setTaille(lj.getTailleWidth()*LabyDessin.taille,lj.getTailleHeight()*LabyDessin.taille);
        MoteurJeu.setFPS(fps);

        //lancement du jeu:
        MoteurJeu.launch(lj,ld);
    }
}
