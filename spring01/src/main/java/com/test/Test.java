package com.test;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Test {

    public static void main(String[] args) throws IOException {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("books");

        Element book1 = root.addElement("book");
        book1.addAttribute("bookid" , "1");
        book1.addAttribute("bookprice" , "100");
        book1.setText("天龙八部");

        Element book2 = root.addElement("book");
        book2.addAttribute("bookid" , "2");
        book2.addAttribute("bookprice" , "200");
        book2.setText("鹿鼎记");

        Element book3 = root.addElement("book");
        book3.addAttribute("bookid" , "3");
        book3.addAttribute("bookprice" , "300");
        book3.setText("倚天屠龙记");

        XMLWriter writer = new XMLWriter(new FileWriter("c:/sunjob/a.xml") , OutputFormat.createPrettyPrint());
        writer.write(document);
        writer.close();

    }
}
