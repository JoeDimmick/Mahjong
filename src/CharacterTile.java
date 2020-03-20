import java.util.HashMap;

public class CharacterTile extends Tile {
    private static HashMap<Character, String> labels = new HashMap<> ( );
    protected static HashMap<Character, String> EnglishToChinese = new HashMap<> ( );
    protected char symbol;

    public CharacterTile(char symbol) {
        this.symbol = symbol;
    }

    public boolean matches(Tile other) {
        return super.matches ( other ) && symbol == ((CharacterTile) other).symbol;
    }

    public String toString() {
        return labels.get ( symbol );
    }

    static {
        labels.put ( 'C', "Red Dragon" );
        labels.put ( 'F', "Green Dragon" );
        labels.put ( 'N', "North Wind" );
        labels.put ( 'E', "East Wind" );
        labels.put ( 'W', "West Wind" );
        labels.put ( 'S', "South Wind" );
        for (char c = '1'; c <= '9'; c++) labels.put ( c, "Character " + c );
    }

    static {
        EnglishToChinese.put ( '1', "\u4e00" );
        EnglishToChinese.put ( '2', "\u4E8C" );
        EnglishToChinese.put ( '3', "\u4E09" );
        EnglishToChinese.put ( '4', "\u56DB" );
        EnglishToChinese.put ( '5', "\u4E94" );
        EnglishToChinese.put ( '6', "\u516D" );
        EnglishToChinese.put ( '7', "\u4E03" );
        EnglishToChinese.put ( '8', "\u516B" );
        EnglishToChinese.put ( '9', "\u4E5D" );
        EnglishToChinese.put ( 'N', "\u5317" );
        EnglishToChinese.put ( 'E', "\u6771" );
        EnglishToChinese.put ( 'S', "\u5357" );
        EnglishToChinese.put ( 'W', "\u897F" );
        EnglishToChinese.put ( 'C', "\u4E2D" );
        EnglishToChinese.put ( 'F', "\u767C" );
    }

    public String toChinese() {
        return EnglishToChinese.get ( symbol );
    }
}
