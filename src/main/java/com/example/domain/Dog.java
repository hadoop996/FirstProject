package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 郝少杰
 * @date 2021/1/13 11:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog  implements Comparable<Dog>{
    public int age;
    public String name;

    @Override
    public int compareTo(Dog o) {
        return this.name.compareTo(o.getName());
    }

    /**
     * Comparable类compareTo方法重写
     * @param o
     * @return
     */
}
