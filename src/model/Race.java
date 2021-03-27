package model;

import exceptions.AgeException;
import exceptions.NameException;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Andrés Leo Amaya
 */
public class Race {

    public static final int MIN_AGE = 15;
    public static final int MAX_AGE = 40;
    public static final int SECONDS_HOUR = 3600;
    public static final int SECONDS_MINUTE = 60;

    private ArrayList<Cyclist> listOfCyclits;

    public Race() {
        this.listOfCyclits = new ArrayList();
    }

    private boolean isAValidWordForNAme(String word) throws NameException {
        if (Character.isUpperCase(word.charAt(0))){
            return Character.isUpperCase(word.charAt(0));
        }
        throw new NameException();
    }

    private boolean isAValidAge(LocalDate date) throws AgeException {
        int age = Period.between(date, LocalDate.now()).getYears();
        if (age <= MAX_AGE && age >= MIN_AGE){
            return true;
        }
        throw new AgeException();
    }

    public void addCyclist(Cyclist cyclist) throws AgeException, NameException {
        if (isAValidAge(cyclist.getDateOfBirth()) && isAValidWordForNAme(cyclist.getName()) && isAValidWordForNAme(cyclist.getSurname())){
            listOfCyclits.add(cyclist);
            order();
        }
    }

    public boolean isAValidCyclist(String name, String surname, LocalDate date){
        return isAValidWordForNAmeFile(name) && isAValidWordForNAmeFile(surname) && isAValidAgeFile(date);
    }

    private boolean isAValidAgeFile(LocalDate date) {
        int age = Period.between(date, LocalDate.now()).getYears();
        if (age <= MAX_AGE && age >= MIN_AGE){
            return true;
        }
        return false;
    }

    private boolean isAValidWordForNAmeFile(String name) {
        if (Character.isUpperCase(name.charAt(0))){
            return true;
        }
        return false;
    }

    public void putCyclist(Cyclist cyclist){
        listOfCyclits.add(cyclist);
    }

    private int convertToSeconds(LocalTime time) {
        return (time.getHour() * SECONDS_HOUR) + (time.getMinute() * SECONDS_MINUTE) + time.getSecond();
    }

    private LocalTime extractPromedium(int totalSeconds) {
        return LocalTime.of(totalSeconds/ SECONDS_HOUR, (totalSeconds / SECONDS_MINUTE) % SECONDS_MINUTE, totalSeconds % SECONDS_MINUTE);
    }

    public LocalTime takeMalePromedium() {
        int count = 0;
        int totalSeconds = 0;
        for (int i = 0; i < listOfCyclits.size(); i++) {
            if (listOfCyclits.get(i).getGender().equals("MALE")) {
                totalSeconds += convertToSeconds(listOfCyclits.get(i).getCyclistTime());
                count++;
            }
        }
        return 0 < count ? extractPromedium(totalSeconds / count): LocalTime.of(0,0,0);
    }

    public LocalTime takeFemalePromedium() {
        int count = 0;
        int totalSeconds = 0;
        for (int i = 0; i < listOfCyclits.size(); i++) {
            if (listOfCyclits.get(i).getGender().equals("FEMALE")) {
                totalSeconds += convertToSeconds(listOfCyclits.get(i).getCyclistTime());
                count++;
            }
        }
        return 0 < count ? extractPromedium(totalSeconds / count): LocalTime.of(0,0,0);
    }

    public void order() {
        Collections.sort(listOfCyclits, Comparator.comparing(Cyclist::getCyclistTime));
    }
    
    public void print(){
        for (int i = 0; i < listOfCyclits.size(); i++) {
            System.out.println(listOfCyclits.get(i).getName() + " " + listOfCyclits.get(i).getCyclistTime() + " ----> " + listOfCyclits.get(i).getDorsal());
        }
    }
    
    public int getSizeOfRace(){
        return listOfCyclits.size();
    }

    public void deleteRunner(int index){
        if (listOfCyclits.size() > index){
            listOfCyclits.remove(index);
        }
    }
    
    public List <Object[]> extractCyclistInfo(){
        ArrayList <Object[]> list = new ArrayList();
        for (int i = 0; i < listOfCyclits.size(); i++) {
            list.add(listOfCyclits.get(i).getCyclistInfo());
        }
        return list;
    }

    public Cyclist getCyclistIndex(int position){
        return listOfCyclits.get(position);
    }
}
