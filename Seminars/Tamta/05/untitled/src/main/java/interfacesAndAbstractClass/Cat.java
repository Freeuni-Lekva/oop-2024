package interfacesAndAbstractClass;

public class Cat extends Animal implements AnimalStuff {
    public int legNum(){
        return 4;
    }

    @Override
    public void makeNoise() {
        System.out.println("MEOW!");
    }

    @Override
    public void eat() {
        System.out.println("eating fish");
    }
}
