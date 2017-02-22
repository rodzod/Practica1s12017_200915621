/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble;
import scrabble.listaSimple.ListaSimple;
import scrabble.listaSimple.ListaSimpleNodo;
import scrabble.Palabra;
import scrabble.BarajaFichas;

import scrabble.listaCircular.ListaCircular;
import scrabble.listaCircular.ListaCircularNodo;


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
        BarajaFichas barajaFichas = new BarajaFichas();        
        ListaCircular jugadores = new ListaCircular();
        ListaSimple diccionario= new ListaSimple();
        
        jugadores.insertEnd(new ListaCircularNodo("jugador1",barajaFichas.popListaFichas(7)));
        jugadores.insertEnd(new ListaCircularNodo("jugador2",barajaFichas.popListaFichas(7)));
        jugadores.insertEnd(new ListaCircularNodo("jugador3",barajaFichas.popListaFichas(7)));
        jugadores.insertEnd(new ListaCircularNodo("jugador3",barajaFichas.popListaFichas(7)));
        jugadores.insertEnd(new ListaCircularNodo("jugador3",barajaFichas.popListaFichas(7)));
        jugadores.insertEnd(new ListaCircularNodo("jugador3",barajaFichas.popListaFichas(7)));
        jugadores.insertEnd(new ListaCircularNodo("jugador3",barajaFichas.popListaFichas(7)));
        jugadores.insertEnd(new ListaCircularNodo("jugador3",barajaFichas.popListaFichas(7)));
        jugadores.insertEnd(new ListaCircularNodo("jugador3",barajaFichas.popListaFichas(7)));
        jugadores.insertEnd(new ListaCircularNodo("jugador3",barajaFichas.popListaFichas(7)));
        jugadores.insertEnd(new ListaCircularNodo("jugador3",barajaFichas.popListaFichas(7)));
        jugadores.insertEnd(new ListaCircularNodo("jugador3",barajaFichas.popListaFichas(7)));
        jugadores.insertEnd(new ListaCircularNodo("jugador3",barajaFichas.popListaFichas(7)));
        jugadores.insertEnd(new ListaCircularNodo("jugador3",barajaFichas.popListaFichas(7)));
        jugadores.insertEnd(new ListaCircularNodo("jugador3",barajaFichas.popListaFichas(7)));
                
        jugadores.printOnConsole();
        barajaFichas.fichasJuego.printOnConsole("---");
        jugadores.generateGraphviz();
        barajaFichas.fichasJuego.generateGraphviz("baraja");
        jugadores.searchByText("jugador1").fichas.generateGraphviz();
        XMLReader lector= new XMLReader();        
        diccionario=lector.readWords();           
        diccionario.generateGraphviz();
    }    
    
}
