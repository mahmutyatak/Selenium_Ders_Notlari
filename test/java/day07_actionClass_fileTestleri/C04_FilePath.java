package day07_actionClass_fileTestleri;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FilePath {
    @Test
    public void test01(){
//C:\Users\Yasemin\Desktop\TheDelta

        String dosyaYolu="C:\\Users\\Yasemin\\Desktop\\TheDelta.docx";
        boolean sonuc= Files.exists(Paths.get(dosyaYolu));
        System.out.println(sonuc);
        /*
        bilgisayarınızda bir dosyanın var oldugunu test etmek icin
        dosya yoluna ihtiyacımız vardır.
        Ancak herkesin bilgisayarındaki dosya yollari farklılıklar gösterir.
         herksin bilgisayarına göre farklı olan kısmı javadan bi rkomula alabiliriz.

         */
        //C:\Users\Yasemin\Desktop\seleniumTeam108\src\test\java\day07_actionClass_fileTestleri\text.txt
        //icinde bulundugumuz projenin temel yolu user.dir

        System.out.println(System.getProperty("user.home"));

        dosyaYolu=System.getProperty("user.home")+"\\Desktop\\TheDelta.docx";
        //herkesle aynı calismasını istiyorsak user home kullanıyoruz.

        System.out.println(System.getProperty("user.dir"));
        //C:\Users\Yasemin\Desktop\seleniumTeam108
        //src ye kalan kısmı veriri herkesde baska olan

    }
}
