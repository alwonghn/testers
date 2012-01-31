/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.sql.Timestamp;

/**
 *
 * @author alfred.wong
 */
public class BeanImplComparable implements Comparable{

    private Timestamp start_date;

    public BeanImplComparable(){

    }
    public BeanImplComparable(Timestamp ts){
        this.start_date = ts;
    }

    public Timestamp getStart_date() {
        return start_date;
    }

    public void setStart_date(Timestamp start_date) {
        this.start_date = start_date;
    }


    public int compareTo(Object obj){
        BeanImplComparable other = (BeanImplComparable)obj;
        Long thisBnStDtLg =  this.getStart_date().getTime();
        Long otherBnStDtLg = other.getStart_date().getTime();
        if(thisBnStDtLg>otherBnStDtLg){
            return 1;
        } else if(thisBnStDtLg.equals(otherBnStDtLg)) {
            return 0;
        } else {
            return -1;
        }
    }
}
