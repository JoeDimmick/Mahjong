import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MahJongModel {

    private MahJongBoard board;
    protected Tile[][][] tiles = new Tile[9][13][5]; //new Tile [#rows][#cols][#layers]
    TileDeck deck = new TileDeck();

    public  MahJongModel(MahJongBoard board){
        int x = 7;
        int y = 10;
        int z = 2;
        this.board = board;
        for(int i = 0; i < x ; i++){ //rows
            for(int j = 0; j < y ; j++){//columns
                for(int k = 0; k < z; k++){//layer
                    positionTile(deck.deal(), i, j, k);
                }
            }
        }
    }
    
    public void positionTile(Tile t, int row, int col, int layer){
        int x = ( col * (t.getWidth ()-12) + layer * 12  );
        int y = ( row * (t.getHeight ()-12) + layer * 12 );
        //int offset= ;
        tiles[row][col][layer] = t;
        t.setXPos ( row );
        t.setXPos ( col );
        t.setZPos ( layer );
        t.setLocation ( x, y );
    }

//    The x, y, and z variables appearing in the method are the location of the tile in a logical,
//    3D data structure (the model or MahJongModel in the Lab 6 UML diagram).
//    The constant values, 0, 14, and 4, depend on how you organize your tiles.
//    My implementation assumes that the bottom (irregular) layer is labeled as layer 0,
//    which means that the top (single tile) layer is number 4.
//    This method also assumes that the 3D structure has its origin (0,0) in the upper left-hand corner. -Delroy
//    public boolean isTileOpen(Tile t){
//
//            if (x == 0 || x == 14 || z == 4)
//                return true;
//
//            return tiles[z + 1] == null &&
//                    (tiles[x - 1, y, z] == null || tiles[x + 1, y, z] == null);
//
//        }

    public Tile getTile(int row, int col, int layer){
        return tiles[row][col][layer];
    }
    
}
