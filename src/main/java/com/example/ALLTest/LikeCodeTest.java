package com.example.ALLTest;

import com.example.domain.Person;
import org.assertj.core.util.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author 郝少杰
 * @date 2021/2/26 10:29
 */
public class LikeCodeTest {
    public static void main(String[] args) {
        List<Person> list = Lists.newArrayList();
        for (int i=1;i<3000;i++){
            Person person = new Person("张三","1"+i,123);
            list.add(person);
        }
        Person person1 = new Person("张三","1253",123);
        Person person2= new Person("张三","12332",123);
        Person person3 = new Person("张三","12999",123);
        list.add(person1);
        list.add(person2);
        list.add(person3);
        System.out.println(list.size());
        System.out.println(knowledgeIsRepeat(list).size());

    }
    public static Set<Person> knowledgeIsRepeat(List<Person> orderList) {
        Set<Person> set = new TreeSet<Person>(new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                // 字符串则按照asicc码升序排列
                return a.getTall().compareTo(b.getTall());
            }
        });
        set.addAll(orderList);
//        if (set.size() < orderList.size()) {
//            return true;
//        }
        return set;

    }

}
