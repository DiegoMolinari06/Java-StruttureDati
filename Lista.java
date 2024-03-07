class ListaVuota extends Exception{
}

class ElementoNonTrovato extends Exception{
}

public class Lista{
    private class Nodo{
        private String info;
        private Nodo link;
        public Nodo(String info){
            setInfo(info);
            setLink(link);
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
    private int elementi;
    public Lista(){
        setHead(null);
        setElementi(0);
    }
    public Lista(String[] info){
        for(int i=0; i<info.length; i++){
            add(new String(info[i]));
            setElementi(getElementi()+1);
        }
    }
    public void setHead(Nodo head){
        this.head = head;
    }
    public void setElementi(int elementi){
        this.elementi = elementi;
    }
    public Nodo getHead(){
        return head;
    }
    public int getElementi(){
        return elementi;
    }
    private void addTesta(String info){
        Nodo nodo = new Nodo(info);
        nodo.setLink(getHead());
        setHead(nodo);
        setElementi(getElementi()+1);
    }
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
    private void deleteTesta(){
        if(getHead() == null){
            return;
        }
        setHead(getHead().getLink());
        setElementi(getElementi()-1);
    }
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
    public static void main(String args[]){
        Lista lista = new Lista();
        lista.add("CIAO");
        lista.add("MONDO");
        System.out.println(lista);
        lista.add("CIAO");
        System.out.println(lista);
        System.out.println(lista.erase("CIAO"));
        System.out.println(lista);
        lista.lastFirst();
        System.out.println(lista);
    }
}