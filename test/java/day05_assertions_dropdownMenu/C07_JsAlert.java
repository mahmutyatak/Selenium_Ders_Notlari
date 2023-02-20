package day05_assertions_dropdownMenu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utulities.TestBaseClass;

public class C07_JsAlert extends TestBaseClass {
    /*
    // Gerekli ayarlamalari yapip
// https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
// 3 test method'u olusturup her method'da bir JsAlert'e basin
// Ilgili method'lari kullanin
// https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
// 1.alert'e tiklayalim
// Alert'deki yazinin "I am a JS Alert" oldugunu test edelim
// OK tusuna basip alert'i kapatalim
// https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
// 2.alert'e tiklayalim
// cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
// https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
// 3.alert'e tiklayalim
// Cikan prompt ekranina "Abdullah" yazdiralim ve OK tusuna basarak alert'i kapatalim
//cıkan sonuc yazısının abdullah icerdigini test edelim
     */
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts ");

        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        //Alert'deki yazinin "I am a JS Alert" oldugunu test edelim
        String expectedAlertYazisi="I am a JS Alert";
        String actualAlertYazisi=driver.switchTo().alert().getText();
        bekle(2);
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        driver.switchTo().alert().accept();
        bekle(2);

    }
    @Test
    public void test02(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts ");//TEST METODLARİNİ AYRI AYRI CALİSTİRMAK İCİN KOYALADIK.
        //2.alerte tıklaylım
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        // cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        bekle(2);
        driver.switchTo().alert().dismiss();
        bekle(2);
        String expectedSonucYazisi="You clicked: Cancel";
        String actualSonucYazisi=driver.findElement(By.xpath("//*[@id='result']")).getText();

        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);

    }@Test
    public void test03(){
        // 3.alert'e tiklayalim

        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        // Cikan prompt ekranina "Abdullah" yazdiralim ve OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().sendKeys("Abdullah");
        bekle(2);
        driver.switchTo().alert().accept();//ok tusuna basmak.
        bekle(2);
        //cıkan sonuc yazısının abdullah icerdigini test edelim
        String actualSOnucYazisi=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedIcerik="Abdullah";

        Assert.assertTrue(actualSOnucYazisi.contains(expectedIcerik));

    }
}
