package ObjectClone;

public class Dog implements Cloneable {
    public DogChild dogChild;
    public String name;
    public int age;



    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
