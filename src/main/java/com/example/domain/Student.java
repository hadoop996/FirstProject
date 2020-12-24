package com.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author 郝少杰
 * @date 2020/9/16 12:51
 */
@Data
public class Student {
    private String a;
    @JsonProperty("zhangsan")
    private String b;

}
