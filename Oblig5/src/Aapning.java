
public class Aapning extends HvitRute {
    public Aapning(Labyrint l, int xAkse, int yAkse){
        super(l, xAkse, yAkse);
    }


    @Override
    char tilTegn() {
        return '%';
    }
    @Override
    public void gaa(String s){
        String veiKoordinater = s + " --> " +  "(" + getxAkse() + "," + getyAkse() + ")";
        tilhorer.settInniListe(veiKoordinater);
        System.out.println("Aapning funnet");
        printKordinater();

    }
}
