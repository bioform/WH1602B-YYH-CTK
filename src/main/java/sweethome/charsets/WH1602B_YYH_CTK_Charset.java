package sweethome.charsets;

public class WH1602B_YYH_CTK_Charset extends OneByteCharset {

    static final String NAME = "WH1602B-YYH-CTK";

    static final String[] ALIASES = {};

    /**
     * Constructs an instance of the KOI8UCharset.
     */
    public WH1602B_YYH_CTK_Charset() {
        super(NAME, ALIASES, BYTE_TO_CHAR, CHAR_TO_BYTE);
    }

    static final int[] BYTE_TO_CHAR = {
            0x0000, 0x0001, 0x0002, 0x0003, 0x0004, 0x0005, 0x0006, 0x0007,
            0x0008, 0x0009, 0x000a, 0x000b, 0x000c, 0x000d, 0x000e, 0x000f,

            0x0010, 0x0011, 0x0012, 0x0013, 0x0014, 0x0015, 0x0016, 0x0017,
            0x0018, 0x0019, 0x001a, 0x001b, 0x001c, 0x001d, 0x001e, 0x001f,

            0x0020, 0x0021, 0x0022, 0x0023, 0x0024, 0x0025, 0x0026, 0x0027,
            0x0028, 0x0029, 0x002a, 0x002b, 0x002c, 0x002d, 0x002e, 0x002f,

            0x0030, 0x0031, 0x0032, 0x0033, 0x0034, 0x0035, 0x0036, 0x0037,
            0x0038, 0x0039, 0x003a, 0x003b, 0x003c, 0x003d, 0x003e, 0x003f,

            0x0040, 0x0041, 0x0042, 0x0043, 0x0044, 0x0045, 0x0046, 0x0047,
            0x0048, 0x0049, 0x004a, 0x004b, 0x004c, 0x004d, 0x004e, 0x004f,

            0x0050, 0x0051, 0x0052, 0x0053, 0x0054, 0x0055, 0x0056, 0x0057,
            0x0058, 0x0059, 0x005a, 0x005b, 0x005c, 0x005d, 0x005e, 0x005f,

            0x0060, 0x0061, 0x0062, 0x0063, 0x0064, 0x0065, 0x0066, 0x0067,
            0x0068, 0x0069, 0x006a, 0x006b, 0x006c, 0x006d, 0x006e, 0x006f,

            0x0070, 0x0071, 0x0072, 0x0073, 0x0074, 0x0075, 0x0076, 0x0077,
            0x0078, 0x0079, 0x007a, 0x007b, 0x007c, 0x007d, 0x007e, 0x007f,

            0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000,
            0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000,
            0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000,
            0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000,

            0x0411, 0x0413, 0x0401, 0x0416, 0x0417, 0x0418, 0x0419, 0x041B,
            0x041F, 0x0423, 0x0424, 0x0427, 0x0428, 0x042A, 0x042B, 0x042D,

            0x042E, 0x042F, 0x0431, 0x0432, 0x0433, 0x0451, 0x0436, 0x0437,
            0x0438, 0x0439, 0x043A, 0x043B, 0x043C, 0x043D, 0x043F, 0x0442,

            0x0447, 0x0448, 0x044A, 0x044B, 0x044C, 0x044D, 0x044E, 0x044F,
            0x00AB, 0x00BB, 0x201C, 0x201D, 0x0235, 0x00BF, 0x0192, 0x00A3,

            0x0000, 0x0000, 0x0000, 0x203C, 0x0000, 0x0000, 0x0000, 0x2160,
            0x2161, 0x2191, 0x2193, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000,

            0x0414, 0x0426, 0x0429, 0x0434, 0x0444, 0x0446, 0x0449, 0x2019,
            0x0308, 0x007E, 0x0450, 0x0000, 0x0133, 0x0000, 0x0000, 0x00B0,

            0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000,
            0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x00A7, 0x00B6, 0x2588,
    };

    /*
     * Absent the following characters:
     * АВЕКМНОРСТХ
     * аеорсух
     */
    static final int[][] CHAR_TO_BYTE = Utils.charToByteTable(BYTE_TO_CHAR);

}
