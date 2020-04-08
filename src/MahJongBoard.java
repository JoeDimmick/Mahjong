import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MahJongBoard extends JPanel implements MouseListener  {

    private MahJong game;
    private MahJongModel model;


    public MahJongBoard(MahJong game){
        this.game = game;
        model = new MahJongModel(this);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        Tile tile = (Tile) mouseEvent.getSource();
        if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
            remove(tile);
            repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    public static void main(String[] args){

    }
}
