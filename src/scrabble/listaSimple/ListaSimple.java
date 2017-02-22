/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble.listaSimple;
import java.io.IOException;
import java.io.PrintWriter;
import scrabble.listaCircular.ListaCircularNodo;
import scrabble.listaSimple.ListaSimpleNodo;

/**
 *
 * @author rodzod
 */
public class ListaSimple {
    public ListaSimpleNodo first;
    public ListaSimpleNodo last;
    
    public ListaSimple(){
        this.first =this.last=null;
    }       
    
    public void insertEnd(String text){
        this.insertEnd(new ListaSimpleNodo(text));        
    };
    
    public void insertEnd(String text,int valor){
        this.insertEnd(new ListaSimpleNodo(text,valor));        
    };
    public void insertFirst(String text){
        this.insertFirst(new ListaSimpleNodo(text));        
    };
    public void insertFirst(String text,int valor){
        this.insertFirst(new ListaSimpleNodo(text,valor));        
    };
    
    /*-------INSERTS----------------*/    
    public boolean insertFirst(ListaSimpleNodo nuevoNodo){       
        if (first==null){
            first=nuevoNodo;
        }else{                       
            nuevoNodo.sig=this.first;
            first=nuevoNodo;
        }
        return true;
    };
    
    public boolean insertEnd(ListaSimpleNodo nuevoNodo){       
        if (first==null){
            first=nuevoNodo;
        }else{                       
            this.getLast().sig=nuevoNodo;             
        }
        return true;
    };
    
    /*--------------DELETES------------*/
    public ListaSimpleNodo deleteFirst(){       
        if (this.first!=null){
            ListaSimpleNodo aux = this.first;            
            this.first=this.first.sig;
            aux.sig=null;
            return aux;
        }
        return null;               
    };
    public ListaSimpleNodo deleteLast(){       
        if (this.first!=null){
            ListaSimpleNodo aux = first;            
            while (aux.sig!=null){                
                ListaSimpleNodo aux2 ;
                aux2=aux;
                aux=aux.sig;
                if (aux.sig==null){
                    aux2.sig=null;
                    return aux;
                }
            }
            if (this.first.sig==null){
                ListaSimpleNodo aux3 = this.first;
                this.first=null;
                return aux3;
            }
        }
        return null;               
    };
    
    public void printOnConsole(String prefix){
        ListaSimpleNodo aux = first; 
        while (aux!=null){                
            System.out.println(prefix+aux.text);
            aux=aux.sig;              
        }   
    }
    public void printOnConsole(){        
        this.printOnConsole("");
    }
    
    public void generateGraphviz(){
        this.generateGraphviz(this.toString());
    }
    public void generateGraphviz(String _url){
        String url=_url;
        try{
            PrintWriter writer = new PrintWriter(url+".txt", "UTF-8");
            writer.print( "digraph G\n {\n");            
            
            ListaSimpleNodo aux = first; 
            while (aux!=null){                              
                writer.println("\""+aux.toString()+"\"");            
                writer.println(" [label=\""+aux.text+"\"]\n");                
                if (aux.sig!=null){
                    writer.println("\""+aux.toString()+"\""+"->"+"\""+aux.sig.toString()+"\"");
                }                
                aux=aux.sig;              
            }                                
            writer.print( "\n}");
            
            Runtime.getRuntime().exec("dot -Tjpg "+url+".txt -o "+url+".jpg");
            
           
            writer.close();
        } catch (IOException e) {
           // do something
        }
    }
    
    
    
    
    private ListaSimpleNodo getLast(){
        ListaSimpleNodo aux = first;            
        while (aux.sig!=null){
            aux=aux.sig;
        }
        return aux;
    }
    public ListaSimpleNodo searchByText(String text){
        ListaSimpleNodo aux = first;            
        while (aux!=null){
            if (text==aux.text){
                return aux;
            }
            aux=aux.sig;
        }
        return null;
    }
    
}
