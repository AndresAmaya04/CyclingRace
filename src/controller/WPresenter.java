package controller;

import exceptions.AgeException;
import exceptions.NameException;
import model.Cyclist;
import model.Gender;
import model.Race;
import model.Teams;
import persistence.LanguageManager;
import persistence.ManagerFiles;
import persistence.Utilities;
import viewWindow.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class WPresenter implements ActionListener {

    public static final String ENGLISH_PATH = "resources/languages/EnLanguage.properties";
    public static final String SPANISH_PATH = "resources/languages/EsLanguage.properties";
    public static final String FILE_INIT = "resources/config/config.init";
    public static final String FILE_DATA = "resources/in/Corredores.bike";
    public static final String FILE_NOT_ACEPTED = "resources/in/oher.txt";
    public static final String MALE_STRING = "MALE";
    public static final String FEMALE_STRING = "FEMALE";
    public static final String MALE_COMPARATOR = "Masculino";
    private ArrayList<String> notAceptedRunners;

    private LanguageManager config;
    private MainWindow mainWindow;
    private Race race;
    private ManagerFiles managerFiles;

    public WPresenter() {
        notAceptedRunners = new ArrayList();
        loadConfiguration();
        this.mainWindow = new MainWindow(this);
        this.managerFiles = new ManagerFiles();
        this.race = new Race();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (Commands.valueOf(event.getActionCommand())){
            case ADD_RUNNER:
                mainWindow.showDialogCreate();
                mainWindow.setTextFooter("" + race.takeMalePromedium(), "" + race.takeFemalePromedium());
                break;
            case PROMEDIUMS:
                try {
                    startFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mainWindow.setTextFooter("" + race.takeMalePromedium(), "" + race.takeFemalePromedium());
                break;
            case SHOW_NEW_RUNNER:
                break;
            case ADD_LIST:
                createListForTable();
                mainWindow.setTextFooter("" + race.takeMalePromedium(), "" + race.takeFemalePromedium());
                break;
            case CREATE_RUNNER:
                try {
                    Cyclist cyclist = takeACyclistSinceDialog();
                    if (race.isAValidCyclist(cyclist.getName(), cyclist.getSurname(), cyclist.getDateOfBirth())){
                        createRunner(cyclist);
                    }else{
                        notAceptedRunners.add(cyclist.toString());
                        managerFiles.writeFile(notAceptedRunners, FILE_NOT_ACEPTED);
                    }
                } catch (NameException e) {
                    e.printStackTrace();
                } catch (AgeException e) {
                    e.printStackTrace();
                }
                mainWindow.setTextFooter("" + race.takeMalePromedium(), "" + race.takeFemalePromedium());
                break;
            case C_TO_ENGLISH:
                try {
                    manageChangeToEnglish(race.takeMalePromedium(), race.takeFemalePromedium());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case C_TO_SPANISH:
                try {
                    manageChangeToSpanish(race.takeMalePromedium(), race.takeFemalePromedium());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case FILE_IN:
                for (int i=0; i<notAceptedRunners.size(); i++){
                    mainWindow.addElementToNotAccepted(notAceptedRunners.get(i).replace('?', '-'));
                }
                mainWindow.showDialogNotAccepted();
                break;
            default:
                break;
        }
    }

    public Cyclist takeACyclistSinceDialog(){
        return mainWindow.createCyclist();
    }

    public Cyclist[] listZ(){
        return new Cyclist[]{
        new Cyclist("Juan", "roa", LocalDate.of(1980, 11, 10), Gender.MALE.toString(), Teams.UAE.toString(), LocalTime.of(05, 32, 10), 1),
        new Cyclist("Martin", "Castro", LocalDate.of(2000, 1, 4), Gender.MALE.toString(), Teams.INEOS.toString(), LocalTime.of(04, 00, 10), 2),
        new Cyclist("Miguel", "contreras", LocalDate.of(1993, 10, 30), Gender.MALE.toString(), Teams.TEAM_COLOMBIA.toString(), LocalTime.of(4, 32, 50), 3),
        new Cyclist("Juana", "Celis", LocalDate.of(2002, 3, 26), Gender.FEMALE.toString(), Teams.MOVISTAR.toString(), LocalTime.of(3, 57, 47), 4),
        new Cyclist("Nairo", "Rodriguez", LocalDate.of(2012, 8, 26), Gender.MALE.toString(), Teams.MOVISTAR.toString(), LocalTime.of(05, 32, 10),5),
        new Cyclist("Felipe", "Escobar", LocalDate.of(2015, 3, 26), Gender.MALE.toString(), Teams.EF.toString(), LocalTime.of(05, 32, 10), 6),
        new Cyclist("Bryan", "Ibaniez", LocalDate.of(2002, 3, 26), Gender.MALE.toString(), Teams.BORA.toString(), LocalTime.of(04, 52, 10), 7),
        new Cyclist("Daniela", "Ortega", LocalDate.of(2002, 3, 26), Gender.FEMALE.toString(), Teams.ARKEA.toString(), LocalTime.of(05, 01, 10), 8),
        new Cyclist("Nicol", "munevar", LocalDate.of(1970, 3, 26), Gender.FEMALE.toString(), Teams.TREK.toString(), LocalTime.of(05, 32, 10), 9),
        new Cyclist("Miguel", "Contreras", LocalDate.of(2002, 3, 26), Gender.MALE.toString(), Teams.SKY.toString(), LocalTime.of(04, 32, 10), 10),
        new Cyclist("Milena", "Soler", LocalDate.of(2002, 3, 26), Gender.FEMALE.toString(), Teams.UAE.toString(), LocalTime.of(05, 33, 10), 11),
        new Cyclist("Mateo", "Pinzon", LocalDate.of(2002, 1, 20), Gender.MALE.toString(), Teams.UAE.toString(), LocalTime.of(04,21,05), 12)};
    }

    private void createListForTable(){
        Cyclist[] list = listZ();
        for (Cyclist  aux : list){
            try {
                race.addCyclist(aux);
            } catch (AgeException e) {
                e.printStackTrace();
            } catch (NameException e) {
                e.printStackTrace();
            }
        }
        race.order();
        for (int i=0; i<race.getSizeOfRace(); i++){
            mainWindow.addElementToTable(race.getCyclistIndex(i).getCyclistData());
        }
    }

    private void createRunner(Cyclist cyclist) throws NameException, AgeException {
        mainWindow.resetList();
        race.addCyclist(cyclist);
        for (int i=0; i<race.getSizeOfRace(); i++){
            mainWindow.addElementToTable(race.getCyclistIndex(i).getCyclistData());
        }
    }

    public void loadConfiguration(){
        if (config == null){
            config = new LanguageManager(FILE_INIT);
        }
        try {
            config.loadLanguage();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void manageChangeToSpanish(LocalTime male, LocalTime female) throws IOException {
        try {
            changeToSpanish();
        }catch (IOException e){
            JOptionPane.showMessageDialog(mainWindow, e.getMessage());
        }
        managerChangeLanguage(male, female);
    }

    private void manageChangeToEnglish(LocalTime male, LocalTime female) throws IOException {
        try {
            changeToEnglish();
        }catch (IOException e){
            JOptionPane.showMessageDialog(mainWindow, e.getMessage());
        }
        managerChangeLanguage(male, female);
    }


    public void changeToEnglish() throws IOException{
       LanguageManager.language = ENGLISH_PATH;
        saveConfig();
        loadLanguage();
    }

    public void changeToSpanish() throws IOException{
        LanguageManager.language = SPANISH_PATH;
        saveConfig();
        loadLanguage();
    }

    public void saveConfig(){
        try {
            new LanguageManager(FILE_INIT).saveLanguage();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(mainWindow, e.getMessage());
        }
    }

    public void loadLanguage(){
        try {
            config.loadLanguage();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(mainWindow, e.getMessage());
        }
    }

    private void startFile() throws IOException {
        mainWindow.resetList();
        ArrayList<String> strings = managerFiles.readFile(FILE_DATA);
        splitLines(strings);
        race.order();
        for (int i=0; i<race.getSizeOfRace(); i++){
            mainWindow.addElementToTable(race.getCyclistIndex(i).getCyclistData());
        }
    }

    private void splitLines(ArrayList<String> lines) {
        for (String line : lines){
            String[] aux = Utilities.splitLine(line);
            LocalDate localDate = arrayToLocalDate(aux[4]);
            if (race.isAValidCyclist(aux[1], aux[2], localDate) && aux.length == 8){
                race.putCyclist(new Cyclist(aux[1],aux[2], localDate, aux[5].equals(MALE_COMPARATOR)?MALE_STRING:FEMALE_STRING,
                        aux[6], LocalTime.parse(aux[7]), Integer.parseInt(aux[0])));
            }else
                notAceptedRunners.add(line);
        }
        managerFiles.writeFile(notAceptedRunners, FILE_NOT_ACEPTED);
    }

    private LocalDate arrayToLocalDate(String dates){
        String[] array = dates.split("/");
        return LocalDate.of(Integer.parseInt(array[2]), Integer.parseInt(array[0]), Integer.parseInt(array[1]));
    }

    private void managerChangeLanguage(LocalTime male, LocalTime female){
        mainWindow.changeLanguage(male, female);
    }

    public static void main(String[] args) {
        new WPresenter();
    }
}
