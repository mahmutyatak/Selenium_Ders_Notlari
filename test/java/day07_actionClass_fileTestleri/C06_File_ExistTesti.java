package day07_actionClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utulities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_File_ExistTesti extends TestBase {

@Test
public void test01(){
    //2. https://the-internet.herokuapp.com/download adresine gidelim.
    driver.get("https://the-internet.herokuapp.com/download");
    //3. logo.png dosyasını indirelim
    driver.findElement(By.linkText("logo.png")).click();
    bekle(5);//inmesi surebilir diye bekledik
    //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

    //dosya dowloads a inecegi icin dosya yolu olusturalım
    String dinamikDosyaYolu=System.getProperty("user.home")+"\\Downloads\\logo.png";

    Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));

}
}
