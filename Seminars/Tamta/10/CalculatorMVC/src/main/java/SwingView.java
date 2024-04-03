import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingView extends BasicView {
    @Override
    public void show() {
        JButton plusButton = new JButton("5");
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                inputListener.inputChanged(actionEvent.getActionCommand().charAt(0));
            }
        });
    }


    @Override
    public void displayChanged(String display) {
        // update textField with the given display
    }
}
