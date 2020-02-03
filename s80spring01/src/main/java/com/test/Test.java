package com.test;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;


public class Test {

    public static void main(String[] args) throws IOException {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("books");

        Element book1 = root.addElement("book");
        book1.addAttribute("id" , "1");
        book1.addAttribute("price" , "100");
        book1.setText("倚天屠龙记");

        Element book2 = root.addElement("book");
        book2.addAttribute("id" , "2");
        book2.addAttribute("price" , "200");
        book2.setText("射雕");

        Element book3 = root.addElement("book");
        book3.addAttribute("id" , "3");
        book3.addAttribute("price" , "300");
        book3.setText("神雕");

        XMLWriter xmlWriter = new XMLWriter(new FileWriter("C:\\Users\\Mr胡\\Desktop\\a.xml"), OutputFormat.createPrettyPrint());
        xmlWriter.write(document);
        xmlWriter.close();

    }
}
