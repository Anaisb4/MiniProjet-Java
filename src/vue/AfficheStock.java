package vue;

import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfficheStock extends JFrame{
    private JButton retourButton;
    private JPanel buttonPane;
    private JPanel afficheStockPanel;
    private JLabel labelTArticle;
    private JTextField textFieldTArticle;
    private JLabel labelPMax;
    private JTextField textFieldPMax;
    private JLabel labelLongueur;
    private JTextField textFieldLongueur;
    private JTextField textFieldLargeur;
    private JLabel labelLargeur;
    private JLabel labelHauteur;
    private JTextField textFieldHauteur;
    private JLabel labelElectrique;
    private JLabel labelDouble;
    private JLabel labelAjustable;
    private JLabel labelTmpGonflage;
    private JTextField textFieldTmpGonflage;
    private JLabel labelLargeurAssise;
    private JTextField textFieldLargeurAssise;
    private JLabel labelPoids;
    private JTextField textFieldPoids;
    private JLabel labelCapacite;
    private JTextField textFieldCapacite;
    private JLabel labelDegPivotage;
    private JTextField textFieldDegPivotage;
    private JLabel labelRef;
    private JTextField textFieldRef;
    private JLabel labelMarque;
    private JTextField textFieldMarque;
    private JLabel labelModele;
    private JTextField textFieldModele;
    private JLabel labelPrix;
    private JTextField textFieldPrix;
    private JLabel labelQuantite;
    private JTextField textFieldQuantite;
    private JCheckBox comboIsElectrique;
    private JCheckBox comboIsDouble;
    private JCheckBox comboIsAjustable;

    private Article article;

    public AfficheStock(Article article)
    {

        this.article = article;
        this.setTitle("Client n°:" + article.getReference());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setContentPane(afficheStockPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        this.textFieldRef.setText(article.getReference());
        this.textFieldMarque.setText(article.getMarque());
        this.textFieldModele.setText(article.getModele());
        this.textFieldPrix.setText(String.valueOf(article.getPrixJourLoc()));
        this.textFieldQuantite.setText(String.valueOf(article.getNbStock()));
        this.textFieldTArticle.setText(article.getClass().getSimpleName());

        switch (article.getClass().getSimpleName()){

            case "FauteuilRoulant":

                FauteuilRoulant fauteuil = (FauteuilRoulant) this.article;
                this.textFieldLargeurAssise.setText(String.valueOf(fauteuil.getLargeurAssise()));
                this.textFieldPoids.setText(String.valueOf(fauteuil.getPoids()));

                break;


            case "LitMedicalise":

                LitMedicalise lit = (LitMedicalise) this.article;
                this.textFieldPMax.setText(String.valueOf(lit.getPoidsMax()));
                this.textFieldLongueur.setText(String.valueOf(lit.getLongueur()));
                this.textFieldLargeur.setText(String.valueOf(lit.getLargeur()));
                this.textFieldHauteur.setText(String.valueOf(lit.getHauteur()));

                this.comboIsElectrique.setSelected(lit.isElectrique());
                this.comboIsDouble.setSelected(lit.isDouble());

                break;


            case "MatelasAir":

                MatelasAir matelasAir = (MatelasAir) this.article;

                this.textFieldTmpGonflage.setText(String.valueOf(matelasAir.getTempGonflage()));

                break;


            case "SouleveMalades":

                SouleveMalades souleveMalade = (SouleveMalades) this.article;

                this.textFieldCapacite.setText(String.valueOf(souleveMalade.getCapacite()));
                this.textFieldDegPivotage.setText(String.valueOf(souleveMalade.getDegrePivotage()));

                break;


            case "TableAlite":

                TableAlite table = (TableAlite) this.article;
                this.textFieldPMax.setText(String.valueOf(table.getPoidsMax()));
                this.textFieldLongueur.setText(String.valueOf(table.getLongueur()));
                this.textFieldLargeur.setText(String.valueOf(table.getLargeur()));
                this.textFieldHauteur.setText(String.valueOf(table.getHauteur()));

                this.comboIsAjustable.setSelected(table.isAjustable());

                break;

        }

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
