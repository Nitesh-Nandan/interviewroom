package com.practice.iroom.collection;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer t0, Integer t1) {
                return t0-t1;
            }
        });

        Queue<Integer> queue2 = new PriorityQueue<>((a,b)->a-b);
    }
}
