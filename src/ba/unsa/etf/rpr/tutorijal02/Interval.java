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
   public Interval intersect(Interval drugi) {
        return intersect(this,drugi);
    }
    public static Interval intersect(Interval prvi, Interval drugi) {
           //ako nema presjeka
           if((drugi.isIn(prvi.pocetnaTacka)==false && drugi.isIn(prvi.krajnjaTacka)==false) || (prvi.isIn(drugi.pocetnaTacka)==false && prvi.isIn(drugi.krajnjaTacka)==false)) {
               Interval presjek = new Interval();
           }
           //ako su jednaki
           else if(prvi.equals(drugi)){
               return prvi;
           }
           //ako je prvi u drugom
           else if(prvi.pocetnaTacka >= drugi.pocetnaTacka && prvi.krajnjaTacka <= drugi.krajnjaTacka){
               //ako se rubovi ne dodiruju
               if(prvi.pocetnaTacka > drugi.pocetnaTacka && prvi.krajnjaTacka < drugi.krajnjaTacka){
                   Interval presjek = new Interval (prvi.pocetnaTacka, prvi.krajnjaTacka, prvi.pocetnaPripadaIntervalu, prvi.krajnjaPripadaIntervalu);
                   return presjek;
               }
               //ako se i pocetni i krajnji rub dodiruju
               if(prvi.pocetnaTacka == drugi.pocetnaTacka && prvi.krajnjaTacka == drugi.krajnjaTacka){
                   if(prvi.pocetnaPripadaIntervalu && prvi.krajnjaPripadaIntervalu){
                       Interval presjek = new Interval(drugi.pocetnaTacka, drugi.krajnjaTacka, drugi.pocetnaPripadaIntervalu, drugi.krajnjaPripadaIntervalu);
                       return presjek;
                   }
                   else if(prvi.pocetnaPripadaIntervalu){
                       Interval presjek = new Interval(prvi.pocetnaTacka, prvi.krajnjaTacka, drugi.pocetnaPripadaIntervalu, false);
                   }
                   else{
                       Interval presjek = new Interval(prvi.pocetnaTacka, prvi.krajnjaTacka, false, drugi.krajnjaPripadaIntervalu);
                       return presjek;
                   }
               }
               //ako se pocetni rubovi dodiruju
               if(prvi.pocetnaTacka == drugi.pocetnaTacka){
                   if(drugi.pocetnaPripadaIntervalu){
                       Interval presjek = new Interval(prvi.pocetnaTacka, prvi.krajnjaTacka, prvi.pocetnaPripadaIntervalu, prvi.krajnjaPripadaIntervalu);
                       return presjek;
                   }
                   else{
                       Interval presjek = new Interval(prvi.pocetnaTacka, prvi.krajnjaTacka, false, drugi.krajnjaPripadaIntervalu);
                       return presjek;
                   }
               }
               //ako se krajnji rubovi dodiruju
               if(prvi.krajnjaTacka == drugi.krajnjaTacka){
                   if(drugi.krajnjaPripadaIntervalu){
                       Interval presjek = new Interval(prvi.pocetnaTacka, prvi.krajnjaTacka, prvi.pocetnaPripadaIntervalu, prvi.krajnjaPripadaIntervalu);
                       return presjek;
                   }
                   else{
                       Interval presjek = new Interval(prvi.pocetnaTacka, prvi.krajnjaTacka, prvi.pocetnaPripadaIntervalu, false);
                       return presjek;
                   }
               }
           }
           //ako je drugi u prvom
           else if(prvi.pocetnaTacka <= drugi.pocetnaTacka && prvi.krajnjaTacka >= drugi.krajnjaTacka) {
               //ako se rubovi ne dodiruju
               if (prvi.pocetnaTacka < drugi.pocetnaTacka && prvi.krajnjaTacka > drugi.krajnjaTacka) {
                   Interval presjek = new Interval(drugi.pocetnaTacka, drugi.krajnjaTacka, drugi.pocetnaPripadaIntervalu, drugi.krajnjaPripadaIntervalu);
                   return presjek;
               }
               //slucaj kad se i pocetni i krajni rub dodiruju je obradjen u sekciji "ako je prvi u drugom"
               //ako se pocetni rubovi dodiruju
               if (drugi.pocetnaTacka == prvi.pocetnaTacka) {
                   if (prvi.pocetnaPripadaIntervalu) {
                       Interval presjek = new Interval(drugi.pocetnaTacka, drugi.krajnjaTacka, drugi.pocetnaPripadaIntervalu, drugi.krajnjaPripadaIntervalu);
                       return presjek;
                   } else {
                       Interval presjek = new Interval(drugi.pocetnaTacka, drugi.krajnjaTacka, false, drugi.krajnjaPripadaIntervalu);
                       return presjek;
                   }
               }
               //ako se krajnji rubovi dodiruju
               if (drugi.krajnjaTacka == prvi.krajnjaTacka) {
                   if (prvi.krajnjaPripadaIntervalu) {
                       Interval presjek = new Interval(drugi.pocetnaTacka, drugi.krajnjaTacka, drugi.pocetnaPripadaIntervalu, drugi.krajnjaPripadaIntervalu);
                       return presjek;
                   } else {
                       Interval presjek = new Interval(drugi.pocetnaTacka, drugi.krajnjaTacka, drugi.pocetnaPripadaIntervalu, false);
                       return presjek;
                   }
               }
           }
           //ako je prvi ispred drugog
           else if(prvi.pocetnaTacka <= drugi.pocetnaTacka && prvi.krajnjaTacka <= drugi.krajnjaTacka) {
               //ako nema dodirnih tacaka
               if (prvi.pocetnaTacka < drugi.pocetnaTacka && prvi.krajnjaTacka < drugi.krajnjaTacka) {
                   Interval presjek = new Interval(drugi.pocetnaTacka, prvi.krajnjaTacka, drugi.pocetnaPripadaIntervalu, prvi.krajnjaPripadaIntervalu);
                   return presjek;
               }
               //ako ima dodirnih tacaka
               else {
                   if(drugi.pocetnaPripadaIntervalu && prvi.pocetnaPripadaIntervalu){
                       Interval presjek = new Interval(prvi.pocetnaTacka, prvi.pocetnaTacka, true, true);
                       return presjek;
                   } else{
                       Interval presjek = new Interval(); return presjek;
                   }
               }
           }
           //ako je prvi iza drugog
           else {
               //ako nema dodirnih tacaka
               if (prvi.pocetnaTacka > drugi.pocetnaTacka && prvi.krajnjaTacka > drugi.krajnjaTacka) {
                   Interval presjek = new Interval(prvi.pocetnaTacka, drugi.krajnjaTacka, prvi.pocetnaPripadaIntervalu, drugi.krajnjaPripadaIntervalu);
                   return presjek;
               }
               //ako ima dodirnih tacaka
               else {

                   if (drugi.krajnjaPripadaIntervalu && prvi.pocetnaPripadaIntervalu) {
                       Interval presjek = new Interval(drugi.krajnjaTacka, drugi.krajnjaTacka, true, true);
                       return presjek;
                   } else {
                       Interval presjek = new Interval();
                       return presjek;
                   }
               }
           }
           Interval presjek = new Interval(); return presjek;
    }
    public boolean equals(Interval interval){
               if (this.pocetnaPripadaIntervalu == interval.pocetnaPripadaIntervalu && this.krajnjaPripadaIntervalu == interval.krajnjaPripadaIntervalu && this.pocetnaTacka == interval.pocetnaTacka && this.krajnjaTacka == interval.krajnjaTacka) {
                   return true;
               }
               return false;
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
