import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class CharacterTile extends Tile {

    private static HashMap<Character, String> labels = new HashMap<> ( );
    protected static HashMap<Character, String> EnglishToChinese = new HashMap<> ( );
    protected char symbol;

    public CharacterTile(char symbol) {
        this.symbol = symbol;
        setToolTipText(toString());
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
        labels.put ( 'w', "Wan" );
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
        EnglishToChinese.put ( 'w', "\u842C" );
    }

    public String toChinese() {
        return EnglishToChinese.get ( symbol );
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        g.setColor(Color.RED);
        font = g.getFont();
        g.setFont(font.deriveFont(10f));

        g.drawString(String.valueOf(symbol), size.width-12, 12 );
        if (symbol == 'C') {
            g.setFont(font.deriveFont(40f));
            g.drawString(EnglishToChinese.get(symbol), 22, 45);

        } else if (String.valueOf(symbol).matches("[1-9]")) {
            g.setFont(font.deriveFont(20f));
            g.drawString(String.valueOf('\u842C'), size.width / 2, size.height - 25);
            g.setColor(Color.BLACK);
            g.drawString(EnglishToChinese.get(symbol), size.width / 2, 25);

        } else if (symbol == 'F'){
            g.setColor(c4);
            g.setFont(font.deriveFont(40f));
            g.drawString(EnglishToChinese.get(symbol), 22, 45);
        } else {
            g.setColor(Color.BLACK);
            g.setFont(font.deriveFont(40f));
            g.drawString(EnglishToChinese.get(symbol), 22, 45);
        }

    }

    public static void main(String[] args)
    {
        JFrame		frame = new JFrame();
        JPanel		tiles = new JPanel();
        JScrollPane	scroller = new JScrollPane(tiles);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Character Tiles");
        frame.add(scroller);

        // Try something like this if your tiles don't fit on the screen.
        // Replace "tile width" and "tile height" with your values.
        //scroller.setPreferredSize(new Dimension(8 * tile width, 40 + tile height));

        tiles.add(new CharacterTile('1'));
        tiles.add(new CharacterTile('2'));
        tiles.add(new CharacterTile('3'));
        tiles.add(new CharacterTile('4'));
        tiles.add(new CharacterTile('5'));
        tiles.add(new CharacterTile('6'));
        tiles.add(new CharacterTile('7'));
        tiles.add(new CharacterTile('8'));
        tiles.add(new CharacterTile('9'));
        tiles.add(new CharacterTile('N'));
        tiles.add(new CharacterTile('E'));
        tiles.add(new CharacterTile('W'));
        tiles.add(new CharacterTile('S'));
        tiles.add(new CharacterTile('C'));
        tiles.add(new CharacterTile('F'));

        frame.pack();
        frame.setVisible(true);
    }

}
