package com.example.xml;

import com.example.xml.pojo.Person;
import jdk.internal.org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import java.util.ArrayList;
import java.util.List;

/**
 * @author 少杰
 */
public class PersonHandler extends DefaultHandler {

    /**
     * 接受保存数据的集合
     */
    private List<Person> personList;

    /**
     * 创建person对象
     */
    private Person person;

    /**
     * 记录这个标签
     */
    private String tag;

    //开始解析文档。。。。
    @Override
    public void startDocument() throws org.xml.sax.SAXException {
        //创建保存数据的集合对象
        personList=new ArrayList<>();
    }


    //开始处理XML文件元素。。。。
    @Override
    public void startElement(String url, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
        if (null != qName){
            tag=qName;
        }
        if (null != qName && qName.equals("person")){
            person=new Person();
        };
    }

    @Override
    public void characters(char[] ch, int start, int length) throws org.xml.sax.SAXException {
        String s = new String(ch, start, length);
        if (null != tag && tag.equals("name")){
            person.setName(s);
        }else if(null != tag && tag.equals("age")){
            person.setAge(Integer.valueOf(s));
        }

    }


    //结束处理XML文件元素。。。。
    @Override
    public void endElement(String uri, String localName, String qName) throws org.xml.sax.SAXException {
        if (qName.equals("person")){
            personList.add(person);
        }
        tag=null;
    }

    //结束解析文档。。。。
    @Override
    public void endDocument() throws org.xml.sax.SAXException {
        System.out.println("接收文件结尾的通知。 ");
    }

    public List<Person> getPersonList() {
        return personList;
    }

}
