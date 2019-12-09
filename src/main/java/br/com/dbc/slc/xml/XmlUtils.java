package br.com.dbc.slc.xml;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.com.dbc.slc.model.SlcItem;

public class XmlUtils {

    public static Object unmarshall(Class<?> objectClass, byte[] xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(objectClass);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        InputStream inStream = new ByteArrayInputStream(xml);
        Object unmarshalObj = jaxbUnmarshaller.unmarshal(inStream);

        return unmarshalObj;

//        JAXBContext jc = JAXBContext.newInstance(objectClass);
//        Unmarshaller unmarshaller = jc.createUnmarshaller();
//        XMLReader reader = XMLReaderFactory.createXMLReader();
//        IngoreNamespaceFilter nsFilter = new IngoreNamespaceFilter();
//        nsFilter.setParent(reader);
//        StringReader stringReader = new StringReader(sampleXML);
//        InputSource is = new InputSource(stringReader);
//        SAXSource source = new SAXSource(nsFilter, is);
//        System.out.println("" + sampleXML);
//        return unmarshaller.unmarshal(source);
    }

    public static <T> T processXmlGenericNodes(List<JAXBElement<Object>> genericItens, Class<T> mainClass) throws Exception {
        T clazz = mainClass.newInstance();

        for (int i = 0; i < genericItens.size(); i++) {
            NodeList childNodes = ((Element) genericItens.get(i)).getChildNodes();
            Object xmlItem = processXmlNodes(childNodes, SlcItem.class);
            Method declaredMethod = mainClass.getDeclaredMethod("add" + xmlItem.getClass().getSimpleName(), xmlItem.getClass());

            declaredMethod.invoke(clazz, xmlItem);
        }
        return clazz;
    }

    private static <T> T processXmlNodes(NodeList children, Class<T> clazz) throws Exception {
        T item = clazz.newInstance();

        for (int i=0; i < children.getLength(); i++) {
            Node n = children.item(i);
            NodeList childNodes = n.getChildNodes();
            String nodeTag = getNodeTag(n);

            if (nodeTag != null) {
                String nodeValue = getNodeValue(n);

                System.out.println("<" + nodeTag + ">" + nodeValue);

                if (nodeValue == null) {
                    String genericTag = getGenericXmlTag(nodeTag);
                    Class<?> innerClass = Class.forName("br.com.dbc.slc.model." + genericTag);
                    Method declaredMethod = clazz.getDeclaredMethod("add" + StringUtils.capitalize(genericTag), innerClass);
                    Object instance = processXmlNodes(childNodes, innerClass);

                    declaredMethod.invoke(item, instance);
                } else {
                    Method declaredMethod = clazz.getDeclaredMethod("set" + StringUtils.capitalize(nodeTag), String.class);

                    declaredMethod.invoke(item, nodeValue);
                }
            }
        }
        return item;
    }
    private static String getGenericXmlTag(String xmlTag) {
        String regex = "_SLC[0-9]{4}_";

        return xmlTag.replaceAll(regex, "");
    }

    private static String getNodeTag(Node node) {
        return node.getLocalName();
    }

    private static String getNodeValue(Node node) {
        if (node.hasChildNodes()) {
            return node.getFirstChild().getNodeValue();
        }
        return null;
    }

}
