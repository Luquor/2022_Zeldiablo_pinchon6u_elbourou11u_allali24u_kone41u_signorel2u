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
        Clavier clavier = new Clavier("../config/configTouches.txt");

        //assertions
        assertEquals(KeyCode.getKeyCode("h"), clavier.getToucheHaut(), "La touche h doit etre la touche du haut");
        assertEquals(KeyCode.getKeyCode("b"), clavier.getToucheBas(), "La touche b doit etre la touche du bas");
        assertEquals(KeyCode.getKeyCode("g"), clavier.getToucheGauche(), "La touche g doit etre la touche de gauche");
        assertEquals(KeyCode.getKeyCode("d"), clavier.getToucheDroite(), "La touche d doit etre la touche de droite");
    }
    /**
     * Test de la methode configurerTouches quand le fichier de configuration
     * n existe pas
     */
    @Test
    public void test_configurerTouches_fichierInexistant(){
        //preparation des donnees et test de la methode
        Clavier clavier = new Clavier("C:\\Users\\Gon\\2022_Zeldiablo_pinchon6u_elbourou11u_allali24u_kone41u_signorel2u\\zeldiablo\\config");

        //assertions
        assertEquals(KeyCode.getKeyCode("z"), clavier.getToucheHaut(), "La touche z doit etre la touche du haut");
        assertEquals(KeyCode.getKeyCode("s"), clavier.getToucheBas(), "La touche s doit etre la touche du bas");
        assertEquals(KeyCode.getKeyCode("q"), clavier.getToucheGauche(), "La touche q doit etre la touche de gauche");
        assertEquals(KeyCode.getKeyCode("d"), clavier.getToucheDroite(), "La touche d doit etre la touche de droite");
    }
    /**
     * Test de la methode configurerTouches quand le fichier de configuration
     * n est pas structuré correctement
     */
    @Test
    public void test_configurerTouches_fichierIncorrect(){
        //preparation des donnees et test de la methode
        Clavier clavier = new Clavier("C:\\Users\\Gon\\2022_Zeldiablo_pinchon6u_elbourou11u_allali24u_kone41u_signorel2u\\zeldiablo\\config");

        //assertions
        assertEquals(KeyCode.getKeyCode("z"), clavier.getToucheHaut(), "La touche z doit etre la touche du haut");
        assertEquals(KeyCode.getKeyCode("s"), clavier.getToucheBas(), "La touche s doit etre la touche du bas");
        assertEquals(KeyCode.getKeyCode("q"), clavier.getToucheGauche(), "La touche q doit etre la touche de gauche");
        assertEquals(KeyCode.getKeyCode("d"), clavier.getToucheDroite(), "La touche d doit etre la touche de droite");
    }


}