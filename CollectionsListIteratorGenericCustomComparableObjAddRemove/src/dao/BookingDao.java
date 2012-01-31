/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import jb.BookingBean;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import testers.CollectionsListIteratorGenericCustomComparableObjAddRemove;

/**
 *
 * @author alfred.wong
 */
public class BookingDao {


    public ArrayList<BookingBean> insertBookings(ArrayList<BookingBean> insBkgBnList, ArrayList<BookingBean> dbBkgBnList) throws SQLException {
        if(insBkgBnList.size()>0){
            for(BookingBean insBkgBn : insBkgBnList){

                Collections.sort(dbBkgBnList);
                System.out.println("Printout of db list after sort and before insertion ");
                CollectionsListIteratorGenericCustomComparableObjAddRemove.printTheList(dbBkgBnList);

//                Timestamp insBkStartDateTs = insBkgBn.getStart_date();
//                for(BookingBean dbBkgBn : dbBkgBnList){
//
//                }
                for(ListIterator<BookingBean> it = dbBkgBnList.listIterator(); it.hasNext(); ){

//                    // tester
//                    if(it.next().getStart_date().equals(java.sql.Timestamp.valueOf("2011-10-28 00:00:00"))){// should be at bn 12, what is the iterator index now ??
//                        System.out.println(" condition satisfied for record with start date of"+java.sql.Timestamp.valueOf("2011-10-28 00:00:00"));
//                        System.out.println(" it.previousIndex now is :" + it.previousIndex());   // ans: 0
//                        System.out.println(" it.nextIndex now is :" + it.nextIndex());  // ans: 1
//                    }
//                    // tester
//                    if(it.next().getStart_date().equals(java.sql.Timestamp.valueOf("2011-10-31 00:00:00"))){// should be at bn 12, what is the iterator index now ??
//                        System.out.println(" condition satisfied for record with start date of"+java.sql.Timestamp.valueOf("2011-10-31 00:00:00"));
//                        System.out.println(" it.previousIndex now is :" + it.previousIndex());   // ans: 1
//                        System.out.println(" it.nextIndex now is :" + it.nextIndex()); // ans: 2   //aws: 'nextIndex' is actually this object!!!
//                    }
//                    // tester
//                    if(it.next().getStart_date().equals(java.sql.Timestamp.valueOf("2011-10-28 00:00:00"))){// should be at bn 12, what is the iterator index now ??
//                        System.out.println(" condition satisfied for record with start date of"+java.sql.Timestamp.valueOf("2011-10-28 00:00:00"));
//                        System.out.println(" it.previousIndex now is :" + it.previousIndex()+" |  element at it.previousIndex :" + it.previous());   // ans: expected: 0  | out of range actual: 0  | 12
//                        System.out.println(" it.nextIndex now is :" + it.nextIndex()+"  |  element at it.nextIndex :" + it.next());  // ans: expected: 1 | 14   ???? actual: 0 | 12 !!!
//                        // it is pointing at betw 0 and 1
//                    }

//                    // tester
//                    if(it.next().getStart_date().equals(java.sql.Timestamp.valueOf("2011-10-31 00:00:00"))){// should be at bn 14, what is the iterator index now ??
//                        System.out.println(" condition satisfied for record with start date of"+java.sql.Timestamp.valueOf("2011-10-31 00:00:00"));
//                        System.out.println(" it.previousIndex now is :" + it.previousIndex()+" |  element at it.previousIndex :" + it.previous());   // ans: 1 | 14
//                        System.out.println(" it.nextIndex now is :" + it.nextIndex()+"  |  element at it.nextIndex :" + it.next());  // ans: 1 | 14
//                        // it is pointing at betw 0 and 1
//                    }

//                    // tester
//                    if(it.next().getStart_date().getTime()<(java.sql.Timestamp.valueOf("2011-11-06 00:00:00").getTime())){// condition satisfied at bn 14, what is the iterator index now ??
//                        System.out.println(" condition satisfied for start date less than"+java.sql.Timestamp.valueOf("2011-11-06 00:00:00"));
//                        System.out.println(" it.previousIndex now is :" + it.previousIndex()+" |  element at it.previousIndex :" + it.previous());   // ans:
//                        System.out.println(" it.nextIndex now is :" + it.nextIndex()+"  |  element at it.nextIndex :" + it.next());  // ans:
//                        // it is pointing at
//                    }

//                    // tester
//                    if(it.next().getStart_date().getTime()<(java.sql.Timestamp.valueOf("2011-11-06 00:00:00").getTime())){// condition satisfied at bn 14, what is the iterator index now ??
//                        System.out.println(" condition satisfied for start date less than"+java.sql.Timestamp.valueOf("2011-11-06 00:00:00"));
//                        System.out.println(" it.previousIndex now is :" + it.previousIndex()+" |  element at it.previousIndex :" + it.previous());   // ans:
//                        System.out.println(" it.nextIndex now is :" + it.nextIndex()+"  |  element at it.nextIndex :" + it.next());  // ans:
//                        // it is pointing at
//                        it.add(insBkgBn); // adds
//                    }

//                    // tester
//                    if(it.previous().getStart_date().getTime()<(java.sql.Timestamp.valueOf("2011-11-06 00:00:00").getTime())){// condition satisfied at bn 14, what is the iterator index now ??
//                        System.out.println(" condition satisfied for start date less than"+java.sql.Timestamp.valueOf("2011-11-06 00:00:00"));
//                        System.out.println(" it.previousIndex now is :" + it.previousIndex()+" |  element at it.previousIndex :" + it.previous());   // ans:
//                        System.out.println(" it.nextIndex now is :" + it.nextIndex()+"  |  element at it.nextIndex :" + it.next());  // ans:
//                        // it is pointing at
//                        it.add(insBkgBn); // ERROR!
//                    }

//                    // tester
//                    if(it.next().getStart_date().getTime()<(java.sql.Timestamp.valueOf("2011-11-06 00:00:00").getTime())){// condition satisfied at bn 14, what is the iterator index now ??
//                        System.out.println(" condition satisfied for start date less than"+java.sql.Timestamp.valueOf("2011-11-06 00:00:00"));
//                        System.out.println(" it.previousIndex now is :" + it.previousIndex()+" |  element at it.previousIndex :" + it.previous());   // ans:
//                        System.out.println(" it.nextIndex now is :" + it.nextIndex()+"  |  element at it.nextIndex :" + it.next());  // ans:
//                        // it is pointing at
//                        if(it.next().getStart_date().getTime()<(java.sql.Timestamp.valueOf("2011-11-06 00:00:00").getTime())){
//                            System.out.println(" condition satisfied for start date less than"+java.sql.Timestamp.valueOf("2011-11-06 00:00:00"));
//                            System.out.println(" it.previousIndex now is :" + it.previousIndex()+" |  element at it.previousIndex :" + it.previous());   // ans:
//                            System.out.println(" it.nextIndex now is :" + it.nextIndex()+"  |  element at it.nextIndex :" + it.next());  // ans:
//                            it.add(insBkgBn); // adds
//                        }
//
//                    }

//                    // tester     ///WORKS!!!!!!!!!!!!!!!!!!!!//////////
//                    if(it.next().getStart_date().getTime()<(java.sql.Timestamp.valueOf("2011-11-14 00:00:00").getTime())){// condition satisfied at bn 14, what is the iterator index now ??
//                        it.next();
//                        System.out.println(" condition satisfied for start date less than"+java.sql.Timestamp.valueOf("2011-11-14 00:00:00"));
//                        System.out.println(" it.previousIndex now is :" + it.previousIndex()+" |  element at it.previousIndex :" + it.previous());   // ans:
//                        System.out.println(" it.nextIndex now is :" + it.nextIndex()+"  |  element at it.nextIndex :" + it.next());  // ans:
//                        if(it.previous().getStart_date().getTime()>(java.sql.Timestamp.valueOf("2011-11-14 00:00:00").getTime())){
//                            // it is pointing at
//                            it.add(insBkgBn); // adds
//                        }
//
//                    }

//                    // tester   ///WORKS!!!!!!!!!!!!!!!!!!!!//////////
//                    if(it.next().getStart_date().getTime()<insBkgBn.getStart_date().getTime()){// condition satisfied at bn 14, what is the iterator index now ??
//                        it.next();
//                        System.out.println(" condition satisfied for start date less than"+insBkgBn.getStart_date().getTime());
//                        System.out.println(" it.previousIndex now is :" + it.previousIndex()+" |  element at it.previousIndex :" + it.previous());   // ans:
//                        System.out.println(" it.nextIndex now is :" + it.nextIndex()+"  |  element at it.nextIndex :" + it.next());  // ans:
//                        if(it.previous().getStart_date().getTime()>insBkgBn.getStart_date().getTime()){
//                            // it is pointing at
//                            it.add(insBkgBn); // adds
//                        }
//
//                    }

                    // tester
                    if(it.next().getStart_date().getTime()<insBkgBn.getStart_date().getTime()){// condition satisfied at bn 14, what is the iterator index now ??
                        it.next();
//                        System.out.println(" condition satisfied for start date less than"+insBkgBn.getStart_date().getTime());
//                        System.out.println(" it.previousIndex now is :" + it.previousIndex()+" |  element at it.previousIndex :" + it.previous());   // ans:
//                        System.out.println(" it.nextIndex now is :" + it.nextIndex()+"  |  element at it.nextIndex :" + it.next());  // ans:
                        if(it.previous().getStart_date().getTime()>insBkgBn.getStart_date().getTime()){
                            // it is pointing at
                            it.add(insBkgBn); // adds
                        }
                        //System.out.println(" it.nextIndex now is :" + it.nextIndex()+"  |  element at it.nextIndex :" + it.next());
                    }


                    //it.previous().getStart_date().getTime()<(java.sql.Timestamp.valueOf("2011-11-13 00:00:00").getTime()) && 


//                    if(it.next().compareTo(insBkgBn)==-1){
//                        System.out.println("insBkgBn is " + insBkgBn.toString());
//                        System.out.println("dbBkgBn which .compareTo insBkgBn == 1 " + it.next().toString());
//                    }
                }










//                insertBooking(insBkgBn);


            }
        }
        return dbBkgBnList;
    }

}
