package converter.client;

import converter.ejb.Converter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author alfred.wong
 */
public class ConverterClient {

/*CASE: lookup using @EJB  [javaee5 tut]DUNWORKS start*/
//    @EJB
//    private static Converter converter;
/*CASE: lookup using @EJB end*/

/**/

/**/

    
    private Converter converter;

    public ConverterClient(String[] args) {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("src/java/converter/client/jndi.properties"));
            InitialContext ctx = new InitialContext(props);
            /**pass a .properties file as a parameter to the InitialContext because
             * client machine may have a webserver running - see wiki.netbeans:
             * http://wiki.netbeans.org/CreatingEJB3UsingNetbeansAndGlassfish  */
            converter = (Converter) ctx.lookup("converter.ejb.Converter"); // must add 'import converter.ejb.Converter;'

        } catch (NamingException nex) {
            nex.printStackTrace();
        } catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ConverterClient client = new ConverterClient(args);
        client.doConversion();
    }

    public void doConversion() {
        try {
            BigDecimal param = new BigDecimal("100.00");
            BigDecimal yenAmount = converter.dollarToYen(param);

            System.out.println("$" + param + " is " + yenAmount + " Yen.");

            BigDecimal euroAmount = converter.yenToEuro(yenAmount);
            System.out.println(yenAmount + " Yen is " + euroAmount + " Euro.");

            System.exit(0);
        } catch (Exception ex) {
            System.err.println("Caught an unexpected exception!");
            ex.printStackTrace();
        }
    }
}
