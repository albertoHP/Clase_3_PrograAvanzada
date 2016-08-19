/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progra_avanzada_clase1;

import java.io.ByteArrayOutputStream;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

// Imports de JAXP API
import javax.xml.parsers.SAXParserFactory;

import javax.xml.parsers.ParserConfigurationException;

import javax.xml.parsers.SAXParser;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;

// Imports de SAX API
import org.xml.sax.Attributes;

import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Alberto
 */
public class PROGRA_AVANZADA_CLASE1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      System.out.println(obtenerCarteleraHMTL());
        
    }
    
     public static String obtenerCarteleraHMTL() {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {

// Usar JAXP DOM para generar Document con fichero xml
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(
                    "C:\\Users\\Alberto\\Desktop\\PROGRA AVANZADA\\Clase 1\\archivo3.xml");

// Generar un objeto transformer para realizar transform XSL
            TransformerFactory tFactory = TransformerFactory.newInstance();

            StreamSource stylesource = new StreamSource(
                    "C:\\Users\\Alberto\\Desktop\\PROGRA AVANZADA\\Clase 1\\archivo3.xsl");

            Transformer transformer = tFactory.newTransformer(stylesource);

            DOMSource source = new DOMSource(document);

            ByteArrayOutputStream outputByteArray = new ByteArrayOutputStream();

            StreamResult result = new StreamResult(outputByteArray);

            transformer.transform(source, result);

            return outputByteArray.toString();

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        }

    }
    

}
