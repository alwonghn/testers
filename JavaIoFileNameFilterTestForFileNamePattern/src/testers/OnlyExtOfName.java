/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author alfred.wong
 */
public class OnlyExtOfName implements FilenameFilter {


    String ext;
    public OnlyExtOfName(String acceptableExt) {
        this.ext = "." + acceptableExt;
    }

    public boolean accept (File directory, String name){
        boolean endsWithExtTF = name.endsWith(ext);
        return endsWithExtTF;
    }
}
