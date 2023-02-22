package day07_actionClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utulities.TestBase;

public class C08_FileUploadTesti extends TestBase {
    @Test
    public void test01(){
        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //2.chooseFile butonuna basalim
        //3.Yuklemek istediginiz dosyayi secelim.
        //Downloadsa indirdiğimiz logo.png dosyasını yukleyelim
        /*
        choose file butonuna basarsak biligisayarınızdan bir dosya secme işlem yapmak gerekir
        Selenıum bize bir yontem gerektirmiştir.
        Choosefile İLE SECMEMİZ GEREKEN dosyanin dosya yolunu olusturup
        olusturulan dosyayolunu SendKeys ile chooseFile butonuna gondermemiz yeterli olur.
         */

        String dinamikDosyaYolu=System.getProperty("user.home")+"\\Downloads\\logo.png";
        WebElement choseFileButon=driver.findElement(By.id("file-upload"));
        choseFileButon.sendKeys(dinamikDosyaYolu);//click yapmadan dosya yolunu gönderiyoruz direk.
        bekle(3);
        //4.Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //5.“File Uploaded!” textinin goruntulendigini test edelim.
        bekle(3);
        WebElement fileUploadedYazielementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedYazielementi.isDisplayed());

    }
}
