#### Thread和Runnable是什么关系：   
    Thread是实现了runnable接口的类，使用run支持多线程
    因类的单一继承原则，推荐多使用Runnable接口

#### 如何给run（）方法传参数：
    构造函数传参
    成员变量传参
    回调函数传参

#### 如何处理线程的返回值：
    主线程等待法
    使用Thread类中的join（）方法阻塞当前线程以等待子线程处理完毕   
    通过Callable接口实现：通过FutureTask 或者 线程池获取
#### 线程的状态
    新建（NEW）：创建后尚未启动线程的状态   
    运行（Runnable）：包含Running和Ready
    无限期等待（waiting）：不会被分配CPU执行时间，需要显示被唤醒。（以下三种方法可以让线程进入无限期等待状态）
        没有设置Timeout参数的Object.wait()方法
        没有设置Timeout参数的Thread.join()方法
        LockSupport.park()方法
    限期等待（Timed Waiting）:在一定时间后由系统自动唤醒。（以下三种方法可以让线程进入限期等待状态）
        Thread.sleep()方法
        设置Timeout参数的Object.wait()方法
        设置Timeout参数的Thread.join()方法
        LockSupport.parkNanos()方法
        LockSupport.parkUntil()方法
    阻塞状态（Blocked）:等待获取排他锁
    结束（Terminated）：已经终止的线程状态，线程已经结束
    
#### sleep和wait的区别
    基本区别：
    1、sleep是Thread类的方法，wait是Object类中的方法
    2、sleep（）方法可以在任何的地方使用
    3、wait（）方法只能在synchronized方法或者synchronized块中使用
    最主要的本质区别：
    Thread.sleep只会让出CPU，不会导致锁行为的改变
    Object.wait不仅会让出CPU，还会释放出已经占有的同步资源锁
#### notify和notifyAll的区别
    两个概念：
    1、锁池EntryList
        假设线程A已经拥有了某个对象（不是类）的锁，而其他线程B、C想要调用这个对象的某个synchronized方法（或者块），
        由于B、C线程在进入对象的synchroized方法（或者块）之前必须先获得该对象锁的拥有权，而恰巧该对象的锁目前正在被线程A所占用，
        此时B、C线程就会被阻塞，进入一个地方去的等待锁的释放，这个地方便是该对象的锁池。
    2、等待池WaitSet
        假设线程A调用了某个对象的wait（）方法，线程A就会释放该对象的锁，同时线程A就会进入到该对象的等待池中，进入到等待池中的线程不会去竞争该对象的锁。
    notifyAll会让所有处于等待池的线程全部进入到锁池去竞争获取锁的机会
    notify只会随机选取一个处于等待池中的线程进入锁池去竞争获取锁的机会
#### yield
    概念：
        当调用Thread.yield()函数时，会给线程调度器一个当前线程愿意让出CPU使用的暗示，但是线程调度器可能会忽视这一个暗示。
        yield不会让出当前线程所占有的锁。
#### 如何中断线程
    已经被抛弃的方法：
        1、通过调用stop（）方法去停止线程
        2、通过调用suspend（）和resume（）方法 
    目前使用的方法：
        调用interrupt()方法，通知线程应该中断了
        1、如果线程处于被阻塞状态，那么线程将立即推出被阻塞状态，并且抛出一个InterrupedException异常
        2、如果线程处于正常活动状态，那么会将该线程的中断标志设置为true。被设置中断标志的线程将继续正常运行，不受影响
    当一个线程需要被中断时的操作：
    需要被调用的线程配合中断：
        1、在正常运行任务时，经常检查本线程的中断标志位，如果被设置了中断标志位就自行停止线程。

