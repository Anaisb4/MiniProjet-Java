package model;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Anais BESSON and Victor FAVREAU on 18/10/2017.
 */
public class Location{

    private boolean enLocation;
    private HashMap<Article, Integer> listeArticle;
    private Date dateDebut;
    private Date dateFin;
    private Client client;
    private double montant;
    private String reference;

    /**
     * Constructeur de la classe modele.model.Location mettant le statut "en location" à true par défaut
     *
     * @param reference    reference de la location
     * @param listeArticle liste des articles inclus dans la location
     * @param dateDebut    date d edébut de location
     * @param dateFin      date de fin de location
     * @param client       client concerné par la location
     */
    public Location(String reference,HashMap<Article, Integer> listeArticle, Date dateDebut, Date dateFin, Client client) {
        this.reference = reference;
        this.enLocation = true;
        this.listeArticle = new HashMap<Article, Integer>();
        listeArticle.putAll(listeArticle);
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.client = client;
        this.montant = calculMontant();
    }

    /**
     * Constructeur de la classe modele.model.Location
     *
     * @param reference    reference de la location
     * @param enLocation   statut de la location
     * @param listeArticle liste des articles inclus dans la location
     * @param dateDebut    date de début de location
     * @param dateFin      date de fin de location
     * @param client       client concerné par la location
     */
    public Location(String reference, boolean enLocation, HashMap<Article, Integer> listeArticle, Date dateDebut, Date dateFin, Client client) {
        this.reference = reference;
        this.enLocation = enLocation;
        this.listeArticle = new HashMap<Article, Integer>();
        this.listeArticle.putAll(listeArticle);
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.client = client;
        this.montant = calculMontant();
    }

    /**
     * Calcul du montant de la location
     *
     * @return le montant de la location
     */
    public double calculMontant() {

        double montantTotal = 0;

        double nbJours = calculerDureeLoc(this.dateDebut, this.dateFin);

        for (Map.Entry<Article, Integer> entree : this.listeArticle.entrySet()) {

            //On récupère l'article loué et la quantitée louée.
            Article article = entree.getKey();
            int nbArticle = entree.getValue();

            montantTotal = article.getPrixJourLoc() * nbArticle * nbJours;

        }

        return (double) Math.round(montantTotal * 100) / 100;
    }

    /**
     * @param dateDebut date du début de location
     * @param dateFin   date de la fin de location
     * @return le nombre de jours séparant les deux dates
     */
    public double calculerDureeLoc(Date dateDebut, Date dateFin) {
        double result = Double.POSITIVE_INFINITY;
        if (dateDebut != null && dateFin != null) {

            final long MILLISECONDS_PER_DAY = 1000 * 60 * 60 * 24;
            Calendar aCal = Calendar.getInstance();
            aCal.setTime(dateDebut);
            long aFromOffset = aCal.get(Calendar.DST_OFFSET);
            aCal.setTime(dateFin);
            long aToOffset = aCal.get(Calendar.DST_OFFSET);
            long aDayDiffInMili = (dateFin.getTime() + aToOffset) - (dateDebut.getTime() + aFromOffset);
            result = ((double) aDayDiffInMili / MILLISECONDS_PER_DAY);
        }

        return result;
    }

    /**
     * Restitution du matériel
     */
    public void rendreMateriel() {
        this.enLocation = false;
    }

    /**
     * Retourne le statut de la location
     *
     * @return true = en location; false = n'est pas en location
     */
    public boolean isEnLocation() {
        return enLocation;
    }

    /**
     * Change le statut de la location
     *
     * @param enLocation nouveau statut de la location
     */
    public void setEnLocation(boolean enLocation) {
        this.enLocation = enLocation;
    }

    /**
     * Retourne la liste des articles
     *
     * @return liste des articles inclus dans la location
     */
    public HashMap<Article, Integer> getListeArticle() {
        return listeArticle;
    }

    /**
     * Change la liste d'articles inclus dans la location
     *
     * @param listeArticle la nouvelle liste d'articles
     */
    public void setListeArticle(HashMap<Article, Integer> listeArticle) {
        this.listeArticle = listeArticle;
    }

    /**
     * Retourne la date de début de location
     *
     * @return la date de début de location
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * Modifie la date de début de location
     *
     * @param dateDebut nouvelle date de début de location
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * Retourne la date de fin de location
     *
     * @return la date de fin de location
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * Modifie la date de fin de location
     *
     * @param dateFin nouvelle date de fin de location
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * Retourne le client concerné par la location
     *
     * @return le client concerné par la location
     */
    public Client getClient() {
        return client;
    }

    /**
     * Modifie le client concerné par la location
     *
     * @param client client concerné par la location
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * retourne le montant de la location
     *
     * @return montant de la location
     */
    public double getMontant() {
        return montant;
    }

    /**
     * modifie le montant de la location
     *
     * @param montant montant de la location
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * Affiche les valeurs de l'objet Location en cours
     * @return Retourne une chaîne représentant l'objet location
     */
    @Override
    public String toString() {
        String result = this.getClient().getNom()+" "+this.getClient().getPrenom() + "("+ this.getClient().getNumClient() +") a loué ";

        for(Map.Entry<Article,Integer> article : listeArticle.entrySet()){
            String nomArticle = article.getKey().getMarque().toUpperCase()+" "+article.getKey().getModele();
            int qte = article.getValue();
            result+= qte + " " + nomArticle+" ";
        }

        result+="du " + dateDebut.getDate() + "/"+ dateDebut.getMonth() + "/" + dateDebut.getYear();
        result+=" au "+ dateFin.getDate() + "/"+ dateFin.getMonth() + "/" + dateFin.getYear();
        result+=" au prix de "+this.montant+"€";

        return result;
    }
}
