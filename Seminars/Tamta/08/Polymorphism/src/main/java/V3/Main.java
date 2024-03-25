package V3;

public class Main {
    public static void main(String[] args) {
        Node a = new ValueNode(5);
        Node b = new ValueNode(6);
        Node add = new PlusNode(a, b);
        System.out.println(add);
        System.out.println("Evaluate: " + add.evaluate() + "\n");

        Node div = new DivideNode(a, add);
        System.out.println(div);
        System.out.println("Evaluate: " + div.evaluate() + "\n");
    }
}
