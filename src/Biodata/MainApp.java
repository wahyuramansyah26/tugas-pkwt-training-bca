package Biodata;

import java.util.Scanner;

import Biodata.models.Education;
import Biodata.models.Person;

public class MainApp {
    static Person person = new Person();;
    static Education education = new Education();;
    static String opsi;
    static Scanner input = new Scanner(System.in);

    public static void menuApp() {
        System.out.println("=== SISTEM INFORMASI BIODATA ===");
        System.out.println("1. Input Data Diri");
        System.out.println("2. Input Data Pendidikan");
        System.out.println("3. Tampilkan Data Diri");
        System.out.println("4. Tampilkan Data Pendidikan");
        System.out.print("Pilihan : ");
        opsi = input.nextLine();
    }
    public static void main(String[] args) throws Exception {
        do {
            menuApp();
            switch (opsi) {
                case "1":
                    System.out.print("Input First Name : ");
                    person.setFirstName(input.nextLine());
                    System.out.print("Input Last Name : ");
                    person.setLastName(input.nextLine());
                    System.out.print("Input Domicile : ");
                    person.setDomicile(input.nextLine());
                    System.out.print("Input Birth Year : ");
                    person.setBirthYear(Integer.valueOf(input.nextLine()));
                    break;

                case "2":
                    System.out.print("Input SD : ");
                    education.setSd(input.nextLine());
                    System.out.print("Input SMP : ");
                    education.setSmp(input.nextLine());
                    System.out.print("Input SMA : ");
                    education.setSma(input.nextLine());
                    System.out.print("Input Perguruan Tinggi : ");
                    education.setPt(input.nextLine());
                    break;

                case "3":
                    person.showPerson();
                    break;

                case "4":
                    education.showEducation();
                    break;

                default:
                    System.out.println("Opsi tidak tersedia.");
                    break;
            }
            System.out.print("Keluar Aplikasi? (y|n)");
            opsi = input.nextLine();
            
        } while (opsi.equalsIgnoreCase("n"));
    }
}
