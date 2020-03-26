import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BambooTile extends RankTile {

    protected ArrayList<Bamboo> bamboos;
    protected Color green = new Color ( 0x00CD00 );

    public BambooTile(int rank) {
        super ( rank );
        setToolTipText ( toString ( ) );
        setBamboos ( );
    }

    public String toString() {
        return "Bamboo " + rank;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent ( g );
        for (Bamboo b : bamboos)
            if (b != null)
                b.draw ( g );
    }

    public class Bamboo {

        private int x;
        private int y;
        private Color color;

        public Bamboo(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public void draw(Graphics g) {
            Polygon b = new Polygon ( );
            b.addPoint ( x + 4, y );
            b.addPoint ( x + 2, y - 2 );
            b.addPoint ( x + 2, y - 6 );
            b.addPoint ( x + 4, y - 6 );
            b.addPoint ( x + 2, y - 8 );
            b.addPoint ( x - 2, y - 8 );
            b.addPoint ( x - 4, y - 6 );
            b.addPoint ( x - 2, y - 6 );
            b.addPoint ( x - 2, y - 2 );
            b.addPoint ( x - 4, y );
            b.addPoint ( x - 2, y );
            b.addPoint ( x - 2, y + 4 );
            b.addPoint ( x - 4, y + 6 );
            b.addPoint ( x + 4, y + 6 );
            b.addPoint ( x + 2, y + 4 );
            b.addPoint ( x + 2, y );

            g.setColor ( color );
            g.fillPolygon ( b );
            g.setColor ( Color.WHITE );
            g.drawLine ( x, y + 1, x, y - 6 );
            g.drawLine ( x, y + 6, x, y - 1 );
        }
    }

//    public class RotatedBamboo {
//        public void draw(Graphics g) {
//
//        }
//    }

    private void setBamboos() {
        // face of tile face is 60x60 each layer is 6px, each tile is 72x72;
        // center of the tile face would be (30 + 12) = 42 width
        // center of the tile face would be 30 height
        //bamboo is 14px tall, 8 px wide
        bamboos = new ArrayList ( rank );
        switch (rank) {
            case 2:
                bamboos.add ( new Bamboo ( 42, 22, Color.BLUE ) );
                bamboos.add ( new Bamboo ( 42, 38, green ) );
                break;
            case 3:
                bamboos.add ( new Bamboo ( 42, 22, Color.BLUE ) );
                bamboos.add ( new Bamboo ( 32, 38, green ) );
                bamboos.add ( new Bamboo ( 50, 38, green ) );
                break;
            case 4:
                bamboos.add ( new Bamboo ( 32, 22, Color.BLUE ) );
                bamboos.add ( new Bamboo ( 50, 22, green ) );
                bamboos.add ( new Bamboo ( 32, 38, green ) );
                bamboos.add ( new Bamboo ( 50, 38, Color.BLUE ) );
                break;
            case 5:
                bamboos.add ( new Bamboo ( 28, 22, green ) );
                bamboos.add ( new Bamboo ( 56, 22, Color.BLUE ) );
                bamboos.add ( new Bamboo ( 42, 30, Color.RED ) );
                bamboos.add ( new Bamboo ( 28, 38, Color.BLUE ) );
                bamboos.add ( new Bamboo ( 56, 38, green ) );
                break;
            case 6:
                bamboos.add ( new Bamboo ( 28, 22, green ) );
                bamboos.add ( new Bamboo ( 42, 22, green ) );
                bamboos.add ( new Bamboo ( 56, 22, green ) );
                bamboos.add ( new Bamboo ( 28, 38, Color.BLUE ) );
                bamboos.add ( new Bamboo ( 42, 38, Color.BLUE ) );
                bamboos.add ( new Bamboo ( 56, 38, Color.BLUE ) );
                break;
            case 7:
                bamboos.add ( new Bamboo ( 42, 16, Color.RED ) );
                bamboos.add ( new Bamboo ( 28, 32, green ) );
                bamboos.add ( new Bamboo ( 42, 32, Color.BLUE ) );
                bamboos.add ( new Bamboo ( 56, 32, green ) );
                bamboos.add ( new Bamboo ( 28, 48, green ) );
                bamboos.add ( new Bamboo ( 42, 48, Color.BLUE ) );
                bamboos.add ( new Bamboo ( 56, 48, green ) );
                break;
            case 8:
                bamboos.add ( new Bamboo ( 28, 16, green ) );
                bamboos.add ( new Bamboo ( 42, 16, green ) );
                bamboos.add ( new Bamboo ( 56, 16, green ) );
                bamboos.add ( new Bamboo ( 35, 32, Color.RED ) );
                bamboos.add ( new Bamboo ( 49, 32, Color.RED ) );
                bamboos.add ( new Bamboo ( 28, 48, Color.BLUE ) );
                bamboos.add ( new Bamboo ( 42, 48, Color.BLUE ) );
                bamboos.add ( new Bamboo ( 56, 48, Color.BLUE ) );
                break;
            case 9:
                bamboos.add ( new Bamboo ( 28, 16, Color.RED ) );
                bamboos.add ( new Bamboo ( 42, 16, Color.BLUE ) );
                bamboos.add ( new Bamboo ( 56, 16, green ) );
                bamboos.add ( new Bamboo ( 28, 32, Color.RED ) );
                bamboos.add ( new Bamboo ( 42, 32, Color.BLUE ) );
                bamboos.add ( new Bamboo ( 56, 32, green ) );
                bamboos.add ( new Bamboo ( 28, 48, Color.RED ) );
                bamboos.add ( new Bamboo ( 42, 48, Color.BLUE ) );
                bamboos.add ( new Bamboo ( 56, 48, green ) );
                break;
            default:
                System.err.println ( "Bamboo Rank out of bounds: " + rank );
                break;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame ( );

        frame.setLayout ( new FlowLayout ( ) );
        frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        frame.setTitle ( "Bamboo Tiles" );

        frame.add ( new BambooTile ( 2 ) );
        frame.add ( new BambooTile ( 3 ) );
        frame.add ( new BambooTile ( 4 ) );
        frame.add ( new BambooTile ( 5 ) );
        frame.add ( new BambooTile ( 6 ) );
        frame.add ( new BambooTile ( 7 ) );
        frame.add ( new BambooTile ( 8 ) );
        frame.add ( new BambooTile ( 9 ) );

        frame.pack ( );
        frame.setVisible ( true );
    }
}
