/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SP4_console_LIBERT;
import java.lang.Math;
import java.util.Scanner;
/**
 *
 * @author pauline
 */
public class Partie {
    // Création des attributs de la classe
    private Joueur listeJoueurs[] = new Joueur[2];
    private Joueur JoueurCourant ;
    private PlateauDeJeu Plateau= new PlateauDeJeu(); 
    
            //Initialisation de l'attribut listeJoueurs
    public Partie(Joueur J1,Joueur J2){
        listeJoueurs[0]=J1;
        listeJoueurs[1]=J2;
        
    }
    
    // Methode qui attribue une couleur au hasard aux joueurs
    public void attribuerCouleurAuxJoueurs()
    {
        //Attribue la couleur rouge à un joueur en tirant un nombre au hasard entre 0 et 2 exlu en retirant la partie décimal
        listeJoueurs[(int)(Math.random())*2].affecterCouleur("rouge");
        //Teste si le joueur 1 n'a toujours pas de couleur et attribue la couleur jaune au joueur qui n'en a pas
        if (listeJoueurs[0].lireCouleur()==""){
            listeJoueurs[0].affecterCouleur("jaune");
        }
        else{
            listeJoueurs[1].affecterCouleur("jaune");
        }
    }
    
            //Methode qui permet de créer les 30 jetons neccessaire de la couleur du joueur en paramètre
    public void creerEtAffecterJeton(Joueur J){
        for (int i=0; i<30;i++)
        {
            //Créer un jeton de la couleur du joueur
            Jeton nvJeton = new Jeton(J.lireCouleur());
            //Appelle la méthode ajouterJeton de la classe Joueur
            J.ajouterJeton(nvJeton);
        }
    }
    
            // Methode qui permet de placer au hasard les trous noir et desintegrateurs 
    public void placerTrouNoirsEtDeseintegrateurs(){
        // Déclaration des variables
        int i,x,y;
        //Mise en place des 3 trous noirs et désintegrateurs
        for (i=0;i<3;i++){
            do{
                //Tirage au hasard des coordonnées d'une cellule du plateau
                x=(int)(Math.random()*6);
                y=(int)(Math.random()*7);
            }while(this.Plateau.presenceTrouNoir(x, y));//Répète le tirage au sort tant qu'un trou noir est déjà présent
            //Place le desintegrateur et le trou noir
            this.Plateau.placerDesintegrateur(x, y);
            this.Plateau.placerTrouNoir(x, y);
        }
        //Mise en place des 2 derniers trous noirs 
        for (i=0;i<2;i++){
            do{
                //Tirage au hasard des coordonnées d'une cellule du plateau
                x=(int)(Math.random()*6); 
                y=(int)(Math.random()*7);
            }while(this.Plateau.presenceTrouNoir(x, y));//Répète le tirage au sort tant qu'un trou noir est déjà présent
            // place le trou noir
            this.Plateau.placerTrouNoir(x, y);
        }
        //Mise en place des 2 derniers desintegrateurs
        for (i=0;i<2;i++){
            do{
                                //Tirage au hasard des coordonnées d'une cellule du plateau
                x=(int)(Math.random()*6);
                y=(int)(Math.random()*7); 
            }while(this.Plateau.presenceTrouNoir(x, y) || this.Plateau.presenceDesintegrateur(x, y));//Répète le tirage au sort tant qu'un trou noir ou un desintegrateur est déjà présent
            //place le desintegrateur
            this.Plateau.placerDesintegrateur(x, y);
        }
    }
    
    //Appelle les méthodes afin d'initialiser la partie
    public void initialiserPartie(){ 
        attribuerCouleurAuxJoueurs();// Attribution des couleurs aux joueurs
        creerEtAffecterJeton(this.listeJoueurs[0]);// Creation des jetosn necessaire pour le joueur 1
        creerEtAffecterJeton(this.listeJoueurs[1]);// Creation des jetosn necessaire pour le joueur 2
        placerTrouNoirsEtDeseintegrateurs();// Mise en place des trous noir et desintegrateur    
    }
    
    //Méthode exécutant le tour d'un joueur
    public void lancerPartie(){
        //Déclaration des variables
        int action,colonne,ligne;
        boolean ok=false, nok;
        Scanner sc = new Scanner(System.in);
        //Recherche la joueur ayant les jetons rouge et le fait commencer la partie
        if (listeJoueurs[0].lireCouleur()=="rouge")
        {
            JoueurCourant=listeJoueurs[0];
        }
        else{
            JoueurCourant=listeJoueurs[1];
        }
        do{
            // Affichage du plateau de jeu en début de tour
            this.Plateau.afficherGrilleSurConsole();
            System.out.println("\n\nTour de joueur " + this.JoueurCourant.lireCouleur() + "\nVeuillez saisir votre coup dans la liste suivante :\n1 : Placer un jeton\n2 : Recuperer un jeton\n3 : Desintegrer un jeton adverse");
            do{
                //Initialise la variable
                nok=false;
                // Attends la saisie d'un entier dans la console et stocke sa valeur dans la variable 'action'
                action=sc.nextInt(); 
                switch(action){
                    //Si le joeuur veut ajouter un jeton
                    case 1 :
                        System.out.println("Veuillez choisir la colonne dans laquelle inserer votre jeton\n");
                        do{
                            // Attends la saisie d'un entier dans la console et stocke sa valeur dans la variable 'colonne'
                        colonne = sc.nextInt();
                        //Vérification que le nombre saisie est bien compatible
                        if (colonne<0 || colonne >6 || this.Plateau.colonneRemplie(colonne)){
                            System.out.println("Le numero de colonne choisi n'est pas compatible avec la grille en cours veuillez saisir un nouveau numero");
                        }
                        else{
                            //Ajoute le jeton dans la colonne indquée
                            ligne=this.Plateau.ajouterJetonDansColonne(this.JoueurCourant.jouerJeton(), colonne);
                            //Teste si un tou noir est présent à l'arrivée du jeton et agit en conséquence
                            if (this.Plateau.presenceTrouNoir(ligne, colonne)){
                                this.Plateau.supprimerJeton(ligne, colonne);
                                this.Plateau.supprimerTrouNoir(ligne, colonne);
                            } 
                            //Teste si un désintégrateur est présent à l'arrivée du jeton et agit en conséquence
                            if (this.Plateau.presenceDesintegrateur(ligne, colonne)){
                                this.Plateau.supprimerDesintegrateur(ligne, colonne);
                                JoueurCourant.obtenirDesintegrateur();
                            }
                            //Inidque qu'un coup valide a été joué
                            ok = true;
                        }
                        }while(!ok);//Boucle tant qu'aucun coup valide n'a été joué
                        break;
                    //Si le joueur veut retirer un de ses jetons
                    case 2 :
                        do{
                            //Recueuille les coordonées du jeton
                            System.out.println("Veuillez saisir le numero de ligne du jeton à retirer");
                            ligne=sc.nextInt();
                            System.out.println("Veuillez saisir le numero de colonne du jeton à retirer");
                            colonne=sc.nextInt();
                            //Vérification que les coordonnées saisies soient compatible
                            if (ligne<0 || ligne>5 || colonne<0 ||colonne>6){
                                System.out.println("Le numero de ligne ou de colonne saisie est incorrect veuillez recommencer votre saisie");
                            }
                            else{
                                //Teste si la cellule ne contient pas un mauvais élément
                                if (!this.Plateau.presenceJeton(ligne, colonne) || this.Plateau.lireCouleurJeton(ligne, colonne)!=this.JoueurCourant.lireCouleur()){
                                    System.out.println("La cellule selectionnee ne contient pas de jeton ou contient un jeton de l'autre joueur. Veuillez recommencer votre saisie.");
                                }
                                else{
                                    //Rend le jeton au joueur et fait tomber les potentiels jetons au dessus de celui récupérer
                                    this.JoueurCourant.ajouterJeton(this.Plateau.recupererJeton(ligne, colonne));
                                    this.Plateau.tasserColonne(colonne);
                                    //Inidque qu'un coup valide a été joué
                                    ok=true;
                                }
                            }
                        }while(!ok);//Boucle tant qu'aucun coup valide n'a été joué
                        break;
                    //Si le joueur veut utiliser un desintégrateur
                    case 3 :
                        //Teste si le joueur a un desintegrateur dans sa réserve
                        if (this.JoueurCourant.nombreDesintegrateurs()==0){
                            System.out.println("Vous n'avez pas de Desintegrateur en votre possession. Veuillez choisir une autre action.");
                            //Passe la variable nok à true pour indquer que ce coup est impossible et laisse la possibilité au joueur de faire uhn nouveau choix d'action
                            nok=true;
                        }
                        else{
                            do{
                                                            //Recueuille les coordonées du jeton
                                System.out.println("Veuillez saisir le numero de ligne du jeton à desintegrer");
                                ligne=sc.nextInt();
                                System.out.println("Veuillez saisir le numero de colonne du jeton à desintegrer");
                                colonne=sc.nextInt();
                                                            //Vérification que les coordonnées saisies soient compatible
                                if (ligne<0 || ligne>5 || colonne<0 ||colonne>6){
                                    System.out.println("Le numéro de ligne ou de colonne saisie est incorrect veuillez recommencer votre saisie");
                                }
                                else{
                                    //Teste si la cellule ne contient pas un mauvais élément
                                    if (!this.Plateau.presenceJeton(ligne, colonne) || this.Plateau.lireCouleurJeton(ligne, colonne)==this.JoueurCourant.lireCouleur()){
                                        System.out.println("La cellule selectionnée ne contient pas de jeton ou contient un jeton de votre couleur. Veuillez recommencer votre saisie.");
                                    }
                                    else{
                                        //Detruit le jeton et retire un désintégrateur au joueur
                                        this.Plateau.supprimerJeton(ligne, colonne);
                                        this.Plateau.tasserColonne(colonne);
                                        //Inidque qu'un coup valide a été joué
                                        ok=true;
                                    }
                                }
                            }while(!ok);//Boucle tant qu'aucun coup valide n'a été joué
                        }
                        break;
                    default :
                        System.out.println("Le numéro d'action choisi est incorrect. Veuillez saisir un nouveau numéro");
                }
            }while(!ok && nok);//Boucle tant qu'aucun coup valide n'a été joué
            if (JoueurCourant==listeJoueurs[0]){
                JoueurCourant=listeJoueurs[1];                    
            }
            else{
                JoueurCourant=listeJoueurs[0];
            }
            //Réinitilise la variable
            ok=false;
        }while(!this.Plateau.GagnantJoueurCouleur("rouge") || !this.Plateau.GagnantJoueurCouleur("jaune"));//Boucle tant qu'aucun gagnant n'a été trouvé
        
        //Enregistre dans des variables le résultat de la partie
        boolean J1win = Plateau.GagnantJoueurCouleur(listeJoueurs[0].lireCouleur());
        boolean J2win = Plateau.GagnantJoueurCouleur(listeJoueurs[1].lireCouleur());
        
        //Teste si un seul joueur est donné gagnant
        if (J1win && !J2win) {
            System.out.println("Victoire de " + listeJoueurs[0].getNom());
        }
        if (!J1win && J2win) {
            System.out.println("Victoire de " + listeJoueurs[1].getNom());
        }
        if (J1win && J2win) {
            //En cas de double victoire le joueur actif est le prochain à jouer, il est donc le gagnant
            if (JoueurCourant == listeJoueurs[1]) {
                System.out.println("Faute de jeu de " + listeJoueurs[0].getNom() + "\nVictoire de " + listeJoueurs[1].getNom());
            } else {
                System.out.println("Faute de jeu de " + listeJoueurs[1].getNom() + "\nVictoire de " + listeJoueurs[0].getNom());
            }
        }
    }
}
