package ListDemo;

import java.util.*;
import java.util.concurrent.locks.Lock;

public class IteratorList {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> addNumber());
        Thread thread2 = new Thread(() -> addNumber());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("number：" + number);
    }
    static int number = 0;
    public static void addNumber() {


            for (int i = 0; i < 10000; i++) {
                ++number;
            }


    }

    public static void iteratorMap(){
        Map<String, String> hashMap = new HashMap();
        hashMap.put("name", "老王");
        hashMap.put("sex", "你猜");
// 方式一：entrySet 遍历
        for (Map.Entry item : hashMap.entrySet()) {
            System.out.println(item.getKey() + ":" + item.getValue());
        }
// 方式二：iterator 遍历
        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
// 方式三：遍历所有的 key 和 value
        for (Object k : hashMap.keySet()) {
            // 循环所有的 key
            System.out.println(k);
        }
        for (Object v : hashMap.values()) {
            // 循环所有的值
            System.out.println(v);
        }
// 方式四：通过 key 值遍历
        for (Object k : hashMap.keySet()) {
            System.out.println(k + ":" + hashMap.get(k));
        }
    }

    public static void QueneDemo(){
        Queue<String> linkedList = new LinkedList<>();
        linkedList.add("Dog");
        linkedList.add("Camel");
        linkedList.add("Cat");
        while (!linkedList.isEmpty()) {
            System.out.println(linkedList.poll());
        }
        System.out.println(linkedList);
    }

}
