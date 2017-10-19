package vue;

import model.Magasin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{
   // private JButton clickMeButton;
    private JPanel mainPanel;
    private JButton locationsButton;
    private JButton clientsButton;
    private JButton stockButton;
    protected static Magasin magasin;

    public Main(Magasin magasin){

        this.magasin = magasin;

        this.setTitle("Magasin");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        locationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame locationsList = new LocationsList();
                setVisible(false);
                locationsList.setVisible(true);
            }
        });

        clientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame clientList = new ClientsList();
                setVisible(false);
                clientList.setVisible(true);
            }
        });

        stockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame stockList = new StockList();
                setVisible(false);
                stockList.setVisible(true);
            }
        });

        setVisible(true);
    }



}
