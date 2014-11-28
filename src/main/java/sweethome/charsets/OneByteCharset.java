package sweethome.charsets;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;

public abstract class OneByteCharset extends Charset {
    public final static int NOT_FOUND = -1;

    private int[] byteToChar;
    private int[][] charToByte;

    protected OneByteCharset(String canonicalName, String[] aliases,
                             final int[] byteToChar, final int[][] charToByte) {
        super(canonicalName, aliases);
        this.byteToChar = byteToChar;
        this.charToByte = charToByte;
    }

    @Override
    public boolean contains(Charset cs) {
        return this.getClass().isInstance(cs);
    }

    @Override
    public CharsetDecoder newDecoder() {
        return new Decoder(this);
    }

    @Override
    public CharsetEncoder newEncoder() {
        return new Encoder(this);
    }

    private class Encoder extends CharsetEncoder {

        protected Encoder(Charset cs) {
            super(cs, 1, 1);
        }

        @Override
        protected CoderResult encodeLoop(CharBuffer in, ByteBuffer out) {
            int b, c;
            int[][] lookup = charToByte;
            int[] table;
            int remaining = in.remaining();
            while (remaining-- > 0) {
                if (out.remaining() < 1)
                    return CoderResult.OVERFLOW;
                c = in.get();
                table = lookup[c >>> 8];
                b =  table == null ? NOT_FOUND : table[c & 0xFF];
                if (b == NOT_FOUND) {
                    in.position(in.position() - 1);
                    return CoderResult.unmappableForLength(1);
                }
                out.put((byte)(b & 0xFF));
            }
            return CoderResult.UNDERFLOW;
        }

    }

    private class Decoder extends CharsetDecoder {

        protected Decoder(Charset cs) {
            super(cs, 1, 1);
        }

        @Override
        protected CoderResult decodeLoop(ByteBuffer in, CharBuffer out) {
            int c;
            int[] lookup = byteToChar;
            int remaining = in.remaining();
            while (remaining-- > 0) {
                if (out.remaining() < 1)
                    return CoderResult.OVERFLOW;
                c = lookup[in.get() & 0xFF];
                if (c == NOT_FOUND) {
                    in.position(in.position() - 1);
                    return CoderResult.malformedForLength(1);
                }
                out.put((char)c);
            }
            return CoderResult.UNDERFLOW;
        }
    }

}
