package com.program.util.xml;

import com.program.util.base.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @Desc 根据xml的格式生成xml的对应的java生成代码
 */
public class XmlToJavaUtils {

    public static void createJavaCode(File file) {
        try {
            //File file = new File("C:/Users/SUCCESS/Desktop/temp.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            if (doc.hasChildNodes()) {
                printNote(doc.getChildNodes(), null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNote(NodeList nodeList, Node parent) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                if (parent == null) {
                    System.out.println("Element " + getTagName(node.getNodeName()) + " = XmlUtils.createRootElement(\"" + node.getNodeName() + "\");");
                } else {
                    String temp = "XmlUtils.appendElement(" + getTagName(parent == null ? null : parent.getNodeName()) + ", \"" + node.getNodeName();

                    if (node.hasChildNodes() && node.getChildNodes().getLength() > 1) {
                        System.out.println();
                        //非叶节点把节点的名称加上，以便子节点和父节点做关联
                        temp = "Element " + getTagName(node.getNodeName()) + " = " + temp + "\");";
                    } else {
                        //叶节点把注释加上
                        //temp += "\", \"value\");//" + node.getTextContent();
                        temp += "\", \"" + node.getTextContent() + "\");";
                    }

                    System.out.println(temp);
                }
                if (node.hasChildNodes()) {
                    printNote(node.getChildNodes(), node);
                }
            }
        }
    }

    /**
     * @param name
     * @return
     * @Desc 把字符串第一个字母转小写
     */
    private static String getTagName(String name) {
        if (StringUtils.isBlank(name)) {
            return "";
        }
        String temp = name;
        temp = temp.substring(0, 1).toLowerCase() + temp.substring(1);
        return temp;
    }
}
