/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;         // |
import org.jdom2.Element;          // |\ Librerías
import org.jdom2.JDOMException;    // |/ JDOM
import org.jdom2.input.SAXBuilder; // |
import scrabble.listaSimple.ListaSimple;

/**
 *
 * @author rodzod
 */
public class XMLReader {
    
    
    public void reader(){
        this.reader("archivo.xml");
    }
    
    public void reader(String route){        
        //Se crea un SAXBuilder para poder parsear el archivo
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(route);
        try
        {
            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build( xmlFile );

            //Se obtiene la raiz 'tables'
            Element rootNode = document.getRootElement();

            Element dimension = rootNode.getChild( "dimension" );
            //Se obtiene la lista de hijos de la raiz 'tables'          
            List dobles_list = rootNode.getChildren( "dobles" );
            List triples_list = rootNode.getChildren( "triples" );
            
            Element diccionario = rootNode.getChild( "diccionario" );
            
            
            System.out.println("dimension "+dimension.getText());

            //Se recorre la lista de hijos de 'dobles'
            for ( int i = 0; i < dobles_list.size(); i++ )
            {
                System.out.println("dobles");                
                Element casillas=(Element) dobles_list.get(i);
                List casillas_list= casillas.getChildren("casilla");
                for(int casillas_i=0; casillas_i<casillas_list.size(); casillas_i++){
                    Element casilla= (Element) casillas_list.get(casillas_i);
                    System.out.println("casilla ("+casilla.getChildTextTrim("x")+","+casilla.getChildTextTrim("y")+")");                
                }                
            }
            //se obtienen triples
            for ( int i = 0; i < triples_list.size(); i++ )
            {
                System.out.println("triples");                
                Element casillas=(Element) triples_list.get(i);
                List casillas_list= casillas.getChildren("casilla");
                for(int casillas_i=0; casillas_i<casillas_list.size(); casillas_i++){
                    Element casilla= (Element) casillas_list.get(casillas_i);
                    System.out.println("casilla ("+casilla.getChildTextTrim("x")+","+casilla.getChildTextTrim("y")+")");                
                }                
            }
            
            //se obtienene el diccionario de palabras
            System.out.println("diccionario_list");                
            List palabras_list= diccionario.getChildren("palabra");
            for(int casillas_i=0; casillas_i<palabras_list.size(); casillas_i++){
                Element palabra= (Element) palabras_list.get(casillas_i);
                System.out.println("palabra "+palabra.getText());                
            }                
            
            
            
            
            
            
        }catch ( IOException io ) {
            System.out.println( io.getMessage() );
        }catch ( JDOMException jdomex ) {
            System.out.println( jdomex.getMessage() );
        }
    }
    public ListaSimple readWords(){
        return readWords("archivo.xml");
    }
    public ListaSimple readWords(String route){        
        ListaSimple diccionarioList= new ListaSimple();
        //Se crea un SAXBuilder para poder parsear el archivo
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(route);
        try
        {
            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build( xmlFile );

            //Se obtiene la raiz 'tables'
            Element rootNode = document.getRootElement();
            
            Element diccionario = rootNode.getChild( "diccionario" );            
            
            //se obtienene el diccionario de palabras
            System.out.println("diccionario_list");                
            List palabras_list= diccionario.getChildren("palabra");
            for(int casillas_i=0; casillas_i<palabras_list.size(); casillas_i++){
                Element palabra= (Element) palabras_list.get(casillas_i);
                diccionarioList.insertEnd(palabra.getText());
                System.out.println("palabra "+palabra.getText());                
            }                
            
        }catch ( IOException io ) {
            System.out.println( io.getMessage() );
        }catch ( JDOMException jdomex ) {
            System.out.println( jdomex.getMessage() );
        }        
        return diccionarioList;
    }
}
