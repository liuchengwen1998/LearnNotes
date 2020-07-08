package com.lcw.javaBasic.Collection;

import java.util.LinkedList;
import java.util.TreeSet;

public class DuplicateAndOrderTest {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("111");
        linkedList.add("222");
        linkedList.add("333");
        linkedList.add("444");
        linkedList.add("111");

        System.out.println(linkedList);

        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("111");
        treeSet.add("222");
        treeSet.add("333");
        treeSet.add("444");
        treeSet.add("111");
        System.out.println(treeSet);
    }
}
