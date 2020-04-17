import javafx.geometry.Point2D;

import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MahJongModel {
    int row = 8;
    int col = 14;
    int layer = 4;
    private MahJongBoard board;
    protected Tile[][][] tiles = new Tile[row+1][col+1][layer+1];
    TileDeck deck = new TileDeck();

    public  MahJongModel(MahJongBoard board){

        this.board = board;

        for(int i = 1; i < row-2 ; i++){
            for(int j = 3; j < col-4 ; j++){
                for(int k = 1; k < layer-1; k++){
                    positionTile(deck.deal(), i, j, k);
                }
            }
        }

        //top and bottom row
        for(int i = 0; i < 12 ; i++){
            positionTile(deck.deal(),0,i,0);
            positionTile(deck.deal(),7,i,0);
        }

        positionTile(deck.deal(),2,2,0);
        positionTile(deck.deal(),2,11,0);

        positionTile(deck.deal(),3,1,0);
        positionTile(deck.deal(),3,2,0);
        positionTile(deck.deal(),3,11,0);
        positionTile(deck.deal(),3,12,0);

        positionTile(deck.deal(),4,1,0);
        positionTile(deck.deal(),4,2,0);
        positionTile(deck.deal(),4,11,0);
        positionTile(deck.deal(),4,12,0);

        positionTile(deck.deal(),2,2,0);
        positionTile(deck.deal(),2,11,0);

        positionTile(deck.deal(),8,0,0);
        positionTile(deck.deal(),8,13,0);
        positionTile(deck.deal(),8,14,0);

        //top tile
        positionTile(deck.deal(),0,0,4);
    }
    
    public void positionTile(Tile t, int row, int col, int layer){
        //int x = ( col * (t.getWidth ()-12) + layer * 12  );
        //int y = ( row * (t.getHeight ()-12) + layer * 12 );
        //int offset= ;
        tiles[row][col][layer] = t;
        t.setXPos ( row );
        t.setXPos ( col );
        t.setZPos ( layer );
        //t.setLocation ( x, y );
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
