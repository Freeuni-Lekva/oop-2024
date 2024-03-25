public class Main {

    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Animal();
        dog.eat();
        cat.eat();
        ((Cat)cat).eat(5);
    }
}
