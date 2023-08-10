package com.practice.iroom.lamdas;

public class LamdaDemo1 {

    public boolean testMe(CustomFilter filter) {
        return filter.test(10);
    }


    public static void main(String[] args) {
        LamdaDemo1 exp = new LamdaDemo1();
        System.out.println(exp.testMe(new CustomFilter() {
            @Override
            public boolean test(int x) {
                return x < 10;
            }
        }));

        System.out.println(exp.testMe((x) -> x >= 10));
    }
}
