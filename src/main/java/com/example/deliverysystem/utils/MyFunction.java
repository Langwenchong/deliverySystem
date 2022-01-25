package com.example.deliverysystem.utils;

import java.util.Iterator;
import java.util.Map;

/**
 * @Author Lang wenchong
 * @Date 2021/12/25 17:49
 * @Version 1.0
 */
public class MyFunction {
    public static String findKeyByValue(String v, Map<String, String> map) {
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            String key = entry.getKey();
            String value = entry.getValue();
            if (value.equals(v)) return key;
        }
        return null;
    }
}
