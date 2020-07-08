package Demo4ThreadSafe;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class MainTest {
//    public static void main(String[] args) {
//
////        threadPoolExecutor();
//        ThreadLocalDemo();
//    }
    static ThreadLocal threadLocal = new ThreadLocal();
    static Integer MOCK_MAX = 10000;
    static Integer THREAD_MAX = 10000;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_MAX);
        for (int i = 0; i < THREAD_MAX; i++) {
            executorService.execute(() -> {
                threadLocal.set(new MainTest().getList());
                System.out.println(Thread.currentThread().getName());
                // 移除对象
//                threadLocal.remove();
            });
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
    List getList() {
        List list = new ArrayList();
        for (int i = 0; i < MOCK_MAX; i++) {
            list.add("Version：JDK 8");
            list.add("ThreadLocal");
            list.add("Author：老王");
            list.add("DateTime：" + LocalDateTime.now());
            list.add("Test：ThreadLocal OOM");
        }
        return list;
    }


    public static void threadPoolExecutor(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 10, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(100));
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                // 执行线程池
                System.out.println("Hello, Java.");
            }
        });
    }

    public static void ThreadLocalDemo(){
        ThreadLocal threadLocal = new ThreadLocal();
// 存值
        threadLocal.set(Arrays.asList("老王", "Java 面试题"));
// 取值
        List list = (List) threadLocal.get();
        System.out.println(list.size());
        System.out.println(threadLocal.get());
//删除值
        threadLocal.remove();
        System.out.println(threadLocal.get());
    }

    public static void ThreadMain(){
        new Thread(() -> {
            for (int i = 1; i < 4; i++) {
                System.out.println("线程一：" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 1; i < 4; i++) {
                System.out.println("线程二：" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
