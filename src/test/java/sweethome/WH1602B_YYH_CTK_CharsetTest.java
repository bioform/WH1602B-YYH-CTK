package sweethome;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class WH1602B_YYH_CTK_CharsetTest {
    @Test
    public void testEncodingRus(){
        String str = "АБВ";
        //Charset charset = new WH1602B_YYH_CTK_Charset()
        //byte[] bytes = str.getBytes(charset)
        //byte[] bytes = str.getBytes("WH1602B-YYH-CTK")

        try {
            byte[] bytes = str.getBytes("WH1602B-YYH-CTK");
            assertArrayEquals(bytes, new byte[]{65, -96, 66});
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
