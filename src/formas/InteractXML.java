package formas;


import org.w3c.dom.*;

import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class InteractXML {
    /*
    public static InteractXML build(Node nNode) {
        Element festival = (Element) nNode;
        String name = festival.getElementsByTagName("Nome").item(0).getTextContent();

        NodeList eventos = festival.getElementsByTagName("Eventos").item(0).getChildNodes();
        InteractXML festivalNovo = new InteractXML(name);

        for(int i=0;i<eventos.getLength(); i++) {
            Node eventoI = eventos.item(i);
            InteractXML eventoNew = Shapes.build(eventoI);
            festivalNovo.addEvento(eventoNew);
        }
        return festivalNovo;
    }


    public Element createElement(Document doc) {
        Element name = doc.createElement("Nome");
        name.appendChild(doc.createTextNode(this.getNome()));

        Element eventosEle = doc.createElement("Eventos");
        for(Shapes evento : this.shapes){
            if(evento!=null){eventosEle.appendChild(evento.createElement(doc));}
        }

        Element festival = doc.createElement("Festival");
        festival.appendChild(name);
        festival.appendChild(eventosEle);

        return festival;
    }
*/
    private static void writeXml(Document doc, OutputStream output) throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        // pretty print XML
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);
    }
}
