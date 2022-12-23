package Geometri.models.parents;

import Geometri.service.BangunDatar;

public class Lingkaran implements BangunDatar {
    private double jarijari;

    @Override
    public void gambarBangun() {
        // TODO Auto-generated method stub
        System.out.println("Bangun Lingkaran");
        
    }

    @Override
    public void karakteristikBangun() {
        // TODO Auto-generated method stub
        System.out.println("--- Karakteristik Lingkaran ---");
        System.out.println("1. Memiliki jarak pada tepi garis ke titik pusat yang biasa disebut dengan jari-jari atau dilambangkan r");
        System.out.println("2. Memiliki simetri lipat dan putar yang jumlahnya tidak terhingga");
        System.out.println("3. Memiliki jumlah derajat lingkaran sebesar 360 derajat");
        System.out.println("4. Memiliki satu titik pusat");
        System.out.println("5. Memiliki diameter yang membagi lingkaran menjadi dua sisi yang seimban");
        System.out.println("6. Memiliki jari-jari yang menghubungkan ke titik pusat dengan titik busur lingkaran");
        System.out.println("7. Memiliki diameter yang konstan");
        
    }

    @Override
    public double hitungLuas() {
        // TODO Auto-generated method stub
        double luasLingkaran = Math.PI * this.jarijari * this.jarijari;;
        return luasLingkaran;
    }

    @Override
    public double hitungKeliling() {
        // TODO Auto-generated method stub
        double kelilingLingkaran = 2 * Math.PI * this.jarijari;
        return kelilingLingkaran;
    }

    public double getJarijari() {
        return jarijari;
    }

    public void setJarijari(double jarijari) {
        this.jarijari = jarijari;
    }
    
}
