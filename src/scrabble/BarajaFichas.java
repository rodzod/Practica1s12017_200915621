/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble;

import scrabble.listaSimple.ListaSimple;
import scrabble.listaSimple.ListaSimpleNodo;

/**
 *
 * @author rodzod
 */
public class BarajaFichas {
    public ListaSimple fichasJuego;
    public BarajaFichas(){
        this.fichasJuego=this.setColaFichas();
    }
    public ListaSimple popListaFichas(int cantidadFichasASacar){
        ListaSimple aux_lista_ficha= new ListaSimple();
        for (int i=0;i<cantidadFichasASacar; i++){
            aux_lista_ficha.insertEnd(fichasJuego.deleteFirst());
        }        
        return aux_lista_ficha;
    }
    public ListaSimple setColaFichas(){
        ListaSimple listaFichas = new ListaSimple();
        for(int i =0; i<12; i++){           
                listaFichas.insertFirst("a",1);
                listaFichas.insertFirst("e",1);           
        }
        for(int i =0; i<9; i++){            
                listaFichas.insertFirst("o",1);                            
        }
        for(int i =0; i<6; i++){            
                listaFichas.insertFirst("i",1);                
                listaFichas.insertFirst("s",1);                
        }
        for(int i =0; i<5; i++){            
                listaFichas.insertEnd("n",1);
                listaFichas.insertEnd("r",1);
                listaFichas.insertEnd("u",1);
                listaFichas.insertEnd("d",2);            
        }
        for(int i =0; i<5; i++){            
                listaFichas.insertEnd("l",1);
                listaFichas.insertEnd("t",1);
                listaFichas.insertEnd("c",3);            
        }
        for(int i =0; i<4; i++){            
                listaFichas.insertEnd("g",2);
                listaFichas.insertEnd("b",3);
                listaFichas.insertEnd("m",3);                
                listaFichas.insertEnd("p",3);                
                listaFichas.insertEnd("h",4);                
        }
        listaFichas.insertEnd("f",4);                
        listaFichas.insertEnd("Ñ",8);
        listaFichas.insertEnd("v",4);
        listaFichas.insertEnd("q",5);                
        listaFichas.insertEnd("j",8);                                
        listaFichas.insertEnd("y",4);                                
        listaFichas.insertEnd("x",8);               
        listaFichas.insertEnd("z",10);                            
        
        for(int i=0;i<999;i++){
            ListaSimple listaAux=new ListaSimple();        
            ListaSimpleNodo aux = listaFichas.first;        
            while(aux!=null){
                //System.out.println("nodo "+aux.text);
                if ((Math.random() <= 0.5)){                  
                    listaAux.insertEnd(aux.text,aux.valor);
                }else{                   
                    listaAux.insertFirst(aux.text,aux.valor);
                }
                aux=aux.sig;
            }        
            listaFichas=listaAux;
        }                        
        return listaFichas;
        
    }
}
