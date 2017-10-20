package vue;

import model.Client;
import model.Magasin;
import model.Article;

import java.awt.*;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Anais BESSON and Victor FAVREAU on 18/10/2017.
 */
public class StockList extends JFrame {
    private JPanel stockListPanel;
    private JButton nouveauButton;
    private JButton consulterButton;
    private JButton retourButton;
    private JScrollPane pane;
    private JPanel buttonPane;
    private JList stockJList;
    private LinkedList<Article> stockList;
    private Magasin magasin;
    String space = "&nbsp;&nbsp;&nbsp;";

    public StockList() {

        super("Stock List");
        setContentPane(stockListPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this.getParent());
        this.magasin = Main.magasin;
        this.stockList = this.magasin.getListe_article();

        DefaultListModel modelList= new DefaultListModel();
        this.stockJList.setModel(modelList);
        StringBuilder strBuilder;
        for(Article article: stockList){
            strBuilder = new StringBuilder("");
            strBuilder.append("<html><br>");
            strBuilder.append(this.space +"Article n°: " + article.getReference() + " " + this.space + "  " + article.getMarque() + this.space + article.getModele());
            strBuilder.append("<br>");
            strBuilder.append(this.space + "Tel: " + article.getPrixJourLoc() + " € / Jours de location" + this.space + "Stock: " + article.getNbStock());
            strBuilder.append("<br><br></html>");
            modelList.addElement(strBuilder.toString());
        }

        this.stockJList.setVisibleRowCount(5);
        pack();

        nouveauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame main = new CreateStock();
                setVisible(false);
                main.setVisible(true);

            }
        });

        consulterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(stockJList.getSelectedValue() != null)
                {
                    Article articleTmp = stockList.get(stockJList.getSelectedIndex());

                    JFrame main = new AfficheStock(articleTmp);
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