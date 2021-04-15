package com.example.utils;

import com.ohaotian.plugin.base.exception.ZTBusinessException;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: zhoubang
 * @Date: 2019/5/15 11:20
 * @Description:校验非空参数
 */
public class ValidBatchUtils {

    /**
     * 批量校验非空参数
     */
    public static void isNotEmpty(Object object, String... params) {
        Arrays.asList(params).stream().forEach(param -> {
            try {
                final Field declaredField = object.getClass().getDeclaredField(param);
                declaredField.setAccessible(true); // 设置些属性是可以访问的
                if (StringUtils.isEmpty(declaredField.get(object))) {
                    throw new ZTBusinessException("入参字段为空:" + param);
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 参数校验： 使用JSR303参数校验，注解使用。
     * 注解使用和类型可以参考javax.validation和hibernate-validation
     * @return 校验结果信息
     */
    public static <T> List<String> checkParams(T object){
        ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations=validator.validate(object);
        Iterator<ConstraintViolation<T>> iter=violations.iterator();
        List<String> errors=new ArrayList<>();
        if(iter.hasNext()){
            while (iter.hasNext()){
                errors.add(iter.next().getMessage());
            }
        }
        return errors;
    }


    public static Boolean isPhoneNumber(String mobile){

        String regex="^(?:(?:\\+|00)86)?1[3-9]\\d{9}$";

        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(mobile);
        return matcher.find();
    }
}
