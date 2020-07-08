### JVM如何加载.class文件
Class Files -> Class Loader -> Runtime Data Area -> Execution Engine -> Native Interface -> Native Libraies   

Class Loader: 依据特定的格式，加载class文件到内存中   
Execution Engine：对命令进行解析   
Native Interface：融合不同开发语言的原生库为Java所用   
Runtime Data Area：JVM内存空间结构模型

### 谈谈反射
   java反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用他的任意属性和方法；这种动态获取信息以及动态调用对象方法的功能称之为java语言的反射机制       
```
public class ReflectSample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<Robot> rc = (Class<Robot>) Class.forName("com.lcw.javaBasic.reflect.Robot");
        Robot robot = rc.newInstance();
        System.out.println("Class name is " + rc.getName() );

        /*
        获取对象所有方法和属性的方法（包括private，但不包括继承和实现的）：getDeclaredMethod（）
        如果方法的修饰符为protected/private 请用， getDeclaredMethod 方法，为 public 请用 getMethod 方法 ！
         */
        Method getHello = rc.getDeclaredMethod("throwHello", String.class);
        getHello.setAccessible(true);
        Object o = getHello.invoke(robot,"Bob");
        System.out.println("getHello result is " + o);

        Method sayHi = rc.getMethod("sayHi", String.class);
        sayHi.invoke(robot,"welcome");
        Field name = rc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(robot,"Allie");
        sayHi.invoke(robot,"welcome");
    }
}
```
   
   
   
### 类从编译到执行的过程
1、编译器将Robot.java源文件编译成为Robot.class字节码文件   
2、ClassLoader将字节码文件转换为JVM中的Class<Robot>对象   
3、JVM利用Class<Robot>对象实例化为Robot对象

### 谈谈ClassLoader
ClassLoader在Java中有着非常重要的作用，它主要工作在Class装载的加载阶段，其主要作用是从系统外部获得Class二进制数据流。他是Java的核心组件，所有的Class都是由ClassLoader进行加载的，ClassLoader负责将Class文件里面的二进制数据流装在进系统，然后交给Java虚拟机进行连接、初始化等操作。

###ClassLoader的种类
1、BootStrapClassLoader：C++编写，加载核心类库java.*   
2、ExtClassLoader：Java编写，加载扩展库javax.*   
3、AppClassLoader：Java编写，加载程序所在目录   
4、自定义ClassLoader：Java编写，定制化加载
