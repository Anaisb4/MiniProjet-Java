package model;

/**
 * Created by Anais BESSON and Victor FAVREAU on 18/10/2017.
 */
public class FauteuilRoulant extends Article {

    private double largeurAssise;
    private double poids;

    /**
     * Constructeur de la classe Fauteuil Roulant
     * @param reference reference de l'article
     * @param marque marque de l'article
     * @param modele modele de l'article
     * @param prixJourLoc prix par jour de location de l'article
     * @param nbStock quantite en stock de l'article
     * @param largeurAssise largeur de l'assise du fauteuil roulant
     * @param poids poids du fauteuil roulant
     */
    public FauteuilRoulant(String reference, String marque, String modele, double prixJourLoc, int nbStock, double largeurAssise, double poids) {
        super(reference, marque, modele, prixJourLoc, nbStock);

        this.largeurAssise = largeurAssise;
        this.poids = poids;

    }

    //Getters and Setters

    /**
     * Retourne  la largeur d'assise du fauteuil roulant
     * @return largeur d'assise du fauteuil roulant
     */
    public double getLargeurAssise() {
        return largeurAssise;
    }

    /**
     * Change la largeur d'assise du fauteuil roulant
     * @param largeurAssise largeur d'assise du fauteuil roulant
     */
    public void setLargeurAssise(double largeurAssise) {
        this.largeurAssise = largeurAssise;
    }

    /**
     * Retourne le poids du fauteuil roulant
     * @return poids du fauteuil roulant
     */
    public double getPoids() {
        return poids;
    }

    /**
     * Change le poids du fauteuil roulant
     * @param poids poids du fauteuil roulant
     */
    public void setPoids(double poids) {
        this.poids = poids;
    }
}
