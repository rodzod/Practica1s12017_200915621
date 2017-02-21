/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble.listaSimple;

/**
 *
 * @author rodzod
 */
public class ListaSimpleNodo {
    public Object data;
    public ListaSimpleNodo sig;   
    public String text; 
    public ListaSimpleNodo(){
        this.sig=null;
    }
    public ListaSimpleNodo(String text){
        this.sig=null;
        this.text=text;
    }
}

