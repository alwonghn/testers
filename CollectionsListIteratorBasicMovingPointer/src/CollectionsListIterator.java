
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * http://leepoint.net/notes-java/data/collections/iterators.html
 * http://www.roseindia.net/tutorial/java/iterator/listiterator.html
 * http://www.javapractices.com/topic/TopicAction.do?Id=125
 */
public class CollectionsListIterator {

    static List putZeroBetweenTwoAndThree(List alist){
//        for (Iterator it = alist.iterator(); it.hasNext();) {  // NO WORK: ITERATOR DOESNT HV .prevous() mtd!!!!
        for (ListIterator it = alist.listIterator(); it.hasNext();) {
            if(it.next().equals(2)){// it is pointing at betw 1 and 2 
                // it is pointing at betw 2 and 3
                //System.out.println("current element :" + it.previous());  //  therefore prints out '2'
                it.add(0); // adds '0' betw 2 and 3
                it.next(); // points at betw 3 and 4 ?
                System.out.println("current element :" + it.previous());  //  therefore prints out '3' and goes to point betw 0 and 3
                it.previous();it.previous(); // makes it pointing at betw 1 and 2
                System.out.println("current element :" + it.previous());  //  therefore prints out '1'
                it.next();
                break;
            }
        }
        return alist;
    }


    static void iterateAndPrintTheListUsingWhile(List alist){
        //Iterator it = alist.iterator();
        ListIterator it = alist.listIterator();        
        // using while loop
        while (it.hasNext()) {
            System.out.print(it.next());
        }
        System.out.println();
    }

    static void iterateAndPrintTheListUsingFor(List alist){
        // using while loop
//        for (Iterator it = alist.iterator(); it.hasNext();) {
        for (ListIterator it = alist.listIterator(); it.hasNext();) {
            System.out.print(it.next());
        }
        System.out.println();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List alist = new ArrayList();
        for (int i = 1; i < 6; i++) {
            alist.add(i);
        }
//        System.out.println("test of WHILE loop +LISTITERATOR(note:not ITERATOR) + it.hasNext() iterate fr st to end to print out the whole ORIGINAL list");
//        iterateAndPrintTheListUsingWhile(alist);
//        System.out.println("test of FOR loop +LISTITERATOR(note:not ITERATOR) + it.next() iterate fr st to end to print out the whole ORIGINAL list");
//        iterateAndPrintTheListUsingFor(alist);
        System.out.println("test of match an element using it.next() stop at 2 and print out it.next()");
        alist = putZeroBetweenTwoAndThree(alist);
        iterateAndPrintTheListUsingFor(alist);
     }

}
