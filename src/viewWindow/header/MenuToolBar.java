package viewWindow.header;

import controller.Commands;
import controller.WPresenter;
import persistence.LanguageManager;
import viewWindow.Constants;

import javax.swing.*;
import java.awt.*;

public class MenuToolBar extends JToolBar {

    private JButton addRunner, fileButton, addList, toSpanish, toEnglish, notAceptedButton;

    public MenuToolBar(WPresenter wPresenter) {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Constants.TOOL_BAR_COLOR);
        this.setFloatable(false);
        initComponents(wPresenter);
    }

    private void initComponents(WPresenter wPresenter){
        addRunner = new JButton();
        addRunner.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(Constants.ADD_RUNNER)).getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
        addRunner.setActionCommand(Commands.ADD_RUNNER.toString());
        addRunner.setToolTipText(Constants.CREATE_RUNNER_BUTTON);
        addRunner.addActionListener(wPresenter);
        this.add(addRunner);

        fileButton = new JButton();
        fileButton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(Constants.CARPETA)).getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
        fileButton.setActionCommand(Commands.PROMEDIUMS.toString());
        fileButton.setToolTipText(Constants.LOAD_FILE);
        fileButton.addActionListener(wPresenter);
        this.add(fileButton);

        notAceptedButton = new JButton();
        notAceptedButton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(Constants.NOT_ACCEPTED)).getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
        notAceptedButton.setActionCommand(Commands.FILE_IN.toString());
        notAceptedButton.setToolTipText(Constants.LIST_NOT_ACCEPTED);
        notAceptedButton.addActionListener(wPresenter);
        this.add(notAceptedButton);

        addList = new JButton();
        addList.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(Constants.TABLE_ICON)).getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
        addList.setActionCommand(Commands.ADD_LIST.toString());
        addList.setToolTipText(Constants.LIST_BUTTON);
        addList.addActionListener(wPresenter);
        this.add(addList);
        
        toSpanish = new JButton();
        toSpanish.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(Constants.SPANISH)).getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
        toSpanish.setToolTipText(Constants.TO_SPANISH);
        toSpanish.setActionCommand(Commands.C_TO_SPANISH.toString());
        toSpanish.addActionListener(wPresenter);
        this.add(toSpanish);

        toEnglish = new JButton();
        toEnglish.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(Constants.ENGLISH)).getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
        toEnglish.setToolTipText(Constants.TO_ENGLISH);
        toEnglish.setActionCommand(Commands.C_TO_ENGLISH.toString());
        toEnglish.addActionListener(wPresenter);
        this.add(toEnglish);
    }

    public void changeLanguage(){
        addRunner.setToolTipText(LanguageManager.propertiesLanguage.getProperty(Constants.FUN_ADD_CYCLIST));
        fileButton.setToolTipText(LanguageManager.propertiesLanguage.getProperty(Constants.FUN_AVERAGES));
        addList.setToolTipText(LanguageManager.propertiesLanguage.getProperty(Constants.FUN_LIST));
        notAceptedButton.setToolTipText(LanguageManager.propertiesLanguage.getProperty(Constants.FUN_NOT_ACCEPTED));
    }
}
