/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble.listaCircular;

import scrabble.listaSimple.ListaSimple;


/**
 *
 * @author rodzod
 */
public class ListaCircularNodo {
    
    public String text;
    public int valor;
    public ListaSimple fichas;
    public ListaCircularNodo sig;
    public ListaCircularNodo(){
        this.sig=null;
    }
    public ListaCircularNodo(String text){
        this.sig=null;
        this.text=text;
    }
    public ListaCircularNodo(String text,int valor){
        this.sig=null;
        this.text=text;
    }
    public ListaCircularNodo(String text,ListaSimple fichas){
        this.sig=null;
        this.fichas=fichas;
        this.text=text;
    }
    public ListaCircularNodo(ListaCircularNodo sig, String text){
        this.sig=sig;
        this.text=text;
    }
    public ListaCircularNodo(ListaCircularNodo sig, String text,int valor){
        this.sig=sig;
        this.text=text;
        this.valor=valor;
    }
    
}
