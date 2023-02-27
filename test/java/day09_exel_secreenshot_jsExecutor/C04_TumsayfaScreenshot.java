package day09_exel_secreenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utulities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class C04_TumsayfaScreenshot extends TestBase {
    @Test
    public void test01() throws IOException {
        //amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");
        // nutella icin arama yapın.
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //sonuclari nutella icerdigini test edin
        String expectedIcerik="Nutella";
        String actualIcerik=driver.findElement(By.xpath("//div[@class='sg-col-inner']")).getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        //ve ropara eklenmek icin tum sayfanın fotografını cekin

        //Tum sayfa screenshot icin
        //1-TakeScreenShot OBJESİ OLUSTURUYORUZ
        TakesScreenshot ts= (TakesScreenshot) driver;//cast yaptık.

        //2-SecreenShot I KAYDEDECEGİMİZ BİR DOSYA OLUSTURALIM.

        File tumSayfaSS=new File("target/screenshot.png");

        //3-Gecici bir dosys olusturup ts objesi ile cekilen fotografı dosyaya kaydediyooruz.

        File geciciResim=ts.getScreenshotAs(OutputType.FILE);

        //4-gECİCİ dosyayi tumSayfaSS dosyasına koyalayalım
        FileUtils.copyFile(geciciResim,tumSayfaSS);

        bekle(3);
    }
}
