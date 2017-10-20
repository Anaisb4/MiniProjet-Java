package model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


/**
 * Created by Anais BESSON and Victor FAVREAU on 18/10/2017.
 */
public class Magasin {
    private LinkedList<Client> listeClients;
    private HashMap<Client, LinkedList<Location>> liste_locations;
    private LinkedList<Article> liste_article;


    //Constructeurs

    /**
     * Constructeur de la classe magasin
     * @param listeClients liste des clients
     * @param liste_locations liste de slocations
     * @param liste_article liste des articles
     */
    public Magasin(LinkedList<Client> listeClients, HashMap<Client, LinkedList<Location>> liste_locations, LinkedList<Article> liste_article) {
        this.listeClients = listeClients;
        this.liste_locations = liste_locations;
        this.liste_article = liste_article;
    }

    /**
     * Constructeur de la classe magasin
     * @param liste_article liste d'articles
     */
    public Magasin(LinkedList<Article> liste_article) {
        this.liste_article = liste_article;
        this.listeClients = new LinkedList<Client>();
        this.liste_locations = new HashMap<Client, LinkedList<Location>>();
    }

    /**
     * Constructeur de la classe magasin
     */
    public Magasin() {
        this.listeClients = new LinkedList<Client>();
        this.liste_locations = new HashMap<Client, LinkedList<Location>>();
        this.liste_article = new LinkedList<Article>();
    }

    //Getters and Setters

    /**
     * Retourne la liste des locations
     * @return liste des locations
     */
    public LinkedList<Location> getLocations()
    {
        LinkedList<Location> listLocations = new LinkedList<Location>();

        for (Map.Entry<Client, LinkedList<Location>> entree : this.liste_locations.entrySet()) {

            LinkedList<Location> locaList = entree.getValue();

            for(Location location:locaList) {
                listLocations.add(location);
            }

        }

        return listLocations;
    }

    /**
     * Retourne la liste des clients
     * @return liste des clients
     */
    public LinkedList<Client> getListeClients() {
        return listeClients;
    }

    /**
     * Modifie la liste des clients
     * @param listeClients nouvelle liste des clients
     */
    public void setListeClients(LinkedList<Client> listeClients) {
        this.listeClients = listeClients;
    }

    /**
     * Retourne la liste des locations
     * @return liste des locations
     */
    public HashMap<Client, LinkedList<Location>> getListe_locations() {
        return liste_locations;
    }

    /**
     * Modifie la liste des locations
     * @param liste_locations liste des locations
     */
    public void setListe_locations(HashMap<Client, LinkedList<Location>> liste_locations) {
        this.liste_locations = liste_locations;
    }

    /**
     * Retourne la liste des articles
     * @return liste des articles
     */
    public LinkedList<Article> getListe_article() {
        return liste_article;
    }

    /**
     * Modifie la liste des articles
     * @param liste_article liste des articles
     */
    public void setListe_article(LinkedList<Article> liste_article) {
        this.liste_article = liste_article;
    }


    //Méthodes de la classe
    /**
     * Ajoute un article à la liste des articles
     * @param article article à ajouter
     */
    public void ajouterArticle(Article article) {
        this.liste_article.add(article);
    }

    /**
     * Ajoute un client à la liste des clients
     * @param client Client à ajouter
     */
    public void ajouterClient(Client client) {
        this.listeClients.add(client);
    }

    /**
     * Récupère la liste des locations d'un client
     * @param client client concerné
     * @param all Toutes les locations ou juste les locations actives
     * @return liste des locations du client
     */
    public LinkedList<Location> getLocClient(Client client, boolean all) {
        LinkedList<Location> listeLocEnC = new LinkedList<Location>();
        if (this.listeClients.contains(client)) {
            if (this.liste_locations.containsKey(client)) {
                for (Location loc : this.liste_locations.get(client)) {

                    if(all)
                    {
                        listeLocEnC.add(loc);
                    }
                    else
                    {
                        if (loc.isEnLocation() == true) {
                            listeLocEnC.add(loc);
                        }
                    }

                }
            }
        } else {
            System.out.println("Le client n'existe pas.");
        }

        return listeLocEnC;
    }


    /**
     * Verifie la disponibilité d'un article
     * @param art Article à vérifier
     * @return nombre d'articles disponibles
     */
    private int getDisponibilite(Article art) {
        return art.getNbStock();
    }

    /**
     * Loue un article
     * @param client client concerné
     * @param listeArt liste d'articles
     * @param dateDeb date de début d ela location
     * @param dateFin date de la fin de location
     * @return true: ajout réussi; false: erreur
     */
    public boolean louerArticle(Client client, HashMap<Article, Integer> listeArt, Date dateDeb, Date dateFin) {
        //Si le client n'existe pas encore dans la base de données on l'ajoute
        if (!this.listeClients.contains(client)) {
            System.out.println("Le client n'existait pas, il est donc ajouté à la base de données.");
            this.ajouterClient(client);
        }

        for (Map.Entry<Article, Integer> liste : listeArt.entrySet()) {
            Article art = liste.getKey();
            Integer nbArt = liste.getValue();
            //on vérifie que l'article existe dans le magasin

            if (!this.liste_article.contains(art)) {
                System.out.println("Impossible de louer l'article puisqu'il n'existe pas dans le magasin.");
                return false;
            }

            //On vérifie qu'il y a assez de quantité disponible
            if (nbArt > getDisponibilite(art)) {
                System.out.println("Impossible de louer l'article puisqu'il n'y a pas assez de stock (reste " + getDisponibilite(art) + ").");
                return false;
            }
        }
        //On re-parcours notre liste pour soustraire du stock ce qui va être loué
        for (Map.Entry<Article, Integer> liste : listeArt.entrySet()) {
            Article art = liste.getKey();
            Integer nbArt = liste.getValue();
            art.subStock(nbArt);
        }

        //On créer la location
        Location newLocation = new Location(String.valueOf(this.getLocations().size()+1),true, listeArt, dateDeb, dateFin, client);

        LinkedList<Location> newLocCl = this.getLocClient(client, true);

        newLocCl.add(newLocation);
        this.liste_locations.put(client, newLocCl);
        return true;
    }

    /**
     * Restitue une location
     * @param client client concerné
     * @param loc location concerné
     */
    public void restituerLocation(Client client, Location loc) {
        if (this.liste_locations.containsKey(client)) {
            LinkedList<Location> listeLoc = this.getLocClient(client, false);
            if (listeLoc.contains(loc)) {
                loc.rendreMateriel();
                enregistrerRestitution(loc);
            } else {
                System.out.println("La location n'existe pas.");
            }
        } else {
            System.out.println("Ce client ne possède aucune location.");
        }
    }

    /**
     * Enregistrer la restitution d'un article dans le fichier mensuelle de location
     * Si le fichier mensuelle à déjà précédemment été créer on écris dans le même fichier
     * Sinon on créer un nouveau fichier et on écris dans celui-ci
     *
     * @param loc La location qui est restituée
     */
    public void enregistrerRestitution(Location loc) {
        //Enregistrement dans le fichier du mois de restitution la location
        //On recherche si le fichier du mois à été crée si oui on écris dedans sinon on en créer un nouveau
        int moisRest = loc.getDateFin().getMonth();
        int anneeRest = loc.getDateFin().getYear();
        String file_path = "data/" + anneeRest + moisRest + ".txt";
        File fichier = new File(file_path);
        //Si le fichier n'existe pas on en créer un nouveau
        if (!fichier.exists()) {
            try {
                fichier.createNewFile();
            } catch (IOException e) {
                System.out.println("Ce fichier existe déjà.\n");
                e.printStackTrace();
            }
        }

        try {
            //Récupération des anciennes locations
            DataInputStream read_file = new DataInputStream(new FileInputStream(file_path));
            LinkedList<String> lines = new LinkedList<>();
            while (read_file.available() > 0) {
                lines.add(read_file.readUTF());
            }
            read_file.close();

            //Ecriture de la nouvelle location
            DataOutputStream write_file = new DataOutputStream(new FileOutputStream(file_path));
            lines.add(loc.toString() + "\n");
            for (String line : lines) {
                write_file.writeUTF(line);
            }
            write_file.close();


        } catch (IOException e) {
            System.out.println("Ce fichier n'existe pas ou il est impossible d'écrire à l'intérieur.\n");
            e.printStackTrace();
        }
    }

    /**
     * Calcule pour un mois donné la recette totale.
     * @param mois mois concerné
     * @param annee année concernée
     * @return recette totale pour le mois donné
     */
    public double calcMensuel(int mois, int annee){
        String file_path = "data/"+annee+""+mois+".txt";
        File fichier = new File(file_path);
        double ca = 0.0;
        //Si le fichier existe on parcours le fichier pour calculer le ca du mois
        if (fichier.exists()) {
            try {
                //Récupération des anciennes locations
                DataInputStream read_file = new DataInputStream(new FileInputStream(file_path));
                while (read_file.available() > 0) {
                    String line = read_file.readUTF();
                    Double mt=Double.parseDouble(line.substring(line.indexOf("au prix de ")+11,line.indexOf("€")));
                    ca+= mt;
                }
                read_file.close();

            } catch (IOException e) {
                System.out.println("Ce fichier n'existe pas ou il est impossible d'écrire à l'intérieur.\n");
                e.printStackTrace();
            }
        }

        return (double) Math.round(ca * 100) / 100;
    }
}