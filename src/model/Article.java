package model;

/**
 * Created by Anais BESSON and Victor FAVREAU on 18/10/2017.
 */
public abstract class Article{

    private String reference;
    private String marque;
    private String modele;
    private double prixJourLoc;
    private int nbStock;

    /**
     * Constructeur de la classe
     * @param reference reference de l'article
     * @param marque marque de l'article
     * @param modele modele de l'article
     * @param prixJourLoc prix par jour de location de l'article
     * @param nbStock quantite en stock
     */
    public Article(String reference, String marque, String modele, double prixJourLoc, int nbStock) {
        this.reference = reference;
        this.marque = marque;
        this.modele = modele;
        this.prixJourLoc = prixJourLoc;
        this.nbStock = nbStock;
    }

    /**
     * Soustrait la valeur passee en parametre au stock.
     * @param nb_sub valeur à soustraire.
     * @return Si l'operation à reussi: true, sinon false.
     */
    public boolean subStock(int nb_sub) {
        if (this.nbStock >= nb_sub) {
            this.nbStock -= nb_sub;

            return true;
        }

        return false;
    }

    /**
     * Ajoute la valeur passee en parametre au stock.
     * @param nb_add valeur à ajouter au stock.
     */
    public void addStock(int nb_add) {
        this.nbStock += nb_add;
    }

    //Getters and Setters

    /**
     * Retourne la reference de l'article.
     * @return reference de l'article.
     */
    public String getReference() {
        return reference;
    }

    /**
     * Change la valeur de la reference de l'article.
     * @param reference nouvelle valeur.
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * Retourne la marque de l'article.
     * @return marque de l'article.
     */
    public String getMarque() {
        return marque;
    }

    /**
     * Change la valeur de la marque de l'article.
     * @param marque valeur de la marque de l'article.
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * Retourne le modele de l'article.
     * @return modele de l'article.
     */
    public String getModele() {
        return modele;
    }

    /**
     * Change la valeur du modele de l'article.
     * @param modele modele de l'article.
     */
    public void setModele(String modele) {
        this.modele = modele;
    }

    /**
     * Retourne le prix par jour de location de l'article.
     * @return prix par jour de location de l'article.
     */
    public double getPrixJourLoc() {
        return prixJourLoc;
    }

    /**
     * Change la valeur du prix par jour de location.
     * @param prixJourLoc valeur du prix par jour de location.
     */
    public void setPrixJourLoc(double prixJourLoc) {
        this.prixJourLoc = prixJourLoc;
    }

    /**
     * Retourne le nombre d'articles en stock.
     * @return nombre d'article en stock.
     */
    public int getNbStock() {
        return nbStock;
    }

    /**
     * Change la valeur du nombre d'articles en stock.
     * @param nbStock nombre d'articles en stock.
     */
    public void setNbStock(int nbStock) {
        this.nbStock = nbStock;
    }


    @Override
    public String toString() {
        return "Article{" +
                "reference='" + reference + '\'' +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", prixJourLoc=" + prixJourLoc +
                ", nbStock=" + nbStock +
                '}';
    }
}
