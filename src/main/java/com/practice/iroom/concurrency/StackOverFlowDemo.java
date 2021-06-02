package com.practice.iroom.concurrency;

public class StackOverFlowDemo {
    public static int fun() {
        return fun();
    }
    public static void main(String[] args) {
        fun();
    }
}
