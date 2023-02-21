package day06_window_iframe_actionsclass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utulities.TestBase;

public class C02_iframe extends TestBase {
    /*
    HTML kodlarının icine baska bir html koymak icin iframe kullanılır
    iframe icinde locate duzgun calismaz
    bAzrn locate islemmizden emin olmamıza ragmet locater calismaz bunun sebebi
    kullanmak istedigimiz webeelemntin bir iframe in child ı olması olabilir.
    Eger kulnamk istedigimiz webelement ana sayfa icine goulen baska bir websayfasının elementi ise
    önce gomulu sayfaya gecmemiz gerekir

    Html komutlarında sayfa icerisine sayfa gömebilmek icin iframe tagı kullanılır.
    bizde istediğimiz elementi kullanmak icin once o frame e switch yapmalıyız.
    1-gecis yapmak istediğiniz frmae i locate edin
    2-switch to ile o frame e gecis yapın
    3-sonra istediginiz elemen ile istediginiz islemi yapın.
     */
    //https://the-internet.herokuapp.com/iframe adresine gidin
    //Your content goes here. yazısının gorunur oldugunu test edin


    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement frameElementi=driver.findElement(By.id("mce_0_ifr"));//once iframe i locate ettik
        driver.switchTo().frame(frameElementi);//sonra switch to ile o frame e girdik

        WebElement yaziElementi=driver.findElement(By.tagName("p"));// sonra normal bulma islemimizi yaptık.
        Assert.assertTrue(yaziElementi.isDisplayed());

        //Elemental Selenium a tıklayiniz
        //driver.switchTo().parentFrame();
        //ic ice framelerde bir ust seviyeye cıkar
        driver.switchTo().defaultContent();
        //direk anasayfaya cıkar.
        driver.findElement(By.linkText("Elemental Selenium")).click();
        /*
        bİR FRAME E gecis yaptıktan sonra oradan cıkıncay veya baska bir frame e gecinceye kadar driver
        o frame icerisinde kalır isimiz bittiginde veya baska frame e gecmek istedigimizde once calisacagımız yere gecis yapmalıyız.
         */
        //BU YOLLA BULAMDI CUNKU İFRAME İN İCİNE GİRDİK ORDA KALDIK.

        bekle(3);
    }
}
