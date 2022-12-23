package Biodata.models;

import java.time.Year;

public class Person {
    private String firstName;
    private String lastName;
    private String domicile;
    private Integer birthYear;
    
    public Person() {
    }

    public Person(String firstName, String lastName, String domicile, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.domicile = domicile;
        this.birthYear = birthYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDomicile() {
        return domicile;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void showPerson() {
        if(this.firstName == null || this.lastName == null || this.domicile == null || this.birthYear == null) {
            System.out.println("Data belum ada, silakan input data terlebih dahulu!");
        }else{
            int currentYear = Year.now().getValue();
            System.out.println("--- BIODATA ---");
            System.out.println("Nama Lengkap : " + this.firstName + " " + this.lastName);
            System.out.println("Domisili : " + this.domicile);
            System.out.println("Umur : " + (currentYear - this.birthYear) + " Tahun" );
        }
    }

}
