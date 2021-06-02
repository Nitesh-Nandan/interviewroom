package com.practice.iroom.collection;

import java.util.*;

public class MapCollectionDemo {
    static void hashMapIntro() {
        Map<String, Integer> hmap = new HashMap<>();
        hmap.put("key2", 100);
        hmap.put("key3", 200);
        hmap.put("key1", 300);
        hmap.put("key11", 300);
        hmap.put("key5", 300);

        hmap.putIfAbsent("key3", 500);

        System.out.println(hmap.get("key1"));
        System.out.println(hmap.get("key3"));

        int val = hmap.getOrDefault("key10", 10000);
        System.out.println(val);

        Set<Map.Entry<String, Integer>> entries = hmap.entrySet();

        for(Map.Entry<String, Integer> entry : entries){
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.printf("key: %s, value: %d %n", key, value);
        }

        Set<String> keySets = hmap.keySet();
        for (String key: keySets) {
            System.out.println(key);
            System.out.println(hmap.get(key));
        }
    }
    static void linkedHashMapIntro() {
        Map<String,Integer> lmap = new LinkedHashMap<>();
        lmap.put("key2", 100);
        lmap.put("key3", 200);
        lmap.put("key1", 300);

        lmap.putIfAbsent("key3", 500);

        System.out.println(lmap.get("key1"));
        System.out.println(lmap.get("key3"));

        int val = lmap.getOrDefault("key10", 10000);
        System.out.println(val);

        Set<Map.Entry<String, Integer>> entries = lmap.entrySet();

        for(Map.Entry<String, Integer> entry : entries){
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.printf("key: %s, value: %d %n", key, value);
        }

    }
    static void treeMapIntro() {
        Map<String,Integer> tmap = new TreeMap<>();
        tmap.put("key2", 100);
        tmap.put("key3", 200);
        tmap.put("key1", 300);

        tmap.putIfAbsent("key3", 500);

        System.out.println(tmap.get("key1"));
        System.out.println(tmap.get("key3"));

        int val = tmap.getOrDefault("key10", 10000);
        System.out.println(val);

        Set<Map.Entry<String, Integer>> entries = tmap.entrySet();

        for(Map.Entry<String, Integer> entry : entries){
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.printf("key: %s, value: %d %n", key, value);
        }

    }
    public static void main(String[] args) {
        hashMapIntro();
//        linkedHashMapIntro();
//        treeMapIntro();


    }
}
