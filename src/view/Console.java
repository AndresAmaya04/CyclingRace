/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import java.util.Scanner;
import model.Gender;
import model.Teams;

/**
 *
 * @author Andrés Leo Amaya
 */
public class Console {

    private Scanner input;
    private Object[] interfaceTable;

    public Console() {
        this.input = new Scanner(System.in);
        this.interfaceTable = new Object[]{Interface.NAME, Interface.SURNAME, Interface.TEAM, Interface.GENDER, Interface.TIME, Interface.DORSAL, Interface.AGE};
    }

    public String getNameOfCyclist() {
        System.out.println("Ingrese el nombre del corredor con la primera letra en mayuscula :");
        return input.nextLine();
    }

    public String getSurnameOfCyclist() {
        System.out.println("Ingrese el apellido del correrdor con la primera letra mayuscula :");
        return input.nextLine();
    }

    private int getYearOfTheCyclist() {
        System.out.println("Ingrese el año en el que nacio :");
        return Integer.parseInt(input.nextLine());
    }

    private int getMonthOfTheCyclist() {
        System.out.println("Ingrese el numero del mes en el que nacio (1-12):");
        return Integer.parseInt(input.nextLine());
    }

    private int getDayOfTheCyclist() {
        System.out.println("Ingrese la fecha del mes en el que nacio: ");
        return Integer.parseInt(input.nextLine());
    }

    public Gender getCyclistGender() {
        System.out.println("Escoja con el genero del corredor :\n 1. Mujer\n 2. Hombre");
        int option = Integer.parseInt(input.nextLine());
        Gender election = null;
        switch (option) {
            case 1:
                election = Gender.FEMALE;
                break;
            case 2:
                election = Gender.MALE;
                break;
            default:
                getCyclistGender();
        }
        return election;
    }

    public Teams getCyclistTeam() {
        System.out.println("Escoja el numero correspondiente al equipo por el que correra el ciclista : ");
        System.out.println(" 1. Movistar\n 2. Arkea\n 3. SKY\n 4. Ineos\n 5. UAE\n 6. EF \n 7. Trek\n 8. Bora\n 9. Team Colombia\n 10. Astana");
        int option = Integer.parseInt(input.nextLine());
        Teams team = null;
        switch (option) {
            case 1:
                team = Teams.MOVISTAR;
                break;
            case 2:
                team = Teams.ARKEA;
                break;
            case 3:
                team = Teams.SKY;
                break;
            case 4:
                team = Teams.INEOS;
                break;
            case 5:
                team = Teams.UAE;
                break;
            case 6:
                team = Teams.EF;
                break;
            case 7:
                team = Teams.TREK;
                break;
            case 8:
                team = Teams.BORA;
                break;
            case 9:
                team = Teams.TEAM_COLOMBIA;
                break;
            case 10:
                team = Teams.ASTANA;
                break;
            default:
                getCyclistTeam();
        }
        return team;
    }
    
    private int getCyclistHours(){
        System.out.println("Ingrese el numero de horas que tendra el ciclista en el recorrido(solo horas sin contar minutos ni segundos):");
        return Integer.parseInt(input.nextLine());
    } 
    
    private int getCyclistMinutes(){
        System.out.println("Ingrese el numero de minutos que tendra el ciclista en su recorrido(ignore el de horas y segundos): ");
        return Integer.parseInt(input.nextLine());
    }
    
    private int getCyclistSeconds(){
        System.out.println("Ingrese el numero de segundos que segunods que tendra el ciclista en su recorrido: ");
        return Integer.parseInt(input.nextLine());
    }
    
    public int showMenu(){
        System.out.println("\n-------TourISC-------");
        System.out.println("Seleccione una opcion :\n 1. agragar corredor\n 2. para mostrar los datos\n 3. Extraer promdeio femenino\n 4. Extraer promdeio masculino");
        return Integer.parseInt(input.nextLine());
    }
    
    public LocalTime getTime(){
        return LocalTime.of(getCyclistHours(), getCyclistMinutes(), getCyclistSeconds());
    }
    
    public LocalDate getDate(){
        return LocalDate.of(getYearOfTheCyclist(), getMonthOfTheCyclist(), getDayOfTheCyclist());
    }
    
    public void printMensage(boolean b){
        System.out.println(b?"El ciclista no pudo ser agregado":"El ciclista fue agregado exitosamente");
    }
    
    public void printFemaleTime(LocalTime time){
        System.out.println("Promedio femenino : " + time);
    }
    public void printMaleTime(LocalTime time){
        System.out.println("Promedio masculino : " + time);
    }
    
    public void printTable(List <Object[]> list){
        System.out.println(String.format(Interface.FORMAT, interfaceTable));
        for (int i = 0; i < list.size(); i++) {
           System.out.println(String.format(Interface.FORMAT, list.get(i)));
        }
    }
}
