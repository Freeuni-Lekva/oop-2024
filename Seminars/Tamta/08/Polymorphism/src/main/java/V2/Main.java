package V2;

public class Main {
    public static void main(String[] args) {
        Node a = new ValueNode(5);
        Node b = new ValueNode(6);
        Node add = new PlusNode(a, b);
        System.out.println(add);
        System.out.println("Evaluate: " + add.evaluate() + "\n");

        Node mul = new MultiplyNode(add, b);
        System.out.println(mul);
        System.out.println("Evaluate: " + mul.evaluate() + "\n");
    }
}
