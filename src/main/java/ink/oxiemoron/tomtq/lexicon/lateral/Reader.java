package ink.oxiemoron.tomtq.lexicon.lateral;

import java.io.IOException;

public class Reader {

    private final char[] source2;
    private int position = -1;

    public Reader(String source2) {

        this.source2 = source2.toCharArray();

    }

    public int getPosition () {
        return position;
    }

    public char read() throws IOException { // queue p2 ending song ♪  ♫   ♪

        position++; // which is not same as ++position, that day i learned haha

        if (position >= source2.length) {
            throw new IOException("Grow up.");
        }

        return source2[position];

    }

    // s02 e06

}
