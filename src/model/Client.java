package model;

public class Client {

    private String numClient;
    private String nom;
    private String prenom;
    private int telephone;
    private String eMail;

    public Client(String numClient, String nom, String prenom, int telephone, String eMail) {
        this.numClient = numClient;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.eMail = eMail;
    }

    public String getNumClient() {
        return numClient;
    }

    public void setNumClient(String numClient) {
        this.numClient = numClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
