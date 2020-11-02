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
        return false;
    }
    public boolean isIn(double tacka){
        return false;
    }
    public static Interval intersect(Interval prviInterval, Interval drugiInterval){
        Interval presjek = new Interval();
        return presjek;
    }
    public Interval intersect(Interval drugiInterval){
        Interval presjek = new Interval();
        return presjek;
    }
    @Override
    public boolean equals(Interval interval){
        boolean jednakePocetneTacke = false;
        boolean jednakeKrajnjeTacke = false;
        boolean jednakiIntervali = false;
        return jednakiIntervali;
    }
    @Override
    public String toString()
    }
}
