/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testclient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import stateless.TestEJBRemote;
/**
 *
 * @author alfred.wong
 */
public class Main {

    private static final String EJB_JNDI_NAME = "stateless.TestEJBRemote";
    //private static final String BUNDLE_CONFIG_CLASSPATH_PROPS = "/testclient/jndi.properties";
    private static TestEJBRemote testEJB = getEjbReference();
    
    public static TestEJBRemote getEjbReference(){
        TestEJBRemote ll = null;
        try{
            //Properties props = getConfigurationProps();
            //InitialContext ctx = new InitialContext(props);
            InitialContext ctx = new InitialContext();
            // for JBoss the JNDI name pattern takes the following format EAR name / The EJB Implementation Component / remove or local
            //ll = (TestEJBRemote)ctx.lookup(EJB_JNDI_NAME);
            ll = (TestEJBRemote)ctx.lookup("TestEJBBean/remote");
            System.out.println(ll.toString());
        }catch(NamingException nex){
            nex.printStackTrace();
        }finally{
            return ll;
        }
        
    }
    
//    private static final Properties getConfigurationProps(){
//        Properties props = new Properties();
//        InputStream is = Main.class.getResourceAsStream(BUNDLE_CONFIG_CLASSPATH_PROPS);
//        try{
//            props.load(is);
//        }catch(IOException e){
//            e.printStackTrace();
//        }finally{
//            return props;
//        }
//    }

    public static void main(String[] args) {
        System.out.println(testEJB.getMessage());
    }

}
