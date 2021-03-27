package viewWindow;

import controller.WPresenter;
import persistence.LanguageManager;
import viewWindow.body.BodyPanel;
import viewWindow.footer.FooterPanel;
import viewWindow.header.HeaderPanel;

import javax.swing.*;
import java.time.LocalTime;

public class MainPanel extends JPanel {

    private JPanel title;
    private JLabel labelJttle;
    private HeaderPanel header;
    private BodyPanel body;
    private FooterPanel footerPanel;

    public MainPanel(WPresenter wPresenter) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initComponents(wPresenter);
    }

    private void initComponents(WPresenter wPresenter){
        title = new JPanel();
        title.setBackground(Constants.MAIN_PANEL_COLOR);
        labelJttle = new JLabel(Constants.TITLE_PANEL_COLOR);
        labelJttle.setAlignmentX(CENTER_ALIGNMENT);
        labelJttle.setFont(Constants.FONT_PANEL_COLOR);
        title.add(labelJttle);
        this.add(title);
        header = new HeaderPanel(wPresenter);
        this.add(header);
        body = new BodyPanel();
        this.add(body);
        this.footerPanel = new FooterPanel();
        this.add(footerPanel);
    }

    public void addElementToTable(Object[] runner){
        body.addElementToTable(runner);
    }

    public void resetList(){
        body.resetList();
    }

    public void changeLanguage(LocalTime male, LocalTime female){
        labelJttle.setText(LanguageManager.propertiesLanguage.getProperty(Constants.FUN_TITLE));
        header.changeLanguage();
        body.changeLanguage();
        footerPanel.changeLanguage(male, female);
    }

    public void setTextFooter(String ma, String fe){
        footerPanel.setTextLabels(ma, fe);
    }
}
