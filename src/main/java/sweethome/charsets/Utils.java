package sweethome.charsets;

import static sweethome.charsets.OneByteCharset.NOT_FOUND;
import java.util.Arrays;

public class Utils {
    public static int[][] charToByteTable(int[] chars) {
        int[][] highAndLowBytes = new int[256][];
        for (int i = 0; i < chars.length; i++)
            add(highAndLowBytes, chars[i], i);
        return highAndLowBytes;
    }

    private static int[][] add(int[][] highAndLowBytes, int c, int b) {
        int high = (c >>> 8) & 0xFF;
        int low = c & 0xFF;
        int[] lowByteRow = highAndLowBytes[high];

        if (lowByteRow == null) {
            lowByteRow = new int[256];
            Arrays.fill(lowByteRow, NOT_FOUND);
            highAndLowBytes[high] = lowByteRow;
        }
        lowByteRow[low] = b;

        return highAndLowBytes;
    }
}
