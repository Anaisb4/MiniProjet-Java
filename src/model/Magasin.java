package model;

import com.sun.deploy.config.WebStartConfig;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Anais on 19/09/2017.
 */
public class Magasin {
    private LinkedList<Client> listeClients;
    private HashMap<Client, LinkedList<Location>> liste_locations;
    private LinkedList<Article> liste_article;


    //Constructeurs

    public Magasin(LinkedList<Client> listeClients, HashMap<Client, LinkedList<Location>> liste_locations, LinkedList<Article> liste_article) {
        this.listeClients = listeClients;
        this.liste_locations = liste_locations;
        this.liste_article = liste_article;
    }

    public Magasin(LinkedList<Article> liste_article) {
        this.liste_article = liste_article;
        this.listeClients = new LinkedList<Client>();
        this.liste_locations = new HashMap<Client, LinkedList<Location>>();
    }

    public Magasin() {
        this.listeClients = new LinkedList<Client>();
        this.liste_locations = new HashMap<Client, LinkedList<Location>>();
        this.liste_article = new LinkedList<Article>();
    }

    //Getters and Setters

    public LinkedList<Client> getListeClients() {
        return listeClients;
    }

    public void setListeClients(LinkedList<Client> listeClients) {
        this.listeClients = listeClients;
    }

    public HashMap<Client, LinkedList<Location>> getListe_locations() {
        return liste_locations;
    }

    public void setListe_locations(HashMap<Client, LinkedList<Location>> liste_locations) {
        this.liste_locations = liste_locations;
    }

    public LinkedList<Article> getListe_article() {
        return liste_article;
    }

    public void setListe_article(LinkedList<Article> liste_article) {
        this.liste_article = liste_article;
    }


    //Méthodes de la classe
//
    public void ajouterArticle(Article article) {
        this.liste_article.add(article);
    }

    public void ajouterClient(Client client) {
        this.listeClients.add(client);
    }

    public LinkedList<Location> getLocClient(Client client) {
        LinkedList<Location> listeLocEnC = new LinkedList<Location>();
        if (this.listeClients.contains(client)) {
            if (this.liste_locations.containsKey(client)) {
                for (Location loc : this.liste_locations.get(client)) {
                    if (loc.isEnLocation() == true) {
                        listeLocEnC.add(loc);
                    }
                }
            }
        } else {
            System.out.println("Le client n'existe pas.");
        }

        return listeLocEnC;
    }

    private int getDisponibilite(Article art) {
        return art.getNbStock();
    }

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
        //On re-parcours notre liste pour soustraire du stock ce qui va être louer
        for (Map.Entry<Article, Integer> liste : listeArt.entrySet()) {
            Article art = liste.getKey();
            Integer nbArt = liste.getValue();
            art.subStock(nbArt);
        }

        //On créer la location
        Location newLocation = new Location(true, listeArt, dateDeb, dateFin, client);
        LinkedList<Location> newLocCl = this.getLocClient(client);
        newLocCl.push(newLocation);
        this.liste_locations.put(client, newLocCl);
        return true;
    }

    public void restituerLocation(Client client, Location loc) {
        if (this.liste_locations.containsKey(client)) {
            LinkedList<Location> listeLoc = this.getLocClient(client);
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