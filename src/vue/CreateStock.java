package vue;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Anais BESSON and Victor FAVREAU on 18/10/2017.
 */
public class CreateStock extends JFrame{

    private JButton retourButton;
    private JButton confirmButton;
    private JPanel buttonPane;
    private JPanel createStockPanel;
    private JLabel labelTArticle;
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
    private JButton nouveauButton;
    private JComboBox comboBoxType;

    public CreateStock(){

        this.comboBoxType.addItem("FauteuilRoulant");
        this.comboBoxType.addItem("LitMedicalise");
        this.comboBoxType.addItem("MatelasAir");
        this.comboBoxType.addItem("MobilierChambre");
        this.comboBoxType.addItem("SouleveMalades");
        this.comboBoxType.addItem("TableAlite");

        this.setTitle("Création Article");
        setLocationRelativeTo(this.getParent());
        this.setResizable(false);
        this.setContentPane(createStockPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        comboBoxType.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                switch ((String)comboBoxType.getSelectedItem()){

                    case "FauteuilRoulant":

                        textFieldPMax.setEditable(false);
                        textFieldLongueur.setEditable(false);
                        textFieldLargeur.setEditable(false);
                        textFieldHauteur.setEditable(false);
                        comboIsElectrique.setEnabled(false);
                        comboIsDouble.setEnabled(false);
                        comboIsAjustable.setEnabled(false);
                        textFieldTmpGonflage.setEditable(false);
                        textFieldLargeurAssise.setEditable(true);
                        textFieldPoids.setEditable(true);
                        textFieldCapacite.setEditable(false);
                        textFieldDegPivotage.setEditable(false);

                        break;

                    case "LitMedicalise":

                        textFieldPMax.setEditable(true);
                        textFieldLongueur.setEditable(true);
                        textFieldLargeur.setEditable(true);
                        textFieldHauteur.setEditable(true);
                        comboIsElectrique.setEnabled(true);
                        comboIsDouble.setEnabled(true);
                        comboIsAjustable.setEnabled(false);
                        textFieldTmpGonflage.setEditable(false);
                        textFieldLargeurAssise.setEditable(false);
                        textFieldPoids.setEditable(false);
                        textFieldCapacite.setEditable(false);
                        textFieldDegPivotage.setEditable(false);

                        break;

                    case "MatelasAir":

                        textFieldPMax.setEditable(true);
                        textFieldLongueur.setEditable(true);
                        textFieldLargeur.setEditable(true);
                        textFieldHauteur.setEditable(true);
                        comboIsElectrique.setEnabled(false);
                        comboIsDouble.setEnabled(false);
                        comboIsAjustable.setEnabled(false);
                        textFieldTmpGonflage.setEditable(true);
                        textFieldLargeurAssise.setEditable(false);
                        textFieldPoids.setEditable(false);
                        textFieldCapacite.setEditable(false);
                        textFieldDegPivotage.setEditable(false);

                        break;


                    case "SouleveMalades":

                        textFieldPMax.setEditable(false);
                        textFieldLongueur.setEditable(false);
                        textFieldLargeur.setEditable(false);
                        textFieldHauteur.setEditable(false);
                        comboIsElectrique.setEnabled(false);
                        comboIsDouble.setEnabled(false);
                        comboIsAjustable.setEnabled(false);
                        textFieldTmpGonflage.setEditable(false);
                        textFieldLargeurAssise.setEditable(false);
                        textFieldPoids.setEditable(false);
                        textFieldCapacite.setEditable(true);
                        textFieldDegPivotage.setEditable(true);

                        break;


                    case "TableAlite":

                        textFieldPMax.setEditable(true);
                        textFieldLongueur.setEditable(true);
                        textFieldLargeur.setEditable(true);
                        textFieldHauteur.setEditable(true);
                        comboIsElectrique.setEnabled(false);
                        comboIsDouble.setEnabled(false);
                        comboIsAjustable.setEnabled(true);
                        textFieldTmpGonflage.setEditable(false);
                        textFieldLargeurAssise.setEditable(false);
                        textFieldPoids.setEditable(false);
                        textFieldCapacite.setEditable(false);
                        textFieldDegPivotage.setEditable(false);

                        break;

                }

            }
        });

        nouveauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Article article = null;

                System.out.println((String)comboBoxType.getSelectedItem());

                switch ((String)comboBoxType.getSelectedItem()){

                    case "FauteuilRoulant":

                        article = new FauteuilRoulant(
                                textFieldRef.getText(),
                                textFieldMarque.getText(),
                                textFieldModele.getText(),
                                Double.parseDouble(textFieldPrix.getText()),
                                Integer.parseInt(textFieldQuantite.getText()),
                                Double.parseDouble(textFieldLargeurAssise.getText()),
                                Double.parseDouble(textFieldPoids.getText())
                        );

                        break;

                    case "LitMedicalise":

                        article = new LitMedicalise(
                                textFieldRef.getText(),
                                textFieldMarque.getText(),
                                textFieldModele.getText(),
                                Double.parseDouble(textFieldPrix.getText()),
                                Integer.parseInt(textFieldQuantite.getText()),
                                Double.parseDouble(textFieldPMax.getText()),
                                Double.parseDouble(textFieldLongueur.getText()),
                                Double.parseDouble(textFieldLargeur.getText()),
                                Double.parseDouble(textFieldHauteur.getText()),
                                comboIsElectrique.isSelected(),
                                comboIsDouble.isSelected()
                        );

                        break;

                    case "MatelasAir":

                        article = new MatelasAir(
                                textFieldRef.getText(),
                                textFieldMarque.getText(),
                                textFieldModele.getText(),
                                Double.parseDouble(textFieldPrix.getText()),
                                Integer.parseInt(textFieldQuantite.getText()),
                                Double.parseDouble(textFieldPMax.getText()),
                                Double.parseDouble(textFieldLongueur.getText()),
                                Double.parseDouble(textFieldLargeur.getText()),
                                Double.parseDouble(textFieldHauteur.getText()),
                                Integer.parseInt(textFieldTmpGonflage.getText())
                        );

                        break;


                    case "SouleveMalades":

                        article = new SouleveMalades(
                                textFieldRef.getText(),
                                textFieldMarque.getText(),
                                textFieldModele.getText(),
                                Double.parseDouble(textFieldPrix.getText()),
                                Integer.parseInt(textFieldQuantite.getText()),
                                Double.parseDouble(textFieldCapacite.getText()),
                                Double.parseDouble(textFieldDegPivotage.getText())
                        );

                        break;


                    case "TableAlite":

                        article = new TableAlite(
                                textFieldRef.getText(),
                                textFieldMarque.getText(),
                                textFieldModele.getText(),
                                Double.parseDouble(textFieldPrix.getText()),
                                Integer.parseInt(textFieldQuantite.getText()),
                                Double.parseDouble(textFieldPMax.getText()),
                                Double.parseDouble(textFieldLongueur.getText()),
                                Double.parseDouble(textFieldLargeur.getText()),
                                Double.parseDouble(textFieldHauteur.getText()),
                                comboIsAjustable.isSelected()
                        );

                        break;

                }




               Main.magasin.ajouterArticle(article);
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
