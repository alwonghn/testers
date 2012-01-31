/*
 * http://www.java2s.com/Code/CSharp/Collections-Data-Structure/InsertingintoanArrayListbyindex.htm
 * 
 */

package testers;

import java.util.ArrayList;

/**
 * http://www.mkyong.com/java/reverse-loop-versus-forward-loop-in-performance-java/
 * @author alfred.wong
 */
public class ArrayListInsertIntoArraylistByIndex {

    public static ArrayList reverseIterateToInsertInOrder(ArrayList al, ArrayList alAddingList){
        System.out.println("alAddingList b4 reverse");
        for(Object alal : alAddingList){
            System.out.println("  Value " +  alal); 
        }
        ArrayList ralAddingList = new ArrayList();
        for(int i=alAddingList.size()-1; i>=0; i--){
            ralAddingList.add(alAddingList.get(i));
                       
        }
        System.out.println("ralAddingList");
        for(Object ralal : ralAddingList){
            System.out.println("  Value " +  ralal);
        }
        System.out.println("adding the alAddingList to the orig al");
        for(Object a : ralAddingList){

                al.add(0, a);

        }
        return al;
    }

    /**
     * @param args the command line arguments
     */
    public static void printDaList(ArrayList al){
        // Enumerate the array
        for(Object a : al) {
            System.out.println(" Index: " + al.indexOf(a) + "  Value " +  a);
        }
    }


    public static void main(String[] args) {
        ArrayList al = new ArrayList();

        // Add three elements to the end of the array without specifying index : order/index of each new element will be assigned index of ascending index
        al.add(10);
        al.add(9);
        al.add(8);

//        // aws: al.add method WILL add to END OF LIST but preserves the index order of the adding list
//        al.add(1);
//        al.add(2);
//        al.add(3);
        // Now, insert three elements by index (e.g. if want to put at the front of the array use insertion index 0)
        
//        al.add(0, 3);
//        al.add(0, 2);
//        al.add(0, 1);  // add(index, object)
        
        //  result: each new element is assigned index 0 as it is inserted
        // hence the index of all other elements are incremented by one everytime a new element is added

//        // Finally, insert into some random spots
//        al.add(2, 4);
//        al.add(4, 5);
//        al.add(6, 6);

        printDaList(al);


        ArrayList alAddingList = new ArrayList();

        // Add three elements to the end of the array without specifying index : order/index of each new element will be assigned index of ascending index
        alAddingList.add(1);
        alAddingList.add(2);
        alAddingList.add(3);

        ArrayList alNew = reverseIterateToInsertInOrder(al, alAddingList);
        printDaList(alNew);
        
    }

}
