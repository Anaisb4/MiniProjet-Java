package vue;

import model.Article;
import model.Magasin;
import model.Client;

import java.awt.*;
import java.util.LinkedList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Anais BESSON and Victor FAVREAU on 18/10/2017.
 */
public class ClientsList extends JFrame {
    private JPanel clientsListPanel;

    private JButton nouveauButton;
    private JButton consulterButton;
    private JButton retourButton;
    private JScrollPane pane;
    private JPanel buttonPane;

    protected JList clientJList;
    private LinkedList<Client> clientsList;
    private Magasin magasin;
    String space = "&nbsp;&nbsp;&nbsp;";

    public ClientsList() {

        super("Clients List");
        setContentPane(clientsListPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this.getParent());
        this.magasin = Main.magasin;
        this.clientsList = this.magasin.getListeClients();
        this.clientJList.setVisibleRowCount(5);
        DefaultListModel modelList= new DefaultListModel();
        this.clientJList.setModel(modelList);
        StringBuilder strBuilder;
        for(Client client: clientsList){
            strBuilder = new StringBuilder("");
            strBuilder.append("<html><br>");
            strBuilder.append(this.space + "Client n°: " + client.getNumClient() + " " + this.space + "  " + client.getNom() + " " + client.getPrenom() + this.space);
            strBuilder.append("<br>");
            strBuilder.append(this.space + "Tel: " + client.getTelephone() + " " + this.space + "  Mail: " + client.geteMail() + this.space);
            strBuilder.append("<br><br></html>");
            modelList.addElement(strBuilder.toString());
        }

        pack();

        nouveauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame createClient = new CreateClient();
                setVisible(false);
                createClient.setVisible(true);
            }
        });

        consulterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(clientJList.getSelectedValue() != null)
                {
                    Client clientTmp = clientsList.get(clientJList.getSelectedIndex());

                    JFrame main = new AfficheClient(clientTmp);
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