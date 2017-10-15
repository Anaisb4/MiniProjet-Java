import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe modele.Location
 */
public class Location {

    private boolean enLocation;
    private HashMap<Article, Integer> listeArticle;
    private Date dateDebut;
    private Date dateFin;
    private Client client;
    private double montant;

    /**
     * Constructeur de la classe modele.Location mettant le statut "en location" à true par défaut
     *
     * @param listeArticle liste des articles inclus dans la location
     * @param dateDebut    date d edébut de location
     * @param dateFin      date de fin de location
     * @param client       client concerné par la location
     */
    public Location(HashMap<Article, Integer> listeArticle, Date dateDebut, Date dateFin, Client client) {
        this.enLocation = true;
        this.listeArticle = new HashMap<Article, Integer>();
        listeArticle.putAll(listeArticle);
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.client = client;
        this.montant = calculMontant();
    }

    /**
     * Constructeur de la classe modele.Location
     *
     * @param enLocation   statut de la location
     * @param listeArticle liste des articles inclus dans la location
     * @param dateDebut    date d edébut de location
     * @param dateFin      date de fin de location
     * @param client       client concerné par la location
     */
    public Location(boolean enLocation, HashMap<Article, Integer> listeArticle, Date dateDebut, Date dateFin, Client client) {
        this.enLocation = enLocation;
        this.listeArticle = new HashMap<Article, Integer>();
        listeArticle.putAll(listeArticle);
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

        double nbJours = calculerDuréeLoc(this.dateDebut, this.dateFin);

        for (Map.Entry<Article, Integer> entree : this.listeArticle.entrySet()) {

            //On récupère l'article loué et la quantitée louée.
            Article article = entree.getKey();
            int nbArticle = entree.getValue();

            montantTotal = article.getPrixJourLoc() * nbArticle * nbJours;

        }
        return montant;
    }

    /**
     * @param dateDebut date du début de location
     * @param dateFin   date de la fin de location
     * @return le nombre de jours séparant les deux dates
     */
    public double calculerDuréeLoc(Date dateDebut, Date dateFin) {
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
     * @return
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
}
