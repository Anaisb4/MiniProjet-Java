package vue;

import model.Magasin;
import model.Article;

import java.awt.*;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public StockList(Magasin magasin) {

        super("Stock List");
        setContentPane(stockListPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.magasin = magasin;
        this.stockList = this.magasin.getListe_article();
        String[] stockSList = prepareStockList(this.stockList);
        this.stockJList = new JList(stockSList);
        ListCellRenderer renderer = new StockCellRenderer();
        this.stockJList.setCellRenderer(renderer);
        this.stockJList.setVisibleRowCount(5);
        this.pane = new JScrollPane(this.stockJList);
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

    public String[] prepareStockList(LinkedList<Article> listeStock) {
        String stocks[] = new String[listeStock.size()];
        Article stockTmp;
        StringBuilder strBuilder;

        for (int cpt = 0; cpt < listeStock.size(); cpt++) {
            strBuilder = new StringBuilder("");
            stockTmp = listeStock.get(cpt);

            strBuilder.append("<html><br>");
            strBuilder.append("Article n°: " + stockTmp.getReference() + " " + this.space + "  " + stockTmp.getMarque() + this.space + stockTmp.getModele());
            strBuilder.append("<br>");
            strBuilder.append("Tel: " + stockTmp.getPrixJourLoc() + " € / Jours de location");
            strBuilder.append("<br><br></html>");
            stocks[cpt] = strBuilder.toString();
        }

        return stocks;
    }
}

class StockCellRenderer extends JLabel implements ListCellRenderer {

    private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

    public StockCellRenderer() {
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