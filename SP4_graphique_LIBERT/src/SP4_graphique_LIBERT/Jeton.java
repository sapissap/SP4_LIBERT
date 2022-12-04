/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SP4_graphique_LIBERT;

/**
 *
 * @author pauline
 */
public class Jeton {

    // Création de l'attribut de la classe
    private String couleur;

    // Constructeur de la classe
    public Jeton(String couleur) {

        this.couleur = couleur;
    }

    // Méthode qui retourne la couleur du jeton
    public String getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        if (couleur == "jaune") {
            return ("J");
        } else {
            return ("R");
        }

    }

}

