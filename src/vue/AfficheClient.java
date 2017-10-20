package vue;

import model.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private Client client;

    public AfficheClient(Client client)
    {
        this.client = client;
        this.setTitle("Client n°:" + client.getNumClient());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setContentPane(afficheClientPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        this.textFieldNClient.setText(this.client.getNumClient());
        this.textFieldNom.setText(this.client.getNom());
        this.textFieldPrenom.setText(this.client.getPrenom());
        this.textFieldTelephone.setText(this.client.getTelephone());
        this.textFieldMail.setText(this.client.geteMail());

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
