/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SP4_graphique_LIBERT;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Graphics;

/**
 *
 * @author pauline
 */
public class CelluleGraphique extends JButton {
//Recuperation des images necessaire pour l'interface graphique
    CelluleDeGrille CelluleAssociee;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/CelluleVide.png"));
    ImageIcon img_rouge = new javax.swing.ImageIcon(getClass().getResource("/images/jetonRouge.png"));
    ImageIcon img_jaune = new javax.swing.ImageIcon(getClass().getResource("/images/jetonJaune.png"));
    ImageIcon img_desint = new javax.swing.ImageIcon(getClass().getResource("/images/desintegrateur.png"));
    ImageIcon img_trounoir = new javax.swing.ImageIcon(getClass().getResource("/images/trounoir.png"));

    /**
     *
     * @param UneCellule
     */
    public CelluleGraphique(CelluleDeGrille UneCellule) {
        CelluleAssociee = UneCellule;
    }

    @Override
    public void paintComponent(Graphics G) {
        //Mise en place des images correpondant aux élement que contient la cellule
        super.paintComponent(G);
        if (CelluleAssociee.presenceTrouNoir()) {
            setIcon(img_trounoir);
        } 
        else{
            if (CelluleAssociee.presenceDesintegrateur()) {
            setIcon(img_desint);
            }
            else {
            switch (CelluleAssociee.LireCouleurJeton()) {
                case "vide":
                    setIcon(img_vide);
                    break;
                case "rouge":
                    setIcon(img_rouge);
                    break;
                case "jaune":
                    setIcon(img_jaune);
                    break;
            }
        }
             
        }
        
    }

}
