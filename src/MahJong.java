import javax.swing.*;
import java.awt.*;

public class MahJong extends JFrame {

    private MahJongBoard board;

    public  MahJong() {
        board = new MahJongBoard(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dimmick Joseph MahJong");
        setSize(700,700);
        //setLocation();
    }

    public static void main(String[] args){
        //JFrame frame = new JFrame();
        MahJong frame = new MahJong();
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("MahJong");
        frame.setSize(700,700);

        //frame.add(new MahJongBoard(new MahJong()));

        frame.pack();
        frame.setVisible(true);
    }

}
