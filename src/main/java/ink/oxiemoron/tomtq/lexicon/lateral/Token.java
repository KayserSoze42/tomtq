package ink.oxiemoron.tomtq.lexicon.lateral;

public class Token {

    private Symbol symbol;

    private int left;
    private int right;

    public Token(int left, int right, Symbol symbol) {
        this.left = left;
        this.right = right;
        this.symbol = symbol;
    }

    @Override
    public String toString() {

        StringBuilder bob = new StringBuilder();
        bob
                .append(symbol)
                .append("[l: ")
                .append(left)
                .append(", r: ")
                .append(right)
                .append("]");

        // This gives me such "ezekiel 25:17" vibes, which further give me HolyC vibes
        // Jesus, take the wheel
        return bob.toString();
    }

    public Symbol getElement() {
        return symbol;
    }

    public int getLeft() {
        return this.left;
    }

    public int getRight() {
        return this.right;
    }

}
