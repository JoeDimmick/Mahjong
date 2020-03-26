import java.awt.*;

public class WhiteDragonTile extends Tile {

    public WhiteDragonTile(){
        setToolTipText ( toString () );
    }

    public String toString() {
        return "White Dragon";
    }

    public void paintComponent(Graphics g){
        super.paintComponent ( g );
        setWhiteDragon(g);
    }

    private void setWhiteDragon(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRect(18, 6, 48, 48);
        g.drawRect( 24, 12, 36, 36);
        g.setColor(Color.BLUE);
        g.drawRect(18, 6, 48, 48);
        g.drawRect( 24, 12, 36, 36);
        g.fillRect ( 18, 7, 8, 6 );//top
        g.fillRect ( 34, 7, 8, 6 );
        g.fillRect ( 50, 7, 8, 6 );
        g.fillRect (60, 12, 6, 8);//right side
        g.fillRect ( 60,  26, 6, 8);
        g.fillRect ( 60, 42, 6, 8 );
        g.fillRect ( 18, 48, 8, 6 );//bottom
        g.fillRect ( 34, 48, 8, 6 );
        g.fillRect ( 50, 48, 8, 6 );
        g.fillRect (18, 18, 6, 8);//left side
        g.fillRect ( 18,  34, 6, 8);
    }

}
