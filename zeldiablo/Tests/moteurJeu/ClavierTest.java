package moteurJeu;

import javafx.scene.input.KeyCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClavierTest {
    /**
     * Test de la methode configurerTouches quand le fichier de configuration
     * est existant et structuré correctement
     */
    @Test
    public void test_configurerTouchesOK(){
        //preparation des donnees et test de la methode
        Clavier clavier = new Clavier("zeldiablo/config/configTouches.txt");

        //assertions
        assertEquals(KeyCode.H, clavier.getToucheHaut(), "La touche h doit etre la touche du haut");
        assertEquals(KeyCode.B, clavier.getToucheBas(), "La touche b doit etre la touche du bas");
        assertEquals(KeyCode.G, clavier.getToucheGauche(), "La touche g doit etre la touche de gauche");
        assertEquals(KeyCode.D, clavier.getToucheDroite(), "La touche d doit etre la touche de droite");
    }
    /**
     * Test de la methode configurerTouches quand le fichier de configuration
     * n existe pas
     */
    @Test
    public void test_configurerTouches_fichierInexistant(){
        //preparation des donnees et test de la methode
        Clavier clavier = new Clavier("jeNexistePas");

        //assertions
        assertEquals(KeyCode.Z, clavier.getToucheHaut(), "La touche Z doit etre la touche du haut");
        assertEquals(KeyCode.S, clavier.getToucheBas(), "La touche S doit etre la touche du bas");
        assertEquals(KeyCode.Q, clavier.getToucheGauche(), "La touche Q doit etre la touche de gauche");
        assertEquals(KeyCode.D, clavier.getToucheDroite(), "La touche D doit etre la touche de droite");
    }
    /**
     * Test de la methode configurerTouches quand le fichier de configuration
     * n est pas structuré correctement
     */
    @Test
    public void test_configurerTouches_fichierIncorrect(){
        //preparation des donnees et test de la methode
        Clavier clavier = new Clavier("zeldiablo/config/configIncorrect.txt");

        //assertions
        assertEquals(KeyCode.Z, clavier.getToucheHaut(), "La touche z doit etre la touche du haut");
        assertEquals(KeyCode.S, clavier.getToucheBas(), "La touche s doit etre la touche du bas");
        assertEquals(KeyCode.Q, clavier.getToucheGauche(), "La touche q doit etre la touche de gauche");
        assertEquals(KeyCode.D, clavier.getToucheDroite(), "La touche d doit etre la touche de droite");
    }

    /**
     * Test de la methode configurerTouches quand le fichier de configuration est incomplet
     */
    @Test
    public void test_configurerTouches_fichierIncomplet(){
        //preparation des donnees et test de la methode
        Clavier clavier = new Clavier("zeldiablo/config/configIncomplete.txt");

        //assertions
        assertEquals(KeyCode.Z, clavier.getToucheHaut(), "La touche z doit etre la touche du haut");
        assertEquals(KeyCode.S, clavier.getToucheBas(), "La touche s doit etre la touche du bas");
        assertEquals(KeyCode.Q, clavier.getToucheGauche(), "La touche q doit etre la touche de gauche");
        assertEquals(KeyCode.D, clavier.getToucheDroite(), "La touche d doit etre la touche de droite");
    }


}