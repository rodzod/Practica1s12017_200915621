/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble.listaCircular;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author rodzod
 */
public class ListaCircular {
    public ListaCircularNodo first;
    
    public ListaCircular(){
        this.first =null;
    }       
    
    public void insertEnd(String text){
        this.insertEnd(new ListaCircularNodo(text));        
    };
    public void insertEnd(String text,int valor){
        this.insertEnd(new ListaCircularNodo(text,valor));        
    };
    /*public void insertFirst(String text){
        this.insertFirst(new ListaCircularNodo(text));        
    };
    public void insertFirst(String text,int valor){
        this.insertFirst(new ListaCircularNodo(text,valor));        
    };*/
    
    /*-------INSERTS----------------*/    
    /*public boolean insertFirst(ListaCircularNodo nuevoNodo){
        if (first==null){
            first=nuevoNodo;
        }else{                       
            nuevoNodo.sig=this.first;
            first=nuevoNodo;
        }
        return true;
    };*/
    
    public boolean insertEnd(ListaCircularNodo nuevoNodo){       
        if (this.first==null){
            nuevoNodo.sig=nuevoNodo;
            this.first=nuevoNodo;
        }else{
            nuevoNodo.sig=this.first;
            this.getLast().sig=nuevoNodo;             
        }
        return true;
    };
    
    /*--------------DELETES------------*/
    public ListaCircularNodo deleteFirst(){       
        if (this.first!=null){
            ListaCircularNodo aux = this.first;            
            this.first=first.sig;
            return aux;
        }
        return null;               
    };
    public ListaCircularNodo deleteLast(){       
        if (this.first!=null){
            ListaCircularNodo aux = first;            
            while (aux.sig!=null){                
                ListaCircularNodo aux2 ;
                aux2=aux;
                aux=aux.sig;
                if (aux.sig==null){
                    aux2.sig=null;
                    return aux;
                }
            }
            if (this.first.sig==null){
                ListaCircularNodo aux3 = this.first;
                this.first=null;
                return aux3;
            }
        }
        return null;               
    };
    
    public void printOnConsole(){        
        ListaCircularNodo aux = first; 
        while (aux!=null && aux.sig!=this.first){                
            System.out.println(aux.text);            
            System.out.println("\t");
//            System.out.println("****"+aux.toString());
            aux.fichas.printOnConsole("\t");
            aux=aux.sig;              
        }   
        System.out.println(aux.text);
        aux.fichas.printOnConsole("\t");
    }
    public void generateGraphviz(){
        String url="jugadorGraph";
        try{
            PrintWriter writer = new PrintWriter(url+".txt", "UTF-8");
            writer.print( "digraph G\n {\n");            
            
            ListaCircularNodo aux = first; 
            while (aux!=null && aux.sig!=this.first){                              
                writer.println("\""+aux.toString()+"\"");            
                writer.println(" [label=\""+aux.text+"\"]\n");                
                writer.println("\""+aux.toString()+"\""+"->"+"\""+aux.sig.toString()+"\"");
                aux=aux.sig;              
            }                    
            writer.println("\""+aux.toString()+"\"");            
            writer.println(" [label=\""+aux.text+"\"]\n");                
            writer.println("\""+aux.toString()+"\""+"->"+"\""+aux.sig.toString()+"\"");
            
            writer.print( "\n}");
            
            Runtime.getRuntime().exec("dot -Tjpg "+url+".txt -o "+url+".jpg");
            
           
            writer.close();
        } catch (IOException e) {
           // do something
        }
    }
    
    
    
    
    private ListaCircularNodo getLast(){
        ListaCircularNodo aux = first;            
        while (aux!=null && aux.sig!=first){
            aux=aux.sig;
        }
        return aux;
    }
    public ListaCircularNodo searchByText(String text){
        ListaCircularNodo aux = first; 
        while (aux!=null && aux.sig!=this.first){       
            if (text==aux.text){
                return aux;
            }            
            aux=aux.sig;              
        }   
        if (aux.text==text){
            return aux;
        }
        return null;
    }
}
