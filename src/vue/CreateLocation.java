package vue;

import model.Article;
import model.Client;
import model.Location;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CreateLocation extends JFrame{

    private JLabel labelTelephone;
    private JLabel labelClients;
    private JTextField textFieldDateFin;
    private JLabel labelDateFin;
    private JTextField textFieldDateDebut;
    private JLabel labelDateDebut;
    private JButton retourButton;
    private JButton nouveauButton;
    private JPanel buttonPane;
    private JPanel createLocationPanel;
    private JComboBox comboBoxClients;
    private JList listeStock;
    private JScrollPane paneStock;
    private JButton ajouterButton;
    private JLabel labelArticlesList;
    private String space = "&nbsp;&nbsp;&nbsp;";
    private JScrollPane pane;
    private HashMap<Article, Integer> mapArticles;

    public CreateLocation()
    {
        this.mapArticles = new HashMap<>();

        this.setTitle("Création Location");
        this.setLocationRelativeTo(null);

        this.setContentPane(createLocationPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        LinkedList<Client> clients = Main.magasin.getListeClients();
        LinkedList<Article> articles = Main.magasin.getListe_article();

        DefaultListModel modelList= new DefaultListModel();
        this.listeStock.setModel(modelList);

        for(Article article: articles){
            modelList.addElement("<html>N°: " + article.getReference() + this.space + article.getModele() + this.space +article.getMarque() + this.space + "x1"+ this.space +"</html>");
        }

        for(Client client: clients)
        {
            this.comboBoxClients.addItem(client.getNom() + " " + client.getPrenom());
        }

        pack();

        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Article article = articles.get(listeStock.getSelectedIndex());
                int value = 1;


                if(mapArticles.containsKey(article))
                {
                    value = mapArticles.get(article);
                    value++;
                    mapArticles.put(article, value);
                }

                else
                {
                    mapArticles.put(article, value);
                }

                StringBuilder strBuilder = new StringBuilder("<html>");

                for (Map.Entry<Article, Integer> liste : mapArticles.entrySet()) {
                    Article art = liste.getKey();
                    Integer nbArt = liste.getValue();
                    strBuilder.append("N°: " + art.getReference() + space + art.getMarque() + space + art.getModele() + space + "x" + nbArt + "<br>");
                }

                strBuilder.append("</html>");

                labelArticlesList.setText(strBuilder.toString());
            }
        });

        nouveauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
                Client clientTmp = clients.get(comboBoxClients.getSelectedIndex());

                String dateDeb = textFieldDateDebut.getText();
                String dateFin = textFieldDateFin.getText();

                try {
                    Date dateBegF = formatter.parse(dateDeb);
                    Date dateEndF = formatter.parse(dateFin);
                    Main.magasin.louerArticle(clientTmp, mapArticles, dateBegF, dateEndF);

                    JFrame main = new Main(Main.magasin);
                    setVisible(false);
                    main.setVisible(true);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

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
