package model;

/**
 *
 * @author Andrés Leo Amaya
 */
public enum Teams {

    MOVISTAR("Movistar"), ASTANA("Astana"), ARKEA("Arkea"), SKY("Sky"), INEOS("Ineos"), UAE("Team Emireates"),
    EF("EF pro"), TREK("Trek team"), BORA("Bora"), TEAM_COLOMBIA("Team COlombia");

    private String name;

    private Teams(String name) {
        this.name = name;
    }

    public String getNameOfTeam() {
        return name;
    }
}
