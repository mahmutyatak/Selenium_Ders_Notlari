package day07_actionClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_File_ExistTesti  {
    @Test
    public void test01(){
        //calistigimiz package icerisinde
        //text.txt dosyası oldugunu test edin

        String dinamikDosyaYolu=System.getProperty("user.dir") +"/src/test/java/day07_actionClass_fileTestleri/text.txt";
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
    }
}
