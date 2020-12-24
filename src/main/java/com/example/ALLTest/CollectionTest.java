package com.example.ALLTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author 郝少杰
 * @date 2020/12/2 10:43
 */
public class CollectionTest {
    class Dog {
        public int age;
        public String name;

        public Dog(int age, String name) {
            super();
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Dog [age=" + age + ", name=" + name + "]";
        }
    }

    public static void main(String[] args) {
        List<Dog> list = new ArrayList<>();
        list.add(new CollectionTest().new Dog(5, "DogA"));
        list.add(new CollectionTest().new Dog(18, "DogB"));
        list.add(new CollectionTest().new Dog(7, "AogC"));
        list.add(new CollectionTest().new Dog(14, "AogC"));
        list.add(new CollectionTest().new Dog(4, "AogC"));
        list.add(new CollectionTest().new Dog(1, "AogC"));
//        Collections.sort(list, new Comparator<Dog>() {
//
//            @Override
//            public int compare(Dog o1, Dog o2) {
//                return 1;
//            }
//        });
//        System.out.println("给狗狗按照年龄倒序：" + list);
        Collections.sort(list, new Comparator<Dog>() {

            @Override
            public int compare(Dog o1, Dog o2) {
                if (o1.age > o2.age) {
                    return 1;
                } else if (o1.age < o2.age) {
                    return -1;
                } else {
                    return -1;
                }
            }
        });
        System.out.println("给狗狗按名字字母顺序排序：" + list);
    }
}

