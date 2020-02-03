package com.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class Test4 {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("C:\\Users\\Mr胡\\Desktop\\a.xml"));

       Element element = (Element) document.selectSingleNode("books/book[@id='1']");
        System.out.println(element.getText());


    }
}
