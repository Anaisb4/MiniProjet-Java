
public class LitMedicalise extends MobilierChambre {

    private boolean isElectrique;
    private boolean isDouble;

    public LitMedicalise(String reference, String marque, String modele, double prixJourLoc, int nbStock, double poidsMax, double longueur, double largeur, double hauteur, boolean isElectrique, boolean isDouble) {
        super(reference, marque, modele, prixJourLoc, nbStock, poidsMax, longueur, largeur, hauteur);

        this.isElectrique = isElectrique;
        this.isDouble = isDouble;
    }


    //Getters and Setters
    public boolean isElectrique() {
        return isElectrique;
    }

    public void setElectrique(boolean electrique) {
        isElectrique = electrique;
    }

    public boolean isDouble() {
        return isDouble;
    }

    public void setDouble(boolean aDouble) {
        isDouble = aDouble;
    }
}
