
public class MatelasAir extends MobilierChambre {

    private int tempGonflage;

    public MatelasAir(String reference, String marque, String modele, double prixJourLoc, int nbStock, double poidsMax, double longueur, double largeur, double hauteur, int tempGonflage) {
        super(reference, marque, modele, prixJourLoc, nbStock, poidsMax, longueur, largeur, hauteur);

        this.tempGonflage = tempGonflage;
    }


    //Getters and Setters
    public int getTempGonflage() {
        return tempGonflage;
    }

    public void setTempGonflage(int tempGonflage) {
        this.tempGonflage = tempGonflage;
    }
}
