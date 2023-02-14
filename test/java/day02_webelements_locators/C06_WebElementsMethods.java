package day02_webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_WebElementsMethods {
    public static void main(String[] args) throws InterruptedException {
        /*
        1- Bir test class’i olusturun ilgili ayarlari yapin
2- https://www.automationexercise.com/ adresine gidin
3- Sayfada 147 adet link bulundugunu test edin.
4- Products linkine tiklayin
5- special offer yazisinin gorundugunu test edin
6- Sayfayi kapatin
         */
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com");

        List<WebElement> linkElementleriList=driver.findElements(By.tagName("a"));

        int expectedLinkSayisi=147;
        int actualLinkSayisi=linkElementleriList.size();

        if (expectedLinkSayisi==actualLinkSayisi){
            System.out.println("link sayisisi testi PASSED");
        }else {
            System.out.println("link sayisi testi FAİLED"+
                    "\n sayfada link sayisi  :"+actualLinkSayisi);
        }
        // product linkine tıklayin
        driver.findElement(By.partialLinkText("Products")).click();
        //special offer yazisinin gorunduğunu test edin

        WebElement specialOfferElement=driver.findElement(By.id("sale_image"));

        if (specialOfferElement.isDisplayed()){
            System.out.println("special offer testi PASSED");
        }else {
            System.out.println("special offer testi FAİLED");
        }
        Thread.sleep(3000);
        driver.close();
    }
}
