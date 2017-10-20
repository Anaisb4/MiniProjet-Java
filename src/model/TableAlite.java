package model;

/**
 * Created by Anais BESSON and Victor FAVREAU on 18/10/2017.
 */
public class TableAlite extends MobilierChambre {

    private boolean isAjustable;

    /**
     * Constructeur de la classe TableAlite
     * @param reference référence de l'article
     * @param marque marque de l'article
     * @param modele modele de l'article
     * @param prixJourLoc prix par jour de location de l'article
     * @param nbStock quantite en stock de l'article
     * @param poidsMax poids maximum supportable du mobilier
     * @param longueur longueur du mobilier
     * @param largeur largeur du mobilier
     * @param hauteur hauteur du mobilire
     * @param isAjustable la table est elle ajustable ?
     */
    public TableAlite(String reference, String marque, String modele, double prixJourLoc, int nbStock, double poidsMax, double longueur, double largeur, double hauteur, boolean isAjustable) {
        super(reference, marque, modele, prixJourLoc, nbStock, poidsMax, longueur, largeur, hauteur);

        this.isAjustable = isAjustable;
    }

    //Getters and Setters

    /**
     * Retourne vrai si la table est ajustable
     * @return valeur de isAjustable
     */
    public boolean isAjustable() {
        return isAjustable;
    }

    /**
     * Modifie la valeur de isAjustable
     * @param ajustable nouvelle valeur de isAjustable
     */
    public void setAjustable(boolean ajustable) {
        isAjustable = ajustable;
    }
}
