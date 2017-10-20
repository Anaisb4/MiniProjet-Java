package vue;

import model.Article;
import model.Client;
import model.Magasin;
import model.Location;

import java.awt.*;
import java.util.LinkedList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LocationsList extends JFrame {
    private JPanel locationsListPanel;
    private JButton nouveauButton;
    private JButton consulterButton;
    private JButton retourButton;
    private JScrollPane pane;
    private JPanel buttonPane;

    private JList locationsJList;
    private LinkedList<Location> locationsListe;
    private Magasin magasin;
    String space = "&nbsp;&nbsp;&nbsp;";

    public LocationsList() {

        super("Locations List");
        setContentPane(locationsListPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this.getParent());
        this.magasin = Main.magasin;
        this.locationsListe = Main.magasin.getLocations();
        DefaultListModel modelList= new DefaultListModel();
        this.locationsJList.setModel(modelList);

        for(Location location: locationsListe){

            StringBuilder strBuilder = new StringBuilder("");
            boolean isActive = location.isEnLocation();
            String active;

            if(isActive)
            {
                active = "Actif: Oui";
            }
            else
            {
                active = "Actif: Non";
            }

            strBuilder.append("<html><br>");
            strBuilder.append(this.space + "Référence n°: " + location.getReference() + " " + this.space + "  " + location.getClient().getNom() + " " + location.getClient().getPrenom()+ this.space + "  Montant: " + location.getMontant()+ this.space + active + this.space);
            strBuilder.append("<br>");
            strBuilder.append(this.space + "Date début: " + location.getDateDebut() + " " + this.space + "  Date fin: " + location.getDateFin() + this.space);
            strBuilder.append("<br><br></html>");
            modelList.addElement(strBuilder.toString());
        }
        pack();

        nouveauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame main = new CreateLocation();
                setVisible(false);
                main.setVisible(true);
            }
        });

        consulterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(locationsJList.getSelectedValue() != null) {
                    Location locationTmp = locationsListe.get(locationsJList.getSelectedIndex());

                    JFrame main = new AfficheLocation(locationTmp);
                    setVisible(false);
                    main.setVisible(true);

                }
            }
        });

        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame main = new Main(magasin);
                setVisible(false);
                main.setVisible(true);
            }
        });
    }

}
