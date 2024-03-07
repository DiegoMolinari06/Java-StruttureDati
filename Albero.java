public class Albero{
    private class NodoAlbero{
        private String info;
        private NodoAlbero pfc;
        private NodoAlbero pfs;
        public NodoAlbero(String info){
            setInfo(info);
            setFirstChild(null);
            setFirstSibling(null);
        }
        public void setInfo(String info){
            this.info = info;
        }
        public void setFirstChild(NodoAlbero pfc){
            this.pfc = pfc;
        }
        public void setFirstSibling(NodoAlbero pfs){
            this.pfs = pfs;
        }
        public String getInfo(){
            return info;
        }
        public NodoAlbero getFirstChild(){
            return pfc;
        }
        public NodoAlbero getFirstSibling(){
            return pfs;
        }
    }
    private NodoAlbero ptr;
    public Albero(String info){
        setPtr(new NodoAlbero(info));
    }
    public void setPtr(NodoAlbero ptr){
        this.ptr = ptr;
    }
    public NodoAlbero getPtr(){
        return ptr;
    }
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
    public void visitaAnticipata(){
        visitaAnticipata(getPtr());
    }
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