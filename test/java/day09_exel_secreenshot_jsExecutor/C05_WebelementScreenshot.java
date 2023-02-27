package day09_exel_secreenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utulities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_WebelementScreenshot extends TestBase {


    @Test
    public void test01() throws IOException {
        driver.get("https://www.amazon.com");
        // nutella icin arama yapın.
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //sonuclari nutella icerdigini test edin
        WebElement sonucYaziElemeneti=driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        String expectedIcerik="Nutella";
        String actualIcerik=sonucYaziElemeneti.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));

        //rapaora yazmak icin sonuc yazısı elementinin fotografını cekin

        //1-fotograf cekilecek elementi locate edin
        //2-dosyayı kaydetmek icin bir File olusturun

        File element=new File("target/elementscreenshot.jpg");

        //3-webelelemnt ile screenshot cekip gecici dosyaya kaydedin

        File geciciDosya=sonucYaziElemeneti.getScreenshotAs(OutputType.FILE);

        //4-gecici dosyayi element ss e kopyalıyoruz
        FileUtils.copyFile(geciciDosya,element);
    }
}
