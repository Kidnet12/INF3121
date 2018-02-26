
abstract class Rute {
    protected int xAkse;
    protected int yAkse;
    protected Rute nord = null;
    protected Rute syd = null;
    protected Rute vest = null;
    protected Rute oest = null;
    protected Labyrint tilhorer;
    protected boolean besokt;
    Rute(Labyrint tilhorer, int xAkse, int yAkse){
        this.tilhorer = tilhorer;
        this.xAkse = xAkse;
        this.yAkse=yAkse;
        this.besokt = false;
    }

    public Rute getNord() {
        return nord;
    }

    public void setNord(Rute nord) {
        this.nord = nord;
    }

    public Rute getSyd() {
        return syd;
    }

    public void setSyd(Rute syd) {
        this.syd = syd;
    }

    public Rute getVest() {
        return vest;
    }

    public void setVest(Rute vest) {
        this.vest = vest;
    }

    public Rute getOest() {
        return oest;
    }

    public void setOest(Rute oest) {
        this.oest = oest;
    }

    abstract char tilTegn();


    public int getyAkse() {
        return yAkse;
    }

    public int getxAkse() {
        return xAkse;
    }
    public void printKordinater(){
        System.out.println("("+getxAkse() + "," + getyAkse()+")");

    }

    public void gaa(String forelopigeKordinater){

    }



    public void finnUtvei(){
        gaa("");
    }
}
