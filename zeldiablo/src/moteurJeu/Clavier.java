package moteurJeu;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

public class Clavier {
    /**
    * touches du clavier
     */
    private KeyCode toucheHaut, toucheBas, toucheGauche, toucheDroite;

    /**
     * controle appuyes
     */
    public boolean haut, bas, gauche, droite;
    /**
     * stocke les commandes
     *
     * @param event evenement clavier
     */
    public void appuyerTouche(KeyEvent event) {

        switch (event.getCode()) {

            // si touche bas
            case S:
                this.bas = true;
                break;

            // si touche haut
            case Z:
                this.haut = true;
                break;

            // si touche gauche
            case Q:
                this.gauche = true;
                break;

            // si touche droite
            case D:
                this.droite = true;
                break;

        }

    }

    /**
     * stocke les commandes
     *
     * @param event evenement clavier
     */
    public void relacherTouche(KeyEvent event) {

        switch (event.getCode()) {

            // si touche bas
            case S:
                this.bas = false;
                break;

            // si touche haut
            case Z:
                this.haut = false;
                break;

            // si touche gauche
            case Q:
                this.gauche = false;
                break;

            // si touche droite
            case D:
                this.droite = false;
                break;

        }
    }

    /**
     * configure les touches qui controlent le personnage
     */
    /*public void configurerTouches(){
        try {
            FileInputStream fichier = new FileInputStream("confi");
            BufferedReader br = new BufferedReader();
        }

    }*/
}
