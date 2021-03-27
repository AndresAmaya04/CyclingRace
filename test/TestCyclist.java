
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import model.Cyclist;
import model.Gender;
import model.Teams;

/**
 *
 * @author Andrés Leo Amaya
 */
public class TestCyclist {

    public static void main(String[] args) {
        Cyclist cyclist1 = new Cyclist("Juan", "Roa", LocalDate.of(1980, 11, 10), Gender.MALE.toString(), Teams.UAE.toString(), LocalTime.of(05, 32, 10), 7);

        Cyclist cyclist2 = new Cyclist("Martin", "Castro", LocalDate.of(2013, 1, 4), Gender.MALE.toString(), Teams.INEOS.toString(), LocalTime.of(05, 32, 10), 5);

        Cyclist cyclist3 = new Cyclist("Miguel Contreras", "Roa", LocalDate.of(1993, 10, 30), Gender.MALE.toString(), Teams.TEAM_COLOMBIA.toString(), LocalTime.of(05, 32, 10), 2);

        Cyclist cyclist4 = new Cyclist("Juana", "Celis", LocalDate.of(2002, 3, 26), Gender.FEMALE.toString(), Teams.MOVISTAR.toString(), LocalTime.of(05, 32, 10), 12);

    }
}
