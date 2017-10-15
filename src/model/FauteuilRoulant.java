package model;

public class FauteuilRoulant extends Article {

    private double largeurAssise;
    private double poids;

    public FauteuilRoulant(String reference, String marque, String modele, double prixJourLoc, int nbStock, double largeurAssise, double poids) {
        super(reference, marque, modele, prixJourLoc, nbStock);

        this.largeurAssise = largeurAssise;
        this.poids = poids;

    }

    //Getters and Setters
    public double getLargeurAssise() {
        return largeurAssise;
    }

    public void setLargeurAssise(double largeurAssise) {
        this.largeurAssise = largeurAssise;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }
}
