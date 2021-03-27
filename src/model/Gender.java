package model;

/**
 *
 * @author Andrés Leo Amaya
 */
public enum Gender {

    MALE("Masculino"), FEMALE("Femenino");

    private String gender;

   Gender(String gender) {
        this.gender=gender;
    }

    public String getGender() {
        return gender;
    }

}
