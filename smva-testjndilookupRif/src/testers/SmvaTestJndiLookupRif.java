/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.smva.ejb.SMVASession;
/**
 *
 * @author alfred.wong
 */
public class SmvaTestJndiLookupRif {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
            properties.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
            properties.put("java.naming.provider.url", "jnp://localhost:1099");
            //properties.put("java.naming.provider.url", "localhost:1099");
            Context ctx = new InitialContext(properties);
            System.out.println("Got context");
            SMVASession rif = (SMVASession) ctx.lookup("smva/SMVASessionEJB/remote");
            //The jndi lookup string above is: "HelloWorld/HelloWorldBean/remote".
            //It consists of three parts:   target project(ear)name/ the bean name/ either remote or local indicator
            //Test is the name of application/project which contains the implementation of TestEJBBean.
            //TestEJBBean is the name of your EJB bean class which has the getMessage method.
            //remote indicates that you are looking a remote session bean.
            System.out.println(rif.getUserIDByNTLogin("alfred.wong"));

        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }
    }

}
