package vue;

import model.Client;
import model.Location;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.LinkedList;


/**
 * Created by Anais BESSON and Victor FAVREAU on 18/10/2017.
 */
public class AfficheClient extends JFrame{
    private JPanel afficheClientPanel;
    private JButton retourButton;
    private JPanel buttonPane;
    private JLabel labelNClient;
    private JTextField textFieldNClient;
    private JLabel labelNom;
    private JTextField textFieldNom;
    private JLabel labelPrenom;
    private JTextField textFieldPrenom;
    private JLabel labelTelephone;
    private JTextField textFieldTelephone;
    private JLabel labelMail;
    private JTextField textFieldMail;
    private JLabel labelListLocationClient;
    private Client client;
    private String space = "&nbsp;&nbsp;&nbsp;";

    public AfficheClient(Client client)
    {
        this.client = client;
        this.setTitle("Client n°:" + client.getNumClient());

        this.textFieldNClient.setText(this.client.getNumClient());
        this.textFieldNom.setText(this.client.getNom());
        this.textFieldPrenom.setText(this.client.getPrenom());
        this.textFieldTelephone.setText(this.client.getTelephone());
        this.textFieldMail.setText(this.client.geteMail());

        LinkedList<Location> listLocation = Main.magasin.getLocClient(this.client, false);

        StringBuilder strBuilder = new StringBuilder("<html>");

        for (Location location : listLocation) {

            Date dateBeg = location.getDateDebut();
            Date dateEnd = location.getDateFin();

            String sDateBeg = dateBeg.getDate() + "/" + dateBeg.getMonth() + "/" + dateBeg.getYear();
            String sDateEnd = dateEnd.getDate() + "/" + dateEnd.getMonth() + "/" + dateEnd.getYear();

            strBuilder.append("N°: " + location.getReference() + space + "Du: " +sDateBeg + space + "Au:" + sDateEnd + space + "Montant: " + location.getMontant() +"€"+ space +"<br>");
        }

        strBuilder.append("</html>");
        labelListLocationClient.setText(strBuilder.toString());

        this.setContentPane(afficheClientPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this.getParent());
        this.setResizable(false);

        pack();

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
