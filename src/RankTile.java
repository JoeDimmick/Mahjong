abstract public class RankTile extends Tile {
    protected int rank;

    public RankTile(int rank) {
        this.rank = rank;
    }

    public boolean matches(Tile other) {
        //System.out.printf(" " + this.getClass().getSuperclass () + " " + other.getClass().getSuperclass ());
        //System.out.printf("\nRank Tile %s : %s " + super.matches ( other ), this.toString (), other.toString ());
        return super.matches ( other ) && this.rank == ((RankTile) other).rank;
    }
}

