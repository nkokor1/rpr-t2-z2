package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetnaTacka;
    private double krajnjaTacka;
    boolean pocetnaPripadaIntervalu;
    boolean krajnjaPripadaIntervalu;
    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pocetnaPripadaIntervalu, boolean krajnjaPripadaIntervalu){
        if(pocetnaTacka>krajnjaTacka) {
            throw new IllegalArgumentException("Početna tačka veća od krajnje tačke");
        }
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
    }
    public Interval() {
        pocetnaTacka = 0;
        krajnjaTacka = 0;
        pocetnaPripadaIntervalu = false;
        krajnjaPripadaIntervalu = false;
    }
    public boolean isNull(){
        if(pocetnaTacka==krajnjaTacka) {
            return true;
        }
        return false;
    }
    public boolean isIn(double tacka){
        if(pocetnaPripadaIntervalu && krajnjaPripadaIntervalu) {
            if(tacka>=pocetnaTacka && tacka<=krajnjaTacka) {
                return true;
            } return false;
        }
        if(pocetnaPripadaIntervalu && !krajnjaPripadaIntervalu) {
            if(tacka>=pocetnaTacka && tacka<krajnjaTacka) {
                return true;
            }
            return false;
        }
        if(!pocetnaPripadaIntervalu && krajnjaPripadaIntervalu) {
            if(tacka>pocetnaTacka && tacka<=krajnjaTacka) {
                return true;
            }
            return false;
        }
            return false;
    }
   /* public Interval intersect(Interval interval) {
        //ako nema presjeka
        if(this.krajnjaTacka<interval.krajnjaTacka) {
            Interval presjek = new Interval();
        }
        if(this.equals(interval)){
            return this;
        }
    }*/
    public static Interval intersect(Interval prviInterval, Interval drugiInterval) {
        return (prviInterval.intersect(drugiInterval));
    }
    public boolean equals(Interval interval){
        boolean jednakePocetneTacke = false;
        boolean jednakeKrajnjeTacke = false;
        boolean jednakiIntervali = false;
        return jednakiIntervali;
    }
    public String toString() {
        if (isNull()) {
            return "()";
        } else {
            if (pocetnaPripadaIntervalu == false) {
                String ispis = "(" + pocetnaTacka + "," + krajnjaTacka;
                if (krajnjaPripadaIntervalu) {
                    ispis = ispis + "]";
                } else {
                    ispis = ispis + ")";
                }
                return ispis;
            } else {
                String ispis = "[" + pocetnaTacka + "," + krajnjaTacka;
                if (krajnjaPripadaIntervalu) {
                    ispis = ispis + "]";
                } else {
                    ispis = ispis + ")";
                }
                return ispis;
            }
        }
    }
}
