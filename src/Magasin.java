import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Anais on 19/09/2017.
 */
public class Magasin {
    private LinkedList<Client> listeClients;
    private HashMap<Client, LinkedList<Location>> liste_locations;
    private LinkedList<Article> liste_article;

    public Magasin(LinkedList<Client> listeClients, HashMap<Client, LinkedList<Location>> liste_locations, LinkedList<Article> liste_article){
        this.listeClients = listeClients;
        this.liste_locations = liste_locations;
        this.liste_article = liste_article;
    }

    public Magasin(LinkedList<Article> liste_article){
        this.liste_article = liste_article;
        this.listeClients=new LinkedList<Client>();
        this.liste_locations = new HashMap<Client, LinkedList<Location>>();
    }

    public Magasin(){
        this.listeClients=new LinkedList<Client>();
        this.liste_locations = new HashMap<Client, LinkedList<Location>>();
        this.liste_article=new LinkedList<Article>();
    }

    public LinkedList<Location> getLocClient(Client client){
        if(this.liste_locations.containsKey(client)){
            return this.liste_locations.get(client);
        }
        return new LinkedList<Location>();
    }

    private int getDisponibilite(Article art){
        return art.getNbStock();
    }

    public boolean louerArticle(Client client, HashMap<Article, Integer> listeArt, Date dateDeb, Date dateFin){
        for(Map.Entry<Article, Integer> liste : listeArt.entrySet()) {
            Article art = liste.getKey();
            Integer nbArt = liste.getValue();
            if(getDisponibilite(art)>nbArt){
                return false;
            }
        }
        Location newLocation = new Location(true, listeArt, dateDeb, dateFin, client);
        LinkedList<Location> newLocCl = this.getLocClient(client);
        newLocCl.push(newLocation);
        this.liste_locations.put(client, newLocCl);
        return true;
    }

    public void restituerArticle(Location loc){
        loc.rendreMateriel();
    }

    public boolean enregistrerMois(int mois, int annee){
        if(mois>=1 && mois <=12){
            //On recherche dans toutes les locations celle ayant une date de fin dont le mois et l'année correspondent
        }
        return false;
    }
}
