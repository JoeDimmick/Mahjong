import java.awt.*;

abstract public class PictureTile extends Tile {
    private String name;

    public PictureTile(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public void paintComponent(Graphics g){
        //TODO
    }

}

