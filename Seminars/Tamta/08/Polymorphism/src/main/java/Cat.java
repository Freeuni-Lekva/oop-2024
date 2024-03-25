public class Cat extends Animal {
    @Override
    void eat() {
        System.out.println("EATING");
    }

    void eat(int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            eat();
        }
    }

}
