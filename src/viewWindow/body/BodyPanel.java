package viewWindow.body;

import javax.swing.*;
import java.awt.*;

public class BodyPanel extends JPanel {

    private JTableBody tableBody;

    public BodyPanel() {
        this.setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents(){
        this.tableBody = new JTableBody();
        this.add(tableBody, BorderLayout.CENTER);
    }

    public void addElementToTable(Object[] runner){
        tableBody.addElementToTable(runner);
    }

    public void resetList(){
        tableBody.resetList();
    }

    public void changeLanguage(){
        tableBody.changeLanguage();
    }
}
