package day07_actionClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_Dinamik_DosyaYolu {
    @Test
    public void test01(){
        //masautumuzde thedelte.docx isimli bir dosya bulundugunu test edin.

        String dosyaYolu=System.getProperty("user.home") + "\\Desktop\\TheDelta.docx";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

}
