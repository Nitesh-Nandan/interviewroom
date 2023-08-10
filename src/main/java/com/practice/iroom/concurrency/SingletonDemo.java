package com.practice.iroom.concurrency;

import lombok.experimental.UtilityClass;

class TvSet {
    private static volatile TvSet INSTANCE = null;
    private TvSet(){}

    public static TvSet getInstance() {
        if(INSTANCE == null) {
            synchronized (TvSet.class) {
                if(INSTANCE == null) {
                    INSTANCE = new TvSet();
                }
            }
        }
        return INSTANCE;
    }
}
public class SingletonDemo {
}
