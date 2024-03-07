/**
 * classe che rappresenta l'eccezione di una lista vuota
 */
class ListaVuota extends Exception{
}

/**
 * classe che rappresenta l'eccezione di una lista che non contiene un elemento
 */
class ElementoNonTrovato extends Exception{
}

/**
 * classe che rappresenta una lista di stringhe
 */
public class Lista{

    /**
     * classe che rappresenta un nodo di una lista
     */
    private class Nodo{
        private String info;
        private Nodo link;

        /**
         * costruttore della classe Nodo
         * @param info informazioni del nodo
         */
        public Nodo(String info){
            setInfo(info);
            setLink(link);
        }

        /**
         * setter dell'attributo info
         * @param info informazioni del nodo
         */
        public void setInfo(String info){
            this.info = info;
        }

        /**
         * setter dell'attributo link
         * @param link collegamento al nodo successivo
         */
        public void setLink(Nodo link){
            this.link = link;
        }

        /**
         * getter dell'attributo info
         * @return informazioni del nodo
         */
        public String getInfo(){
            return info;
        }

        /**
         * getter dell'attributo link
         * @return collegamento del nodo successivo
         */
        public Nodo getLink(){
            return link;
        }
    }
    private Nodo head;
    private int elementi;

    /**
     * costruttore vuoto della classe Lista
     */
    public Lista(){
        setHead(null);
        setElementi(0);
    }

    /**
     * costruttore parametrico della classe Lista
     * @param info vettore contenente le informazioni dei nodi della lista
     */
    public Lista(String[] info){
        for(int i=0; i<info.length; i++){
            add(new String(info[i]));
            setElementi(getElementi()+1);
        }
    }

    /**
     * setter dell'attributo head
     * @param head testa della lista
     */
    public void setHead(Nodo head){
        this.head = head;
    }

    /**
     * setter dell'attributo elementi
     * @param elementi numero di elementi della lista
     */
    public void setElementi(int elementi){
        this.elementi = elementi;
    }

    /**
     * getter dell'attributo head
     * @return testa della lista
     */
    public Nodo getHead(){
        return head;
    }

    /**
     * getter dell'attributo elementi
     * @return numero di elementi della lista
     */
    public int getElementi(){
        return elementi;
    }

    /**
     * metodo per aggiungere un nodo in testa alla lista
     * @param info informazioni del nodo da aggiungere
     */
    private void addTesta(String info){
        Nodo nodo = new Nodo(info);
        nodo.setLink(getHead());
        setHead(nodo);
        setElementi(getElementi()+1);
    }

    /**
     * metodo per aggiungere un nodo in coda alla lista
     * @param info informazioni del nodo da aggiungere
     */
    private void addCoda(String info){
        if(getHead() == null){
            addTesta(info);
        }else{
            Nodo indice = head;
            Nodo nodo = new Nodo(info);
            while(indice.getLink() != null){
                indice = indice.getLink();
            }
            nodo.setLink(null);
            indice.setLink(nodo);
            setElementi(getElementi()+1);
        }
    }

    /**
     * metodo per aggiungere un nodo alla lista
     * @param info informazioni del nodo da aggiungere
     */
    public void add(String info){
        if(getHead() == null){
            addTesta(info);
        }else{
            if(info.equals(getHead().getInfo())){
                addTesta(info);
            }else{
                Nodo primo = head;
                Nodo secondo = head.getLink();
                Nodo nodo = new Nodo(info);
                while(secondo != null && secondo != null && secondo.getInfo().equals(info)){
                    primo = secondo;
                    secondo = secondo.getLink();
                }
                if(secondo == null){
                    addCoda(info);
                }else{
                    nodo.setLink(secondo);
                    primo.setLink(nodo);
                    setElementi(getElementi()+1);
                }
            }
        }
    }

    /**
     * metodo per eliminare il nodo in testa alla lista
     */
    private void deleteTesta(){
        if(getHead() == null){
            return;
        }
        setHead(getHead().getLink());
        setElementi(getElementi()-1);
    }

    /**
     * metodo per eliminare un nodo dalla lista
     * @param info informazioni del nodo da eliminare
     * @throws ElementoNonTrovato eccezione dell'elemento non trovato
     */
    public void delete(String info) throws ElementoNonTrovato{
        if(getHead() == null){
            return;
        }
        if(getHead().getInfo().equals(info)){
            deleteTesta();
        }else{
            Nodo primo = getHead();
            Nodo secondo = getHead().getLink();
            while(secondo.getLink() != null && !(secondo.getInfo().equals(info))){
                primo = secondo;
                secondo = secondo.getLink();
            }
            if(secondo.getInfo().equals(info)){
                primo.setLink(secondo.getLink());
                setElementi(getElementi()-1);
            }else{
                throw new ElementoNonTrovato();
            }
        }
    }

    /**
     * metodo per eliminare dei nodi dalla lista
     * @param info informazioni dei nodi da eliminare
     * @return numero dei nodi eliminati
     */
    public int erase(String info){
        int i = 0;
        if(getHead() == null){
            return i;
        }
        Nodo precedente = getHead();
        Nodo successivo = getHead();
        while(successivo.getLink() != null){
            if(successivo.getInfo().equals(info)){
                if(successivo == getHead()){
                    setHead(getHead().getLink());
                    i++;
                    if(getHead() == null){
                        return i;
                    }
                    successivo = getHead();
                    precedente = getHead();
                }else{
                    precedente.setLink(successivo.getLink());
                    successivo = precedente.getLink();
                    i++;
                }
            }else{
                precedente = successivo;
                successivo = successivo.getLink();
            }
        }    
        if(successivo.getInfo().equals(info)){
            precedente.setLink(null);
            i++;
        }
        return i;
    }

    /**
     * metodo per scambiare il primo nodo della lista con l'ultimo
     */
    public void lastFirst(){
        if(getHead() == null || getHead().getLink() == null){
            return;
        }
        Nodo nodo1 = getHead();
        setHead(getHead().getLink());
        Nodo nodo2 = getHead();
        Nodo nodo3 = getHead();
        nodo1.setLink(null);
        while(nodo2.getLink()!=null){
            nodo3=nodo2;
            nodo2=nodo2.getLink();
        }
        nodo3.setLink(nodo1);
        nodo2.setLink(getHead());
        setHead(nodo2);
    }

    /**
     * metodo per avere un array contente le informazioni dei nodi della lista
     * @return array contenente le informazioni dei nodi della lista
     * @throws ListaVuota eccezione della lista vuota
     */
    public String[] array() throws ListaVuota{
        String[] lista = new String[getElementi()];
        Nodo indice = getHead();
        int i = 0;
        if(getElementi() == 0){
            throw new ListaVuota();
        }
        while(indice != null){
            lista[i] = new String(indice.getInfo());
            indice = indice.getLink();
            i++;
        }
        return lista;
    }

    /**
     * metodo per avere una stringa contenente le informazioni dei nodi della lista
     */
    public String toString(){
        Nodo nodo = getHead();
        String stringa = new String();
        while(nodo.getLink() != null){
            stringa += "["+nodo.getInfo()+"]->";
            nodo = nodo.getLink();
        }
        stringa += "["+nodo.getInfo()+"]|";
        return stringa;    
    }
}