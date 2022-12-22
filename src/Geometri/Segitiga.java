package Geometri;

import Geometri.service.BangunDatar;

public class Segitiga implements BangunDatar{
    private double sisiSatu;
    private double sisiDua;
    private double sisiTiga;

    

    public double getSisiSatu() {
        return sisiSatu;
    }

    public void setSisiSatu(double sisiSatu) {
        this.sisiSatu = sisiSatu;
    }

    public double getSisiDua() {
        return sisiDua;
    }

    public void setSisiDua(double sisiDua) {
        this.sisiDua = sisiDua;
    }

    public double getSisiTiga() {
        return sisiTiga;
    }

    public void setSisiTiga(double sisiTiga) {
        this.sisiTiga = sisiTiga;
    }

    @Override
    public void gambarBangun() {
        // TODO Auto-generated method stub
        System.out.println("Bangun Segitiga");
        
    }

    @Override
    public void karakteristikBangun() {
        // TODO Auto-generated method stub
        System.out.println("--- Karakteristik Segitiga ---");
        System.out.println("1. Terdiri dari berbagai jenis segitiga yaitu segitiga sama sisi, segitiga sama kaki, segitiga siku-siku, segitiga sembarang");
        System.out.println("2. Memiliki 3 sisi");
    }

    @Override
    public double hitungLuas() {
        // TODO Auto-generated method stub
        double s = 0.5 * (this.sisiSatu + this.sisiDua + this.sisiTiga);
        double luasSegitiga = Math.sqrt(s * (s - this.sisiSatu) * (s - this.sisiDua) * (s - this.sisiTiga));
        return luasSegitiga;
    }

    @Override
    public double hitungKeliling() {
        // TODO Auto-generated method stub
        double kelilingSegitiga = this.sisiSatu + this.sisiDua + this.sisiTiga;
        return kelilingSegitiga;
    }

    
}