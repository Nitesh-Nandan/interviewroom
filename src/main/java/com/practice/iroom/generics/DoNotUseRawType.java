package com.practice.iroom.generics;

import java.util.Arrays;
import java.util.List;

class GenericContainer<T> {
    private T value;

    public List<Integer> getNumberList() {
        return Arrays.asList(1, 2, 3);
    }
}

class Handler {
    public void traverseNumberList(GenericContainer<?> container) {
        for(int num: container.getNumberList()) {
            System.out.println(num);
        }
    }
}
public class DoNotUseRawType {
}
