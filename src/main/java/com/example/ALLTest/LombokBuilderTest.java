package com.example.ALLTest;

import com.example.domain.EngineerBO;
import com.example.domain.EngineersBO;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author 郝少杰
 * @date 2021/1/28 16:37
 */
public class LombokBuilderTest {
    public static void main(String[] args) {
        List list = Lists.newArrayList();

        list.add(EngineersBO.builder().
                channelCode("91-0910").
                channelName("测试渠道01").
                developerID("91-0910000").
                developerName("测试发展人名称01").
                name("李芳").
                nameHeadImg("/img/head/a/head.jpg").
                phone("18612081234").
                tenantCode("919191"));
        System.out.println(list);
    }
}
