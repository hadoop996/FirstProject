package com.example.ALLTest;

import com.example.domain.Dog;
import org.assertj.core.util.Lists;

import java.text.Collator;
import java.util.*;

/**
 * @author 郝少杰
 * @date 2020/12/2 10:43
 */
public class CollectionTest {

    public static void main(String[] args) {
        List<Dog> list = new ArrayList<>();
        Dog dog = new Dog(18, "郝少杰");
        Dog dog1 = new Dog(1, "张飞");
        Dog dog2 = new Dog(19, "皮洛米修斯");
        Dog dog3 = new Dog(22, "哇卡");
        list.add(dog);
        list.add(dog1);
        list.add(dog2);
        list.add(dog3);

        Collections.sort(list, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                //注意:按照中文拼音排序要进行下面的设置
                Comparator<Object> com = Collator.getInstance(Locale.CHINA);
                return ((Collator) com).compare(o1.getName(),o2.getName());
            }
        });

        System.out.println(list);

//        Collections.sort(list, new Comparator<Dog>() {
//
//            @Override
//            public int compare(Dog o1, Dog o2) {
//                if (o1.age > o2.age) {
//                    return 1;
//                } else if (o1.age < o2.age) {
//                    return -1;
//                } else {
//                    return -1;
//                }
//            }
//        });
    }
}

