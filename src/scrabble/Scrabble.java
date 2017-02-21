/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble;
import scrabble.listaSimple.ListaSimple;
import scrabble.listaSimple.ListaSimpleNodo;
import scrabble.Palabra;


/**
 *
 * @author rodzod
 */
public class Scrabble {

    /**
     * @param args the command line arguments
     */
    //prueba de commit
    public static void main(String[] args) {        
        // TODO code application logic here
        ListaSimple listaPalabras=new ListaSimple();       
        listaPalabras.insertEnd("1");
        listaPalabras.insertEnd("2");
        listaPalabras.insertEnd("3");
        listaPalabras.insertEnd("4");
        listaPalabras.insertFirst("5");
        listaPalabras.insertFirst("6");        
        listaPalabras.printOnConsole();        
        ListaSimpleNodo resultado= listaPalabras.searchByText("hola3");
        
        listaPalabras.insertEnd("hola5");
        
    }
    
}
