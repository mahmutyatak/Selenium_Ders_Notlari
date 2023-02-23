package Day08_ExplicitylWaits_cookies_WebTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_ExpilicitlyWait {
    @Test
    public void test01() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        //amazon anasayfaya gidip
        driver.get("https://www.amazon.com");
        //aramakutusu clicable oluncaya kadar bekleyin nutella icin arama yapın.

        /*
        Explicitly wait icin
        1-Wait objesi olustur.
        2-MUMKUNSE WEBELEMENTİ locate et.
        3-wait objesini kullanarak istenen gorev icin bekle.
         */
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        //bu sefer elemnti direk locate edebiliyoruz.
        wait.until(ExpectedConditions.elementToBeClickable(aramaKutusu));

        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        Thread.sleep(5);
        driver.close();
    }
}
