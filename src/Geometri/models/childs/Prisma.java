package Geometri.models.childs;

import Geometri.models.parents.Segitiga;
import Geometri.service.BangunRuang;

public class Prisma extends Segitiga implements BangunRuang{
    private double tinggiPrisma;

    @Override
    public void gambarBangun() {
        System.out.println("PRISMA");
        System.out.print("Inheritence dari ");
        super.gambarBangun();
    }

    @Override
    public void karakteristikBangun() {
        System.out.println("--- Karakteristik Prisma ---");
        System.out.println("1. Mempunyai 5 buah sisi (3 bidang sisi tegak berbentuk persegi panjang dan 2 bidang sisi alas dan tutup berbentuk segitiga)");
        System.out.println("2. Mempunyai 6 titik sudut");
        System.out.println("3. Mempunyai 9 rusuk (3 rusuk merupakan rusuk tegak)");
    }

    @Override
    public double hitungLuasPermukaan() {
        // TODO Auto-generated method stub
        double luasPermukaan = (2 * hitungLuas()) + (hitungKeliling() * this.tinggiPrisma);

        return luasPermukaan;
    }

    @Override
    public double hitungVolume() {
        // TODO Auto-generated method stub
        double volumePrisma = hitungLuas() * this.tinggiPrisma; 
        return volumePrisma;
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    public void setTinggiPrisma(double tinggiPrisma) {
        this.tinggiPrisma = tinggiPrisma;
    }
    
}
