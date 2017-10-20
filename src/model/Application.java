package model;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Anais on 15/10/2017.
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("### Création d'articles diverses et ajout des articles au magasin ###");
        Magasin magasin = new Magasin();
        LitMedicalise lit = new LitMedicalise("01","Lit","NumerOne", 85, 3, 95, 90, 180, 75, true, false);
        FauteuilRoulant fauteuil = new FauteuilRoulant("02","Fauteuil", "NumberTwo", 55, 3, 80, 100);
        MatelasAir matelas = new MatelasAir("03", "MatelasAir", "NumberThree", 20, 5, 120, 90, 180, 60, 5);
        magasin.ajouterArticle(fauteuil);
        magasin.ajouterArticle(lit);
        magasin.ajouterArticle(matelas);
        for (Article art: magasin.getListe_article()) {
            System.out.println(art);
        }

        System.out.println("### Création de deux nouveaux clients dans le magasin ###");
        Client c1 = new Client("001","Favreau", "Victor","0234564645","vfavreau@outlook.fr");
        Client c2 = new Client("002","Besson","Anais","0245785452","abesson@outlook.fr");
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        magasin.ajouterClient(c1);
        magasin.ajouterClient(c2);

        System.out.println("### Location par c1 de tous le stock de lit médicalisé et d'un fauteuil ###");
        HashMap<Article,Integer> listeArt = new HashMap<Article,Integer>();
        listeArt.put(lit,3);
        listeArt.put(fauteuil,1);
        magasin.louerArticle(c1,listeArt,new Date(2017,10,10), new Date(2017,10,12));

        System.out.println("### Location par c2 d'un lit médicalisé (génère une erreur) et d'un matelas ###");
        HashMap<Article,Integer> listeArtC2 = new HashMap<Article, Integer>();
        listeArtC2.put(lit,1);
        listeArtC2.put(matelas,1);
        magasin.louerArticle(c2,listeArtC2,new Date(2017,10,10), new Date(2017,10,12));

        System.out.println("### Récupération et affichage des locations en cours de c1 : ###");
        for (Location location: magasin.getLocClient(c1, false)) {
            System.out.println(location);
        }

        System.out.println("### Restitution par c1 de sa location et écriture dans le fichier de novembre 2017 ###");
        Location loc = magasin.getLocClient(c1, false).getFirst();
        magasin.restituerLocation(c1,loc);

        System.out.println("### Trie des articles par référence : ###");
        Collections.sort(magasin.getListe_article(),ArticlesCompare.compParRef);
        for (Article art: magasin.getListe_article()) {
            System.out.println(art);
        }

        System.out.println("### Trie des articles par prix : ###");
        Collections.sort(magasin.getListe_article(),ArticlesCompare.compParPrix);
        for (Article art: magasin.getListe_article()) {
            System.out.println(art);
        }

        System.out.println("### Trie des articles par marque : ###");
        Collections.sort(magasin.getListe_article(),ArticlesCompare.compParMarque);
        for (Article art: magasin.getListe_article()) {
            System.out.println(art);
        }

        System.out.println("### Trie des articles par modèle : ###");
        Collections.sort(magasin.getListe_article(),ArticlesCompare.compParModele);
        for (Article art: magasin.getListe_article()) {
            System.out.println(art);
        }

        System.out.println("### Calcul du montant total des recettes du magasin sur Octobre 2017 ###");
        System.out.println("Recettes totales 11/2017 : "+magasin.calcMensuel(10,2017));
    }
}
