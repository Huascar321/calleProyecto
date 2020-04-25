
public class Variable {
    private char variable;
    private float valor;
    
    public Variable()
    {
        variable=' ';
        valor=0;
    }
    
    public float getValor()
    {
        return valor;
    }
    public char getVariable()
    {
        return variable;
    }
    public void setValor(float x)
    {
        valor=x;
    }
    public void setVariable (char c)
    {
        variable = c;
    }
}
