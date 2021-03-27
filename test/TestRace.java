
import java.time.LocalDate;
import java.time.LocalTime;

import exceptions.AgeException;
import exceptions.NameException;
import model.Cyclist;
import model.Gender;
import model.Race;
import model.Teams;

/**
 *
 * @author Andrés Leo Amaya
 */
public class TestRace {
    public static void main(String[] args){
        try {
            Race tour = new Race();
            tour.addCyclist(new Cyclist("Juan", "Roa", LocalDate.of(1980, 11, 10), Gender.MALE.toString(), Teams.UAE.toString(), LocalTime.of(05, 32, 10), 1));
            tour.addCyclist(new Cyclist("Martin", "Castro", LocalDate.of(2000, 1, 4), Gender.MALE.toString(), Teams.INEOS.toString(), LocalTime.of(04, 00, 10), 2));
            tour.addCyclist(new Cyclist("Miguel", "Contreras", LocalDate.of(1993, 10, 30), Gender.MALE.toString(), Teams.TEAM_COLOMBIA.toString(), LocalTime.of(4, 32, 50), 3));
            tour.addCyclist(new Cyclist("Juana", "Celis", LocalDate.of(2002, 3, 26), Gender.FEMALE.toString(), Teams.MOVISTAR.toString(), LocalTime.of(3, 57, 47), 4));
            tour.addCyclist(new Cyclist("Nairo", "Rodriguez", LocalDate.of(2000, 8, 26), Gender.MALE.toString(), Teams.MOVISTAR.toString(), LocalTime.of(05, 32, 10),5));
            tour.addCyclist(new Cyclist("Juan", "Ariza", LocalDate.of(2000, 3, 26), Gender.MALE.toString(), Teams.EF.toString(), LocalTime.of(05, 32, 10), 6));
            tour.addCyclist(new Cyclist("Bryan", "Ibaniez", LocalDate.of(2002, 3, 26), Gender.MALE.toString(), Teams.BORA.toString(), LocalTime.of(04, 52, 10), 7));
            tour.addCyclist(new Cyclist("Daniela", "Ortega", LocalDate.of(2002, 3, 26), Gender.FEMALE.toString(), Teams.ARKEA.toString(), LocalTime.of(05, 01, 10), 8));
            tour.addCyclist(new Cyclist("Nicol", "Munevar", LocalDate.of(2000, 3, 26), Gender.FEMALE.toString(), Teams.TREK.toString(), LocalTime.of(05, 32, 10), 9));
            tour.addCyclist(new Cyclist("Jeffer", "Sanchez", LocalDate.of(2002, 3, 26), Gender.MALE.toString(), Teams.SKY.toString(), LocalTime.of(04, 32, 10), 10));
            tour.addCyclist(new Cyclist("Andresita", "UwU", LocalDate.of(2002, 3, 26), Gender.FEMALE.toString(), Teams.UAE.toString(), LocalTime.of(05, 33, 10), 11));
            tour.addCyclist(new Cyclist("Mateo", "Pinzon", LocalDate.of(2002, 1, 20), Gender.MALE.toString(), Teams.UAE.toString(), LocalTime.of(04,21,05), 12));
            tour.print();
            System.out.println("---------------------------");
            System.out.println("Promedio hombres : " + tour.takeMalePromedium());
            System.out.println("Promedio mujeres : " + tour.takeFemalePromedium());
            System.out.println("__________________");
            tour.order();
            tour.print();
            tour.addCyclist(new Cyclist("Jorge", "Gonzalez", LocalDate.of(2001, 4, 15), Gender.MALE.toString(), Teams.UAE.toString(), LocalTime.of(5, 23, 55), 13));
            tour.print();
        } catch (AgeException e) {
            e.printStackTrace();
        } catch (NameException e) {
            e.printStackTrace();
        }
    }
}
