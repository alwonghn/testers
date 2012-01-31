/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import dao.BookingDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jb.BookingBean;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author alfred.wong
 */
public class CollectionsListIteratorGenericCustomComparableObjAddRemove {


    public static ArrayList<BookingBean> generateBookings(ArrayList<BookingBean> insBkgBnList, ArrayList<BookingBean> dbBkgBnList) throws SQLException {
        BookingDao bkDao = new BookingDao();
        ArrayList<BookingBean> insertedDbBkgBnList = bkDao.insertBookings(insBkgBnList, dbBkgBnList);
        return insertedDbBkgBnList;
    }
    
    
    public static void printTheList(ArrayList<BookingBean> agenList){
        for(BookingBean bkgBn: agenList){
            System.out.println(bkgBn.toString());   // BookingBean has a custom toString method
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // make the db arraylist
        ArrayList<BookingBean> dbBkgBnList = new ArrayList<BookingBean>();
        // make the ins arraylist
        ArrayList<BookingBean> insBkgBnList = new ArrayList<BookingBean>();


        // make the 2bInsertedBean #19:
        //BookingBean bkg19Bn = new BookingBean(java.sql.Timestamp.valueOf("2011-11-06 00:00:00"));
        BookingBean bkg19Bn = new BookingBean(java.sql.Timestamp.valueOf("2011-10-29 00:00:00"));
//        BookingBean bkg19Bn = new BookingBean(java.sql.Timestamp.valueOf("2011-11-13 00:00:00"));
        bkg19Bn.setBean_name("19");

        // add it to the ins arraylist:
        insBkgBnList.add(bkg19Bn);

        // make the before bean #14:
        BookingBean bkg14Bn = new BookingBean(java.sql.Timestamp.valueOf("2011-10-31 00:00:00"));
        bkg14Bn.setBean_name("14");
        bkg14Bn.setEnd_date(java.sql.Timestamp.valueOf("2011-11-06 00:00:00"));
        dbBkgBnList.add(bkg14Bn);

        // make the after bean #15:
        BookingBean bkg15Bn = new BookingBean(java.sql.Timestamp.valueOf("2011-11-07 00:00:00"));
        bkg15Bn.setBean_name("15");
        bkg15Bn.setEnd_date(java.sql.Timestamp.valueOf("2011-11-13 00:00:00"));
        dbBkgBnList.add(bkg15Bn);

        // make other beans
        BookingBean bkg12Bn = new BookingBean(java.sql.Timestamp.valueOf("2011-10-28 00:00:00"));
        bkg12Bn.setBean_name("12");
        bkg12Bn.setEnd_date(java.sql.Timestamp.valueOf("2011-10-30 00:00:00"));
        dbBkgBnList.add(bkg12Bn);

        // make other beans
        BookingBean bkg16Bn = new BookingBean(java.sql.Timestamp.valueOf("2011-11-14 00:00:00"));
        bkg16Bn.setBean_name("16");
        bkg16Bn.setEnd_date(java.sql.Timestamp.valueOf("2011-11-18 00:00:00"));
        dbBkgBnList.add(bkg16Bn);
        
        //test
        System.out.println("Printout of db list b4  sort ");
        printTheList(dbBkgBnList);
//
//        //test
//        Collections.sort(dbBkgBnList);  // BookingBean implements comparable
//        System.out.println("Printout of db list after sort ");
//        printTheList(dbBkgBnList);        
        
        try {
            ArrayList<BookingBean> insertedDbBkgBnList = generateBookings(insBkgBnList, dbBkgBnList); 
            System.out.println("Printout of db list after insertion ");
            printTheList(insertedDbBkgBnList); 
        } catch (SQLException ex) {
            Logger.getLogger(CollectionsListIteratorGenericCustomComparableObjAddRemove.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
        
    }

}
