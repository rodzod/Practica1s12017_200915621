/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble.listaSimple;
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
    public void insertFirst(String text){
        this.insertFirst(new ListaSimpleNodo(text));        
    };
    
    /*-------INSERTS----------------*/    
    private boolean insertFirst(ListaSimpleNodo nuevoNodo){       
        if (first==null){
            first=nuevoNodo;
        }else{                       
            nuevoNodo.sig=this.first;
            first=nuevoNodo;
        }
        return true;
    };
    
    private boolean insertEnd(ListaSimpleNodo nuevoNodo){       
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
            this.first=first.sig;
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
    
    public void printOnConsole(){        
        ListaSimpleNodo aux = first; 
        while (aux!=null){                
            System.out.println("-"+aux.text);
            aux=aux.sig;              
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
