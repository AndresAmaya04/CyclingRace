package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;

import exceptions.AgeException;
import exceptions.NameException;
import model.Cyclist;
import model.Gender;
import model.Race;
import model.Teams;
import view.Console;
import viewWindow.MainWindow;

import javax.swing.*;

/**
 *
 * @author Andrés Leo Amaya
 */
public class Presenter {

    private Race tour;
    private Console console;
    private int dorsal;

    public Presenter() throws NameException, AgeException {
        this.tour = new Race();
        this.console = new Console();
        this.dorsal = 12;
        menu();
    }

    /*private void add() throws NameException, AgeException {
        tour.addCyclist(new Cyclist("Juan", "Roa", LocalDate.of(1980, 11, 10), Gender.MALE, Teams.UAE, LocalTime.of(04, 27,25), 1));
        tour.addCyclist(new Cyclist("Martin", "Castro", LocalDate.of(2000, 1, 4), Gender.MALE, Teams.INEOS, LocalTime.of(04, 00, 10), 2));
        tour.addCyclist(new Cyclist("Miguel", "Contreras", LocalDate.of(1993, 10, 30), Gender.MALE, Teams.TEAM_COLOMBIA, LocalTime.of(4, 32, 50), 3));
        tour.addCyclist(new Cyclist("Juana", "Celis", LocalDate.of(2002, 3, 26), Gender.FEMALE, Teams.MOVISTAR, LocalTime.of(3, 57, 47), 4));
        tour.addCyclist(new Cyclist("Nairo", "Rodriguez", LocalDate.of(1993, 8, 26), Gender.MALE, Teams.MOVISTAR, LocalTime.of(03, 59, 59), 5));
        tour.addCyclist(new Cyclist("Juan", "Ariza", LocalDate.of(2004, 3, 26), Gender.MALE, Teams.EF, LocalTime.of(05, 32, 10), 6));
        tour.addCyclist(new Cyclist("Bryan", "Ibaniez", LocalDate.of(2002, 3, 26), Gender.MALE, Teams.BORA, LocalTime.of(04, 52, 10), 7));
        tour.addCyclist(new Cyclist("Daniela", "Ortega", LocalDate.of(1990, 3, 26), Gender.FEMALE, Teams.ARKEA, LocalTime.of(05, 01, 10), 8));
        tour.addCyclist(new Cyclist("Nicol", "Munevar", LocalDate.of(1999, 3, 26), Gender.FEMALE, Teams.TREK, LocalTime.of(05, 52, 53), 9));
        tour.addCyclist(new Cyclist("Jeffer", "Sanchez", LocalDate.of(2005, 10, 26), Gender.MALE, Teams.SKY, LocalTime.of(04, 32, 10), 10));
        tour.addCyclist(new Cyclist("Andrea", "Vargas", LocalDate.of(1980, 10, 7), Gender.FEMALE, Teams.UAE, LocalTime.of(06, 12, 11), 11));
        tour.addCyclist(new Cyclist("Mateo", "Pinzon", LocalDate.of(2002, 1, 20), Gender.MALE, Teams.UAE, LocalTime.of(04, 21, 05), 12));
        tour.addCyclist(new Cyclist("Alison", "Villamil", LocalDate.of(2000, 1, 1), Gender.FEMALE, Teams.BORA, LocalTime.of(04, 11, 1), 13));
        tour.addCyclist(new Cyclist("Camilo", "Happy", LocalDate.of(1998, 12, 15), Gender.MALE, Teams.TREK, LocalTime.of(06, 0, 0), 14));
        tour.addCyclist(new Cyclist("Brayan", "Collazos", LocalDate.of(1989, 8, 12), Gender.MALE, Teams.SKY, LocalTime.of(05, 35, 13), 15));
    }*/

    public void addPlayer() throws NameException, AgeException {
        int size = tour.getSizeOfRace();
        tour.addCyclist(new Cyclist(console.getNameOfCyclist(), console.getSurnameOfCyclist(), console.getDate(), console.getCyclistGender().toString(), console.getCyclistTeam().toString(), console.getTime(), ++dorsal));
        console.printMensage(size == tour.getSizeOfRace());
    }

    public void showList() {
        console.printTable(tour.extractCyclistInfo());
    }

    public void menu() throws NameException, AgeException {
        int option = console.showMenu();
        switch (option) {
            case 1:
                addPlayer();
                break;
            case 2:
                showList();
                break;
            case 3:
                console.printFemaleTime(tour.takeFemalePromedium()); 
                break;
            case 4:
                console.printMaleTime(tour.takeMalePromedium());
                break;
            default:
                menu();
                break;
        }
        menu();
    }

    public static class WinPresenter implements ActionListener {

        private MainWindow mainWindow;
        private Race race;

        public WinPresenter() {
           // this.mainWindow = new MainWindow(this);
            this.race = new Race();
        }

        @Override
        //Cyclist(int dorsal, String name, String surname, LocalDate dateOfBirth,LocalTime cyclistTime)
        public void actionPerformed(ActionEvent e) {
            switch (Commands.valueOf(e.getActionCommand())){
                case ADD_RUNNER:
                    int dorsal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero de dorsal"));
                    String name = JOptionPane.showInputDialog("Ingrese nombre de corredor con 1a mayuscula");
                    String surname = JOptionPane.showInputDialog("Ingrese apellido de corredor con 1a mayuscula");
                    int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia de nacimiento (1-31)"));
                    int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese mes de nacimiento(1-12)"));
                    int año = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de nacimiento"));
                    int minutos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los minutos del corredor"));
                    int horas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas del corredor"));
                    int segundos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los segundos del corredor"));
                    Cyclist cyclist = new Cyclist(dorsal, name, surname, LocalDate.of(año, mes, dia),LocalTime.of(horas, minutos, segundos));
                    //JOptionPane.showMessageDialog(null, race.addCyclistW(cyclist));
                    break;
                default:
                    break;
            }
        }

        public static void main(String[] args) {
            new WinPresenter();
        }
    }
}
