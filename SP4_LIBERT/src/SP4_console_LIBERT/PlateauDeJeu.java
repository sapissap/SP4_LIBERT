/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SP4_console_LIBERT;

/**
 *
 * @author pauline
 */
public class PlateauDeJeu {
    // Création de l'attribut de la classe

    private CelluleDeGrille[][] grille = new CelluleDeGrille[6][7];

    // Constructeur de la classe
    public PlateauDeJeu() {

        // Créer un objet CelluleDeGrille et le stocke dans un index du tableau
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                this.grille[i][j] = new CelluleDeGrille();
            }
        }
    }

    //Méthode qui ajoute le jeton joué dans la colonne indiquée
    public int ajouterJetonDansColonne(Jeton nvJeton, int colonne) {
        //Initialise le compteur de ligne
        int ligne = 0;
        //Tant que la ligne possède un jeton, incrémente le compteur
        System.out.println(this.grille[ligne][colonne].presenceJeton());
        while (this.grille[ligne][colonne].presenceJeton()) {
            ligne++;
        }
        //Apelle la méthode AffecterJeton de la classe CelluleDeGrille
        this.grille[ligne][colonne].AffecterJeton(nvJeton);
        //Renvoie l'index de la ligne où a été ajoute le jeton
        return ligne;
    }

//Méthode qui teste si toutes les cellules de la grille possède un jeton
    public boolean grilleRemplie() {
        //Initialise l'index de colonne
        int colonne = 0;
        //Parcours les colonnes et teste si la dernière ligne possède un jeton
        while (this.grille[5][colonne].presenceJeton()) {
            colonne++;
            //Si toute les colonnes ont été parcourue retourne vrai
            if (colonne == 7) {
                return true;
            }

        }
        //Si une colonne n'est pas remplie, retourne faux
        return false;
    }

//Méthode qui vide toutes les cellules du plateau
    public void Vidergrille(Joueur J1, Joueur J2) {
        //Parcours toutes les cellules du plateau
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                //Si un jeton est présent dans la cellule, le récuoère et l'ajoute à la réserve du joueur correspondant
                if (this.grille[i][j].presenceJeton()) {
                    if (this.grille[i][j].LireCouleurJeton() == J1.lireCouleur()) {
                        J1.ajouterJeton(recupererJeton(i, j));
                    } else {
                        J2.ajouterJeton(this.grille[i][j].recupererJeton());
                    }
                }
                //Si un desintegrateur est présent le supprime
                if (this.grille[i][j].presenceDesintegrateur()) {
                    this.grille[i][j].supprimerDesintegrateur();
                }
                //Si un trou noir est présent le supprime
                if (this.grille[i][j].presenceTrouNoir()) {
                    this.grille[i][j].supprimerTrouNoir();
                }
            }
        }
    }

//Méthode qui permet d'afficher sur la console le plateau
    public void afficherGrilleSurConsole() {
        System.out.println("\t0\t1\t2\t3\t4\t5\t6");
        for (int i = 5; i > -1; i--) {
            System.out.print(i+"\t");
            for (int j = 0; j < 7 ; j++) {
                if (this.grille[i][j].presenceTrouNoir()) {
                    System.out.print("T" + "\t");
                } else {
                    if (this.grille[i][j].presenceDesintegrateur()) {
                        System.out.print("D" + "\t");
                    } else {
                        if(this.grille[i][j].presenceJeton()){
                            if (this.grille[i][j].LireCouleurJeton() == "rouge"){
                                System.out.print("R" + "\t");
                            }
                            else{
                                System.out.print("J"+"\t");
                            }
                        }
                        else{
                            System.out.print("V"+"\t");
                        }
                        
                    }
                }
            }
            System.out.print("\n");
        }
    }

//Méthode qui retourne le résultat de la méthode presenceJeton de la classe CelluleDeGrille
    public boolean presenceJeton(int x, int y) {
        return this.grille[x][y].presenceJeton();
    }

//Méthode qui retourne le résultat de la méthode LireCouleurJeton de la classe CelluleDeGrille
    public String lireCouleurJeton(int x, int y) {
        return this.grille[x][y].LireCouleurJeton();
    }

//Méthode qui teste si le joueur a aligné 4 jetons en ligne 
    public boolean etreGagnanteLignePourCouleur(String Couleur) {
        //Déclaration de variables
        int Colonne, cmpt;
        //Parcours les lignes du plateau
        for (int Ligne = 0; Ligne < 6; Ligne++) {
            //Teste si la colonne centrale possède un jeton de bonne couleur
            if (lireCouleurJeton(Ligne, 3) == Couleur) {
                //Initialise les variables
                Colonne = 2;
                cmpt = 1;
                //Tant que la cellule suivante possède un jeton de la bonne couleur, incrémente le compteur et passe à la colonne suivante
                while (lireCouleurJeton(Ligne, Colonne) == Couleur) {
                    cmpt++;
                    Colonne--;
                    //Si le compteur a atteit la valeur de alors le joueur a gagné 
                    if (cmpt == 4) {
                        return true;
                    }
                }
                //Réinitialise l'index de colonne pour parcourir l'autre moité du plateau
                Colonne = 4;
                while (lireCouleurJeton(Ligne, Colonne) == Couleur) {
                    cmpt++;
                    Colonne++;
                    //Si le compteur a atteit la valeur de alors le joueur a gagné 
                    if (cmpt == 4) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

//Méthode qui teste si le joueur a aligné 4 jetons en colonne 
    public boolean GagnanteColonnePourCouleur(String Couleur) {
        //Déclaration de variables
        int Ligne, cmpt;
        //Parcours les colonnes du plateau
        for (int Colonne = 0; Colonne < 7; Colonne++) {
            //Teste si la quatrième ligne possède un jeton de bonne couleur
            if (lireCouleurJeton(3, Colonne) == Couleur) {
                //Initialise les variables
                Ligne = 2;
                cmpt = 1;
                //Tant que la cellule suivante possède un jeton de la bonne couleur, incrémente le compteur et passe à la ligne suivante
                while (lireCouleurJeton(Ligne, Colonne) == Couleur) {
                    cmpt++;
                    Ligne--;
                    //Si le compteur a atteit la valeur de alors le joueur a gagné 
                    if (cmpt == 4) {
                        return true;
                    }
                }
                //Réinitialise l'index de ligne pour parcourir l'autre moité du plateau
                Ligne = 4;
                while (Ligne < 6 && lireCouleurJeton(Ligne, Colonne) == Couleur) {
                    cmpt++;
                    Ligne++;
                    //Si le compteur a atteit la valeur de alors le joueur a gagné 
                    if (cmpt == 4) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    //Méthode qui teste si le joueur a aligné 4 jetons en diagonale 
    public boolean GagnanteDiagonalePositivePourCouleur(String Couleur) {
        //Déclaration de variables
        int cmpt, i;
        //Parcours les colonnes du plateau
        for (int Colonne = 0; Colonne < 7; Colonne++) {
            //Teste si la quatrième ligne possède un jeton de bonne couleur
            if (lireCouleurJeton(3, Colonne) == Couleur) {
                //Initialise les variables
                cmpt = 1;
                i = 1;
                //Tant que la cellule suivante possède un jeton de la bonne couleur, incrémente les compteurs et parcours la diagonale
                while (Colonne - i > 0 && i < 4 && lireCouleurJeton(3 - i, Colonne - i) == Couleur) {
                    cmpt++;
                    i++;
                    //Si le compteur a atteit la valeur de alors le joueur a gagné 
                    if (cmpt == 4) {
                        return true;
                    }
                }
                //Réinitialise l'index pour parcourir l'autre moité du plateau
                i = 1;
                while (Colonne + i < 6 && i < 3 && lireCouleurJeton(3 + i, Colonne + i) == Couleur) {
                    cmpt++;
                    i++;
                    //Si le compteur a atteit la valeur de alors le joueur a gagné 
                    if (cmpt == 4) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

//Méthode qui teste si le joueur a aligné 4 jetons en diagonale 
    public boolean GagnanteDiagonaleNegativePourCouleur(String Couleur) {
        //Déclaration de variables
        int cmpt, i;
        //Parcours les colonnes du plateau
        for (int Colonne = 0; Colonne < 7; Colonne++) {
            //Teste si la quatrième ligne possède un jeton de bonne couleur
            if (lireCouleurJeton(3, Colonne) == Couleur) {
                //Initialise les variables
                cmpt = 1;
                i = 1;
                //Tant que la cellule suivante possède un jeton de la bonne couleur, incrémente les compteurs et parcours la diagonale
                while (Colonne - i > 0 && i < 3 && lireCouleurJeton(3 + i, Colonne - i) == Couleur) {
                    cmpt++;
                    i++;
                    //Si le compteur a atteit la valeur de alors le joueur a gagné 
                    if (cmpt == 4) {
                        return true;
                    }
                }
                //Réinitialise l'index pour parcourir l'autre moité du plateau
                i = 1;
                while (Colonne + i < 6 && i < 4 && lireCouleurJeton(3 - i, Colonne + i) == Couleur) {
                    cmpt++;
                    i++;
                    //Si le compteur a atteit la valeur de alors le joueur a gagné 
                    if (cmpt == 4) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    //Méthode qui retourne le résultat du test des quatres méthodes de condition de victoire
    public boolean GagnantJoueurCouleur(String Couleur) {
        return (GagnanteDiagonaleNegativePourCouleur(Couleur) || GagnanteDiagonalePositivePourCouleur(Couleur) || GagnanteColonnePourCouleur(Couleur) || etreGagnanteLignePourCouleur(Couleur));
    }

    //Méthode qui permet faire dessendre les jetons à la cellule d'en dessous si celle-ci est vide
    public void tasserColonne(int Colonne) {
        //Déclare l'index de ligne
        int Ligne;
        //Parcours toutes les lignes de la colonne sauf la dernière
        for (Ligne = 0; Ligne < 5; Ligne++) {
            //Si la cellule n'a pas de jeton récupère je jeton de la ligne supérieur et l'insère dans cette ligne
            if (!presenceJeton(Ligne, Colonne)) {
                this.grille[Ligne][Colonne].AffecterJeton(this.grille[Ligne + 1][Colonne].recupererJeton());
            }
        }
    }

    //Méthode qui teste si la colonne est pleine
    public boolean colonneRemplie(int Colonne) {
        return this.grille[5][Colonne].presenceJeton();
    }

    //Méthode qui appelle la métode presenceTrouNoir de la classe CelluleDeGrille
    public boolean presenceTrouNoir(int Ligne, int Colonne) {
        return this.grille[Ligne][Colonne].presenceTrouNoir();
    }

    //Méthode qui appelle la métode placerTrouNoir de la classe CelluleDeGrille
    public void placerTrouNoir(int Ligne, int Colonne) {
        this.grille[Ligne][Colonne].placerTrouNoir();
    }

    //Méthode qui appelle la métode supprimerTrouNoir de la classe CelluleDeGrille
    public void supprimerTrouNoir(int Ligne, int Colonne) {
        this.grille[Ligne][Colonne].supprimerTrouNoir();
    }

    //Méthode qui appelle la métode placerDesintegrateur de la classe CelluleDeGrille
    public void placerDesintegrateur(int Ligne, int Colonne) {
        this.grille[Ligne][Colonne].placerDesintegrateur();
    }

    //Méthode qui appelle la métode supprimerDesintegrateur de la classe CelluleDeGrille
    public void supprimerDesintegrateur(int Ligne, int Colonne) {
        this.grille[Ligne][Colonne].supprimerDesintegrateur();
    }

    //Méthode qui appelle la métode presenceDesintegrateur de la classe CelluleDeGrille
    public boolean presenceDesintegrateur(int Ligne, int Colonne) {
        return this.grille[Ligne][Colonne].presenceDesintegrateur();
    }

    //Méthode qui appelle la métode supprimerJeton de la classe CelluleDeGrille
    public void supprimerJeton(int Ligne, int Colonne) {
        this.grille[Ligne][Colonne].supprimerJeton();
    }

    //Méthode qui appelle la métode recupererJeton de la classe CelluleDeGrille
    public Jeton recupererJeton(int Ligne, int Colonne) {
        return this.grille[Ligne][Colonne].recupererJeton();
    }
}
