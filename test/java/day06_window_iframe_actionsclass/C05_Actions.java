package day06_window_iframe_actionsclass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

import java.util.Set;

public class C05_Actions extends TestBase {
    /*
    2- https://the-internet.herokuapp.com/context_menu sitesine gidin
3- Cizili alan uzerinde sag click yapin
4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
5- Tamam diyerek alert’i kapatalim
6- Elemental Selenium linkine tiklayalim
7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */
    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapin
        Actions actions=new Actions(driver);
        WebElement cizgiliAlanElementi=driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlanElementi).perform();//actions ların sonuna mutlaka perform demek gerekir.
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlert="You selected a context menu";
        String actualAlert=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlert,actualAlert);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        String ilksayfaWHD=driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();//İKİNİC TAB ACILIYOR O YUZDEN HANDLE A İHTİYAC VAR
        //ikinici sayfanın WDH sine ihtiyac var.ilkini click yapmadan kaydettik
        Set<String> tumWHD=driver.getWindowHandles();//tum handle degerleri burda
        String ikiciSayfaWDH="";//ONCE HİCLİK OLARAK ALDIK ATAMA YAPACAGIZ.
        for (String each:tumWHD
             ) {
            if (!each.equals(ilksayfaWHD)){
                ikiciSayfaWDH=each;
            }
        }
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        driver.switchTo().window(ikiciSayfaWDH);
        String expectedİkinciSAYFAyAZİSİ="Elemental Selenium";
        String actualİkinciSayfaYazisi=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedİkinciSAYFAyAZİSİ,actualİkinciSayfaYazisi);
        bekle(3);
    }
}
