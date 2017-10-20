package model;

/**
 * Created by Anais BESSON and Victor FAVREAU on 18/10/2017.
 */
public class LitMedicalise extends MobilierChambre {

    private boolean isElectrique;
    private boolean isDouble;

    /**
     * Constructeur de la classe LitMedicalise
     * @param reference reference de l'article
     * @param marque marque de l'article
     * @param modele modele de l'article
     * @param prixJourLoc prix par jour de location de l'article
     * @param nbStock quantité de l'article en stock
     * @param poidsMax poids maximum acceptable
     * @param longueur longueur du lit
     * @param largeur largeur du lit
     * @param hauteur hauteur du lit
     * @param isElectrique le lit est il electrique ?
     * @param isDouble le lit est il double ?
     */
    public LitMedicalise(String reference, String marque, String modele, double prixJourLoc, int nbStock, double poidsMax, double longueur, double largeur, double hauteur, boolean isElectrique, boolean isDouble) {
        super(reference, marque, modele, prixJourLoc, nbStock, poidsMax, longueur, largeur, hauteur);

        this.isElectrique = isElectrique;
        this.isDouble = isDouble;
    }


    //Getters and Setters

    /**
     * Le lit est il electrique ?
     * @return valeur de isElectrique
     */
    public boolean isElectrique() {
        return isElectrique;
    }

    /**
     * Change la valeur de isElectrique.
     * @param electrique nouvelle valeur de isElectrique
     */
    public void setElectrique(boolean electrique) {
        isElectrique = electrique;
    }

    /**
     * Retourne la valeur de isDouble
     * @return nouvelle valeur de isDouble
     */
    public boolean isDouble() {
        return isDouble;
    }

    /**
     * Change la valeur de isDouble
     * @param aDouble nouvelle valeur de isDouble
     */
    public void setDouble(boolean aDouble) {
        isDouble = aDouble;
    }
}
