package com.ioc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.InputStream;

public class ApplicatonContext {

    public static Object getBean(String id)  {
        SAXReader saxReader = new SAXReader();
        InputStream is = ApplicatonContext.class.getResourceAsStream("/bean.xml");
        Object object = null;
        try {
            Document document = saxReader.read(is);

            Element element = (Element) document.selectSingleNode("beans/bean[@id='"+id+"']");
            String classname = element.attributeValue("class");

            Class c =Class.forName(classname);

            object = c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return object;

    }



}
