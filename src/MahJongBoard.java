import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//set mouse listener call
public class MahJongBoard extends JPanel implements MouseListener  {

    private MahJong game;
    private MahJongModel model;
    //private ImageIcon backgroundImage = "";


    public MahJongBoard(MahJong game){
        this.game = game;
        model = new MahJongModel(this);
        setLayout(null);
    }


    //design the game window here
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //add(model.test());
        //model.getTile(0,1,0);
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 15 ; j++){
                for(int k = 0; k < 4; k++){
                    if(model.getTile(i,j,k)!=null)add(model.getTile(i,j,k));
                }
            }
        }
        //setLocation ( 576, 360 );
        //setBackground(Color.ORANGE);
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

//    public static void main(String[] args){
//
//    }
}
