package viewWindow.body;

import model.Cyclist;
import persistence.LanguageManager;
import viewWindow.Constants;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class JTableBody extends JPanel{

    private DefaultTableModel defaultTable;
    private JTable tableElements;
    private JScrollPane jsTable;

    public JTableBody() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);
        initComponents();
    }

    private void initComponents(){
        String[] columnsIdentifiers = {Constants.NAME, Constants.SURNAME, Constants.TEAM, Constants.GENDER, Constants.AGE, Constants.TIME};

        defaultTable = new DefaultTableModel();
        defaultTable.setColumnIdentifiers(columnsIdentifiers);

        tableElements = new JTable();
        tableElements.setModel(defaultTable);
        tableElements.getTableHeader().setReorderingAllowed(false);
        tableElements.getTableHeader().setBackground(Constants.MAIN_PANEL_COLOR);
        //setSizenew Color(255, 213, 0)
        tableElements.setBackground(Color.WHITE);
        tableElements.setFillsViewportHeight(true);
        tableElements.setRowHeight(Constants.ROW_HEIGHT);

        jsTable = new JScrollPane(tableElements);
        jsTable.setForeground(Color.WHITE);
        jsTable.setAlignmentX(LEFT_ALIGNMENT);
        this.add(jsTable);
    }

    public void addListToTable(ArrayList<Object[]> elements){
        defaultTable.setNumRows(0);
        for (Object[] runner : elements){
            defaultTable.addRow(runner);
        }
    }

    public void resetList(){
        defaultTable.setNumRows(0);
    }

    public void addElementToTable(Object[] data){
        defaultTable.addRow(data);
    }

    public void changeLanguage(){
        defaultTable.setColumnIdentifiers(new String[]{
                LanguageManager.propertiesLanguage.getProperty(Constants.FUN_NAME_R),
                LanguageManager.propertiesLanguage.getProperty(Constants.FUN_SURNAME),
                LanguageManager.propertiesLanguage.getProperty(Constants.FUN_TEAM),
                LanguageManager.propertiesLanguage.getProperty(Constants.FUN_GENDER),
                LanguageManager.propertiesLanguage.getProperty(Constants.FUN_AGE),
                LanguageManager.propertiesLanguage.getProperty(Constants.FUN_TIME)});
    }
}
