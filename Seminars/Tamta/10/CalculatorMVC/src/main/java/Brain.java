public class Brain {
    BrainDisplayListener displayListener;
    public void pushDigit(char input){
        String result = "";
        displayListener.displayChanged(result);
    }

    public void pushOperator(char input){

    }

    public void evaluate(){
        String result = "";
        displayListener.displayChanged(result);
    }

    public void registerDisplayListener(BrainDisplayListener listener){
        displayListener = listener;
    }
}
