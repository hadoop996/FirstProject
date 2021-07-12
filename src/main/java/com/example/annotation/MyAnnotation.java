package com.example.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@SuppressWarnings({"all"})
public @interface MyAnnotation{
}
