package model;

import java.util.Comparator;

/**
 * Created by Anais on 18/10/2017.
 */
public class ArticlesCompare {

    public static Comparator compParRef = new Comparator(){
        @Override
        public int compare(Object o1, Object o2) {
            if(o1==null || o2==null) {
                return 0;
            }

            Article art1 = (Article) o1;
            Article art2 = (Article) o2;
            return (art1.getReference().compareTo(art2.getReference()));
        }
    };

    public static Comparator compParMarque = new Comparator(){

        @Override
        public int compare(Object o1, Object o2) {
            if(o1==null || o2==null) {
                return 0;
            }

            Article art1 = (Article) o1;
            Article art2 = (Article) o2;
            return (art1.getMarque().compareTo(art2.getMarque()));
        }
    };

    public static Comparator compParModele = new Comparator(){

        @Override
        public int compare(Object o1, Object o2) {
            if(o1==null || o2==null) {
                return 0;
            }

            Article art1 = (Article) o1;
            Article art2 = (Article) o2;
            return (art1.getModele().compareTo(art2.getModele()));
        }
    };

    public static Comparator compParPrix = new Comparator(){

        @Override
        public int compare(Object o1, Object o2) {
            if(o1==null || o2==null) {
                return 0;
            }

            Article art1 = (Article) o1;
            Article art2 = (Article) o2;
            if(art1.getPrixJourLoc()>=art2.getPrixJourLoc()){
                return 1;
            } else {
                return -1;
            }
        }
    };
}
