/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testclient;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;

import javax.naming.NamingException;
import stateless.TestEJBRemote;
import ejb.TestRemote;
/**
 *
 * @author a
 */
public class Main {

    /**
     * test of :    jndi lookup of ejb remote interface - on same (different can??) jvm
     */
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
            properties.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
            //properties.put("java.naming.provider.url", "jnp://localhost:1099");
            properties.put("java.naming.provider.url", "localhost:1099");
            Context ctx = new InitialContext(properties);
            System.out.println("Got context");

            //TestEJBRemote testEJB = (TestEJBRemote) ctx.lookup("Test/TestEJBBean/remote");
            TestRemote rif = (TestRemote) ctx.lookup("twebclientcallejbremoteejbifmtdnodb/TestBean/remote");

            //The jndi lookup string above is: "HelloWorld/HelloWorldBean/remote".
            //It consists of three parts:   target project(ear)name/ the bean name/ either remote or local indicator
            //Test is the name of application/project which contains the implementation of TestEJBBean.
            //TestEJBBean is the name of your EJB bean class which has the getMessage method.
            //remote indicates that you are looking a remote session bean.

            //System.out.println(testEJB.getMessage());
            System.out.println(rif.getMessage());

        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }

    }
}
