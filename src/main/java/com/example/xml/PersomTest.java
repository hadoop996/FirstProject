package com.example.xml;


import com.example.xml.pojo.Person;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PersomTest {
    public static void main (String[] args) throws ParserConfigurationException, SAXException, IOException {

        //1),获得解析工厂 SAXParserFactory
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        //2),工厂获取解析器SAXParser
        SAXParser saxParser = parserFactory.newSAXParser();
        //3),加载文档Document

        //4),编写处理器
        PersonHandler handler = new PersonHandler();
        File inputFile = new File("D:\\software\\person.xml");
        InputStream fins = new FileInputStream(inputFile);
//        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/hp/xml/person.xml");
        saxParser.parse(fins ,handler);

        List<Person> personList = handler.getPersonList();
        personList.forEach(e-> System.out.println(e.getName() + "--->" + e.getAge()));

    }
}
