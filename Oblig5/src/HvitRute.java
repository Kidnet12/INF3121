
public class HvitRute extends Rute {
    public HvitRute(Labyrint l, int xAkse, int yAkse){
        super(l,xAkse, yAkse);
    }
    @Override
    char tilTegn() {
        return '.';
    }
    @Override
    public void gaa(String s){
        String veiKoordinater = s + " --> " +  "(" + getxAkse() + "," + getyAkse() + ")";
        this.besokt = true;
    if (!vest.besokt ) {
        vest.gaa(veiKoordinater);
    }
    if (!oest.besokt) {
        oest.gaa(veiKoordinater);
    }
    if (!syd.besokt) {
        syd.gaa(veiKoordinater);
    }
    if (!nord.besokt) {
        nord.gaa(veiKoordinater);
    }
        //clear besokt
        this.besokt = false;
}
}
