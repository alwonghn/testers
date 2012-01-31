package util;
import java.io.File;
import java.io.FilenameFilter;
/**
 *
 * @author alfred.wong
 */
public class OnlyExtOfName implements FilenameFilter {
    String ext;
    public OnlyExtOfName(String acceptable) {
        this.ext = "." + acceptable;
    }

    @Override
    public boolean accept (File directory, String name){
        boolean endsWithExtTF = name.endsWith(ext);
        return endsWithExtTF;
    }
}
