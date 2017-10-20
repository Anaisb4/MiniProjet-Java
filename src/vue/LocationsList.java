package vue;

import model.Article;
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
        setLocationRelativeTo(null);
        this.magasin = Main.magasin;
        this.locationsListe = Main.magasin.getLocations();
        String[] locationsList = prepareLocationsList(this.locationsListe);
        this.locationsJList = new JList(locationsList);
        ListCellRenderer renderer = new LocationsCellRenderer();
        this.locationsJList.setCellRenderer(renderer);
        this.locationsJList.setVisibleRowCount(5);
        this.pane = new JScrollPane(this.locationsJList);
        add(pane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.SOUTH);
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

    public String[] prepareLocationsList(LinkedList<Location> listeLocations) {
        String locations[] = new String[listeLocations.size()];
        Location locationTmp;
        StringBuilder strBuilder;

        for (int cpt = 0; cpt < listeLocations.size(); cpt++) {
            strBuilder = new StringBuilder("");
            locationTmp = listeLocations.get(cpt);

            boolean isActive = locationTmp.isEnLocation();
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
            strBuilder.append("Référence n°: " + locationTmp.getReference() + " " + this.space + "  " + locationTmp.getClient().getNom() + " " + locationTmp.getClient().getPrenom()+ this.space + "  Montant: " + locationTmp.getMontant()+ this.space + active + this.space);
            strBuilder.append("<br>");
            strBuilder.append("Date début: " + locationTmp.getDateDebut() + " " + this.space + "  Date fin: " + locationTmp.getDateFin() + this.space);
            strBuilder.append("<br><br></html>");
            locations[cpt] = strBuilder.toString();
        }

        return locations;
    }
}

class LocationsCellRenderer extends JLabel implements ListCellRenderer {

    private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

    public LocationsCellRenderer() {
        setOpaque(true);
        setIconTextGap(12);
    }

    public Component getListCellRendererComponent(JList list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        String entry = (String) value;

        setText(entry);
        if (isSelected) {
            setBackground(HIGHLIGHT_COLOR);
            setForeground(Color.white);
        } else {
            setBackground(Color.white);
            setForeground(Color.black);
        }
        return this;
    }
}