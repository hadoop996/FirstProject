package com.example.ALLTest;

import com.example.domain.Person;
import com.example.domain.Student;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.apache.commons.beanutils.BeanUtils.copyProperties;
/**
 * 对象直接映射存在相同属性的对象得值
 * @author 郝少杰
 * @date 2021/1/6 17:22
 */
public class CopyPropertiesTest {

    //观测到
    //可以直接将b对应中a对象也包含的属性直接映射过去 b到a
    //如果a中包含 b中也有 b覆盖a上
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
//        Person person = new Person();
//        person.setTall("123");
//        Student student = new Student("张三",123,"四平");
//
//        copyProperties(person,student);
//        System.out.println(person);
//        System.out.println(student);
        ConcurrentHashMap concurrentHashMap  = new ConcurrentHashMap();
        if (concurrentHashMap.size()==0||concurrentHashMap.get("1").equals("2")){
            concurrentHashMap.put("1","2");
            System.out.println(concurrentHashMap.get("1"));
        }
    }
}
