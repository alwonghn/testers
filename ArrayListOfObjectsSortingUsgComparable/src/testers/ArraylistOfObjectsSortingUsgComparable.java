/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import beans.BeanImplComparable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author alfred.wong
 */
public class ArraylistOfObjectsSortingUsgComparable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<BeanImplComparable> bnList = new ArrayList<BeanImplComparable>();
        java.util.Date todayDt = new java.util.Date();
        java.sql.Timestamp todayTs = new java.sql.Timestamp(todayDt.getTime());
        java.sql.Timestamp customTimeTs = java.sql.Timestamp.valueOf("2005-04-06 09:01:10");
        java.sql.Timestamp todayTs2 = new java.sql.Timestamp(todayDt.getTime());
        BeanImplComparable todayDtBn = new BeanImplComparable(todayTs);
        todayDtBn.setBean_name("laterBean");
        bnList.add(todayDtBn);
        BeanImplComparable customDtBn = new BeanImplComparable(customTimeTs);
        customDtBn.setBean_name("earlierBean");
        bnList.add(customDtBn);
        BeanImplComparable todayDtBn2 = new BeanImplComparable(todayTs2);
        System.out.println("result of todayDtBn.compareTo(customDtBn)   (today should be greater/later than custom)   "+" "+ todayDtBn.compareTo(customDtBn));

        System.out.println("result of todayDtBn.compareTo(todayDtBn2)   (today should be equal to today2)   " + todayDtBn2.compareTo(todayDtBn2));

        for (BeanImplComparable bn : bnList){
            System.out.println("bean before sort : " + bn.getBean_name());
        }
        Collections.sort(bnList);
        for (BeanImplComparable bn : bnList){
            System.out.println("bean after sort : " + bn.getBean_name());
        }
    }

}
