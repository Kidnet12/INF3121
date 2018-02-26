import java.util.Iterator;
import java.util.NoSuchElementException;
abstract class LenkeListe<T> implements Liste<T> {
    protected Node foerste = null; //Foerste noden i lenkelisten. Brukes i iterator

    @Override
    public Iterator<T> iterator(){
        return new lenkeListeIterator();
    }
    private class lenkeListeIterator implements Iterator<T>{
        private Node cursor;


        lenkeListeIterator(){

            cursor = foerste;
        }
        public boolean hasNext(){
            return cursor != null;
        }
        public T next(){
            if (hasNext()){
                    T returnValue = cursor.data;
                    cursor = cursor.neste;
                    return returnValue;
            } throw new NoSuchElementException();
        }
    }
    //Finner antall elementer i listen
    public int storrelse(){
        int teller = 0;
        Node cursor = foerste;
        while(cursor != null){
            teller ++;
            cursor = cursor.neste;
        }
        return teller;
    }
    /**
     * Sjekker om listen er tom
     * @return      om listen er tom
     */
    public boolean erTom() {
        return foerste == null;
    }
    //Felles node klasse som inneholder baade neste og forrige.
    class Node{
        protected T data;
        protected Node neste = null;
        protected Node forrige = null;

        public Node (T data){

            this.data = data;
        }
    }
}
