package Geometri;

import Geometri.service.BangunRuang;

public class Kubus extends Persegi implements BangunRuang{

    @Override
    public void gambarBangun() {
        System.out.println("KUBUS");
        System.out.print("Inheritence dari ");
        super.gambarBangun();
    }

    @Override
    public void karakteristikBangun() {
        System.out.println("--- Karakteristik Kubus ---");
        System.out.println("1. Memiliki 6 buah sisi yang sama berbentuk persegi");
        System.out.println("2. Memiliki 8 buah titik sudut");
        System.out.println("3. Memiliki 12 buah rusuk yang sama panjang");
        System.out.println("4. Memiliki 12 buah diagonal bidang yang sama panjang");
        System.out.println("5. Memiliki 4 buah diagonal ruang yang sama panjang");
        System.out.println("6. Memiliki 6 buah bidang diagonal, yang berbentuk persegi panjang saling kongruen");
    }


    @Override
    public double hitungLuasPermukaan() {
        // TODO Auto-generated method stub
        return 6 * hitungLuas();
    }

    @Override
    public double hitungVolume() {
        // TODO Auto-generated method stub
        return getSisi() * getSisi() * getSisi();
    }
    
}
