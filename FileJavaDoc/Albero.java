/**
 * classe che rappresenta un albero di stringhe
 */
public class Albero{

    /**
     * classe che rappresenta un nodo di un albero
     */
    private class NodoAlbero{
        private String info;
        private NodoAlbero pfc;
        private NodoAlbero pfs;

        /**
         * costruttore della classe NodoAlbero
         * @param info informazioni del nodo
         */
        public NodoAlbero(String info){
            setInfo(info);
            setFirstChild(null);
            setFirstSibling(null);
        }

        /**
         * setter dell'attributo info
         * @param info informazioni del nodo
         */
        public void setInfo(String info){
            this.info = info;
        }

        /**
         * setter dell'attributo pfc
         * @param pfc collegamento al primo figlio
         */
        public void setFirstChild(NodoAlbero pfc){
            this.pfc = pfc;
        }

        /**
         * setter dell'attributo pfs
         * @param pfs collegamento al primo fratello
         */
        public void setFirstSibling(NodoAlbero pfs){
            this.pfs = pfs;
        }

        /**
         * getter dell'attributo info
         * @return informazioni del nodo
         */
        public String getInfo(){
            return info;
        }

        /**
         * getter dell'attributo pfc
         * @return collegamento al primo figlio
         */
        public NodoAlbero getFirstChild(){
            return pfc;
        }

        /**
         * getter dell'attributo pfs
         * @return collegamento al primo fratello
         */
        public NodoAlbero getFirstSibling(){
            return pfs;
        }
    }
    private NodoAlbero ptr;

    /**
     * costruttore parametrico della classe Albero
     * @param info informazioni della radice
     */
    public Albero(String info){
        setPtr(new NodoAlbero(info));
    }

    /**
     * setter dell'attributo ptr
     * @param ptr radice dell'albero
     */
    public void setPtr(NodoAlbero ptr){
        this.ptr = ptr;
    }

    /**
     * getter dell'attributo ptr
     * @return radice dell'albero
     */
    public NodoAlbero getPtr(){
        return ptr;
    }

    /**
     * metodo per visitare l'albero in modo anticipato
     * @param nodo nodo di partenza
     */
    private void visitaAnticipata(NodoAlbero nodo){
        if(nodo == null){
            return;
        }
        System.out.println(nodo.getInfo());
        if(nodo.getFirstChild() != null){
            visitaAnticipata(nodo.getFirstChild());
        }
        if(nodo.getFirstSibling() != null){
            visitaAnticipata(nodo.getFirstSibling());
        }
    }

    /**
     * metodo per visitare l'albero in modo anticipato dalla radice
     */
    public void visitaAnticipata(){
        visitaAnticipata(getPtr());
    }

    /**
     * metodo per cercare un nodo
     * @param nodo nodo di partenza
     * @param info informazioni del nodo da ricercare
     * @return nodo contenente le informazioni del nodo da ricercare
     */
    private NodoAlbero cercaNodo(NodoAlbero nodo, String info){
        if(nodo == null){
            return null;
        }
        if(nodo.getInfo().equals(info)){
            return nodo;
        }
        if(nodo.getFirstChild() != null){
            NodoAlbero nodoFiglio = cercaNodo(nodo.getFirstChild(),info);
            if(nodoFiglio != null){
                return nodoFiglio;
            }
        }
        if(nodo.getFirstSibling() != null){
            NodoAlbero nodoFratello = cercaNodo(nodo.getFirstSibling(),info);
            if(nodoFratello != null){
                return nodoFratello;
            }
        }
        return null;
    }

    /**
     * metodo per aggiungere un figlio
     * @param infoPadre informazioni del padre
     * @param infoFiglio informazioni del figlio
     */
    public void aggiungiFiglio(String infoPadre, String infoFiglio){
        NodoAlbero nodo = new NodoAlbero(infoFiglio);
        NodoAlbero nodoPadre = cercaNodo(getPtr(), infoPadre);
        if(nodoPadre != null){
            if(nodoPadre.getFirstChild() == null){
                nodoPadre.setFirstChild(nodo);
            }else{
                nodoPadre = nodoPadre.getFirstChild();
                while(nodoPadre.getFirstSibling() != null){
                    nodoPadre = nodoPadre.getFirstSibling();
                }
                nodoPadre.setFirstSibling(nodo);
            }
        }
    }
}