package Geometri.models.childs;

import Geometri.models.parents.Lingkaran;
import Geometri.service.BangunRuang;

public class Bola extends Lingkaran implements BangunRuang {
    @Override
    public void gambarBangun() {
        System.out.println("BOLA");
        System.out.print("Inheritence dari ");
        super.gambarBangun();
    }

    @Override
    public void karakteristikBangun() {
        System.out.println("--- Karakteristik Bola ---");
        System.out.println("1. Memiliki 1 sisi");
        System.out.println("2. Memiliki 1 titik pusat");
        System.out.println("3. Tidak memiliki rusuk");
        System.out.println("4. Tidak memiliki titik sudut");
        System.out.println("5. Tidak memiliki diagonal bidang");
        System.out.println("6. Sisi pada bangun ruang bola disebut dinding bola");
        System.out.println("7. Jarak dari titik pusat ke dinding bola disebut jari jari");
        System.out.println("8. Jarak dari dinding bola ke dinding bola disebut diameter");
    }


    @Override
    public double hitungLuasPermukaan() {
        // TODO Auto-generated method stub
        double luasPermukaan = 4 * hitungLuas();
        return luasPermukaan;
    }

    @Override
    public double hitungVolume() {
        // TODO Auto-generated method stub
        double volumeBola = (4 * Math.PI * Math.pow(getJarijari(), 3)) / 3;
        return volumeBola;
    }
    
}
