package shapes;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.*;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class ImageSVG {
    private int width, height;
    private ArrayList<AbstShape> shapes = new ArrayList<AbstShape>();

    public ImageSVG(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int[] getDimensions(){
        int[] dimensions = {this.width, this.height};
        return dimensions;
    }

    public ArrayList<AbstShape> getShapes(){
        return this.shapes;
    }

    private void setDimensions(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void addShape(AbstShape shape){
        this.shapes.add(shape);
    }
    public void removeShape(AbstShape shape){
        this.shapes.remove(shape);
    }

    public static Element openSVG(String inPath) throws ParserConfigurationException, IOException, SAXException {
        File inputFile = new File(inPath);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder = dbFactory.newDocumentBuilder();

        Document doc = dbuilder.parse(inputFile);

        System.out.println("File opened! Check it here: " + inPath);
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        return doc.getDocumentElement();
    }

    private Element rootSVG(Document doc) {
        Element svg = doc.createElement("svg");

        svg.setAttribute("width", Integer.toString(this.width));
        svg.setAttribute("height", Integer.toString(this.height));
        //svg.setAttribute("viewBox", "0 0 " + Integer.toString(this.width) + " " + Integer.toString(this.height));

        svg.setAttribute("xmlns", "http://www.w3.org/2000/svg");
        return svg;
    }

    private void appendShapes(Document doc, Element svg) {
        for (AbstShape shape : this.shapes) {
            Element shapeElement = doc.createElement(shape.getType());
            shape.addElement(svg, shapeElement);
        }
    }

    public Document saveSVG(String outPath) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder = dbFactory.newDocumentBuilder();
        Document doc = dbuilder.newDocument();

        Element svg = rootSVG(doc);
        doc.appendChild(svg); // root element <svg>

        appendShapes(doc, svg);

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

    public void deleteShape(int currentX, int currentY) {
        for (AbstShape shape : this.shapes) {
            if (shape.isInside(currentX, currentY)) {
                this.shapes.remove(shape);
                System.out.println("Shape deleted!");
                break;
            }
        }
    }

    public void reset() {
        this.shapes.clear();
        System.out.println("Image reset!");
    }

    /*
    public static void main(String[] args) throws Exception {
        // READ FROM EXISTING SVG FILE
        String inPath = "SVG_files/open_svg.svg";
        openSVG(inPath);

        // CREATE NEW SVG FILE
        // 1. Create new image
        Image newImage = new Image(500, 500);

        // 2. Add shapes
        Circle newCircle = new Circle("000", 10, 20, 80, "fill:red;stroke:black;stroke-width:5;opacity:0.5");
        newImage.addShape(newCircle);

        // 3. Save image in new empty SVG file
        String outPath = "SVG_files/new_01.svg";
        newImage.saveSVG(outPath);

    }
    */
}
