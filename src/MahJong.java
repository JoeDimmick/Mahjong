import javax.swing.*;
import java.awt.*;

public class MahJong extends JFrame {
    private static Dimension dim = new Dimension(960, 600);
    private MahJongBoard board;

    //design the frame holding the game window here
    public  MahJong() {
        board = new MahJongBoard(this);
        setPreferredSize(dim);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MahJong");

        Dimension screenSize;
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width-dim.width)/2,(screenSize.height-dim.height)/2);

        add(board);

        pack();
        setVisible(true);
    }

    public static void main(String[] args){
        new MahJong();
    }

}
