package viewWindow.footer;

import persistence.LanguageManager;
import viewWindow.Constants;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class FooterPanel extends JPanel {

    private JLabel promediumsM;
    private JLabel promediumF;

    public FooterPanel() {
        this.setLayout(new GridLayout(1, 2,50,50));
        initComponents();
    }

    private void initComponents(){
        this.promediumsM = new JLabel();
        promediumsM.setFont(new Font("", Font.ITALIC, 18));
        this.add(promediumsM);

        this.promediumF = new JLabel();
        promediumF.setFont(new Font("", Font.ITALIC, 18));
        this.add(promediumF);
    }

    public void setTextLabels(String timeMale, String timeFemale){
        promediumF.setText(Constants.AVERAGE_FEMALE + timeFemale);
        promediumsM.setText(Constants.AVERAGE_MALE + timeMale);
    }

    public void changeLanguage(LocalTime male, LocalTime female){
        promediumsM.setText(LanguageManager.propertiesLanguage.getProperty(Constants.FUN_AVERAGEM) + male);
        promediumF.setText(LanguageManager.propertiesLanguage.getProperty(Constants.FUN_AVERAGEF) + female);
    }
}
