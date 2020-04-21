import java.util.ArrayList;

public class MahJongModel {
    private int row = 8;
    private int col = 14;
    private int layer = 4;
    private MahJongBoard board;
    protected Tile[][][] tiles = new Tile[row+1][col+1][layer+1];
    private ArrayList<Tile> discardedT = new ArrayList<>();
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

        //System.out.println("MahJongModel()");
    }
    
    private void positionTile(Tile t, int row, int col, int layer){
        int x = ( (col * (t.getWidth ()-12) + layer * 12) + 30);
        int y = ( (row * (t.getHeight ()-12) - layer * 12) + 30);
        tiles[row][col][layer] = t;
        t.setLocation ( x, y );
        tiles[row][col][layer].setXYZ(row, col, layer);
    }

    private void positionTopTile(Tile t, int row, int col, int layer){
        int x = ( ((7 * (t.getWidth ()-12)) + 20) + 30 );
        int y = ( ((2 * (t.getHeight ()-12)) + (layer * 12)) + 30);
        tiles[row][col][layer] = t;
        t.setLocation(x,y);
        tiles[row][col][layer].setXYZ(row, col, layer);
    }

    private void positionSpecialTile(Tile t, int row, int col, int layer){
        int x = ( (col * (t.getWidth ()-12) + layer * 12) + 30);
        int y = ( (4 * (t.getHeight ()-12)) + layer * 12);
        tiles[row][col][layer] = t;
        t.setLocation(x,y);
        tiles[row][col][layer].setXYZ(row, col, layer);
    }

    public void discardTile(Tile t){
        tiles[t.getXPos()][t.getYPos()][t.getZPos()] = null;
        discardedT.add(t);
        // int x = (5 + (discardedT.get(0).getWidth()/2));
        //int y = (16 * (discardedT.get(0).getHeight()));;
//       System.out.printf("\ndiscardTiles() %d\n" +
//               "location %d : %d\n", discardedT.size(), t.getX(), t.getY());
    }

    public boolean isTileOpen(Tile t){
        int x = t.getXPos();
        int y = t.getYPos();
        int z = t.getZPos();

        if(y == 0 || y == 14 || z == 4) return true;
        if(z == 3 && (tiles[0][0][4] != null))return false;
        if(((x == 3 || x == 4) && y == 12) && tiles[8][13][0]!=null)return false;
        if((y == 1 && (x == 3 || x ==4)) && tiles [8][0][0]!=null)return false;
        if((x == 8 && y == 13) && tiles[8][14][0]!=null)return false;
        return tiles[x][y][z+1] == null &&
                (tiles [x][y - 1][z] == null || tiles[x][y+1][z] == null);
    }

    public Tile getTile(int row, int col, int layer){
        return tiles[row][col][layer];
    }

    public Tile getDiscardedTile(){
        int size = discardedT.size();
        int x = 10;
        int y = 1080;
        for(int i = 0; i < discardedT.size (); i++){
            discardedT.get ( i ).setLocation ( x, y );
        }
//        System.out.printf("\ngetDiscardedTile() %s\n" +
//                        "Location %d : %d ",
//                discardedT.get(size-1),
//                discardedT.get(size-1).getX(),
//                discardedT.get(size-1).getY());
        return discardedT.get(size-1);
    }

}
