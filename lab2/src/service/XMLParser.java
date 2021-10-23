package service;

import entity.*;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser implements Parser {

    private String path;

    public  XMLParser(String path) {
        this.path = path;
    }

    @Override
    public List<Appliance> getAll() {
        var doc = getDoc();
        if (doc != null) {
            return createApplinces(doc);
        }
        return null;
    }


    private Document getDoc(){
        Document doc = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(new File("Appliance.xml"));
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }

        return doc;
    }

    private List<Appliance> createApplinces(Document doc) {
        List<Appliance> applinces = new ArrayList<Appliance>();

        Element root = doc.getDocumentElement();
        NodeList products = doc.getElementsByTagName("appliance");
        for (int i = 0; i < products.getLength(); i++){
            final Node node = products.item(i);
            try {
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Appliance product = createAppliance((Element) node);
                    applinces.add(product);
                }
            }catch(Exception ex){
                continue;
            }
        }

        return applinces;
    }

    private Appliance createAppliance(Element xmlElement) throws Exception{
        String curType = xmlElement.getAttribute("type");
        String title = xmlElement.getElementsByTagName("title").item(0).getTextContent();
        String priceString = xmlElement.getElementsByTagName("price").item(0).getTextContent();
        int price = Integer.parseInt(priceString);
        switch (curType){
            case Constants.Computer:{
                String cpu = xmlElement.getElementsByTagName("cpu").item(0).getTextContent();
                return new Computer(title,price,cpu);
            }
            case Constants.Fridge:{
                String weightString = xmlElement.getElementsByTagName("weight").item(0).getTextContent();
                int weight = Integer.parseInt(weightString);
                return new Fridge(title,price,weight);
            }
            case Constants.Kettle:{
                String mark = xmlElement.getElementsByTagName("mark").item(0).getTextContent();
                return new Kettle(title, price,mark);
            }
            case Constants.TV:{
                String resolution = xmlElement.getElementsByTagName("resolution").item(0).getTextContent();
                return new TV(title, price,resolution);
            }
        }
        throw new Exception();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
