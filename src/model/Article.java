package model;

public abstract class Article {

    private String reference;
    private String marque;
    private String modele;
    private double prixJourLoc;
    private int nbStock;

    public Article(String reference, String marque, String modele, double prixJourLoc, int nbStock) {
        this.reference = reference;
        this.marque = marque;
        this.modele = marque;
        this.prixJourLoc = prixJourLoc;
        this.nbStock = nbStock;
    }

    //Soustrait la valeur passée en parametre au stock
    public boolean subStock(int nb_sub) {
        if (this.nbStock >= nb_sub) {
            this.nbStock -= nb_sub;

            return true;
        }

        return false;
    }

    //Ajoute la valeur passée en parametre au stock
    public void addStock(int nb_add) {
        this.nbStock += nb_add;
    }

    //Getters and Setters
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public double getPrixJourLoc() {
        return prixJourLoc;
    }

    public void setPrixJourLoc(double prixJourLoc) {
        this.prixJourLoc = prixJourLoc;
    }

    public int getNbStock() {
        return nbStock;
    }

    public void setNbStock(int nbStock) {
        this.nbStock = nbStock;
    }
}
