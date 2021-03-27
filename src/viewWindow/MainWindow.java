package viewWindow;

import controller.Presenter;
import controller.WPresenter;
import model.Cyclist;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class MainWindow extends JFrame {

    private MainPanel mainPanel;
    private JDialogRunner dialogRunner;
    private DialogNoAccepted dialogNoAccepted;

    public MainWindow(WPresenter wPresenter){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource(Constants.LOGO)).getImage());
        this.getContentPane().setBackground(Color.WHITE);
        initComponents(wPresenter);
        this.setVisible(true);
    }

    private void initComponents(WPresenter wPresenter){
        this.mainPanel = new MainPanel(wPresenter);
        this.dialogRunner = new JDialogRunner(wPresenter);
        this.dialogNoAccepted = new DialogNoAccepted();
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        this.add(scrollPane);
    }

    public void showDialogCreate(){
        dialogRunner.setVisible(true);
    }

    public void showDialogNotAccepted(){
        dialogNoAccepted.setVisible(true);
    }

    public Cyclist createCyclist(){
       return dialogRunner.createCyclist();
    }

    public void addElementToTable(Object[] runner){
        mainPanel.addElementToTable(runner);
    }

    public void addElementToNotAccepted(String s){
        dialogNoAccepted.addEliminateRunner(s);
    }

    public void resetList(){
        mainPanel.resetList();
    }

    public void changeLanguage(LocalTime male, LocalTime female){
        mainPanel.changeLanguage(male, female);
        dialogRunner.changeLanguage();
        dialogNoAccepted.changeLanguage();
    }

    public void setTextFooter(String ma, String fe){
        mainPanel.setTextFooter(ma, fe);
    }
}
