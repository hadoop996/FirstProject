package com.example.xml.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class Channl implements Serializable {
    @NotNull
    @Size(max = 4)
    private String name;
    @NotNull
    @Size(max = 3)
    private String age;
}
