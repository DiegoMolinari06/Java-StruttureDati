public class Coda{
    private class Nodo{
        private String info;
        private Nodo link;
        public Nodo(String info){
            setInfo(info);
            setLink(null);
        }
        public void setInfo(String info){
            this.info = info;
        }
        public void setLink(Nodo link){
            this.link = link;
        }
        public String getInfo(){
            return info;
        }
        public Nodo getLink(){
            return link;
        }
    }
    private Nodo head;
    private Nodo tail;
    public Coda(){
        setHead(null);
        setTail(null);
    }
    public void setHead(Nodo head){
        this.head = head;
    }
    public void setTail(Nodo tail){
        this.tail = tail;
    }
    public Nodo getHead(){
        return head;
    }
    public Nodo getTail(){
        return tail;
    }
    private Nodo creaNodo(String info, Nodo link){
        Nodo nodo = new Nodo(info);
        nodo.setLink(link);
        return nodo;
    }
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