package sweethome.charsets;

import java.nio.charset.Charset;
import java.util.*;

public class CharsetProvider extends java.nio.charset.spi.CharsetProvider {

    static Map name2charset;
    static Collection charsets;

    /**
     * Retrieves a charset for the given charset name. </p>
     *
     * @param  charsetName
     *         The name of the requested charset; may be either
     *         a canonical name or an alias
     *
     * @return  A charset object for the named charset,
     *          or <tt>null</tt> if the named charset
     *          is not supported by this provider
     */
    public Charset charsetForName(String charsetName) {
        if (name2charset == null)
            init();

        // get charset instance for given name (case insensitive)
        Charset c = (Charset)name2charset.get(charsetName.toLowerCase());
        if (c != null) {
            try {
                return (Charset)c.getClass().newInstance();
            } catch (Exception ignore) {
                // if we can't create an instance, we don't
            }
        }
        return null;
    }

    /**
     * Creates an iterator that iterates over the charsets supported by this
     * provider.  This method is used in the implementation of the {@link
     * java.nio.charset.Charset#availableCharsets Charset.availableCharsets}
     * method. </p>
     *
     * @return  The new iterator
     */
    public Iterator charsets() {
        if (charsets == null)
            init();

        return charsets.iterator();
    }

    /**
     * Initializes this charset provider's data.
     */
    void init() {
        // prepare supported charsets
        Charset[] cs = new Charset[] { new WH1602B_YYH_CTK_Charset() };

        // initialize charset collection
        charsets = Collections.unmodifiableCollection(Arrays.asList(cs));

        // initialize name to charset map
        Map n2c = new HashMap();
        for (int i = 0; i < cs.length; i++) {
            Charset c = cs[i];
            n2c.put(c.name().toLowerCase(), c);
            for (Iterator a = c.aliases().iterator(); a.hasNext();)
                n2c.put(((String)a.next()).toLowerCase(), c);
        }
        name2charset = n2c;
    }

}
