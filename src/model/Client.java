package model;


/**
 * Created by Anais BESSON and Victor FAVREAU on 18/10/2017.
 */
public class Client {

    private String numClient;
    private String nom;
    private String prenom;
    private String telephone;
    private String eMail;

    /**
     * Constructeur de la classe Client
     * @param numClient numero de client
     * @param nom nom du client
     * @param prenom prenom du client
     * @param telephone telephone du client
     * @param eMail email du client
     */
    public Client(String numClient, String nom, String prenom, String telephone, String eMail) {
        this.numClient = numClient;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.eMail = eMail;
    }

    /**
     * Retourne le numero de client
     * @return numero de client
     */
    public String getNumClient() {
        return numClient;
    }

    /**
     * Change la valeur du numero de client
     * @param numClient nouveau numero de client
     */
    public void setNumClient(String numClient) {
        this.numClient = numClient;
    }

    /**
     * Retourne le nom du Client
     * @return nom du Client
     */
    public String getNom() {
        return nom;
    }

    /**
     * Change le nom du Client
     * @param nom nouveau nom du Client
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le prenom du client
     * @return prenom du client
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Change le prenom du client
     * @param prenom nouveau prenom du client
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Retourne le téléphone du client
     * @return téléphone du client
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Change le téléphone du client
     * @param telephone nouveau téléphone du client
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Retourne le mail du client
     * @return mail du client
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * Change le mail du client
     * @param eMail nouveau mail du client
     */
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "Client{" +
                "numClient='" + numClient + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
