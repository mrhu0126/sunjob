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

public class Test2 {
    public static void main(String[] args) throws DocumentException, IOException {

        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("C:\\Users\\Mr胡\\Desktop\\a.xml"));

        Element element = (Element) document.selectSingleNode("books");

        Element book = element.addElement("book");
        book.addAttribute("id" , "4");
        book.addAttribute("price" , "400");
        book.setText("连城诀");

        XMLWriter xmlWriter = new XMLWriter(new FileWriter("C:\\Users\\Mr胡\\Desktop\\a.xml"), OutputFormat.createPrettyPrint());
        xmlWriter.write(document);
        xmlWriter.close();




    }
}
