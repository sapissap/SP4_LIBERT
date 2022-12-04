/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SP4_graphique_LIBERT;

/**
 *
 * @author pauline
 */
public class fenetreDeJeu extends javax.swing.JFrame {

    Joueur listeJoueurs[] = new Joueur[2];
    Joueur JoueurCourant;
    PlateauDeJeu Plateau = new PlateauDeJeu();

    /**
     * Creates new form fenetreDeJeu
     */
    public fenetreDeJeu() {
        initComponents();
        // Permet de cacher les infos joueur et info partie
        panneau_info_Joueur.setVisible(false);
        panneau_info_partie.setVisible(false);
        //Création du plateau de jeu
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                final CelluleGraphique CelluleGraph = new CelluleGraphique(Plateau.grille[i][j]);

                CelluleGraph.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        CelluleDeGrille C = CelluleGraph.CelluleAssociee;
                        if (C.presenceJeton()) {
                            // Verification de  l'appartenance du jeton dans le but de le recuperer
                            if (C.LireCouleurJeton() == JoueurCourant.lireCouleur()) {
                                InfoPartie.setText("Le joueur" + JoueurCourant.getNom() + "récupère un de ses jetons");
                                JoueurCourant.ajouterJeton(C.recupererJeton());
                            } else {
                                // Verification de la possession d'au moins un désintegrateur pour l'utiliser
                                if (JoueurCourant.nombreDesintegrateurs() > 0) {
                                    InfoPartie.setText("Le joueur" + JoueurCourant.getNom() + "désintègre un jeton adverse");
                                    C.supprimerJeton();
                                    JoueurCourant.utiliserDesintegrateurs();
                                    lbl_j1_desintegrateur1.setText(listeJoueurs[0].nombreDesintegrateurs()+"");
                                    lbl_j2_desintegrateur.setText(listeJoueurs[1].nombreDesintegrateurs()+"");                                    
                                } else {
                                    //Utilise le mot clé return pour sortir de la sctructure événement sans exécuter la fin du code
                                    return;
                                }

                            }
                        } else {
                            //Utilise le mot clé return pour sortir de la sctructure événement sans exécuter la fin du code
                            return;
                        }
                        //Balaye les colonne du plateau
                        for (int i = 0; i < 7; i++) {
                            // Tasse la colonne pour enlever les potentiels cellule vide sous un jeton 
                            Plateau.tasserColonne(i);
                            //Si la colonne n'est pas rempli active le bouton correspondant
                            if (!Plateau.colonneRemplie(i)) {
                                switch (i) {
                                    case 0:
                                        btn_col_0.setEnabled(true);
                                        break;
                                    case 1:
                                        btn_col_1.setEnabled(true);
                                        break;
                                    case 2:
                                        btn_col_2.setEnabled(true);
                                        break;
                                    case 3:
                                        btn_col_3.setEnabled(true);
                                        break;
                                    case 4:
                                        btn_col_4.setEnabled(true);
                                        break;
                                    case 5:
                                        btn_col_5.setEnabled(true);
                                        break;
                                    case 6:
                                        btn_col_6.setEnabled(true);
                                        break;

                                }
                            }
                        }
                        //Actualise le plateau de jeu 
                        panneau_grille.repaint();
                        // Initialise les variable pour savoir si un joueur à gagner
                        boolean J1win = Plateau.GagnantJoueurCouleur(listeJoueurs[0].lireCouleur());
                        boolean J2win = Plateau.GagnantJoueurCouleur(listeJoueurs[1].lireCouleur());

                        if (J1win && !J2win) {
                            InfoPartie.setText("Victoire de " + listeJoueurs[0].getNom());
                        }
                        if (!J1win && J2win) {
                            InfoPartie.setText("Victoire de " + listeJoueurs[1].getNom());
                        }
                        if (J1win && J2win) {
                            //En cas de double victoire le joueur actif est le prochain à jouer, il est donc le gagnant
                            if (JoueurCourant == listeJoueurs[0]) {
                                InfoPartie.setText("Faute de jeu de " + listeJoueurs[0].getNom() + "\nVictoire de " + listeJoueurs[1].getNom());
                            } else {
                                InfoPartie.setText("Faute de jeu de " + listeJoueurs[1].getNom() + "\nVictoire de " + listeJoueurs[0].getNom());
                            }
                        }
                        //Indication aux joueurs du prochain tours 
                        TourSuivant();
                    }
                });

                panneau_grille.add(CelluleGraph);
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panneau_grille = new javax.swing.JPanel();
        panneau_info_Joueur = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_j2_nom = new javax.swing.JLabel();
        lbl_j2_couleur = new javax.swing.JLabel();
        lbl_j2_desintegrateur = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_j1_nom1 = new javax.swing.JLabel();
        lbl_j1_couleur1 = new javax.swing.JLabel();
        lbl_j1_desintegrateur1 = new javax.swing.JLabel();
        panneau_info_partie = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_jcourant = new javax.swing.JLabel();
        InfoPartie = new java.awt.TextArea();
        panneau_creation_partie = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nom_joueur_1 = new javax.swing.JTextField();
        nom_joueur_2 = new javax.swing.JTextField();
        bebut_partie = new javax.swing.JButton();
        btn_col_0 = new javax.swing.JButton();
        btn_col_1 = new javax.swing.JButton();
        btn_col_2 = new javax.swing.JButton();
        btn_col_3 = new javax.swing.JButton();
        btn_col_4 = new javax.swing.JButton();
        btn_col_5 = new javax.swing.JButton();
        btn_col_6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panneau_grille.setBackground(new java.awt.Color(255, 255, 255));
        panneau_grille.setLayout(new java.awt.GridLayout(6, 7));
        getContentPane().add(panneau_grille, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 672, 576));
        panneau_grille.getAccessibleContext().setAccessibleDescription("");

        panneau_info_Joueur.setBackground(new java.awt.Color(204, 255, 204));
        panneau_info_Joueur.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel3.setText("Infos Joueur :");
        panneau_info_Joueur.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, -1));

        jLabel4.setText("Couleur :");
        panneau_info_Joueur.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel5.setText("désintegrateurs :");
        panneau_info_Joueur.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel6.setText("Joueur 2 :");
        panneau_info_Joueur.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        lbl_j2_nom.setText("nbJoueur1");
        panneau_info_Joueur.add(lbl_j2_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));
        lbl_j2_nom.getAccessibleContext().setAccessibleName("nbJoueur2");

        lbl_j2_couleur.setText("couleurJoueur2");
        panneau_info_Joueur.add(lbl_j2_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        lbl_j2_desintegrateur.setText("nbdesintegrateur");
        panneau_info_Joueur.add(lbl_j2_desintegrateur, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, -1));
        panneau_info_Joueur.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, -1, -1));
        panneau_info_Joueur.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 250, -1));

        jLabel7.setText("Couleur :");
        panneau_info_Joueur.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel8.setText("désintegrateurs :");
        panneau_info_Joueur.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel9.setText("Joueur 1 :");
        panneau_info_Joueur.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        lbl_j1_nom1.setText("nbJoueur1");
        panneau_info_Joueur.add(lbl_j1_nom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        lbl_j1_couleur1.setText("couleurJoueur1");
        panneau_info_Joueur.add(lbl_j1_couleur1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

        lbl_j1_desintegrateur1.setText("nbdesintegrateur");
        panneau_info_Joueur.add(lbl_j1_desintegrateur1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        getContentPane().add(panneau_info_Joueur, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 210, 250, 240));

        panneau_info_partie.setBackground(new java.awt.Color(204, 255, 204));
        panneau_info_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel10.setText("Infos Jeu :");
        panneau_info_partie.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, -1));

        jLabel11.setText("Joueur  courant  :");
        panneau_info_partie.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));

        lbl_jcourant.setText("nbJoueur1");
        panneau_info_partie.add(lbl_jcourant, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, 20));
        panneau_info_partie.add(InfoPartie, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 200, 60));

        getContentPane().add(panneau_info_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 480, 250, 160));

        panneau_creation_partie.setBackground(new java.awt.Color(204, 255, 204));
        panneau_creation_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nom Joueur 2 : ");
        panneau_creation_partie.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 20));

        jLabel2.setText("Nom Joueur 1 : ");
        panneau_creation_partie.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));
        panneau_creation_partie.add(nom_joueur_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 110, -1));

        nom_joueur_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_joueur_2ActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(nom_joueur_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 110, -1));

        bebut_partie.setText("Démarrer la partie");
        bebut_partie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bebut_partieActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(bebut_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        getContentPane().add(panneau_creation_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 250, 120));

        btn_col_0.setActionCommand("1");
        btn_col_0.setLabel("1");
        btn_col_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_0ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        btn_col_1.setLabel("2");
        btn_col_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        btn_col_2.setHideActionText(true);
        btn_col_2.setLabel("3");
        btn_col_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        btn_col_3.setLabel("4");
        btn_col_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        btn_col_4.setLabel("5");
        btn_col_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        btn_col_5.setLabel("6");
        btn_col_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, -1));

        btn_col_6.setLabel("7");
        btn_col_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_6ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));

        setBounds(0, 0, 1077, 704);
    }// </editor-fold>//GEN-END:initComponents

    private void nom_joueur_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_joueur_2ActionPerformed
        
    }//GEN-LAST:event_nom_joueur_2ActionPerformed

    private void btn_col_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_0ActionPerformed
        //Initialisation des variables
        int ligne, colonne = 0;
        ligne = this.Plateau.ajouterJetonDansColonne(this.JoueurCourant.jouerJeton(), colonne);
        if (Plateau.colonneRemplie(colonne)) {
            //Si la est remplie désactive le bouton correspondant
            btn_col_0.setEnabled(false);
        }
        //application du cas lorsqu'il y a un trou noir 
        if (this.Plateau.presenceTrouNoir(ligne, colonne)) {
            this.Plateau.supprimerJeton(ligne, colonne);
            this.Plateau.supprimerTrouNoir(ligne, colonne);
        }
        // Aplication du cas ou il y a un desintegrateur 
        if (this.Plateau.presenceDesintegrateur(ligne, colonne)) {
            this.Plateau.supprimerDesintegrateur(ligne, colonne);
            JoueurCourant.obtenirDesintegrateur();
            lbl_j1_desintegrateur1.setText(listeJoueurs[0].nombreDesintegrateurs() + "");
            lbl_j2_desintegrateur.setText(listeJoueurs[1].nombreDesintegrateurs() + "");
        }
        //Actualisation du plateau de jeu 
        panneau_grille.repaint();

        // Initialise les variable pour savoir si un joueur à gagner
        boolean J1win = Plateau.GagnantJoueurCouleur(listeJoueurs[0].lireCouleur());
        boolean J2win = Plateau.GagnantJoueurCouleur(listeJoueurs[1].lireCouleur());

        if (J1win && !J2win) {
            InfoPartie.setText("Victoire de " + listeJoueurs[0].getNom());
        }
        if (!J1win && J2win) {
            InfoPartie.setText("Victoire de " + listeJoueurs[1].getNom());
        }
        if (J1win && J2win) {
            //En cas de double victoire le joueur actif est le prochain à jouer, il est donc le gagnant
            if (JoueurCourant == listeJoueurs[0]) {
                InfoPartie.setText("Faute de jeu de " + listeJoueurs[0].getNom() + "\nVictoire de " + listeJoueurs[1].getNom());
            } else {
                InfoPartie.setText("Faute de jeu de " + listeJoueurs[1].getNom() + "\nVictoire de " + listeJoueurs[0].getNom());
            }
        }
        //Indication aux joueurs du prochain tours 
        TourSuivant();
    }//GEN-LAST:event_btn_col_0ActionPerformed

    private void btn_col_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_2ActionPerformed
        //Initialisation des variables
        int ligne, colonne = 2;
        ligne = this.Plateau.ajouterJetonDansColonne(this.JoueurCourant.jouerJeton(), colonne);
        //Si la est remplie désactive le bouton correspondant
        if (Plateau.colonneRemplie(colonne)) {
            btn_col_2.setEnabled(false);
        }
        //application du cas lorsqu'il y a un trou noir 
        if (this.Plateau.presenceTrouNoir(ligne, colonne)) {
            this.Plateau.supprimerJeton(ligne, colonne);
            this.Plateau.supprimerTrouNoir(ligne, colonne);
        }
        // Aplication du cas ou il y a un desintegrateur 
        if (this.Plateau.presenceDesintegrateur(ligne, colonne)) {
            this.Plateau.supprimerDesintegrateur(ligne, colonne);
            JoueurCourant.obtenirDesintegrateur();
            lbl_j1_desintegrateur1.setText(listeJoueurs[0].nombreDesintegrateurs() + "");
            lbl_j2_desintegrateur.setText(listeJoueurs[1].nombreDesintegrateurs() + "");
        }
        //Actualisation du plateau de jeu 
        panneau_grille.repaint();

        // Initialise les variable pour savoir si un joueur à gagner
        boolean J1win = Plateau.GagnantJoueurCouleur(listeJoueurs[0].lireCouleur());
        boolean J2win = Plateau.GagnantJoueurCouleur(listeJoueurs[1].lireCouleur());

        if (J1win && !J2win) {
            InfoPartie.setText("Victoire de " + listeJoueurs[0].getNom());
        }
        if (!J1win && J2win) {
            InfoPartie.setText("Victoire de " + listeJoueurs[1].getNom());
        }
        if (J1win && J2win) {
            //En cas de double victoire le joueur actif est le prochain à jouer, il est donc le gagnant
            if (JoueurCourant == listeJoueurs[0]) {
                InfoPartie.setText("Faute de jeu de " + listeJoueurs[0].getNom() + "\nVictoire de " + listeJoueurs[1].getNom());
            } else {
                InfoPartie.setText("Faute de jeu de " + listeJoueurs[1].getNom() + "\nVictoire de " + listeJoueurs[0].getNom());
            }
        }
        //Indication aux joueurs du prochain tours 
        TourSuivant();
    }//GEN-LAST:event_btn_col_2ActionPerformed

    private void btn_col_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_4ActionPerformed
        //Initialisation des variables
        int ligne, colonne = 4;
        ligne = this.Plateau.ajouterJetonDansColonne(this.JoueurCourant.jouerJeton(), colonne);
        //Si la est remplie désactive le bouton correspondant
        if (Plateau.colonneRemplie(colonne)) {
            btn_col_4.setEnabled(false);
        }
        //application du cas lorsqu'il y a un trou noir 
        if (this.Plateau.presenceTrouNoir(ligne, colonne)) {
            this.Plateau.supprimerJeton(ligne, colonne);
            this.Plateau.supprimerTrouNoir(ligne, colonne);
        }
        // Aplication du cas ou il y a un desintegrateur 
        if (this.Plateau.presenceDesintegrateur(ligne, colonne)) {
            this.Plateau.supprimerDesintegrateur(ligne, colonne);
            JoueurCourant.obtenirDesintegrateur();
            lbl_j1_desintegrateur1.setText(listeJoueurs[0].nombreDesintegrateurs() + "");
            lbl_j2_desintegrateur.setText(listeJoueurs[1].nombreDesintegrateurs() + "");
        }
        //Actualisation du plateau de jeu 
        panneau_grille.repaint();

        // Initialise les variable pour savoir si un joueur à gagner
        boolean J1win = Plateau.GagnantJoueurCouleur(listeJoueurs[0].lireCouleur());
        boolean J2win = Plateau.GagnantJoueurCouleur(listeJoueurs[1].lireCouleur());

        if (J1win && !J2win) {
            InfoPartie.setText("Victoire de " + listeJoueurs[0].getNom());
        }
        if (!J1win && J2win) {
            InfoPartie.setText("Victoire de " + listeJoueurs[1].getNom());
        }
        if (J1win && J2win) {
            //En cas de double victoire le joueur actif est le prochain à jouer, il est donc le gagnant
            if (JoueurCourant == listeJoueurs[0]) {
                InfoPartie.setText("Faute de jeu de " + listeJoueurs[0].getNom() + "\nVictoire de " + listeJoueurs[1].getNom());
            } else {
                InfoPartie.setText("Faute de jeu de " + listeJoueurs[1].getNom() + "\nVictoire de " + listeJoueurs[0].getNom());
            }
        }
        //Indication aux joueurs du prochain tours 
        TourSuivant();
    }//GEN-LAST:event_btn_col_4ActionPerformed

    private void btn_col_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_5ActionPerformed
        //Initialisation des variables
        int ligne, colonne = 5;
        ligne = this.Plateau.ajouterJetonDansColonne(this.JoueurCourant.jouerJeton(), colonne);
        //Si la est remplie désactive le bouton correspondant
        if (Plateau.colonneRemplie(colonne)) {
            btn_col_5.setEnabled(false);
        }
        //application du cas lorsqu'il y a un trou noir 
        if (this.Plateau.presenceTrouNoir(ligne, colonne)) {
            this.Plateau.supprimerJeton(ligne, colonne);
            this.Plateau.supprimerTrouNoir(ligne, colonne);
        }
        // Aplication du cas ou il y a un desintegrateur 
        if (this.Plateau.presenceDesintegrateur(ligne, colonne)) {
            this.Plateau.supprimerDesintegrateur(ligne, colonne);
            JoueurCourant.obtenirDesintegrateur();
            lbl_j1_desintegrateur1.setText(listeJoueurs[0].nombreDesintegrateurs() + "");
            lbl_j2_desintegrateur.setText(listeJoueurs[1].nombreDesintegrateurs() + "");
        }
        //Actualisation du plateau de jeu 
        panneau_grille.repaint();

        // Initialise les variable pour savoir si un joueur à gagner
        boolean J1win = Plateau.GagnantJoueurCouleur(listeJoueurs[0].lireCouleur());
        boolean J2win = Plateau.GagnantJoueurCouleur(listeJoueurs[1].lireCouleur());

        if (J1win && !J2win) {
            InfoPartie.setText("Victoire de " + listeJoueurs[0].getNom());
        }
        if (!J1win && J2win) {
            InfoPartie.setText("Victoire de " + listeJoueurs[1].getNom());
        }
        if (J1win && J2win) {
            //En cas de double victoire le joueur actif est le prochain à jouer, il est donc le gagnant
            if (JoueurCourant == listeJoueurs[0]) {
                InfoPartie.setText("Faute de jeu de " + listeJoueurs[0].getNom() + "\nVictoire de " + listeJoueurs[1].getNom());
            } else {
                InfoPartie.setText("Faute de jeu de " + listeJoueurs[1].getNom() + "\nVictoire de " + listeJoueurs[0].getNom());
            }
        }
        //Indication aux joueurs du prochain tours 
        TourSuivant();
    }//GEN-LAST:event_btn_col_5ActionPerformed

    private void bebut_partieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebut_partieActionPerformed
        panneau_info_Joueur.setVisible(true);
        panneau_info_partie.setVisible(true);
        initialiserPartie();
        panneau_grille.repaint();
        bebut_partie.setEnabled(false);
    }//GEN-LAST:event_bebut_partieActionPerformed

    private void btn_col_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_1ActionPerformed
        //Initialisation des variables
        int ligne, colonne = 1;
        ligne = this.Plateau.ajouterJetonDansColonne(this.JoueurCourant.jouerJeton(), colonne);
        //Si la est remplie désactive le bouton correspondant
        if (Plateau.colonneRemplie(colonne)) {
            btn_col_1.setEnabled(false);
        }
        //application du cas lorsqu'il y a un trou noir 
        if (this.Plateau.presenceTrouNoir(ligne, colonne)) {
            this.Plateau.supprimerJeton(ligne, colonne);
            this.Plateau.supprimerTrouNoir(ligne, colonne);
        }
        // Aplication du cas ou il y a un desintegrateur 
        if (this.Plateau.presenceDesintegrateur(ligne, colonne)) {
            this.Plateau.supprimerDesintegrateur(ligne, colonne);
            JoueurCourant.obtenirDesintegrateur();
            lbl_j1_desintegrateur1.setText(listeJoueurs[0].nombreDesintegrateurs() + "");
            lbl_j2_desintegrateur.setText(listeJoueurs[1].nombreDesintegrateurs() + "");
        }
        //Actualisation du plateau de jeu 
        panneau_grille.repaint();

        // Initialise les variable pour savoir si un joueur à gagner
        boolean J1win = Plateau.GagnantJoueurCouleur(listeJoueurs[0].lireCouleur());
        boolean J2win = Plateau.GagnantJoueurCouleur(listeJoueurs[1].lireCouleur());

        if (J1win && !J2win) {
            InfoPartie.setText("Victoire de " + listeJoueurs[0].getNom());
        }
        if (!J1win && J2win) {
            InfoPartie.setText("Victoire de " + listeJoueurs[1].getNom());
        }
        if (J1win && J2win) {
            //En cas de double victoire le joueur actif est le prochain à jouer, il est donc le gagnant
            if (JoueurCourant == listeJoueurs[0]) {
                InfoPartie.setText("Faute de jeu de " + listeJoueurs[0].getNom() + "\nVictoire de " + listeJoueurs[1].getNom());
            } else {
                InfoPartie.setText("Faute de jeu de " + listeJoueurs[1].getNom() + "\nVictoire de " + listeJoueurs[0].getNom());
            }
        }
        //Indication aux joueurs du prochain tours 
        TourSuivant();
    }//GEN-LAST:event_btn_col_1ActionPerformed

    private void btn_col_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_3ActionPerformed
        //Initialisation des variables
        int ligne, colonne = 3;
        ligne = this.Plateau.ajouterJetonDansColonne(this.JoueurCourant.jouerJeton(), colonne);
        //Si la est remplie désactive le bouton correspondant
        if (Plateau.colonneRemplie(colonne)) {
            btn_col_3.setEnabled(false);
        }
        //application du cas lorsqu'il y a un trou noir 
        if (this.Plateau.presenceTrouNoir(ligne, colonne)) {
            this.Plateau.supprimerJeton(ligne, colonne);
            this.Plateau.supprimerTrouNoir(ligne, colonne);
        }
        // Aplication du cas ou il y a un desintegrateur 
        if (this.Plateau.presenceDesintegrateur(ligne, colonne)) {
            this.Plateau.supprimerDesintegrateur(ligne, colonne);
            JoueurCourant.obtenirDesintegrateur();
            lbl_j1_desintegrateur1.setText(listeJoueurs[0].nombreDesintegrateurs() + "");
            lbl_j2_desintegrateur.setText(listeJoueurs[1].nombreDesintegrateurs() + "");
        }
        //Actualisation du plateau de jeu 
        panneau_grille.repaint();

        // Initialise les variable pour savoir si un joueur à gagner
        boolean J1win = Plateau.GagnantJoueurCouleur(listeJoueurs[0].lireCouleur());
        boolean J2win = Plateau.GagnantJoueurCouleur(listeJoueurs[1].lireCouleur());

        if (J1win && !J2win) {
            InfoPartie.setText("Victoire de " + listeJoueurs[0].getNom());
        }
        if (!J1win && J2win) {
            InfoPartie.setText("Victoire de " + listeJoueurs[1].getNom());
        }
        if (J1win && J2win) {
            //En cas de double victoire le joueur actif est le prochain à jouer, il est donc le gagnant
            if (JoueurCourant == listeJoueurs[0]) {
                InfoPartie.setText("Faute de jeu de " + listeJoueurs[0].getNom() + "\nVictoire de " + listeJoueurs[1].getNom());
            } else {
                InfoPartie.setText("Faute de jeu de " + listeJoueurs[1].getNom() + "\nVictoire de " + listeJoueurs[0].getNom());
            }
        }
        //Indication aux joueurs du prochain tours 
        TourSuivant();
    }//GEN-LAST:event_btn_col_3ActionPerformed

    private void btn_col_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_6ActionPerformed
        //Initialisation des variables
        int ligne, colonne = 6;
        ligne = this.Plateau.ajouterJetonDansColonne(this.JoueurCourant.jouerJeton(), colonne);
        //Si la est remplie désactive le bouton correspondant
        if (Plateau.colonneRemplie(colonne)) {
            btn_col_6.setEnabled(false);
        }
        //application du cas lorsqu'il y a un trou noir 
        if (this.Plateau.presenceTrouNoir(ligne, colonne)) {
            this.Plateau.supprimerJeton(ligne, colonne);
            this.Plateau.supprimerTrouNoir(ligne, colonne);
        }
        // Aplication du cas ou il y a un desintegrateur 
        if (this.Plateau.presenceDesintegrateur(ligne, colonne)) {
            this.Plateau.supprimerDesintegrateur(ligne, colonne);
            JoueurCourant.obtenirDesintegrateur();
            lbl_j1_desintegrateur1.setText(listeJoueurs[0].nombreDesintegrateurs() + "");
            lbl_j2_desintegrateur.setText(listeJoueurs[1].nombreDesintegrateurs() + "");
        }
        //Actualisation du plateau de jeu 
        panneau_grille.repaint();

        // Initialise les variable pour savoir si un joueur à gagner
        boolean J1win = Plateau.GagnantJoueurCouleur(listeJoueurs[0].lireCouleur());
        boolean J2win = Plateau.GagnantJoueurCouleur(listeJoueurs[1].lireCouleur());

        if (J1win && !J2win) {
            InfoPartie.setText("Victoire de " + listeJoueurs[0].getNom());
        }
        if (!J1win && J2win) {
            InfoPartie.setText("Victoire de " + listeJoueurs[1].getNom());
        }
        if (J1win && J2win) {
            //En cas de double victoire le joueur actif est le prochain à jouer, il est donc le gagnant
            if (JoueurCourant == listeJoueurs[0]) {
                InfoPartie.setText("Faute de jeu de " + listeJoueurs[0].getNom() + "\nVictoire de " + listeJoueurs[1].getNom());
            } else {
                InfoPartie.setText("Faute de jeu de " + listeJoueurs[1].getNom() + "\nVictoire de " + listeJoueurs[0].getNom());
            }
        }
        //Indication aux joueurs du prochain tours 
        TourSuivant();
    }//GEN-LAST:event_btn_col_6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fenetreDeJeu().setVisible(true);
            }
        });
    }

    public void initialiserPartie() {
        //Initialisation des parametre par rapport aux joueurs 
        Plateau.Vidergrille(listeJoueurs[0], listeJoueurs[1]);
        String nomJoueur1 = nom_joueur_1.getText();
        listeJoueurs[0] = new Joueur(nomJoueur1);
        String nomJoueur2 = nom_joueur_2.getText();
        listeJoueurs[1] = new Joueur(nomJoueur2);
        //Attribution de la couleur aux joueurs 
        attribuerCouleurAuxJoueurs();
        System.out.println(nomJoueur1 + " est de couleur " + listeJoueurs[0].lireCouleur());
        System.out.println(nomJoueur2 + " est de couleur " + listeJoueurs[1].lireCouleur());
        //Mise en place des information du joueur dans l'affichage infos joueurs
        lbl_j1_nom1.setText(nomJoueur1);
        lbl_j1_couleur1.setText(listeJoueurs[0].lireCouleur());
        lbl_j1_desintegrateur1.setText(listeJoueurs[0].nombreDesintegrateurs() + "");

        lbl_j2_nom.setText(nomJoueur2);
        lbl_j2_couleur.setText(listeJoueurs[1].lireCouleur());
        lbl_j2_desintegrateur.setText(listeJoueurs[1].nombreDesintegrateurs() + "");

        lbl_jcourant.setText(JoueurCourant.getNom());
        //Creation et affection des jetons aux joueurs conserner 
        creerEtAffecterJeton(this.listeJoueurs[0]);
        creerEtAffecterJeton(this.listeJoueurs[1]);
        placerTrouNoirsEtDeseintegrateurs();
    }

    public void attribuerCouleurAuxJoueurs() {
        // Affectation des couleurs au hasard aux joueurs 
        listeJoueurs[(int) (Math.random() * 2)].affecterCouleur("rouge");
        if (listeJoueurs[0].lireCouleur() == "") {
            listeJoueurs[0].affecterCouleur("jaune");
            //Attribution de la couleur jaune au joueur qui est premier dans la liste 
            JoueurCourant = listeJoueurs[1];
        } else {
            listeJoueurs[1].affecterCouleur("jaune"); 
            JoueurCourant = listeJoueurs[0];
        }
    }
    //Methode qui permet de créer les 30 jetons neccessaire de la couleur du joueur en paramètre
    public void creerEtAffecterJeton(Joueur J) {
        for (int i = 0; i < 30; i++) {
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
    

    public void TourSuivant() {
        //Permet de passer à un nouveau tour 
        //Changement du joueurCourant 
        if (JoueurCourant == listeJoueurs[0]) {
            JoueurCourant = listeJoueurs[1];
        } else {
            JoueurCourant = listeJoueurs[0];
        }
        //Changement du label joueurCourant 
        lbl_jcourant.setText(JoueurCourant.getNom());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextArea InfoPartie;
    private javax.swing.JButton bebut_partie;
    private javax.swing.JButton btn_col_0;
    private javax.swing.JButton btn_col_1;
    private javax.swing.JButton btn_col_2;
    private javax.swing.JButton btn_col_3;
    private javax.swing.JButton btn_col_4;
    private javax.swing.JButton btn_col_5;
    private javax.swing.JButton btn_col_6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_j1_couleur1;
    private javax.swing.JLabel lbl_j1_desintegrateur1;
    private javax.swing.JLabel lbl_j1_nom1;
    private javax.swing.JLabel lbl_j2_couleur;
    private javax.swing.JLabel lbl_j2_desintegrateur;
    private javax.swing.JLabel lbl_j2_nom;
    private javax.swing.JLabel lbl_jcourant;
    private javax.swing.JTextField nom_joueur_1;
    private javax.swing.JTextField nom_joueur_2;
    private javax.swing.JPanel panneau_creation_partie;
    private javax.swing.JPanel panneau_grille;
    private javax.swing.JPanel panneau_info_Joueur;
    private javax.swing.JPanel panneau_info_partie;
    // End of variables declaration//GEN-END:variables
}
