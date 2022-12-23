package Geometri.models.parents;

import Geometri.service.BangunDatar;

public class Persegi implements BangunDatar{
    private double sisi;

    @Override
    public void gambarBangun() {
        // TODO Auto-generated method stub
        System.out.println("Bangun Persegi");
        
    }

    @Override
    public void karakteristikBangun() {
        // TODO Auto-generated method stub
        System.out.println("--- Karakteristik Persegi ---");
        System.out.println("1. Memiliki sisi-sisi yang sama panjang");
        System.out.println("2. Memiliki dua diagonal yang sama panjang (keduanya saling berpotongan dan membentuk tegak lurus serta membaginya menjadi dua bagian sama panjang)");
        System.out.println("3. Memiliki empat sudut siku-siku yang sama besar, yakni 90 derajat");
        System.out.println("4. Memiliki empat sumbu simetri lipat");
        System.out.println("5. Memiliki empat titik sudut");
        System.out.println("6. Memiliki empat sumbu simetri putar");
        
    }

    @Override
    public double hitungLuas() {
        // TODO Auto-generated method stub
        double luasPersegi = this.sisi * this.sisi;
        return luasPersegi;
    }

    @Override
    public double hitungKeliling() {
        // TODO Auto-generated method stub
        double kelilingPersegi = 4 * this.sisi;
        return kelilingPersegi;
    }

    public double getSisi() {
        return sisi;
    }

    public void setSisi(double sisi) {
        this.sisi = sisi;
    }
    
}
