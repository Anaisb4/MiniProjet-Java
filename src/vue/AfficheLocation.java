package vue;

import model.Article;
import model.Client;
import model.Location;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


/**
 * Created by Anais BESSON and Victor FAVREAU on 18/10/2017.
 */
public class AfficheLocation extends JFrame{
    private JPanel afficheLocationPanel;
    private JPanel buttonPane;
    private JButton restituerButton;
    private JButton retourButton;
    private JTextField textFieldDateDebut;
    private JLabel labelDateFin;
    private JTextField textFieldDateFin;
    private JLabel labelClients;
    private JLabel labelDateDebut;
    private JLabel labelTelephone;
    private JLabel labelArticlesList;
    private JTextField textFieldClient;
    private String space = "&nbsp;&nbsp;&nbsp;";
    private Location location;

    public AfficheLocation(Location location){

        super("Location N°:" + location.getReference());
        this.location = location;
        Date dateDebut = this.location.getDateDebut();
        Date dateFin = this.location.getDateFin();
        String sDateDebut = dateDebut.getDate() + "/" + dateDebut.getMonth() + "/" + dateDebut.getYear();
        String sDateFin = dateFin.getDate() + "/" + dateFin.getMonth() + "/" + dateFin.getYear();

        this.textFieldDateDebut.setText(sDateDebut);
        this.textFieldDateFin.setText(sDateFin);

        Client client = this.location.getClient();
        this.textFieldClient.setText(client.getNom() + " " + client.getPrenom());

        HashMap<Article, Integer> mapArticles = this.location.getListeArticle();
        StringBuilder strBuilder = new StringBuilder("");

        strBuilder.append("<html>");

        for (Map.Entry<Article, Integer> liste : mapArticles.entrySet()) {
            Article art = liste.getKey();
            Integer nbArt = liste.getValue();
            strBuilder.append("N°: " + art.getReference() + space + art.getMarque() + space + art.getModele() + space + "x" + nbArt + space + "<br>");
        }

        strBuilder.append("</html>");

        this.labelArticlesList.setText(strBuilder.toString());
        this.setTitle("Location n°:" + location.getReference());

        setContentPane(afficheLocationPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this.getParent());
        this.setResizable(false);

        pack();

        restituerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main.magasin.restituerLocation(client, location);

                JFrame main = new Main(Main.magasin);
                setVisible(false);
                main.setVisible(true);
            }
        });

        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame main = new Main(Main.magasin);
                setVisible(false);
                main.setVisible(true);
            }
        });



    }

}
