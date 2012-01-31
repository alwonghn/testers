/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jb;

import java.sql.Timestamp;

/**
 *
 * @author alfred.wong
 */
public class BookingBean implements Comparable{

    private String bean_name;
    private Timestamp start_date;
    private Timestamp end_date;
    
    public BookingBean(){

    }
    public BookingBean(Timestamp start_date){
        this.start_date = start_date;        
    }
    

    public String getBean_name() {
        return bean_name;
    }
    public Timestamp getStart_date() {
        return start_date;
    }
    public Timestamp getEnd_date() {
        return end_date;
    }
    
    
    public void setBean_name(String bean_name) {
        this.bean_name = bean_name;
    }
    public void setStart_date(Timestamp start_date) {
        this.start_date = start_date;
    }
    public void setEnd_date(Timestamp end_date) {
        this.end_date = end_date;
    }    




    public int compareTo(Object obj){
        BookingBean other = (BookingBean)obj;
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

    @Override
    public String toString(){
        return("name : " + this.getBean_name() + " | " + "start_date : " +this.getStart_date() + " | " + "end_date : " + this.getEnd_date());
    }
}
