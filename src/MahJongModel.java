import javafx.geometry.Point2D;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MahJongModel {
    private int row = 8;
    private int col = 14;
    private int layer = 4;
    private MahJongBoard board;
    protected Tile[][][] tiles = new Tile[row+1][col+1][layer+1];
    private TileDeck deck = new TileDeck();

    public  MahJongModel(MahJongBoard board){

        this.board = board;
        deck.shuffle();

        //top layer just under the top tile
        for(int i = 3; i < 5; i++){
            for(int j = 6; j < 8 ; j++){
                    positionTile(deck.deal(), i, j, 3);
            }
        }

        for(int i = 2; i < 6; i++){
            for(int j = 5; j < 9 ; j++){
                positionTile(deck.deal(), i, j, 2);
            }
        }

        for(int i = 1; i < 7; i++){
            for(int j = 4; j < 10 ; j++){
                positionTile(deck.deal(), i, j, 1);
            }
        }

        for(int i = 0; i < 8; i++){
            for(int j = 3; j < 11 ; j++){
                positionTile(deck.deal(), i, j, 0);
            }
        }


        //top row
        positionTile(deck.deal(), 0, 1,0);
        positionTile(deck.deal(), 0, 2,0);
        positionTile(deck.deal(), 0, 11,0);
        positionTile(deck.deal(), 0, 12,0);

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

        positionTile(deck.deal(),5,2,0);
        positionTile(deck.deal(),5,11,0);

        positionTile(deck.deal(), 7, 1,0);
        positionTile(deck.deal(), 7, 2,0);
        positionTile(deck.deal(), 7, 11,0);
        positionTile(deck.deal(), 7, 12,0);

        //row 8 is the special case tiles on the right and left
        positionSpecialTile(deck.deal(),8,0,0);
        positionSpecialTile(deck.deal(),8,13,0);
        positionSpecialTile(deck.deal(),8,14,0);

        //top tile special case tile
        positionTopTile(deck.deal(),0,0,4);
    }

    private void positionTile(Tile t, int row, int col, int layer){
        int x = ( (col * (t.getWidth ()-12) + layer * 12) + 30);
        int y = ( (row * (t.getHeight ()-12) - layer * 12) + 30);
        //int offset= ;
        tiles[row][col][layer] = t;
        t.setXPos ( row );
        t.setXPos ( col );
        t.setZPos ( layer );
        t.setLocation ( x, y );
    }

    private void positionTopTile(Tile t, int row, int col, int layer){
        int x = ( ((7 * (t.getWidth ()-12)) + 20) + 30 );
        int y = ( ((2 * (t.getHeight ()-12)) + (layer * 12)) + 30);
        tiles[row][col][layer] = t;
        t.setXPos ( row );
        t.setXPos ( col );
        t.setZPos ( layer );
        t.setLocation(x,y);
    }

    private void positionSpecialTile(Tile t, int row, int col, int layer){
        int x = ( (col * (t.getWidth ()-12) + layer * 12) + 30);
        int y = ( (4 * (t.getHeight ()-12)) + layer * 12);
        tiles[row][col][layer] = t;
        t.setXPos ( row );
        t.setXPos ( col );
        t.setZPos ( layer );
        t.setLocation(x,y);
    }

//    The x, y, and z variables appearing in the method are the location of the tile in a logical,
//    3D data structure (the model or MahJongModel in the Lab 6 UML diagram).
//    The constant values, 0, 14, and 4, depend on how you organize your tiles.
//    My implementation assumes that the bottom (irregular) layer is labeled as layer 0,
//    which means that the top (single tile) layer is number 4.
//    This method also assumes that the 3D structure has its origin (0,0) in the upper left-hand corner. -Delroy
    public boolean isTileOpen(Tile t){
        int x = t.getXPos ();
        int y = t.getYPos ();
        int z = t.getZPos ();
        boolean open = false;

        System.out.printf("Tile : %s \n" +
                "Tile x position %d\n" +
                "Tile y position %d \n" +
                "Tile z position %d\n", t.toString (), t.getXPos (),t.getYPos (), t.getZPos ());

//        if(x == 0||x == 14 || z == 4) open = true;
//        if(tiles[x][y][z+1] == null &&
//                (tiles[x - 1][ y][ z] == null || tiles[x + 1][ y][ z] == null)){
//                    open = true;
//        }

        return open;

//        if (x == 0 || x == 14 || z == 4) return true;
//
//        return tiles[x][y][z + 1] == null &&
//                (tiles[x - 1][ y][ z] == null || tiles[x + 1][ y][ z] == null);
    }

    public Tile getTile(int row, int col, int layer){
        return tiles[row][col][layer];
    }

    public Tile test(){
        return deck.deal();
    }
    
}
