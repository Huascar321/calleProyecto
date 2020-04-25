
import javax.swing.JTextArea;
import java.util.Stack;
import javax.swing.JOptionPane;


public class Arbol {

    private Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    private boolean esHoja(Nodo pr) {
        return pr.getHI() == null && pr.getHD() == null;
    }

    public boolean parentesisCorrectos(String op) //Validador
    {
        int t = op.length();
        int c = 0;
        for(int i=0; i<t; i++)
        {
            if(op.charAt(i)=='(')
                c++;
            if (op.charAt(i)==']')
                c--;
        }
        return c==0;
    }
    
    public boolean esOperador(char a){
        return (a=='*'||a=='/'||a=='-'||a=='+'||a=='^');
    }
    
    public boolean operadoresCorrectos(String op){
        int t = op.length();
        int c = 0;
        if(esOperador(op.charAt(t-1)))
            return false;
        if(esOperador(op.charAt(0)))
            return false;
        for(int i=0; i<t; i++)
        {
            if(esOperador(op.charAt(i)) && i+1<t && esOperador(op.charAt(i+1)))
                return false;
        }
        return true;
    }
    /*
    public boolean existenVariables(String op){
        int t = op.length();
        int c = 0;
        for(int i=0; i<t; i++)
        {
            if(op.charAt(i)<=90 && op.charAt(i)>=65)
                return true;
            if(op.charAt(i)>=97 && op.charAt(i)<=122)
                return true;
                //Borrar return true;
                //Buscar la forma de convertir a mayusculas...
        }
        return false;
    }
    */
    public boolean expresionValida (String s)
    {
        if(s==null || !parentesisCorrectos(s)||!operadoresCorrectos(s) )
            return false;
        else return true;      
    }
    
    public boolean esOperando (char s)
    {
        return ((s<=90 && s>=65) || (s>=97 && s<=122) || (s>=48 && s<=57) );
    }
    
    public String infixToPosfix (String s)
        {
            //Crear un vector con todos los operadores
            Operador op[]=new Operador[6];
            op[0]=new Operador("+");
            op[1]=new Operador("-");
            op[2]=new Operador("*");
            op[3]=new Operador("/");
            op[4]=new Operador("^");
            op[5]=new Operador("(");
            Stack<String> pilita = new Stack();
            String posfix=new String();
            //Recorrer todo el string
            for(int i=0;i<s.length();i++)
            {
                char cactual=s.charAt(i);
                if(esOperando(cactual))                 //Si es una variable o un numero
                    posfix=posfix+cactual;
                else
                    if(cactual=='(')
                    {
                        String c=String.valueOf(s.charAt(i));
                        pilita.push(c);
                    }
                    else   
                        if(s.charAt(i)==')')
                        {
                            
                            String t=pilita.pop();
                            while (!t.equalsIgnoreCase("("))            //Hasta que encuentre su par cerrado
                            {
                                posfix=posfix+t;
                                t=pilita.pop();
                            
                            }
                        }
                        else
                        {
                            while(!pilita.empty()&& CompararValoresOperador(pilita, op, String.valueOf(cactual))) //jerarquia de operadores
                            {
                                posfix=posfix+ pilita.pop();
                            }
                            pilita.push(String.valueOf(cactual));
                        }
            }
            while (!pilita.empty())
            {
                posfix=posfix+pilita.pop();
            }
            return posfix;
        }
    
    //Funcion para comparar la jerarquia matemática de los operadores
    public boolean CompararValoresOperador (Stack<String> pilita, Operador[] op, String s)
    {
        int x=0, y=0;
        for(int j=0; j<6; j++)
        {   
            if(op[j].returnOperador().getOperador().equalsIgnoreCase(pilita.peek()))
                x = op[j].returnOperador().getValor();
            if(op[j].returnOperador().getOperador().equalsIgnoreCase(s)) 
                y = op[j].returnOperador().getValor();
        }
        return (x>=y);
    }
     
    //devuelve el nodo raiz
  /*  public void insertarArbol (String s)
    {
        Stack<Nodo> pilita = new Stack();
        Nodo t, t1, t2;
       //Recorrer todo el string
        for (int i=0; i<s.length(); i++)
        {
            char cactual = s.charAt(i);
            if (esOperando(cactual))        //Si es un operando(A-Z)(0-9)
            {
                t= new Nodo(cactual);
                pilita.push(t);
            }
            else
            {
                t= new Nodo(cactual);
                t1 = pilita.pop();
                t2 = pilita.pop();
                t.setHD(t1);
                t.setHI(t2);
                pilita.push(t);
            }
        }
        t=pilita.peek();
        pilita.pop();
        raiz= t;
    }
     */
 public void insertarArbol (String s)
    {
        Stack<Nodo> pilita = new Stack();
        Nodo t, t1, t2;
       //Recorrer todo el string
       
        for (int i=0; i<s.length(); i++)
        {
            char cactual = s.charAt(i);
            if (esOperando(cactual))        //Si es un operando(A-Z)(0-9)
            {
                t= new Nodo(cactual);
                pilita.push(t);
            }
            else
            {
                t= new Nodo(cactual);
                t1 = pilita.pop();
                t2 = pilita.pop();
                t.setHD(t1);
                t.setHI(t2);
                pilita.push(t);
            }
        }
        t=pilita.peek();
        pilita.pop();
        raiz= t;
    }

        
   
 
 
     
    private void preOrden(Nodo pr, JTextArea rt) {
        if (pr != null) {
            rt.append(pr.getElem() + "  ");
            preOrden(pr.getHI(), rt);
            preOrden(pr.getHD(), rt);
        }
    }

    public void preOrden(JTextArea rt) {
        preOrden(raiz, rt);
    }

    private void InOrden(Nodo pr, JTextArea rt) {
        if (pr != null) {
            InOrden(pr.getHI(), rt);
            rt.append(String.valueOf(pr.getElem() + "  "));
            InOrden(pr.getHD(), rt);
        }
    }

    public void InOrden(JTextArea rt) {
        InOrden(raiz, rt);
    }

    private void PostOrden(Nodo pr, JTextArea rt) {
        if (pr != null) {
            PostOrden(pr.getHI(), rt);
            PostOrden(pr.getHD(), rt);
            rt.append(String.valueOf(pr.getElem() + "  "));
        }
    }

    public void PostOrden(JTextArea rt) {
        PostOrden(raiz, rt);
    }
    
    private float resolver (Nodo pr, Variable[] v)
    {
        char c=pr.getElem();
        switch (c)
        {
            case '+':
                return resolver(pr.getHI(),v) + resolver(pr.getHD(),v);
            case '-':
                return resolver(pr.getHI(),v) - resolver(pr.getHD(),v);
            case '*':
                return resolver(pr.getHI(),v) * resolver(pr.getHD(),v);
            case '/':
                return resolver(pr.getHI(),v) / resolver(pr.getHD(),v);
            case '^':
                return potencia(resolver(pr.getHI(),v),resolver(pr.getHD(),v));
            default:
                return ObtenerValorVariable(v,c);  
        }
    }
    
    public float resolver (Variable[] v)
    {
        return resolver(raiz,v);
    }
    
    public float potencia(float x, float y)
    {
        if(y==0)
            return 1;
        else
        {
            float p=potencia(x,y-1);
            return p*x;
        }
    }
    
    public float ObtenerValorVariable (Variable[] v, char c)
    {
        int i=0;
        if ((c>=48 && c<=57))
            return Integer.valueOf(Character.toString(c));
        else
        {
        while (v[i].getValor()!=0)
        {
            if(c==v[i].getVariable())
                return v[i].getValor();
            i++;
        }
        }
        return 0;
    }
    
      public Variable buscarVariable(String s, Variable[] vec)
    {
        int i=0;
        while (vec[i].getVariable()!=' ')
        {
            if(vec[i].getVariable()==s.charAt(0))
            {
                return vec[i];
            }
            i++;
        }
        return null;
    }

}
