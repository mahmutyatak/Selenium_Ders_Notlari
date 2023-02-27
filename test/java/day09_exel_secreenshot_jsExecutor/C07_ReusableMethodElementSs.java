package day09_exel_secreenshot_jsExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utulities.ReusableMethod;
import utulities.TestBase;

public class C07_ReusableMethodElementSs extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        // nutella icin arama yapın.
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //sonuclari nutella icerdigini test edin
        WebElement sonucYaziElemeneti=driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        String expectedIcerik="Nutella";
        String actualIcerik=sonucYaziElemeneti.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        // ve rapora eklemek icin SONUC YAZISI ELEMENTİNİN fotografini cekin.
        ReusableMethod.webelementScreenshot(sonucYaziElemeneti);
    }
}
