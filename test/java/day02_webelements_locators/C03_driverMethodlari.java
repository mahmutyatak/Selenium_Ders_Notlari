package day02_webelements_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_driverMethodlari {
    public static void main(String[] args) {
        /*
        1.Yeni bir class olusturalim (Homework)
2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
4.https://www.walmart.com/ sayfasina gidin.
5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
6. Tekrar “facebook” sayfasina donun
7. Sayfayi yenileyin
8. Sayfayi tam sayfa (maximize) yapin
9.Browser’i kapatin
         */
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.facebook.com");
        String expectedTitle="facebook";
        String actualTitle=driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println(" facebook title testi PASSED");
        }else {
            System.out.println("facebook title testi FAİLED "+driver.getTitle());
        }
        String expectedUrl="facebook";
        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)){
            System.out.println("FACEBOOK URL TEST PASSED");
        }else {
            System.out.println("facebook url test FAİLED "+driver.getCurrentUrl());
        }

        driver.get("https://www.Walmart.com");
        String expectedTitleWalmart="Walmart.com";
        String actualTitleWalmart=driver.getTitle();

        if (actualTitleWalmart.contains(expectedTitleWalmart)){
            System.out.println("walmart title test PASSED");
        }else {
            System.out.println("walmart title test FAİLED "+driver.getTitle());
        }

        driver.navigate().back();
        driver.navigate().refresh();
        driver.manage().window().maximize();
        driver.close();
    }
}
