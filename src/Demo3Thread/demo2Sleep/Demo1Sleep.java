package Demo3Thread.demo2Sleep;

/*


 */
public class Demo1Sleep {
    public static void main(String[] args){
        //模拟秒表
        for (int i=1;i<=60;i++){
            System.out.println(i);
            //使用Thread类的sleep方法，让程序睡眠
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
