import java.util.Comparator;
public class OrdnetLenkeliste<T extends Comparable<T>> extends LenkeListe<T> implements Liste<T>{
    //Setter inn element i ordnetliste. Minst til stoerst
    @Override
    public void settInn(T element){
        Node cursor = foerste;
        Node ny = new Node(element);
        if(erTom()) {
            foerste = ny;
            return;
        }
        //Sjekker om element som blir sendt med er stoerre/mindre enn elementene i listen
        while(ny.data.compareTo(cursor.data) >= 0){
            if (cursor.neste != null) {
                cursor = cursor.neste;
            }
            else {//sett i slutten av listen
                ny.forrige = cursor;
                cursor.neste = ny;
                return;
            }
        }
        //sjekk om elementet skal settes foerst
        if(cursor.data.compareTo(foerste.data) <=0) {
            foerste.forrige = ny;
            ny.neste = foerste;
            foerste = ny;
            return;
        }

        //sett mellom to elementer
        cursor.forrige.neste = ny;
        ny.neste = cursor;
        cursor.forrige = ny;



    }
        //Fjerner minste elementet i listen, returnerer null hvis listen er tom.
    @Override
    public T fjern(){
        if (erTom()){
            return null;
        }
        T returnValue = foerste.data;
        foerste = foerste.neste;
        return returnValue;
    }
}
