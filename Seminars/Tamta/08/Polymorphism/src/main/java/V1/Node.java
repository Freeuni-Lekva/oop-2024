package V1;

public class Node {
    private char operation;
    private double value;
    private Node left;
    private Node right;

    public Node(double value) {
        this.operation = '$';
        this.value = value;
    }

    public Node(char operation, Node left, Node right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    public Node(char operation, double left, double right) {
        this(operation, new Node(left), new Node(right));
    }

    public double evaluate() {
        return switch (operation) {
            case '$' -> value;
            case '+' -> left.evaluate() + right.evaluate();
            case '-' -> left.evaluate() - right.evaluate();
            case '*' -> left.evaluate() * right.evaluate();
            case '/' -> left.evaluate() / right.evaluate();
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
    }

    public String toString() {
        return switch (operation) {
            case '$' -> "" + value;
            case '+', '-', '*', '/' -> "(" + left + operation + right + ")";
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
    }
}
