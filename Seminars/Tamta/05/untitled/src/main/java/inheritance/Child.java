package inheritance;

public class Child extends Parent{
    @Override
    public void go(){
        System.out.println("go in child");
    }

    public void cries(){
        System.out.println("waa");
    }

}
