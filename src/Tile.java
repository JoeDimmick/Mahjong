import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel {

    protected static Dimension size;
    protected static Polygon side;
    protected static Polygon boarder;
    protected static Color c1;
    protected static Color c2;
    protected static Color c3;

    static{
        size = new Dimension(72,72);

//        int[] x = {20,10,10,110,120,20};    for 100x100 pxl tile
//        int[] y = {0,10,110,110,100,100};

        int[] x = {12,6,6,66,72,12};
        int[] y = {0,6,66,66,60,60};
        int[] xBoarder = {6,0,0,60,66,6};
        int[] yBoarder = {6,12,72,72,66,66};
        c1 = new Color(0xffe4c4);
        c2 = new Color(0xfaf0e6);
        c3 = new Color(0x228B22);


        side = new Polygon(x,y,6);
        boarder = new Polygon(xBoarder,yBoarder,6);
    }
    public Tile(){
        setSize(size);
        setPreferredSize(new Dimension(73,73));
    }

    public boolean matches(Tile other) {
        if (this == other) return false;
        if (other == null) return false;
        return getClass ( ) == other.getClass ( );
    }

    public void paintComponent(Graphics g){
        //TODO
        super.paintComponent(g);
        g.drawRect(12,0,60,60);
        g.drawPolygon(side);
        Graphics2D graphics2D = (Graphics2D)g;
        GradientPaint gradientPaint = new GradientPaint(12,60, c2, 72, 0, c1, true);
        graphics2D.setPaint(gradientPaint);
        graphics2D.setPaint(c3);
        graphics2D.fillPolygon(boarder);

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
