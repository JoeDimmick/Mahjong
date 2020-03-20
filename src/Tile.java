abstract public class Tile {
    public boolean matches(Tile other) {
        if (this == other) return false;
        if (other == null) return false;
        return getClass ( ) == other.getClass ( );
    }
}
