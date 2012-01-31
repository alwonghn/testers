/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author alfred.wong
 */
public class ArraylistDifferencingUsingCollectionRemovePlusTypeConversionToCollection {


    public static Collection<String> RemoveAllListBfromListA(Collection<String> listA, Collection<String> listB){
        Collection<String> resultingList = new ArrayList<String>(listA);
        resultingList.removeAll(listB);
        return resultingList;
    }

    public static ArrayList<String> RemoveFromListA(Collection<String> icList, Collection<String> replList, Collection<String> topgList, Collection<String> botgList){
        Collection<String> resultingList = new ArrayList<String>(icList);
        resultingList.removeAll(replList);
        resultingList.removeAll(topgList);
        resultingList.removeAll(botgList);
        return (ArrayList)resultingList;
    }

//    public static Collection<String> UnionListAListBListC(Collection<String> listA, Collection<String> listB, Collection<String> listC){
//        Collection<String> resultingList = Union(listA,listB,listC);
//        resultingList.removeAll(listB);
//        return resultingList;
//    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> icList = new ArrayList<String> ();
        icList.add(new String("bbn1"));
        icList.add(new String("bbn2"));
        icList.add(new String("bbn3"));
        icList.add(new String("bbn4"));
        icList.add(new String("bbn5"));
        ArrayList<String> replList = new ArrayList<String> ();
        replList.add(new String("bbn1"));
        ArrayList<String> topgList = new ArrayList<String> ();
        topgList.add(new String("bbn3"));
        ArrayList<String> botgList = new ArrayList<String> ();
        botgList.add(new String("bbn5"));

//        // SUBTRACT someList from icList :
//        Collection<String> resultList = RemoveAllListBfromListA(icList, replList);

        // SUBTRACT someList and somelist and somelist from icList
        ArrayList<String> resultList = RemoveFromListA(icList, replList, topgList, botgList);

        System.out.println("size of resulting insList :"+resultList.size());
        for(String insBn : resultList){
            System.out.println(insBn);
        }

        // ADD TOGETHER replList, topgList and botgList


    }



}
