package com.sparksys.commons.cloud.utils;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalUtils {

    private static final ThreadLocal<Map<String, String>> THREAD_LOCAL = new ThreadLocal<>();


    public static void setLocalMap(Map<String, String> threadLocalMap) {
        THREAD_LOCAL.set(threadLocalMap);
    }

    public static Map<String, String> getLocalMap() {
        Map<String, String> map = THREAD_LOCAL.get();
        if (map == null) {
            map = new HashMap<>(10);
            THREAD_LOCAL.set(map);
        }
        return map;
    }

    public static void remove() {
        THREAD_LOCAL.remove();
    }

}
