package interfacesAndAbstractClass;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // usage
        Cat cat = new Cat();
        Animal dog = new Dog();

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(cat);
        animals.add(dog);
        for (Animal animal: animals) {
            animal.makeNoise();
        }

        // runtime type is always the type that we initialised variable as
        System.out.println("I have " + ((Cat)animals.get(0)).legNum() + " legs");
        // error
//        System.out.println("I have " + ((Cat)animals.get(1)).legNum() + " legs");
    }
}
