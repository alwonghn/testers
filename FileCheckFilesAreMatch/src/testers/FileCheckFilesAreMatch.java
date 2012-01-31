/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import util.OnlyFileNamesWith;

/**
 *
 * @author alfred.wong
 */
public class FileCheckFilesAreMatch {

        static boolean checkScheduleFilesPresent(String schFilePath, String type){
        File vehSchUpDir = new File(schFilePath);
        if(!vehSchUpDir.exists() || !vehSchUpDir.isDirectory()){
            System.out.println("hastus schedule upload file folder "+schFilePath+" does not exist, please check");
            return false;
        } else {
//            FilenameFilter onlyExtOfName = new OnlyExtOfName("txt");
            FilenameFilter onlyFileNamesWith = new OnlyFileNamesWith("."+type);
//            String[] filesList = vehSchUpDir.list(onlyExtOfName);
            String[] filesList = vehSchUpDir.list(onlyFileNamesWith);
            if(filesList.length==0){
                System.out.println("hastus schedule upload file folder "+schFilePath+" might be empty or containing invalid upload files, please check");
                return false;
            }
        }
        return true;
    }

    static boolean checkSchFilesAreMatch(String schFilePath1, String type1, String schFilePath2, String type2){
        File vehSchUpDir1 = new File(schFilePath1);
        File vehSchUpDir2 = new File(schFilePath2);
        HashMap<String, String> svcNosMp1 = getServiceNosMp(schFilePath1, type1);
        HashMap<String, String> svcNosMp2 = getServiceNosMp(schFilePath2, type2);
        HashMap<Integer, Integer> dtypeHm = new HashMap();
        dtypeHm.put(new Integer(1), new Integer(1));
        dtypeHm.put(new Integer(6), new Integer(6));
        dtypeHm.put(new Integer(7), new Integer(7));
        FilenameFilter onlyFileNamesWithA = new OnlyFileNamesWith("."+type1);
        FilenameFilter onlyFileNamesWithB = new OnlyFileNamesWith("."+type2);
        String[] filesListA = vehSchUpDir1.list(onlyFileNamesWithA);
        String[] filesListB = vehSchUpDir2.list(onlyFileNamesWithB);
        boolean errorFlag = false;
        Integer match = 0;
        if(vehSchUpDir1.exists() && vehSchUpDir1.isDirectory() && vehSchUpDir2.exists() && vehSchUpDir2.isDirectory()){
            if(filesListA.length==filesListB.length){
                if(svcNosMp1.size()>0 && svcNosMp2.size()>0 && svcNosMp1.size()==svcNosMp2.size()){
                    for (String r : svcNosMp1.keySet()) {
                        for(Integer d : dtypeHm.keySet()){
                            FilenameFilter onlyFileNamesWith1 = new OnlyFileNamesWith(r+"_"+d+"."+type1);
                            String[] filesList1 = vehSchUpDir1.list(onlyFileNamesWith1);
                            FilenameFilter onlyFileNamesWith2 = new OnlyFileNamesWith(r+"_"+d+"."+type2);
                            String[] filesList2 = vehSchUpDir2.list(onlyFileNamesWith2);
                            if(filesList1.length>0 || filesList2.length>0){
                                if(filesList1.length==filesList2.length){
                                    errorFlag = false;
                                }else{
                                    errorFlag = true;
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("the vehicle schedule files upload folder does not contain the same route schedules as those of the crew schedule files upload folder");
                }
            }else{
                System.out.println("the total number of vehicle schedule files does not correspond with the total number of crew schedule files");
            }
        }
        if(!errorFlag){
            return true;
        }else{
            System.out.println("the total number of vehicle schedule files does not correspond with the total number of crew schedule files for some routes, please check");
            return false;
        }
    }

    static HashMap<String, String> getServiceNosMp(String schFilePath, String type){
        File directory = new File(schFilePath);
        HashMap<String, String> svcNosMp = new HashMap<String, String>();
        FilenameFilter onlyFileNamesWith = new OnlyFileNamesWith("."+type);
        if(directory.isDirectory()){
            String[] filesList = directory.list(onlyFileNamesWith);
            if(filesList.length>0){
                for(String fileName : filesList){
                    if(((Integer)fileName.length()).equals(9)){
                        if(!svcNosMp.containsKey(fileName.substring(0, 1))){
                            svcNosMp.put(fileName.substring(0, 1), fileName.substring(4, 5));
                        }
                    }
                    if(((Integer)fileName.length()).equals(10)){
                        if(!svcNosMp.containsKey(fileName.substring(0, 2))){
                            svcNosMp.put(fileName.substring(0, 2), fileName.substring(5, 6));
                        }
                    }
                    if(((Integer)fileName.length()).equals(11)){
                        if(!svcNosMp.containsKey(fileName.substring(0, 3))){
                            svcNosMp.put(fileName.substring(0, 3), fileName.substring(6, 7));
                        }
                    }
                    if(((Integer)fileName.length()).equals(12)){
                        if(!svcNosMp.containsKey(fileName.substring(0, 4))){
                            svcNosMp.put(fileName.substring(0, 4), fileName.substring(7, 8));
                        }
                    }
                    if(((Integer)fileName.length()).equals(13)){
                        if(!svcNosMp.containsKey(fileName.substring(0, 5))){
                            svcNosMp.put(fileName.substring(0, 5), fileName.substring(8, 9));
                        }
                    }
                    if(((Integer)fileName.length()).equals(14)){
                        if(!svcNosMp.containsKey(fileName.substring(0, 6))){
                            svcNosMp.put(fileName.substring(0, 6), fileName.substring(9, 10));
                        }
                    }
                    if(((Integer)fileName.length()).equals(15)){
                        if(!svcNosMp.containsKey(fileName.substring(0, 7))){
                            svcNosMp.put(fileName.substring(0, 7), fileName.substring(10, 11));
                        }
                    }
                }
            }
        }
        return svcNosMp;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        if(checkScheduleFilesPresent("C:\\avmsshare\\hastus\\vehicle", "V") && checkScheduleFilesPresent("C:\\avmsshare\\hastus\\crew", "C")){
//            System.out.println("Checked:   checkScheduleFilesPresent = true");
//        }

        HashMap<String, String> serviceNosMp =  getServiceNosMp("C:\\avmsshare\\hastus\\vehicle", "V");
        for(String svc : serviceNosMp.keySet()){
            System.out.println("service no from vehicle schedule folder : "+svc );
        }

//        HashMap<String, String> serviceNosMp =  getServiceNosMp("C:\\avmsshare\\hastus\\crew", "C");
//        for(String svc : serviceNosMp.keySet()){
//            System.out.println("service nos map from vehicle schedule file : "+svc );
//        }
    }

}
