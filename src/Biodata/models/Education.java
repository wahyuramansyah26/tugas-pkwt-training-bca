package Biodata.models;

public class Education {
    private String sd;
    private String smp;
    private String sma;
    private String pt;
    public Education() {
    }
    public Education(String sd, String smp, String sma, String pt) {
        this.sd = sd;
        this.smp = smp;
        this.sma = sma;
        this.pt = pt;
    }
    public String getSd() {
        return sd;
    }
    public void setSd(String sd) {
        this.sd = sd;
    }
    public String getSmp() {
        return smp;
    }
    public void setSmp(String smp) {
        this.smp = smp;
    }
    public String getSma() {
        return sma;
    }
    public void setSma(String sma) {
        this.sma = sma;
    }
    public String getPt() {
        return pt;
    }
    public void setPt(String pt) {
        this.pt = pt;
    }

    public void showEducation() {
        System.out.println("--- RIWAYAT PENDIDIKAN ---");
        System.out.println("SD : " + this.sd);
        System.out.println("SMP : " + this.smp);
        System.out.println("SMA : " + this.sma);
        System.out.println("Perguruan Tinggi : " + this.pt);
    }
}
