import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel {

    protected static Dimension size;
    protected static Polygon side;
    protected static Polygon boarder;
    protected static Color ivory;
    protected static Color offWhite;
    protected static Color ltGreen;
    protected static Color drkGreen;
    protected static GradientPaint gpRect;
    protected static GradientPaint gpSide;
    protected static GradientPaint gpBoarder;
    protected static Font font;

    static{

        size = new Dimension(72,72);

        int[] x = {12,6,6,66,72,12};
        int[] y = {0,6,66,66,60,60};
        int[] xBoarder = {6,0,0,60,66,6};
        int[] yBoarder = {6,12,72,72,66,66};

        ivory = new Color(0xEED8AE);
        offWhite = new Color(0xfaf0e6);
        ltGreen = new Color(0x90EE90);
        drkGreen = new Color(0x228B22);

        side = new Polygon(x,y,6);
        boarder = new Polygon(xBoarder,yBoarder,6);

        gpRect = new GradientPaint(72,60, offWhite, 12, 0, ivory );
        gpSide = new GradientPaint(66,66, offWhite,6,66, ivory );
        gpBoarder = new GradientPaint(6,66, ltGreen,6,6, drkGreen );

    }
    public Tile(){

        setPreferredSize(size);

    }

    public boolean matches(Tile other) {

        if (this == other) return false;
        if (other == null) return false;
        return getClass ( ) == other.getClass ( );

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setPaint(gpRect);
        g.fillRect(12,0,60,60);
        graphics2D.setPaint(gpSide);
        graphics2D.fillPolygon(side);
        graphics2D.setPaint(gpBoarder);
        graphics2D.fillPolygon(boarder);
        g.setColor(Color.BLACK);
        g.drawRect(12,0,60,60);
        g.drawPolygon(side);
        g.drawPolygon(boarder);
        g.drawLine(12,60,0,72);

    }

    public static void main(String[] args) {

        JFrame	frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tile");
        frame.setSize(72,72);

        frame.add(new Tile());

        frame.pack();
        frame.setVisible(true);

    }

}//Tile
