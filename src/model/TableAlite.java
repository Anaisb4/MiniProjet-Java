package model;

public class TableAlite extends MobilierChambre {

    private boolean isAjustable;

    public TableAlite(String reference, String marque, String modele, double prixJourLoc, int nbStock, double poidsMax, double longueur, double largeur, double hauteur, boolean isAjustable) {
        super(reference, marque, modele, prixJourLoc, nbStock, poidsMax, longueur, largeur, hauteur);

        this.isAjustable = isAjustable;
    }

    //Getters and Setters
    public boolean isAjustable() {
        return isAjustable;
    }

    public void setAjustable(boolean ajustable) {
        isAjustable = ajustable;
    }
}
