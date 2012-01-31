/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import beans.BeanImplComparable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author alfred.wong
 */
public class ArraylistObjectsSyncStartEndDatesOfObjectsWithEachOther {

    public static ArrayList<BeanImplComparable> synStEdDtTBooking(ArrayList<BeanImplComparable> toBeSyncList) {
        for(int i=0; i<toBeSyncList.size(); i++){
            if(i>=1){
                if(!(toBeSyncList.get(i-1).getEnd_date().getTime()==(toBeSyncList.get(i).getStart_date().getTime()-86400000))){
                    toBeSyncList.get(i-1).setEnd_date(new Timestamp(toBeSyncList.get(i).getStart_date().getTime()-86400000));
                }
            }
        }
        return toBeSyncList;
    }

    public static void printDaList(ArrayList<BeanImplComparable> aList){
        for(BeanImplComparable b : aList){
            System.out.println(b);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<BeanImplComparable> toBeSyncList = new ArrayList<BeanImplComparable>();
        java.util.Date todayDt = new java.util.Date();

        // first on list bean 9     3Oct11~9Oct11
        java.sql.Timestamp bn9StTs = java.sql.Timestamp.valueOf("2011-10-03 00:00:00");
        java.sql.Timestamp bn9EtTs = java.sql.Timestamp.valueOf("2011-10-09 00:00:00");
        BeanImplComparable Bn9 = new BeanImplComparable("9", bn9StTs, bn9EtTs);
        toBeSyncList.add(Bn9);

        // preceding insert bean 14    30Oct11~6Nov11
        java.sql.Timestamp bn14StTs = java.sql.Timestamp.valueOf("2011-10-30 00:00:00");
        java.sql.Timestamp bn14EtTs = java.sql.Timestamp.valueOf("2011-11-06 00:00:00");
        BeanImplComparable Bn14 = new BeanImplComparable("14", bn14StTs, bn14EtTs);
        toBeSyncList.add(Bn14);

        // seceeding insert bean 15     7Nov11~13Nov11
        java.sql.Timestamp bn15StTs = java.sql.Timestamp.valueOf("2011-11-07 00:00:00");
        java.sql.Timestamp bn15EtTs = java.sql.Timestamp.valueOf("2011-11-13 00:00:00");
        BeanImplComparable Bn15 = new BeanImplComparable("15", bn15StTs, bn15EtTs);
        toBeSyncList.add(Bn15);

        // last on list bean 5    25Nov12~30Nov12
        java.sql.Timestamp bn5StTs = java.sql.Timestamp.valueOf("2012-11-25 00:00:00");
        java.sql.Timestamp bn5EtTs = java.sql.Timestamp.valueOf("2012-11-30 00:00:00");
        BeanImplComparable Bn5 = new BeanImplComparable("5", bn5StTs, bn5EtTs);
        toBeSyncList.add(Bn5);

        Collections.sort(toBeSyncList);

        System.out.println("list before sync : ");
        printDaList(toBeSyncList);
        
        ArrayList<BeanImplComparable> afSyncList = synStEdDtTBooking(toBeSyncList);
        System.out.println("list after sync : ");
        printDaList(afSyncList);
    }

}
