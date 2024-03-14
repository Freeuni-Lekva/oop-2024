package interfacesAndAbstractClass;

public class Dog extends Animal implements AnimalStuff{
    @Override
    public void makeNoise() {
        System.out.println("Woof");
    }

    @Override
    public void eat() {
        System.out.println("eating dog food");
    }
}
