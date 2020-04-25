public class Operador {
    public String operador;
    public int valor;
    
    public Operador(String c)
    {
        operador=c;
        valor=0;
        if(c=="^")
           valor=4;
        if(c=="*")
            valor=3;
        if(c=="/")
            valor=3;
        if(c=="+")
            valor=2;
        if(c=="-")
            valor=2;
        if(c=="(")
            valor=1;
    }
    
    public int getValor()
    {
        return valor;
    }
    public String getOperador()
    {
        return operador;
    }
    
    public Operador returnOperador()
    {
        return this;
    }
    
    
    public boolean esOperador(String a){
        return (a=="*"||a=="/"||a=="-"||a=="+"||a=="^"||a=="("||a==")");
    }
}
