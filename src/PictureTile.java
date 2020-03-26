import javax.swing.*;
import java.awt.*;
import java.net.URL;

abstract public class PictureTile extends Tile {
    private String name;
    private ImageIcon image;

    public PictureTile(String name) {
        this.name = name;
        setToolTipText ( toString () );
        URL url = PictureTile.class.getResource ( "images/" + name + ".png" );
        image = new ImageIcon ( url );
        image = new ImageIcon ( image.getImage().getScaledInstance ( 50,50, Image.SCALE_SMOOTH ) );
    }

    public String toString() {
        return name;
    }

    public void paintComponent(Graphics g){
        super.paintComponent ( g );
        g.drawImage ( image.getImage (), 16, 4, this );
    }

    public static void main(String[] args) {
        JFrame	frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Picture Tiles");

        frame.add(new Bamboo1Tile());

        frame.add(new FlowerTile("Chrysanthemum"));
        frame.add(new FlowerTile("Orchid"));
        frame.add(new FlowerTile("Plum"));
        frame.add(new FlowerTile("Bamboo"));

        frame.add(new SeasonTile("Spring"));
        frame.add(new SeasonTile("Summer"));
        frame.add(new SeasonTile("Fall"));
        frame.add(new SeasonTile("Winter"));

        frame.pack();
        frame.setVisible(true);
    }

}

