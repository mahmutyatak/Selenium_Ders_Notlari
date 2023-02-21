package day06_window_iframe_actionsclass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utulities.TestBase;

import java.util.Set;

public class C04_SwitchToWindow extends TestBase {

    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.

        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement ilkSayfaYaziElementi=driver.findElement(By.tagName("h3"));
        String expectedYazi="Opening a new window";
        String actualYazi=ilkSayfaYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        bekle(2);
        String ilkSayfaWindowHandleDegeri=driver.getWindowHandle();
        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        /*
            eger switchToNewWindow methodu kullanılırsa
            driver yeni acılan sayfaya gecis yapar.
            Ancak bu method kullanılmadan bir link tıklandığında yeni bir sayfa acılıyorsa driver
            yeni sayfaya gecis yapmaz.

            Bbizim yeni acılan sayfanın WindowHandle degerini bulup DİRVERI O SAYFAYA GECİRMEMİZ GEREKLİDİR.

            Linke click yaptığımızda acık 2 sayfamız oluyor bunlardan bir tanesi windowHndle degerini kaydettigimiz
            ilk sayfa diğeri ise windowHandle degerini bilmedigimiz ikinci sayfa.

            Biz getWindowHandles() methodu ile BİR SET olarak 2 sayfanın WİndowHandle DEGERLERİNİ alabiliyoruz.
            O set iceriside ilk sayfaWindowsHandle DEGERİNE esit olmayan String i ikinci sayfa windowHandle degeri
            olarak atayabiliriz.
         */
        Set<String> tumSayfalarWindowsHandleDegerleriSeti=driver.getWindowHandles();
        String ikincisayfaWindowHnadleDegeri="";
        for (String each:tumSayfalarWindowsHandleDegerleriSeti
             ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikincisayfaWindowHnadleDegeri=each;
            }
        }
        driver.switchTo().window(ikincisayfaWindowHnadleDegeri);
        expectedTitle="New Window";
        actualTitle=driver.getTitle();
        bekle(2);
        //System.out.println("ilk sayfa window handle degeri :"+ilkSayfaWindowHandleDegeri);
        //System.out.println("tümsayfa window handle seti "+tumSayfalarWindowsHandleDegerleriSeti);
        Assert.assertEquals(expectedTitle,actualTitle);
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String ikinciSayfaYazi=driver.findElement(By.tagName("h3")).getText();
        expectedYazi="New Window";
        Assert.assertEquals(expectedYazi,ikinciSayfaYazi);
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        // “The Internet” olduğunu doğrulayın.
        expectedTitle="The Internet";
        actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        bekle(2);
    }

}
