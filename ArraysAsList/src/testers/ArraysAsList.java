/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testers;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author alfred.wong
 */
public class ArraysAsList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      String[] words = {"ace", "boom", "crew", "dog", "eon"};

      List<String> wordList = Arrays.asList(words);

      for (String e : wordList)
      {
         System.out.println(e);
      }
    }

}
