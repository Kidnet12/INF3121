import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Labyrint {
    private static int rad;
    private static int kolonne;
    private static Rute[][] labyrintArray;
    private OrdnetLenkeliste<String> utveier = new OrdnetLenkeliste<>();

    private Labyrint(int kolonne, int rad) {
        this.rad = rad;
        this.kolonne = kolonne;
        labyrintArray = new Rute[rad][kolonne];
    }

    @Override
    public String toString() {
        String labyrintString = "";
        for (int i = 0; i < kolonne; i++) {
            for (int i2 = 0; i2 < rad; i2++) {
                labyrintString = labyrintString + labyrintArray[i2][i].tilTegn();
            }
        }
        return labyrintString;
    }

    static Labyrint lesFraFil(File fil) throws FileNotFoundException {

        int yAkse = 0;
        String linje = "";
        Scanner innFil = new Scanner(fil);
        Labyrint l = null;
        while (innFil.hasNextLine()) {
            linje = innFil.nextLine();
            String[] split = linje.split(" ");
            l = new Labyrint(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            break;
        }
        while (innFil.hasNextLine()) {
            linje = innFil.nextLine();
            for (int i = 0; i < rad; i++) {
                char[] charArray = linje.toCharArray(); //Gjoer linjen om til et char array
                if (charArray[i] == '#') {
                    SortRute nyRute = new SortRute(l, i + 1, yAkse + 1);
                    labyrintArray[i][yAkse] = nyRute;
                }
                if (charArray[i] == ('.')) {
                    if (i == 0 || i == rad - 1 || yAkse == 0 || yAkse == kolonne - 1) {
                        Aapning nyRute = new Aapning(l, i + 1, yAkse + 1);
                        labyrintArray[i][yAkse] = new Aapning(l, i + 1, yAkse + 1);
                    } else {
                        HvitRute nyRute = new HvitRute(l, i + 1, yAkse + 1);

                        labyrintArray[i][yAkse] = new HvitRute(l, i + 1, yAkse + 1);
                    }
                }

            }
            yAkse++;
        }
        for (int i2 = 0; i2 < kolonne; i2++) {
            for (int i = 0; i < rad; i++) {
                if (i2 != 0) {
                    labyrintArray[i][i2].setNord(labyrintArray[i][i2 - 1]);
                }
                if (i != 0) {
                    labyrintArray[i][i2].setVest(labyrintArray[i - 1][i2]);
                }
                if (i != rad - 1) {
                    labyrintArray[i][i2].setOest(labyrintArray[i + 1][i2]);
                }
                if (i2 != kolonne - 1) {
                    labyrintArray[i][i2].setSyd(labyrintArray[i][i2 + 1]);
                }

            }
        }

        return l;
    }

    public void printLabyrint() {
        String tempString = "";
        for (int i = 0; i < toString().length(); i++) {
            tempString = tempString + toString().charAt(i);
            if (tempString.length() == rad) {
                System.out.println(tempString);
                tempString = "";
            }
        }
    }

    public void printAlleKordinater() {
        for (int i2 = 0; i2 < kolonne; i2++) {
            for (int i = 0; i < rad; i++) {
                labyrintArray[i][i2].printKordinater();
            }
        }
    }

    public OrdnetLenkeliste<String> finnUtveiFra(int kol, int rad) {
        //toem beholder
        utveier.foerste = null;
        labyrintArray[kol - 1][rad - 1].finnUtvei();
        return utveier;
    }

    public void settInniListe(String s) {
        utveier.settInn(s);
    }

    public void settMinimalUtskrift() {

    }
   /* public void settBesoktRuterFalse(){
        for (int i2 = 0; i2< kolonne; i2++) {
            for (int i = 0; i < rad; i++) {
                labyrintArray[i][i2].besokt = false;
            }
        }
    } */
}
