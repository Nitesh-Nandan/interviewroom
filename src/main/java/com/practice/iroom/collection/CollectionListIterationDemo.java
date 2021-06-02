package com.practice.iroom.collection;

import java.util.*;

public class CollectionListIterationDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        List<Integer> list3 = new Vector<>();

        list.add(10); list.add(20); list.add(30);
        list2.add(10);list2.add(20);list2.add(30);
        list3.add(10);list3.add(20);list3.add(30);

        Iterator<Integer> itr = list.iterator();
        Iterator<Integer> itr2 = list2.listIterator();
        Iterator<Integer> itr3 = list3.iterator();

//        while(itr.hasNext()) {
//            System.out.println(itr.next());
//        }
//        while(itr2.hasNext()) {
//            System.out.println(itr2.next());
//        }
//        while(itr3.hasNext()) {
//            System.out.println(itr3.next());
//        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);

//        Iterator<Integer> itrq = queue.iterator();
//        while(itrq.hasNext()) {
//            System.out.println(itrq.next());
//        }

//        System.out.println(queue.peek()); // element
//        System.out.println(queue.poll()); // remove
//        System.out.println(queue.remove());
//        System.out.println(queue.element());
//        System.out.println(queue.element());

        Queue<Integer> aq = new ArrayDeque<>();
        Queue<Integer> pq = new PriorityQueue<>();

        Object[] arr = new Object[10];
        arr[0] = new String("nitesh");
        arr[1] = new Integer(10);
//        arr[2] = 56.f;

        for(int i=0;i<3;i++) {
            System.out.println(arr[i]);
        }
//
//        List<Object> ll = new ArrayList<>();
//        ll.add(10);
//        ll.add(56.25f);
//        li.add("adiaod");



        /**
         * Set Interface
         */

        /**
         * HashSet
         */
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(50);
        hashSet.add(150);
        hashSet.add(10);
        hashSet.add(30);
        hashSet.add(20);

//        Iterator<Integer> ithset = hashSet.iterator();
//        while (ithset.hasNext()) {
//            System.out.println(ithset.next());
//        }

        /**
         * Treeset
         */
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(50);
        treeSet.add(150);
        treeSet.add(10);
        treeSet.add(30);
        treeSet.add(20);
//        Iterator<Integer> titr = treeSet.iterator();
//        while (titr.hasNext()) {
//            System.out.println(titr.next());
//        }
        /**
         * LinkedHashSet
         */
        Set<Integer> linkHashSet = new LinkedHashSet<>();
        linkHashSet.add(50);
        linkHashSet.add(150);
        linkHashSet.add(10);
        linkHashSet.add(30);
        linkHashSet.add(20);
        Iterator<Integer> litr = linkHashSet.iterator();
        while (litr.hasNext()) {
            System.out.println(litr.next());
        }
    }
}