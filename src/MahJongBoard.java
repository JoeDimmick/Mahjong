import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

//set mouse listener call
public class MahJongBoard extends JPanel implements MouseListener {

    private MahJong game;
    private MahJongModel model;
    private URL url = getClass().getResource("images/dragon_bg.png");
    private Image backgroundImage = new ImageIcon(url).getImage();
    private Dimension imageDim;
    private Dimension boardDim;

    public MahJongBoard(MahJong game){
        this.game = game;
        model = new MahJongModel(this);
        setLayout(null);
        imageDim = new Dimension(backgroundImage.getWidth(this),
                backgroundImage.getHeight(this));

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 15 ; j++){
                for(int k = 0; k < 5; k++){
                    if(model.getTile(i,j,k)!=null){
                        model.getTile(i,j,k).addMouseListener(this);
                    }
                }
            }
        }

        // top tile
        add(model.getTile(0,0,4));

        // layer 3
        for(int i = 4; i > 2; i--){
            for(int j = 6; j < 8 ; j++){
                add(model.getTile(i,j,3));
            }
        }

        //layer 2
        for(int i = 5; i > 1; i--){
            for(int j = 5; j < 9 ; j++){
                add(model.getTile(i,j,2));
            }
        }

        //layer 1
        for(int i = 6; i > 0; i--){
            for(int j = 4; j < 10 ; j++){
                add(model.getTile(i,j,1));
            }
        }

        //layer 0
        add(model.getTile(0,1,0));
        add(model.getTile(0,2,0));
        add(model.getTile(8,0,0));
        add(model.getTile(5,2,0));
        add(model.getTile(4,1,0));
        add(model.getTile(4,2,0));
        add(model.getTile(3,1,0));
        add(model.getTile(3,2,0));
        add(model.getTile(2,2,0));
        add(model.getTile(7,1,0));
        add(model.getTile(7,2,0));

        for(int i = 7; i > -1; i--){
            for(int j = 3; j < 11 ; j++){
                add(model.getTile(i,j,0));
            }
        }

        add(model.getTile(0,11,0));
        add(model.getTile(0,12,0));
        add(model.getTile(5,11,0));
        add(model.getTile(4,11,0));
        add(model.getTile(4,12,0));
        add(model.getTile(3,11,0));
        add(model.getTile(3,12,0));
        add(model.getTile(2,11,0));
        add(model.getTile(7,11,0));
        add(model.getTile(7,12,0));
        add(model.getTile(8,13,0));
        add(model.getTile(8,14,0));

    }

    //design the game window here
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        boardDim = new Dimension(this.getWidth(), this.getHeight());
        g.drawImage(backgroundImage, ((boardDim.width-216)-imageDim.width)/2,
                ((boardDim.height-144)-imageDim.height)/2, this);
        setBackground(Color.ORANGE);

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
