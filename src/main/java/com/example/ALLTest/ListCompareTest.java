//package com.example.ALLTest;
//
//import com.example.utils.JsonUtils;
//import com.example.domain.Person;
//import com.google.common.collect.Lists;
//import org.junit.Test;
//
//import java.util.Comparator;
//import java.util.List;
//
///**
// * @author 郝少杰
// * @date 2020/12/21 14:37
// */
//public class ListCompareTest {
//
//    @Test
//    public void JAVAget(){
//        List<Person> people = Lists.newArrayList();
//        people.add(new Person("张三",23));
//        people.add(new Person("李四",14));
//        people.add(new Person("王五",45));
//        people.add(new Person("赵六",6));
//        people.add(new Person("孙十八",18));
//        people.add(new Person("马五",19));
//        people.add(new Person("乔四",34));
//        //.reversed()降序 不加默认是升序
//        people.sort(Comparator.comparing(Person::getAge).reversed());
//        System.out.println(JsonUtils.toString(people));
//    }
//}
