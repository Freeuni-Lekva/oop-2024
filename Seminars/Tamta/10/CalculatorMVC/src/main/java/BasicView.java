public abstract class BasicView implements View {
    ViewInputListener inputListener;

    public void registerInputListener(ViewInputListener listener){
        inputListener = listener;
    }
}
