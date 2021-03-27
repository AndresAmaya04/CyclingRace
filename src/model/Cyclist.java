package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

/**
 *
 * @author Andrés Leo Amaya
 */
public class Cyclist {

    private int dorsal;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String gender;
    private String team;
    private LocalTime cyclistTime;
    private int age;

    public Cyclist(String name, String surname, LocalDate dateOfBirth, String gender, String team, LocalTime cyclistTime, int dorsal) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.team = team;
        this.cyclistTime = cyclistTime;
        this.dorsal = dorsal;
        this.age = Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public Cyclist(int dorsal, String name, String surname, LocalDate dateOfBirth,LocalTime cyclistTime) {
        this.dorsal=dorsal;
        this.name=name;
        this.surname=surname;
        this.dateOfBirth=dateOfBirth;
        this.cyclistTime=cyclistTime;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getTeam() {
        return team;
    }

    public LocalTime getCyclistTime() {
        return cyclistTime;
    }

    public int getDorsal() {
        return dorsal;
    }
    
    public Object[] getCyclistInfo(){
        return new Object[]{this.name, this.surname, this.team, this.gender, this.cyclistTime, this.dorsal, this.age};
    }

    public Object[] getCyclistData(){
        return new Object[]{this.name, this.surname, this.team, this.gender, this.age, this.cyclistTime};
    }

    public int getAge() {
        return age;
    }
}
