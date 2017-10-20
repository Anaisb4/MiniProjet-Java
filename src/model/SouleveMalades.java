package model;

/**
 * Created by Anais BESSON and Victor FAVREAU on 18/10/2017.
 */
public class SouleveMalades extends Article {

    private double capacite;
    private double degrePivotage;

    /**
     * Constructeur de la classe souleve malade
     * @param reference référence de l'article
     * @param marque marque de l'article
     * @param modele modele de l'article
     * @param prixJourLoc prix par jour de location de l'article
     * @param nbStock quantite en stock de l'article
     * @param capacite capacite du souleve malade
     * @param degrePivotage degre de pivotage du souleve malade

     */
    public SouleveMalades(String reference, String marque, String modele, double prixJourLoc, int nbStock, double capacite, double degrePivotage) {
        super(reference, marque, modele, prixJourLoc, nbStock);

        this.capacite = capacite;
        this.degrePivotage = degrePivotage;
    }


    //Getters and Setters

    /**
     * Retourne la capacite du souleve malade
     * @return capacite du souleve malade
     */
    public double getCapacite() {
        return capacite;
    }

    /**
     * Modifie la capacite du souleve malade
     * @param capacite capacite du souleve malade
     */
    public void setCapacite(double capacite) {
        this.capacite = capacite;
    }

    /**
     * Retourne le degré de pivotage
     * @return degré de pivotage
     */
    public double getDegrePivotage() {
        return degrePivotage;
    }

    /**
     * modifie le degre de pivotage
     * @param degrePivotage nouveau degré de pivotage
     */
    public void setDegrePivotage(double degrePivotage) {
        this.degrePivotage = degrePivotage;
    }
}
