package com.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class Test3 {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("C:\\Users\\Mr胡\\Desktop\\a.xml"));

        List<Element> list = document.selectNodes("books/book");
        for (Element element : list) {
            System.out.println(element.getText());
        }




    }
}
