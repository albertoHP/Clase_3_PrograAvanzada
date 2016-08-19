/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progra_avanzada_clase1;

import java.io.File;
import org.w3c.dom.Document;

import org.w3c.dom.NamedNodeMap;

import org.w3c.dom.Node;

import org.w3c.dom.NodeList;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.*;

//import org.w3c.dom.*;
/**
 *
 * @author Alberto
 */
public class EjemploDOM {

    public static void main(String[] args) {

        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();

// Crear nueva instancia de DOMBuilder a través factoria
        try{
        DocumentBuilder parser =  fact.newDocumentBuilder();
        String fich = "C:\\Users\\Alberto\\Desktop\\PROGRA AVANZADA\\Clase 1\\archivo2.xml";
        parser.parse(fich);

        Document doc = parser.parse(new File(fich));

        tratarNodo(doc);

        }catch(Exception e){
            
        }
    }

    public static void tratarNodo(Node nodo) {

        switch (nodo.getNodeType()) {

            case Node.DOCUMENT_NODE:
                System.out.println("<xml version=\"1.0\">");

                Document doc = (Document) nodo;

                tratarNodo(doc.getDocumentElement());
                break;

            case Node.ELEMENT_NODE:
                String nombre = nodo.getNodeName();

                System.out.print("<" + nombre);

                NamedNodeMap ats = nodo.getAttributes();

                for (int i = 0; i < ats.getLength(); i++) {

                    tratarNodo(ats.item(i));

                }

                System.out.println(">");

                NodeList hijos = nodo.getChildNodes();
                break;

            case Node.ATTRIBUTE_NODE:
                System.out.print(" " + nodo.getNodeName() + "=\"" + nodo.getNodeValue() + "\"");
                break;

            case Node.TEXT_NODE:
                String texto = nodo.getNodeValue().trim();

                if (!texto.equals("")) {

                    System.out.println( texto);

                }
                break;

            case Node.CDATA_SECTION_NODE:
                System.out.println(nodo.getNodeValue());
                break;

            case Node.PROCESSING_INSTRUCTION_NODE:

                break;

            case Node.ENTITY_REFERENCE_NODE:

                break;

            case Node.DOCUMENT_TYPE_NODE:

                break;

        }

    }

}
