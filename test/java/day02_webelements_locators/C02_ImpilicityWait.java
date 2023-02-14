package day02_webelements_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ImpilicityWait {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        /*
        driver ı bir web uygulamasına gönderdiğimizde o sayfanın açılması,
        rada istediğimiz işlemleri yapmak için elementleri bulması
        gibi işlemler zaman gerektirebiir.

        implicitlywait zaman isteyen işlemler için driver ın maksimum ne kadar
        bekleyeceğini belirler.

        bu 4 satır tüm classlarda ihtiyç var .
         */
    }
}
