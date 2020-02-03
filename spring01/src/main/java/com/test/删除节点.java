package com.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class 删除节点 {

    public static void main(String[] args) throws DocumentException, IOException {

        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("c:/sunjob/a.xml"));

        Element element = (Element) document.selectSingleNode("books/book[@bookid='2']");
        System.out.println(element);
        if(element!=null){
            element.attribute("bookprice").setValue("10");
            element.setText("sss");
        }

        XMLWriter xmlWriter = new XMLWriter(new FileWriter("c:/sunjob/a.xml") , OutputFormat.createPrettyPrint());
        xmlWriter.write(document);
        xmlWriter.close();

    }

}
