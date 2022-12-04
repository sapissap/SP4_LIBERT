/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SP4_console_LIBERT;

import java.util.Scanner;

/**
 *
 * @author pauline
 */
public class SuperPuissance4_LIBERT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Créer un objet permettant de lire les saisie dans la console
        Scanner sc = new Scanner(System.in);
        //Recueuille le pseudo du premier joueur
        System.out.println("Veuillez saisir le nom du joueur 1 :");
        Joueur J1 = new Joueur(sc.nextLine());
        //Recueuille le pseudo du second joueur
        System.out.println("Veuillez saisir le nom du joueur 2 :");
        Joueur J2 = new Joueur(sc.nextLine());
        //Créer un nouvel objet partie
        Partie SPQ = new Partie(J1,J2);
        //Initilise la partie
        SPQ.initialiserPartie();
        //Lancement de la partie
        SPQ.lancerPartie();
    }
    
}
