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
public class ArrayListDifferencing {

    public static ArrayList<String> ArrayListDifference(ArrayList<String> icList, ArrayList<String> replList, ArrayList<String> topgList, ArrayList<String> botgList){
        ArrayList<String> notInsList = new ArrayList<String>();
        ArrayList<String> insList = new ArrayList<String>();
        if(icList.size()>0){
            if(botgList.size()>0 || topgList.size()>0 || replList.size()>0){
                for(String icBn : icList){
                    for(String botgBn : botgList){
//                        if(icBn.equalsIgnoreCase(botgBn)){
                        if(icBn.equals(botgBn)){
                            notInsList.add(icBn);
                            System.out.println("added one botg bean to notInsBkgBnList");
                        }
                    }
                    for(String topgBn : topgList){
//                        if(icBn.equalsIgnoreCase(topgBn)){
                        if(icBn.equals(topgBn)){
                            notInsList.add(icBn);
                            System.out.println("added one topg bean to notInsBkgBnList");
                        }
                    }
                    for(String replBn : replList){
//                        if(icBn.equalsIgnoreCase(replBn)){
                        if(icBn.equals(replBn)){
                            notInsList.add(icBn);
                            System.out.println("added one repl bean to notInsBkgBnList");
                        }
                    }
//                }
                    System.out.println("Size of notInsList :" + notInsList.size());
                    if(notInsList.size()>0){
                        for(String niBn : notInsList){
    //                        for(String icBn : icList){
    //                            if(icBn.equals(niBn)){
    //                                inxList.add(icBn);
    //                                System.out.println("added one bean to inx list");
    //                            }
    //                        }
                            if(!icList.contains(niBn)){
                                insList.add(niBn);
                            }
                        }
                    }
                }
            } else {
                System.out.println("topg botg and repl lists are all empty");
                insList = icList;
            }
        }
        return insList;

        // THE ABOVE CODE WILL NEVER WORK AT ALL!!!
//        ArrayList<String> insList = new ArrayList();
//
//
//
//        return insList;


    }
    
    
    public static Collection<String> RemoveAllListBfromListA(Collection<String> listA, Collection<String> listB){
        Collection<String> resultingList = new ArrayList<String>(listA);
        resultingList.removeAll(listB);
        return resultingList;
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
        ArrayList<String> insList = ArrayListDifference(icList, replList, topgList, botgList);

//        // SUBTRACT someList from icList :
//        Collection<String> resultList = RemoveAllListBfromListA(icList, replList);
        System.out.println("size of resulting insList :"+insList.size());
        for(String insBn : insList){
            System.out.println(insBn);
        }

        // ADD TOGETHER replList, topgList and botgList


    }

}
