public class Pila{
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
    public Pila(){
        setHead(null);
    }
    public void setHead(Nodo head){
        this.head = head;
    }
    public Nodo getHead(){
        return head;
    }
    private Nodo creaNodo(String info, Nodo link){
        Nodo nodo = new Nodo(info);
        nodo.setLink(link);
        return nodo;
    }
    public void push(String info){
        Nodo nodo;
        nodo = creaNodo(info,getHead());
        setHead(nodo);
    }
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