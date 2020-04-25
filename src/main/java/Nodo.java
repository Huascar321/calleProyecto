
class Nodo {      
        private Nodo hijoIzq;
        private char elem;
        private Nodo hijoDer;

        public Nodo(char ele) {
            hijoIzq=null;
            elem = ele;
            hijoDer=null;
        }
        public void setHI(Nodo izq){
            hijoIzq = izq;
        }
        public void setElem(char e) {
            elem = e;
        }
        public void setHD(Nodo der) {
            hijoDer = der;
        }
        public Nodo getHI() {
            return hijoIzq;
        }
        public char getElem() {
            return elem;
        }
        public Nodo getHD() {
            return hijoDer;
        }

    
}
/*
    private Nodo hijoIzq;
    private char operador;
    private int numero;
    private Nodo hijoDer;

    public Nodo(int n) {
        hijoIzq = null;
        operador = ' ';
        numero = n;
        hijoDer = null;
    }
    
    public Nodo(char o) {
        hijoIzq = null;
        operador = ' ';
        numero = 0;
        hijoDer = null;
    }

    public void setHI(Nodo izq) {
        hijoIzq = izq;
    }

    public void setNumero(int n) {
        numero = n;
    }

    public void setOperador(char o) {
        operador = o;
    }
    
    public void setHD(Nodo der) {
        hijoDer = der;
    }

    public Nodo getHI() {
        return hijoIzq;
    }

    public int getNumero() {
        return numero;
    }

    public char getOperador() {
        return operador;
    }
    
    public Nodo getHD() {
        return hijoDer;
    }

}*/

