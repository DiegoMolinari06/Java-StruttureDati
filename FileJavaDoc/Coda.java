/**
 * classe che rappresenta una coda
 */
public class Coda{

    /**
     * classe che rappresenta un nodo della coda
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
            setLink(null);
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
    private Nodo tail;

    /**
     * costruttore vuoto della classe Coda
     */
    public Coda(){
        setHead(null);
        setTail(null);
    }

    /**
     * setter dell'attributo head
     * @param head primo elemento della coda
     */
    public void setHead(Nodo head){
        this.head = head;
    }

    /**
     * setter dell'attributo tail
     * @param tail ultimo elemento della coda
     */
    public void setTail(Nodo tail){
        this.tail = tail;
    }

    /**
     * getter dell'attributo head
     * @return primo elemento della coda
     */
    public Nodo getHead(){
        return head;
    }

    /**
     * getter dell'attributo tail
     * @return ultimo elemento della coda
     */
    public Nodo getTail(){
        return tail;
    }

    /**
     * metodo per creare un nuovo nodo
     * @param info informazioni del nodo
     * @param link collegamento al nodo successivo
     * @return nodo creato
     */
    private Nodo creaNodo(String info, Nodo link){
        Nodo nodo = new Nodo(info);
        nodo.setLink(link);
        return nodo;
    }

    /**
     * metodo per aggiungere un elemento in fondo alla coda
     * @param info informazioni del nodo
     */
    public void enqueue(String info){
        Nodo nodo = creaNodo(info, null);
        if(getHead() == null){
            setTail(nodo);
            setHead(getTail());
        }else{
            tail.setLink(nodo);
            setTail(nodo);
        }
    }

    /**
     * metodo per rimuovere il primo elemento della coda
     * @return primo elemento della coda
     */
    public String dequeue(){
        Nodo nodo;
        if(getHead() == null){
            return null;
        }
        nodo = getHead();
        setHead(getHead().getLink());
        if(getHead() == null){
            setTail(null);
        }
        return nodo.getInfo();
    }
}