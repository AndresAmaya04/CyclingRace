package viewWindow.header;

import controller.Commands;
import controller.WPresenter;
import viewWindow.Constants;

import javax.swing.*;
import java.awt.*;

public class HeadMenu extends JMenuBar {

    private JMenu menuFile;
    private JMenuItem addPerson;

    public HeadMenu(WPresenter wPresenter) {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Color.ORANGE);
        initComponents(wPresenter);
    }

    private void initComponents(WPresenter wPresenter) {
        menuFile = new JMenu(Constants.FILE);
        menuFile.setForeground(Color.WHITE);

        addPerson = new JMenuItem(Constants.NEW_ITEM_RUNNER);
        addPerson.setActionCommand(Commands.SHOW_NEW_RUNNER.toString());
        addPerson.addActionListener(wPresenter);
        menuFile.add(addPerson);

        //this.add(menuFile);
    }


}
