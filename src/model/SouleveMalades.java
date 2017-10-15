package model;

public class SouleveMalades extends Article {

    private double capacite;
    private double degrePivotage;

    public SouleveMalades(String reference, String marque, String modele, double prixJourLoc, int nbStock, double capacite, double degrePivotage) {
        super(reference, marque, modele, prixJourLoc, nbStock);

        this.capacite = capacite;
        this.degrePivotage = degrePivotage;
    }


    //Getters and Setters
    public double getCapacite() {
        return capacite;
    }

    public void setCapacite(double capacite) {
        this.capacite = capacite;
    }

    public double getDegrePivotage() {
        return degrePivotage;
    }

    public void setDegrePivotage(double degrePivotage) {
        this.degrePivotage = degrePivotage;
    }
}
