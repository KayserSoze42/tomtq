package ink.oxiemoron.tomtq.lexicon.lateral;

import java.util.HashMap;

public class Symbol {

    private Tokens type; // Haven't really used 'em
    private String body; //                                so not rly sure here, hah

    private static HashMap<String, Symbol> symbols = new HashMap<String, Symbol>();

    private Symbol(Tokens type, String body) {
        this.type = type;
        this.body = body;
    }

    @Override
    public String toString() {
        return body;
    }

    public Tokens getType() {
        return type;
    }

    public Symbol augment(String body, Tokens type) { // hocusPokusy0.2.6

        Symbol symbol = symbols.get(body);//<-get-your-fresh-Java-memez-right-here-

        if (symbol == null) { // 1.7698594e+31 doge coins
            symbol = new Symbol(type, body);
            symbols.put(body, symbol);
        }
        return symbol;
    }

}
