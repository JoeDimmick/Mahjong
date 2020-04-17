public class MahJongModel {

    private MahJongBoard board;
//    int x;
//    int y;
//    int z;
    //                     new Tile [#rows][#cols][#layers]
  // protected Tile[] tiles = new Tile;
    TileDeck deck = new TileDeck();

    public  MahJongModel(MahJongBoard board){
        this.board = board;

    }
    //mouselistener needs to be here somewhere tile.setMouseListener(this);
    public void positionTile(Tile t, int row, int col, int layer){
        //TODO
        deck.deal();
    }

//    The x, y, and z variables appearing in the method are the location of the tile in a logical,
//    3D data structure (the model or MahJongModel in the Lab 6 UML diagram).
//    The constant values, 0, 14, and 4, depend on how you organize your tiles.
//    My implementation assumes that the bottom (irregular) layer is labeled as layer 0,
//    which means that the top (single tile) layer is number 4.
//    This method also assumes that the 3D structure has its origin (0,0) in the upper left-hand corner. -Delroy
    public boolean isTileOpen(Tile t){

            if (x == 0 || x == 14 || z == 4)
                return true;

            return tiles[z + 1] == null &&
                    (tiles[x - 1, y, z] == null || tiles[x + 1, y, z] == null);

        }
    //                  int row, int col, int layer
    public Tile getTile(){
        //TODO

        return deck.deal();
    }
    
}
