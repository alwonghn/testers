package util;
import java.io.File;
import java.io.FilenameFilter;
/**
 *
 * @author alfred.wong
 */
public class OnlyFileNamesWith implements FilenameFilter{
    String chrs;
    public OnlyFileNamesWith (String chrs) {
        this.chrs = chrs; 
    }
    
    @Override
    public boolean accept(File dir, String name) {
        String f = new File(name).getName();
        return f.indexOf(chrs) != -1;
    }
}
