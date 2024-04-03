public class Controller implements ViewInputListener{
    BasicView view;
    Brain brain;

    public void start(){
        view = new SwingView();
        brain = new Brain();
        view.registerInputListener(this);
        brain.registerDisplayListener(view);
    }


    @Override
    public void inputChanged(char input) {
        if (Character.isDigit(input)) {
            brain.pushDigit(input);
        } else if("+-*/".indexOf(input) != -1) {
            brain.pushOperator(input);
        } else if(input == '=') {
            brain.evaluate();
        } else {
            throw new IllegalArgumentException("no such button");
        }
    }
}
