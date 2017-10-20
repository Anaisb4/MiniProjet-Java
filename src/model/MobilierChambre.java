package model;


/**
 * Created by Anais BESSON and Victor FAVREAU on 18/10/2017.
 */
public abstract class MobilierChambre extends Article {

    private double poidsMax;
    private double longueur;
    private double largeur;
    private double hauteur;

    /**
     * Constructeur de la classe MobilierChambre
     * @param reference référence de l'article
     * @param marque marque de l'article
     * @param modele modele de l'article
     * @param prixJourLoc prix par jour de location de l'article
     * @param nbStock quantite en stock de l'article
     * @param poidsMax poids maximum supportable du mobilier
     * @param longueur longueur du mobilier
     * @param largeur largeur du mobilier
     * @param hauteur hauteur du mobilire
     */
    public MobilierChambre(String reference, String marque, String modele, double prixJourLoc, int nbStock, double poidsMax, double longueur, double largeur, double hauteur) {
        super(reference, marque, modele, prixJourLoc, nbStock);

        this.poidsMax = poidsMax;
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    //Getters and Setters

    /**
     * Retourne le poids max supportable de l'article
     * @return poids max supportable de l'article
     */
    public double getPoidsMax() {
        return poidsMax;
    }

    /**
     * Change le poids max supportable de l'article
     * @param poidsMax nouveau poids max supportable de l'article
     */
    public void setPoidsMax(double poidsMax) {
        this.poidsMax = poidsMax;
    }

    /**
     * Retourne la longueur de l'article
     * @return longueur de l'article
     */
    public double getLongueur() {
        return longueur;
    }

    /**
     * Modifie la longueur de l'article
     * @param longueur longueur de l'article
     */
    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    /**
     * Retourne la largeur de l'article
     * @return largeur de l'article
     */
    public double getLargeur() {
        return largeur;
    }

    /**
     * Change la largeur de l'article
     * @param largeur nouvelle largeur de l'article
     */
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    /**
     * Retourne la hauteur de l'aticle
     * @return hauteur de l'article
     */
    public double getHauteur() {
        return hauteur;
    }

    /**
     * Change la hauteur de l'article
     * @param hauteur nouvelle hauteur de l'article
     */
    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }
}
