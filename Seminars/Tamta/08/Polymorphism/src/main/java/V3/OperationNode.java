package V3;

import V3.Node;

public abstract class OperationNode implements Node {
    private Node left;
    private Node right;

    public OperationNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return doEvaluate(left.evaluate(), right.evaluate());
    }

    @Override
    public String toString() {
        return "(" + left.toString() + getOperation() + right.toString() + ")";
    }
    public abstract double doEvaluate(double left, double right);
    public abstract char getOperation();

}
