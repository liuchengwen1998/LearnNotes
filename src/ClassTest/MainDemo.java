package ClassTest;

public class MainDemo {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0;i<10;i++){
            VariantTest variantTest = new VariantTest();
            Thread.sleep(1000);
        }


    }


}
class VariantTest{
    public static int staticVar = 0;
    public int instanceVar = 0;
    public VariantTest(){
        staticVar++;
        instanceVar++;
        System.out.println("staticVar="+staticVar+",instanceVar="+instanceVar);
    }
}
