package V3;

import V3.Node;

public class ValueNode implements Node {
    private double value;

    public ValueNode(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
