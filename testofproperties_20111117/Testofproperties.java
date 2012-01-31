package com.comfortdelgro.avms;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 *
 * @author alfred.wong
 */
public class Testofproperties {

    public static void main( String[] args )
    {
    	Properties prop = new Properties();

    	try {
               //load a properties file
    		prop.load(new FileInputStream("db.properties"));

               //get the property value and print it out
                System.out.println(prop.getProperty("dbUserid"));
    		System.out.println(prop.getProperty("dbPassword"));
    		System.out.println(prop.getProperty("dbUrl"));

    	} catch (IOException ex) {
    		ex.printStackTrace();
        }

    }
}