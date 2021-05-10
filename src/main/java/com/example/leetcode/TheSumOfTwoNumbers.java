package com.example.leetcode;

import com.example.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TheSumOfTwoNumbers {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     *·················
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * @param args
     */
    public static void main(String[] args) {
        int num[] = {1,2,3,9,8,7,6};
        int target = 7;
        Map<Integer, Integer> integerIntegerMap = twoSum(num, target);
        log.info(integerIntegerMap.toString());
    }

    public static Map<Integer,Integer> twoSum(int[] num,int target){
        Map<Integer,Integer> returnMap = new HashMap<>(1);
        Map<Integer,Integer> map = new HashMap<>(num.length);
        for (int i = 0;i<num.length;i++){
            if (map.containsKey(target-num[i])){
                returnMap.put(map.get(target-num[i]),i);
                return returnMap;
            }
            map.put(num[i],i);
        }
        throw new IllegalArgumentException("无两数据之和");
    }
}
