package vue;

import model.Magasin;
import model.Client;

import java.awt.*;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientsList extends JFrame{
    private JPanel clientsListPanel;

    private JButton nouveauButton;
    private JButton consulterButton;
    private JButton retourButton;
    private JScrollPane pane;
    private JPanel buttonPane;

    private JList clientJList;
    private LinkedList<Client> clientList;
    private Magasin magasin;
    String space = "&nbsp;&nbsp;&nbsp;";

    public ClientsList(Magasin magasin){

        super("Clients List");
        setContentPane(clientsListPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.magasin = magasin;
        this.clientList = this.magasin.getListeClients();

        String[] clientList = prepareClientList(this.clientList);

        this.clientJList = new JList(clientList);

        ListCellRenderer renderer = new ClientCellRenderer();

        this.clientJList.setCellRenderer(renderer);
        this.clientJList.setVisibleRowCount(10);
        this.pane = new JScrollPane(this.clientJList);


        add(pane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.SOUTH);


        pack();


        nouveauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        });

        consulterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



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

    public String[] prepareClientList(LinkedList<Client> listeClients)
    {
        String clients[] = new String[listeClients.size()];
        Client clientTmp;
        StringBuilder strBuilder;

        for(int cpt = 0 ; cpt < listeClients.size() ; cpt++)
        {
            strBuilder = new StringBuilder("");

            clientTmp = listeClients.get(cpt);

            strBuilder.append("<html><br>");
            strBuilder.append("Client n°: "+ clientTmp.getNumClient() +" "+ this.space +"  "+ clientTmp.getNom()+ " " + clientTmp.getPrenom());
            strBuilder.append("<br>");
            strBuilder.append("Tel: "+ clientTmp.getTelephone() +" "+ this.space +"  Mail: " + clientTmp.geteMail());
            strBuilder.append("<br><br></html>");

            clients[cpt] = strBuilder.toString();
        }

        return clients;
    }
}

class ClientCellRenderer extends JLabel implements ListCellRenderer {

    private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

    public ClientCellRenderer() {
        setOpaque(true);
        setIconTextGap(12);

    }

    public Component getListCellRendererComponent(JList list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus)
    {
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