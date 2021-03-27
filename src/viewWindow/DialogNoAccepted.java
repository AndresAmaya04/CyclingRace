package viewWindow;

import persistence.LanguageManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DialogNoAccepted extends JDialog {

    private final String header = "Info corredores no aceptados";

    private JPanel container;
    private JTable table;
    private DefaultTableModel defaultTableModel;
    private JScrollPane scrollPane;

    public DialogNoAccepted() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setSize(Constants.DIMENSION_DIAGLOG_NOT_ACCEPTED);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource(Constants.LOGO)).getImage());
        initComponents();
    }

    private void initComponents() {
        container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.LEFT));

        defaultTableModel = new DefaultTableModel();
        defaultTableModel.setColumnIdentifiers(new String[]{header});

        table = new JTable();
        table.setModel(defaultTableModel);
        table.getTableHeader().setBackground(Constants.MAIN_PANEL_COLOR);
        table.getTableHeader().setForeground(Constants.TOOL_BAR_COLOR);
        table.setRowHeight(28);

        scrollPane = new JScrollPane(table);
        scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        container.add(scrollPane);

        this.add(container);
    }

    public void changeLanguage(){
        defaultTableModel.setColumnIdentifiers(new String[]{LanguageManager.propertiesLanguage.getProperty(Constants.FUN_NOT_ACCEPTED_RUNNERS)});

    }

    public void addEliminateRunner(String string){
        Object[] row = {string};
        defaultTableModel.addRow(row);
    }
}
