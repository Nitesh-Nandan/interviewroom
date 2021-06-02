package com.practice.iroom.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class CKey {
    final private String name;
    final private Integer val;

    public CKey(String name, Integer val) {
        this.name = name;
        this.val = val;
    }
    @Override
    public int hashCode() {
        int prime = 31;
        int value = 1;
        value = prime * value + Objects.hashCode(this.name);
        value = prime*value + this.val;
        return value;
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        CKey okey = (CKey) obj;
        return Objects.equals(this.name, okey.name) && Objects.equals(this.val, okey.val);

    }
    @Override
    public String toString() {
        return name + " " + val;
    }
}

public class LowLevelExp {
    public static void main(String[] args) {
        HashMap<CKey, Integer> mymap = new HashMap<>();
        CKey key1 = new CKey("John", 12);
        CKey key2 = new CKey("John", 12);

        mymap.put(key1,123);
        mymap.put(key2,45678);

        System.out.println(key1.hashCode());
        System.out.println(key2.hashCode());

        System.out.println(key1.equals(key2));


        Set<Map.Entry<CKey, Integer>> entries = mymap.entrySet();
        for(Map.Entry<CKey, Integer> entry : entries){
            CKey key = entry.getKey();
            Integer value = entry.getValue();
            System.out.printf("key: %s, value: %d %n", key, value);
        }

    }
}
