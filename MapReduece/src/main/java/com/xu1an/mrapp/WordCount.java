package com.xu1an.mrapp;

import com.xu1an.common.KeyValue;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordCount implements IMapReduce{
//    public static void main(String[] args) throws UnsupportedEncodingException {
//        String s = "浣犲ソ";
//        //这是"你好"的gbk编码的字符串
//        s = "��";
//        String ss = new String(s.getBytes("GBK"), "UTF-8");
//
//        System.out.println(ss);
//    }
    public List<KeyValue> map(String contents) {

        List<String> words = Arrays.stream(contents.split("[^a-zA-Z]+"))
                // 拆分所有字母相关数据
                                   .filter(word -> !"".equals(word))
                // 过滤非空数据
                                   .collect(Collectors.toList());
        List<KeyValue> keyValues = new ArrayList<>(words.size());
        // 装成对象
        for (String word : words) {
            KeyValue keyValue = new KeyValue(word, "1");
            // 默认key  value赋值 作为对象可以允许有重复的key
            keyValues.add(keyValue);
        }
        return keyValues;
    }

    public String reduce(List<String> values) {
        return String.valueOf(values.size());
    }
}
