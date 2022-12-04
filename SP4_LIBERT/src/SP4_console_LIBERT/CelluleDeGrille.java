/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SP4_console_LIBERT;

/**
 *
 * @author pauline
 */
public class CelluleDeGrille {

    // Création des attribut de la classe CelluleDeGrille
    private Jeton jetonCourant;
    private boolean avoirTrouNoir, avoirDesintegrateur;

    public CelluleDeGrille() {
        // Constructeur de la classe
        this.jetonCourant = null;
        this.avoirTrouNoir = false;
        this.avoirDesintegrateur = false;
    }

    //Méthode permettant de savoir la présence d'un jeton dans la case donnée
    public boolean presenceJeton() {
        return (this.jetonCourant != null);
    }

    // Methode permettant d'affecter un jeton à la cellule
    public void AffecterJeton(Jeton jetonCourant) {
        this.jetonCourant = jetonCourant;
    }

    // Méthode qui retourne la couleur du jeton. Elle retourne vide si il n'y a pas de jeton.
    public String LireCouleurJeton() {
        if (this.jetonCourant != null) {
            return this.jetonCourant.getCouleur();
        }
        return ("vide");
    }

    // Méthode qui permet de placer un trou noir dans la cellule
    public void placerTrouNoir() {
        this.avoirTrouNoir = true;
    }

    // Méthode qui permet de supprimer un trou noir dans la cellule
    public void supprimerTrouNoir() {
        this.avoirTrouNoir = false;
    }

    // Méthode qui permet de savoir si il y a un trou noir dans la cellule
    public boolean presenceTrouNoir() {
        return this.avoirTrouNoir;
    }

    //Methode qui permet de retirer le jeton dans la cellule et le retourne
    public Jeton recupererJeton() {
        Jeton tempo = this.jetonCourant;
        this.jetonCourant = null;
        return tempo;
    }

    // Méthode qui permet de supprimer le jeton dans la cellule
    public void supprimerJeton() {
        this.jetonCourant = null;
    }

    // Méthode qui permet de savoir si il y a un desintegrateur dans la cellule
    public boolean presenceDesintegrateur() {
        return this.avoirDesintegrateur;
    }

    // Méthode qui permet de supprimer le desintegrateur dans la cellule
    public void supprimerDesintegrateur() {
        this.avoirDesintegrateur = false;
    }

    // Méthode qui permet de placer un desintegrateur dans la cellule
    public void placerDesintegrateur() {
        this.avoirDesintegrateur = true;
    }

    // Méthode qui permet de supprimer le jeton et le trou noir dans la cellule
    public void activerTrouNoir() {
        supprimerJeton();
        supprimerTrouNoir();

    }
}
