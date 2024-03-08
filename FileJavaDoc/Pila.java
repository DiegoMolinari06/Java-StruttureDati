/**
 * classe che rappresenta una pila
 */
public class Pila{

    /**
     * classe che rappresenta un nodo della pila
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

    /**
     * costruttore vuoto della classe Pila
     */
    public Pila(){
        setHead(null);
    }

    /**
     * setter dell'attributo head
     * @param head primo elemento della pila
     */
    public void setHead(Nodo head){
        this.head = head;
    }

    /**
     * getter dell'attributo head
     * @return primo elemento della pila
     */
    public Nodo getHead(){
        return head;
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
     * metodo per aggiungere un elemento all'inizio della pila
     * @param info informazioni del nodo
     */
    public void push(String info){
        Nodo nodo;
        nodo = creaNodo(info,getHead());
        setHead(nodo);
    }

    /**
     * metodo per rimuovere il primo elemento della pila
     * @return primo elemento della pila
     */
    public String pop(){
        Nodo nodo;
        if(getHead() == null){
            return null;
        }
        nodo = getHead();
        setHead(getHead().getLink());
        return nodo.getInfo();
    }
}