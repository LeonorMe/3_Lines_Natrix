package formas;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class InteractXML {

    public static Element openSVG(String inPath) throws ParserConfigurationException, IOException, SAXException {
        File inputFile = new File(inPath);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder = dbFactory.newDocumentBuilder();

        Document doc = dbuilder.parse(inputFile);

        System.out.println("File opened! Check it here: " + inPath);
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        return doc.getDocumentElement();
    }

    private static Element rootSVG(Document doc, int width, int height) {
        Element svg = doc.createElement("svg");

        svg.setAttribute("width", Integer.toString(width));
        svg.setAttribute("height", Integer.toString(height));
        //svg.setAttribute("viewBox", "0 0 " + Integer.toString(this.width) + " " + Integer.toString(this.height));

        svg.setAttribute("xmlns", "http://www.w3.org/2000/svg");
        return svg;
    }

    public static Document creatEmptySVG(String outPath, int width, int height) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder = dbFactory.newDocumentBuilder();
        Document doc = dbuilder.newDocument();

        Element rSVG = rootSVG(doc, width, height); // root element <svg>
        doc.appendChild(rSVG);

        DOMSource source = new DOMSource(doc);

        File outFile = new File(outPath);
        Result result = new StreamResult(outFile);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);

        System.out.println("File created! Check it here: " + outPath);

        return doc;
    }

    public static void main(String[] args) throws Exception {
        // READ FROM EXISTING SVG FILE
        String inPath = "SVG_files/open_svg.svg";
        openSVG(inPath);

        // CREATE NEW SVG FILE
        String outPath = "SVG_files/new_01.svg";
        creatEmptySVG(outPath, 500, 500);
    }
}
