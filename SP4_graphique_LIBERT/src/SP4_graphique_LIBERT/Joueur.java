/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SP4_graphique_LIBERT;

import java.util.ArrayList;

/**
 *
 * @author pauline
 */
public class Joueur {

    // Création des attribut de la classe
    private String nom;
    private String couleur;
    private int nombreDesintegrateurs;
    private ArrayList<Jeton> reserveJetons = new ArrayList<Jeton>();

    // Constructeur de la classe
    public Joueur(String nom) {
        this.nom = nom;
        this.couleur="";
        this.nombreDesintegrateurs = 0;
    }

//Méthode qui attribue une couleur au joueur
    public void affecterCouleur(String CoulJou) {
        this.couleur = CoulJou;
    }

    // Méthode qui retourne la couleur du joueur
    public String lireCouleur() {
        return couleur;
    }

    // Méthode qui retourne le nombre de jetons que le joueur possède
    public int nombreDeJetons() {
        return reserveJetons.size();
    }

    // Méthode qui permet d'ajouter un jeton dans la reserve du joueur
    public void ajouterJeton(Jeton Jeton) {
        this.reserveJetons.add(Jeton);
    }

    // Méthode qui permet de retirer un jeton de la reserve du joueur
    public Jeton jouerJeton() {
        return this.reserveJetons.remove(0);
    }

    // Méthode qui permet d'ajouter un desintegrateur au joueur
    public void obtenirDesintegrateur() {
        this.nombreDesintegrateurs++;
    }

    // Méthode qui permet de retirer un desintegrateur au joueur
    public void utiliserDesintegrateurs() {
        this.nombreDesintegrateurs--;
    }

    // Méthode qui permet de retourner le nombre de desintegrateur que possède le joueur
    public int nombreDesintegrateurs() {
        return this.nombreDesintegrateurs;
    }
    
    // Méthode qui permet de retourner le nom du joueur
    public String getNom() {
        return nom;
    }

}
