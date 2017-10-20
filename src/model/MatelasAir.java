package model;

/**
 * Created by Anais BESSON and Victor FAVREAU on 18/10/2017.
 */
public class MatelasAir extends MobilierChambre {

    private int tempGonflage;

    /**
     * Constructeur de la classe MatelasAir
     * @param reference référence de l'article
     * @param marque marque de l'article
     * @param modele modele de l'article
     * @param prixJourLoc prix par jour de location de l'article
     * @param nbStock quantité en stock de l'article
     * @param poidsMax poids maximum supportable de l'article
     * @param longueur longueur du matelas
     * @param largeur largeur du matelas
     * @param hauteur hauteur du matelas
     * @param tempGonflage temps de gonflage du matelas
     */
    public MatelasAir(String reference, String marque, String modele, double prixJourLoc, int nbStock, double poidsMax, double longueur, double largeur, double hauteur, int tempGonflage) {
        super(reference, marque, modele, prixJourLoc, nbStock, poidsMax, longueur, largeur, hauteur);

        this.tempGonflage = tempGonflage;
    }


    //Getters and Setters

    /**
     * Retourne le temps de gonflage du matelas
     * @return temps de gonflage du matelas
     */
    public int getTempGonflage() {
        return tempGonflage;
    }

    /**
     * Modifie le temps de gonflage du matelas
     * @param tempGonflage temps de gonflage du matelas
     */
    public void setTempGonflage(int tempGonflage) {
        this.tempGonflage = tempGonflage;
    }
}
