package model;

public abstract class MobilierChambre extends Article {

    private double poidsMax;
    private double longueur;
    private double largeur;
    private double hauteur;


    public MobilierChambre(String reference, String marque, String modele, double prixJourLoc, int nbStock, double poidsMax, double longueur, double largeur, double hauteur) {
        super(reference, marque, modele, prixJourLoc, nbStock);

        this.poidsMax = poidsMax;
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    //Getters and Setters
    public double getPoidsMax() {
        return poidsMax;
    }

    public void setPoidsMax(double poidsMax) {
        this.poidsMax = poidsMax;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }
}
