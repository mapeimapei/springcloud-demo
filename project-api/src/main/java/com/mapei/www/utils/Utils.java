package com.mapei.www.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.DecimalFormat;
import java.util.*;

public class Utils {

    // array to list
    public static List<Object> Array2List(Object[] arr) {
        ArrayList<Object> arrayList = new ArrayList<Object>(Arrays.asList(arr));
        return arrayList;
    }

    //list to array
    public static String[] List2Array(List<String> list) {
        String[] arr = new String[list.size()];
        list.toArray(arr);
        return arr;
    }

//    public static Integer[] List2Array(List<Integer> list) {
//        Integer[] arr = new Integer[list.size()];
//        list.toArray(arr);
//        return arr;
//    }


    //set to list
    public static Set<Object> List2Set(List<Object> list) {
        return new HashSet<>(list);
    }


    /**
     * 数字进行格式化
     *
     * @param patrern 占位符
     * @param value   数字
     * @return String
     */
    public static String SimgleFormat(String patrern, double value) {
        DecimalFormat myFormat = new DecimalFormat(patrern);
        String output = myFormat.format(value);
        return output;
    }


    /**
     * 加密处理
     *
     * @param str 要加密的字符串，需要与盐值整合
     * @return 加密后的数据
     */
    public static String base64_encode(String str, String salt, int repeat) {                    // 加密处理
        String temp = str + "{" + salt + "}";                // 盐值对外不公布
        byte data[] = temp.getBytes();                        // 将字符串变为字节数组
        for (int x = 0; x < repeat; x++) {
            data = Base64.getEncoder().encode(data);            // 重复加密
        }
        return new String(data);                                // 返回加密后的内容
    }

    public static String base64_encode(String str, String salt) {
        int repeat = 5;
        String temp = str + "{" + salt + "}";
        byte data[] = temp.getBytes();                        // 将字符串变为字节数组
        for (int x = 0; x < repeat; x++) {
            data = Base64.getEncoder().encode(data);            // 重复加密
        }
        return new String(data);                                // 返回加密后的内容
    }

    public static String base64_encode(String str) {
        String salt = "mapei";
        int repeat = 5;
        String temp = str + "{" + salt + "}";
        byte data[] = temp.getBytes();                        // 将字符串变为字节数组
        for (int x = 0; x < repeat; x++) {
            data = Base64.getEncoder().encode(data);            // 重复加密
        }
        return new String(data);                                // 返回加密后的内容
    }

    /**
     * 进行解密处理
     *
     * @param str 要解密的内容
     * @return 解密后的原始数据
     */
    public static String base64_decode(String str, int repeat) {
        byte data[] = str.getBytes();                        // 获取加密内容
        for (int x = 0; x < repeat; x++) {
            data = Base64.getDecoder().decode(data);            // 多次解密
        }
        return new String(data).replaceAll("\\{\\w+\\}", "");    // 删除掉盐值格式
    }

    public static String base64_decode(String str) {
        int repeat = 5;
        byte data[] = str.getBytes();                        // 获取加密内容
        for (int x = 0; x < repeat; x++) {
            data = Base64.getDecoder().decode(data);            // 多次解密
        }
        return new String(data).replaceAll("\\{\\w+\\}", "");    // 删除掉盐值格式
    }


}
