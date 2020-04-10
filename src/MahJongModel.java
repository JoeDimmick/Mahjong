public class MahJongModel {

    private MahJongBoard board;
    //                     new Tile [#rows][#cols][#layers]
  // protected Tile[] tiles = new Tile;
    TileDeck deck = new TileDeck();
    public  MahJongModel(MahJongBoard board){
        this.board = board;
        //Tile test = new CharacterTile('5');

    }
    
    public void positionTile(Tile t, int row, int col, int layer){
        //TODO
        //deck.deal();
    }
    
    public boolean isTileOpen(Tile t){
        //An open tile does not have a tile on top or either its left or right.
        //TODO
        return true;
    }
    //                  int row, int col, int layer
    public Tile getTile(){
        //TODO

        return deck.deal();
    }
    
}
