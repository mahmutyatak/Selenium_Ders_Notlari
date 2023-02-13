package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_DriverNavigateMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriwer.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();//tam ekran

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");
        //yeniden amazon anasayafaya gidin

        driver.navigate().back();// geri siteye gelmek icin.windows daki geir tusu
        //wiseuarter ansayfaya dönün
        driver.navigate().forward();//ileri siteye gitmek icin

        //navigate.to driver.get ile aynı işlemi yapar.
        driver.navigate().to("https://www.youtube.com");

        //
        driver.navigate().refresh();//sayfayi yeniler.
        driver.quit();
    }
}
