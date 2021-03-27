package viewWindow;

import com.toedter.calendar.JDateChooser;
import controller.Commands;
import controller.WPresenter;
import model.Cyclist;
import model.Gender;
import model.Teams;
import persistence.LanguageManager;

import java.time.ZoneId;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalTime;

public class JDialogRunner extends JDialog {

    private JPanel container;
    private JComboBox<Teams> teamsJComboBox;
    private JDateChooser date;
    private JTextField time;
    private JTextField name;
    private JTextField surname;
    private JComboBox<Gender> genderJComboBox;
    private JToggleButton createRunner;
    private int dorsals = 0;

    public JDialogRunner(WPresenter wpresenter) {
        setModal(true);
        setSize(Constants.DIMENSION_DIAGLOG);
        getContentPane().setBackground(Constants.DIALOG_COLOR);
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource(Constants.LOGO)).getImage());
        initComponents(wpresenter);
    }

    private void initComponents(WPresenter wpresenter){
      container = new JPanel();
      container.setLayout(new GridLayout(7,1,10,10));
      container.setBackground(Color.WHITE);
      container.setBorder(new EmptyBorder(20,20,20,20));

        name = new JTextField();
        name.setBorder(BorderFactory.createTitledBorder(Constants.INPUT_NAME));
        container.add(name);

        surname = new JTextField();
        surname.setBorder(BorderFactory.createTitledBorder(Constants.INPUT_SURNAME));
        container.add(surname);

        teamsJComboBox = new JComboBox<>(Teams.values());
        teamsJComboBox.setBorder(BorderFactory.createTitledBorder(Constants.INPUT_TEAM));
        container.add(teamsJComboBox);

        genderJComboBox = new JComboBox<>(Gender.values());
        genderJComboBox.setBorder(BorderFactory.createTitledBorder(Constants.INPUT_GENDER));
        container.add(genderJComboBox);

        date = new JDateChooser();
        date.setBorder(BorderFactory.createTitledBorder(Constants.INPUT_DATE));
        container.add(date);

        time = new JTextField();
        time.setBorder(new EmptyBorder(60,12,60,12));
        time.setBorder(BorderFactory.createTitledBorder(Constants.INPUT_TIME));
        container.add(time);

        createRunner = new JToggleButton();
        createRunner.setBackground(Color.WHITE);
        createRunner.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(Constants.CHECK)).getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH)));
        createRunner.setAlignmentX(CENTER_ALIGNMENT);
        createRunner.setActionCommand(Commands.CREATE_RUNNER.toString());
        createRunner.setBorder(new EmptyBorder(10,10,10,10));
        createRunner.addActionListener(wpresenter);
        container.add(createRunner);

        this.add(container);
    }

    public Cyclist createCyclist(){
        return new Cyclist(name.getText(), surname.getText(),date.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), String.valueOf(genderJComboBox.getSelectedItem()),
                String.valueOf(teamsJComboBox.getSelectedItem()), LocalTime.parse(time.getText()), ++dorsals);
    }

    public void changeLanguage(){
        name.setBorder(BorderFactory.createTitledBorder(LanguageManager.propertiesLanguage.getProperty(Constants.FUN_INPUT_NAME)));
        surname.setBorder(BorderFactory.createTitledBorder(LanguageManager.propertiesLanguage.getProperty(Constants.FUN_INPUT_SURNAME)));
        teamsJComboBox.setBorder(BorderFactory.createTitledBorder(LanguageManager.propertiesLanguage.getProperty(Constants.FUN_INPUT_TEAM)));
        genderJComboBox.setBorder(BorderFactory.createTitledBorder(LanguageManager.propertiesLanguage.getProperty(Constants.FUN_INPUT_GENDER)));
        date.setBorder(BorderFactory.createTitledBorder(LanguageManager.propertiesLanguage.getProperty(Constants.FUN_INPUT_DATE)));
        time.setBorder(BorderFactory.createTitledBorder(LanguageManager.propertiesLanguage.getProperty(Constants.FUN_INPUT_TIME)));
        createRunner.setBorder(BorderFactory.createTitledBorder(LanguageManager.propertiesLanguage.getProperty(Constants.FUN_CREATE_RUNNER)));
    }
}
