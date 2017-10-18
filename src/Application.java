import model.Magasin;
import model.Client;
import vue.Main;

public class Application{

    public static void main(String[] args){

        Magasin magasin = new Magasin();

        magasin.addClient(new Client("156451213854", "FABIEN", "Henri", "0619506806", "fabienherny@gmail.com"));
        magasin.addClient(new Client("515465121354", "DUPOND", "Patrick", "0615606806", "dupondpatrick@gmail.com"));
        magasin.addClient(new Client("898554632135", "THAIM", "Boubou", "0619506980", "thaimbobou@gmail.com"));


        Main myForm = new Main(magasin);




    }
}
