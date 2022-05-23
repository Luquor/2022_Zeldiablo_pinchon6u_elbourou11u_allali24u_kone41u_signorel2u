package gameLaby.laby;

import moteurJeu.MoteurJeu;

import java.io.IOException;

public class MainLaby
{
    public static void main(String[] args) throws IOException {
        int width = 800;
        int height = 600;
        int fps = 30;

        //création du jeu et du dessin:
        LabyDessin ld = new LabyDessin();
        LabyJeu lj = new LabyJeu();

        //set du moteur jeu :
        MoteurJeu.setTaille(width,height);
        MoteurJeu.setFPS(fps);

        //lancement du jeu:
        MoteurJeu.launch(lj,ld);
    }
}
