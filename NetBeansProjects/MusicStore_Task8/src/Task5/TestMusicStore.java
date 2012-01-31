package Task5;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alfred.wong
 */
public class TestMusicStore {
    public static void main(String[] Args){
        
        MusicTitle[] titlesNew = new MusicTitle[2];
        titlesNew[0] =  new MusicTitle("Las Cosas Que Vives", "Laura Pausini");
        titlesNew[1] =  new MusicTitle("Luna Nueva","Diego Torres");
        MusicStore store = new MusicStore(titlesNew);

        // testing passing by value
//        MusicTitle title1 = new MusicTitle();
//        title1.setTitle("Las Cosas Que Vives - set by setter");
//        title1.setArtist("Laura Pausini - set by setter");
//        titlesNew[0] = title1;
//        MusicTitle title2 = new MusicTitle();
//        title2.setTitle("Luna Nueva - set by setter");
//        title2.setArtist("Diego Torres - set by setter");
//        titlesNew[1] = title2;
//        MusicStore store = new MusicStore(titlesNew);

        // testing passing by instantiated value
//        titlesNew[0] = new MusicTitle(new String("Las Cosas Que Vives - set by instantiation"), new String("Laura Pausini - set by instantiation"));
//        titlesNew[1] = new MusicTitle(new String("Luna Nueva - set by instantiation"), new String("Diego Torres - set by instantiation"));
//        MusicStore store = new MusicStore(titlesNew);

        // testing titlesNew
//        System.out.println(titlesNew.length);
//        for(int i=0; i<titlesNew.length; i++){
//            System.out.println("Title "+(i+1)+":");
//            System.out.println("Title "+(i+1)+": "+titlesNew[i].getTitle());
//            System.out.println("Artist "+(i+1)+": "+titlesNew[i].getArtist());
//        }
        store.displayMusicTitles();
    }
}
