package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 郝少杰
 * @date 2021/2/19 11:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonPo {
    private String name;
    private int age;
}
