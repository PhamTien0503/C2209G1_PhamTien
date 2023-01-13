package model;

public class Employee {
    private int id;
    private String name;
    private String dateOfBirth;
    private boolean gender;
    private int positionId;

    public Employee() {
    }

    public Employee(int id, String name, String dateOfBirth, boolean gender, int positionId) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.positionId = positionId;
    }

    public Employee(String name, String dateOfBirth, boolean gender, int positionId) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.positionId = positionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }
}
