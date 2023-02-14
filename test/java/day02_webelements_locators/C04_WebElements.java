package day02_webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WebElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // AMAZON ANA SAYFAYA GİDİN
        driver.get("https://www.amazon.com");

        //ARAMA KUTUSUNU LOCATE EDİP BİR WEBELEMENT OLARAK KAYDEDİN
        //id si totabsearchtextbox olan webelement seklinde locate edecegiz.

        WebElement aramaKutusu =driver.findElement(By.id("twotabsearchtextbox"));
        /*
        DRİVER A webelementi tarif etme işlemine locate ,
        bu tarifi yapabilmek için kullanabileceğim değişkenlere de locater denir.

        8 tane locator vardır.
        Locator ların 6 tanese webelemetin özelleiklerine baglidir.
        -id,-classname,-name,-tagname,-linkText,-partialLinkText

        GERİYE KALAN 2 LOCATOR ise her türlü webelementi locate etmek için kullanılabilir.
        -xpath,-cssSelector
         */
        //ARAMA KUTUSUNA "Nutella" yazip aratın
        aramaKutusu.sendKeys("Nutella");
        aramaKutusu.submit();

        Thread.sleep(3000);
        driver.close();

    }
}
