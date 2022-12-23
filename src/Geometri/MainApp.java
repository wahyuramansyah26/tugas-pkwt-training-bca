package Geometri;

import java.util.Scanner;

import Geometri.models.childs.Bola;
import Geometri.models.childs.Kubus;
import Geometri.models.childs.Prisma;
import Geometri.models.parents.Lingkaran;
import Geometri.models.parents.Persegi;
import Geometri.models.parents.Segitiga;

public class MainApp {
    static Persegi persegi = new Persegi();
    static Segitiga segitiga = new Segitiga();
    static Lingkaran lingkaran = new Lingkaran();
    static Kubus kubus = new Kubus();
    static Prisma prisma = new Prisma();
    static Bola bola = new Bola();

    static String opsi;
    static Scanner input = new Scanner(System.in);

    private static void mainMenu() {
        System.out.println("=== GEOMETRI ===");
        System.out.println("1. Bangun Datar");
        System.out.println("2. Bangun Ruang");
        System.out.print("Pilihan : ");
        opsi = input.nextLine();
    }

    private static void menuDatar() {
        System.out.println("=== Bangun Datar ===");
        System.out.println("1. Persegi");
        System.out.println("2. Segitiga");
        System.out.println("3. Lingkaran");
        System.out.print("Pilihan : ");
        opsi = input.nextLine();
    }

    private static void menuRuang() {
        System.out.println("=== Bangun Ruang ===");
        System.out.println("1. Kubus");
        System.out.println("2. Prisma");
        System.out.println("3. Bola");
        System.out.print("Pilihan : ");
        opsi = input.nextLine();
    }

    private static void tampilanPersegi() {
        persegi.gambarBangun();
        persegi.karakteristikBangun();
    }

    private static void tampilanSegitiga() {
        segitiga.gambarBangun();
        segitiga.karakteristikBangun();
    }

    private static void tampilanLingkaran() {
        lingkaran.gambarBangun();
        lingkaran.karakteristikBangun();
    }

    private static void tampilanKubus() {
        kubus.gambarBangun();
        kubus.karakteristikBangun();
    }

    private static void tampilanPrisma() {
        prisma.gambarBangun();
        prisma.karakteristikBangun();
    }

    private static void tampilanBola() {
        bola.gambarBangun();
        bola.karakteristikBangun();
    }

    public static void main(String[] args) throws Exception {
        do {
            mainMenu();
            switch (opsi) {
                case "1":
                    menuDatar();
                    switch (opsi) {
                        case "1":
                            tampilanPersegi();
                            System.out.print("Input panjang sisi : ");
                            persegi.setSisi(Double.valueOf(input.nextLine()));
                            System.out.println("Luas Persegi = " + persegi.hitungLuas());
                            System.out.println("Keliling Persegi = " + persegi.hitungKeliling());
                            break;
                        
                        case "2":
                            tampilanSegitiga();
                            System.out.print("Input sisi pertama : ");
                            segitiga.setSisiSatu(Double.valueOf(input.nextLine()));
                            System.out.print("Input sisi kedua : ");
                            segitiga.setSisiDua(Double.valueOf(input.nextLine()));
                            System.out.print("Input sisi ketiga : ");
                            segitiga.setSisiTiga(Double.valueOf(input.nextLine()));
                            System.out.println("Luas Segitiga = " + segitiga.hitungLuas());
                            System.out.println("Keliling Segitiga = " + segitiga.hitungKeliling());
                            break;

                        case "3":
                            tampilanLingkaran();
                            System.out.print("Input jari-jari : ");
                            lingkaran.setJarijari(Double.valueOf(input.nextLine()));
                            System.out.println("Luas Lingkaran = " + lingkaran.hitungLuas());
                            System.out.println("Keliling Lingkaran = " + lingkaran.hitungKeliling());
                            break;
                    
                        default:
                            System.out.println("Pilihan tidak tersedia.");
                            break;
                    }
                    break;

                case "2":
                    menuRuang();
                    switch (opsi) {
                        case "1":
                            tampilanKubus();
                            System.out.print("Input panjang rusuk : ");
                            kubus.setSisi(Double.valueOf(input.nextLine()));
                            System.out.println("Luas Permukaan Kubus = " + kubus.hitungLuasPermukaan());
                            System.out.println("Volume Kubus = " + kubus.hitungVolume());
                            break;
                        
                        case "2":
                            tampilanPrisma();
                            System.out.print("Input sisi pertama alas prisma : ");
                            prisma.setSisiSatu(Double.valueOf(input.nextLine()));
                            System.out.print("Input sisi kedua alas prisma : ");
                            prisma.setSisiDua(Double.valueOf(input.nextLine()));
                            System.out.print("Input sisi ketiga alas prisma : ");
                            prisma.setSisiTiga(Double.valueOf(input.nextLine()));
                            System.out.print("Input tingi prisma : ");
                            prisma.setTinggiPrisma(Double.valueOf(input.nextLine()));
                            System.out.println("Luas Permukaan Prisma = " + prisma.hitungLuasPermukaan());
                            System.out.println("Volume Prisma = " + prisma.hitungVolume());
                            break;

                        case "3":
                            tampilanBola();
                            System.out.print("Input jari-jari bola : ");
                            bola.setJarijari(Double.valueOf(input.nextLine()));
                            System.out.println("Luas Permukaan Bola = " + bola.hitungLuasPermukaan());
                            System.out.println("Volume Bola = " + bola.hitungVolume());
                            break;
                    
                        default:
                            System.out.println("Pilihan tidak tersedia.");
                            break;
                    }
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
                    break;
            }
            System.out.print("Keluar Aplikasi? (y|n)");
            opsi = input.nextLine();
            
        } while (opsi.equalsIgnoreCase("n"));
    }
}
