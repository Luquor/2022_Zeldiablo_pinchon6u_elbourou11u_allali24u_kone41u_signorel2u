package moteurJeu;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.*;

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
     * Constructeur
     */
    public Clavier(String nomFichier) {
        this.configurerTouches(nomFichier);
    }


    /**
     * stocke les commandes
     *
     * @param event evenement clavier
     */
    public void appuyerTouche(KeyEvent event) {
        // si touche bas
        if (event.getCode().equals(this.toucheBas)){
            this.bas = true;
        }

        // si touche haut
        if (event.getCode().equals(this.toucheHaut)){
            this.haut = true;
        }

        // si touche gauche
        if(event.getCode().equals(this.toucheGauche)){
            this.gauche = true;
        }

        // si touche droite
        if(event.getCode().equals(this.toucheDroite)){
            this.droite = true;
        }

    }

    /**
     * stocke les commandes
     *
     * @param event evenement clavier
     */
    public void relacherTouche(KeyEvent event) {
        // si touche bas
        if (event.getCode().equals(this.toucheBas)){
            this.bas = false;
        }

        // si touche haut
        if (event.getCode().equals(this.toucheHaut)){
            this.haut = false;
        }

        // si touche gauche
        if(event.getCode().equals(this.toucheGauche)){
            this.gauche = false;
        }

        // si touche droite
        if(event.getCode().equals(this.toucheDroite)){
            this.droite = false;
        }
    }



    /**
     * configure les touches qui controlent le personnage
     */
    public void configurerTouches(String nomFichier) {
        try {
            FileInputStream fichier = new FileInputStream(nomFichier);
            BufferedReader br = new BufferedReader(new InputStreamReader(fichier));
            this.toucheHaut = KeyCode.valueOf(br.readLine());
            this.toucheBas = KeyCode.valueOf(br.readLine());
            this.toucheGauche = KeyCode.valueOf(br.readLine());
            this.toucheDroite = KeyCode.valueOf(br.readLine());
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichier de configuration introuvable");
            this.toucheHaut = KeyCode.Z;
            this.toucheBas = KeyCode.S;
            this.toucheGauche = KeyCode.Q;
            this.toucheDroite = KeyCode.D;
        } catch (IllegalArgumentException e) {
            System.out.println("Fichier de configuration incorrect");
            this.toucheHaut = KeyCode.Z;
            this.toucheBas = KeyCode.S;
            this.toucheGauche = KeyCode.Q;
            this.toucheDroite = KeyCode.D;
        } catch (NullPointerException e) {
            System.out.println("Certains parametres du fichier de configuration sont manquants");
            this.toucheHaut = KeyCode.Z;
            this.toucheBas = KeyCode.S;
            this.toucheGauche = KeyCode.Q;
            this.toucheDroite = KeyCode.D;
        } catch (IOException e) {
            e.printStackTrace();
            this.toucheHaut = KeyCode.Z;
            this.toucheBas = KeyCode.S;
            this.toucheGauche = KeyCode.Q;
            this.toucheDroite = KeyCode.D;
        }
    }

}
