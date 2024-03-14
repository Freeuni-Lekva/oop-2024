package interfacesAndAbstractClass;

public abstract class Animal implements AnimalStuff{
    int age;
    String name;
    public abstract void makeNoise();
    public void drinkWater(){
        System.out.println("drinking");
    }

}
