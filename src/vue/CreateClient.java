package vue;

import model.Client;
import model.Magasin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Anais BESSON and Victor FAVREAU on 18/10/2017.
 */
public class CreateClient extends JFrame{
    private JPanel buttonPane;
    private JPanel createClientPanel;
    private JTextField textFieldNClient;
    private JTextField textFieldNom;
    private JTextField textFieldPrenom;
    private JTextField textFieldTelephone;
    private JTextField textFieldMail;
    private JButton nouveauButton;
    private JButton retourButton;
    private JLabel labelNClient;
    private JLabel labelNom;
    private JLabel labelPrenom;
    private JLabel labelTelephone;
    private JLabel labelMail;


    public CreateClient()
    {
        this.setTitle("Création client");
        setLocationRelativeTo(this.getParent());
        this.setResizable(false);
        this.setContentPane(createClientPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        nouveauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Client client = new Client(textFieldNClient.getText(), textFieldNom.getText(), textFieldPrenom.getText(), textFieldTelephone.getText(), textFieldMail.getText());
                Main.magasin.ajouterClient(client);
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
