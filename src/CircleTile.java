import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CircleTile extends RankTile {

    protected ArrayList<Circle> circles;
    protected Pancake p = new Pancake ();
    protected Color green = new Color(0x00CD00);

    public CircleTile(int rank) {

        super ( rank );
        setToolTipText ( toString () );
        setCircles();

    }

    public String toString() {
        return "Circle " + rank;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(rank == 1){p.draw ( g );}
        for (Circle c : circles)
            if (c != null)
                c.draw(g);

    }

    public class Circle {
        private int x;
        private int y;
        private int dSize;
        private Color color;

        public Circle (int x, int y, int dSize, Color color){
            this.x = x;
            this.y = y;
            this.dSize = dSize;
            this.color = color;
        }

        public void draw(Graphics g) {

            g.setColor ( color );
            g.fillOval ( x, y, dSize, dSize );
            g.setColor ( Color.white );
            g.fillOval( x+(dSize/4), y+(dSize/4), dSize/2, dSize/2 );

        }

    }//Circle
    public class Pancake{

        public Pancake(){
        }

        public void draw(Graphics g){
            g.setColor ( green );
            g.fillOval ( 17, 5, 50, 50);
        }
    }
    private void setCircles() {
        // face of tile face is 60x60 each layer is 6px, each tile is 72x72;
        // center of the tile face would be (30 + 12) = 42 width
        // center of the tile face would be 30 height
        circles = new ArrayList ( rank );
        switch (rank) {
            case 1:
                Pancake pan = new Pancake ();
                circles.add(new Circle(34,22,16, Color.RED));
                circles.add(new Circle(40, 10, 4, Color.WHITE));//12 o'clock
                circles.add(new Circle(48, 12, 4, Color.WHITE));
                circles.add(new Circle(54, 18, 4, Color.WHITE));
                circles.add(new Circle(58, 28, 4, Color.WHITE));//3 o'clock
                circles.add(new Circle(54, 38, 4, Color.WHITE));
                circles.add(new Circle(48, 44, 4, Color.WHITE));
                circles.add(new Circle(40, 46, 4, Color.WHITE));//6
                circles.add(new Circle(30, 44, 4, Color.WHITE));
                circles.add(new Circle(24, 38, 4, Color.WHITE));
                circles.add(new Circle(20, 28, 4, Color.WHITE));//9
                circles.add(new Circle(30, 12, 4, Color.WHITE));
                circles.add(new Circle(24, 18, 4, Color.WHITE));
                break;
            case 2:
                circles.add ( new Circle ( 32, 3, 26, green ) );
                circles.add ( new Circle ( 32, 30, 26, Color.RED ) );
                break;
            case 3:
                circles.add ( new Circle ( 14, 2, 20, Color.BLUE ) );
                circles.add ( new Circle ( 32, 20, 20, Color.RED ) );
                circles.add ( new Circle ( 50, 38, 20, green ) );
                break;
            case 4:
                circles.add ( new Circle ( 16, 3, 26, Color.BLUE ) );
                circles.add ( new Circle ( 16, 30, 26, green ) );
                circles.add ( new Circle ( 42, 3, 26, green ) );
                circles.add ( new Circle ( 42, 30, 26, Color.BLUE ) );
                break;
            case 5:
                circles.add ( new Circle ( 14, 2, 18, Color.BLUE ) );
                circles.add ( new Circle ( 32, 20, 18, Color.RED ) );
                circles.add ( new Circle ( 50, 38, 18, Color.BLUE ) );
                circles.add ( new Circle ( 14, 38, 18, green ) );
                circles.add ( new Circle ( 50, 2, 18, green ) );
                break;
            case 6:
                circles.add ( new Circle ( 22, 2, 18, green ) );
                circles.add ( new Circle ( 22, 20, 18, Color.RED ) );
                circles.add ( new Circle ( 22, 38, 18, Color.RED ) );
                circles.add ( new Circle ( 44, 2, 18, green ) );
                circles.add ( new Circle ( 44, 20, 18, Color.RED ) );
                circles.add ( new Circle ( 44, 38, 18, Color.RED ) );
                break;
            case 7:
                circles.add ( new Circle ( 15, 4, 14, green ) );
                circles.add ( new Circle ( 35, 6, 14, green) );
                circles.add ( new Circle ( 55, 10, 14, green ) );
                circles.add ( new Circle ( 25, 25, 14, Color.RED ) );
                circles.add ( new Circle ( 25, 40, 14, Color.RED ) );
                circles.add ( new Circle ( 45, 25, 14, Color.RED ) );
                circles.add ( new Circle ( 45, 40, 14, Color.RED ) );
                break;
            case 8 :
                circles.add ( new Circle ( 22, 2, 12, Color.BLUE ) );
                circles.add ( new Circle ( 22, 16, 12, Color.BLUE ) );
                circles.add ( new Circle ( 22, 32, 12, Color.BLUE ) );
                circles.add ( new Circle ( 22, 46, 12, Color.BLUE ) );
                circles.add ( new Circle ( 50, 2, 12, Color.BLUE ) );
                circles.add ( new Circle ( 50, 16, 12, Color.BLUE ) );
                circles.add ( new Circle ( 50, 32, 12, Color.BLUE ) );
                circles.add ( new Circle ( 50, 46, 12, Color.BLUE ) );
                break;
            case 9:
                circles.add ( new Circle ( 15, 4, 14, green ) );
                circles.add ( new Circle ( 35, 4, 14, green) );
                circles.add ( new Circle ( 55, 4, 14, green ) );
                circles.add ( new Circle ( 15, 24, 14, Color.RED ) );
                circles.add ( new Circle ( 35, 24, 14, Color.RED) );
                circles.add ( new Circle ( 55, 24, 14, Color.RED ) );
                circles.add ( new Circle ( 15, 44, 14, Color.BLUE ) );
                circles.add ( new Circle ( 35, 44, 14, Color.BLUE) );
                circles.add ( new Circle ( 55, 44, 14, Color.BLUE ) );
                break;
            default:
                System.err.println ( "Circle Rank out of bounds: " + rank );
                break;
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Circle Tiles");

        frame.add(new CircleTile(1));
        frame.add(new CircleTile(2));
        frame.add(new CircleTile(3));
        frame.add(new CircleTile(4));
        frame.add(new CircleTile(5));
        frame.add(new CircleTile(6));
        frame.add(new CircleTile(7));
        frame.add(new CircleTile(8));
        frame.add(new CircleTile(9));

        frame.pack();
        frame.setVisible(true);

    }//main

}//CircleTile

