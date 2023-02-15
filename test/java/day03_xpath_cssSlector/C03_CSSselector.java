package day03_xpath_cssSlector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C03_CSSselector {
    public static void main(String[] args) {
        /*
        1- bir class olusturun
2- https://www.amazon.com/ adresine gidin
3- Browseri tam sayfa yapin
4- Sayfayi “refresh” yapin
5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
6- Gift Cards sekmesine basin
7- Birthday butonuna basin
8- Best Seller bolumunden ilk urunu tiklayin
9- Gift card details’den 25 $’i secin
10-Urun ucretinin 25$ oldugunu test edin
11-Sayfayi kapatin
         */
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//span[@class='a-button-inner']")).click();
        String expecteIcerik="Spend less";
        String actualIcerik=driver.getTitle();

        if (actualIcerik.contains(expecteIcerik)){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }

        driver.findElement(By.xpath("(//a[@tabindex='0'])[8]")).click();

        driver.findElement(By.cssSelector("a[aria-label='Birthday']")).click();

        driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[1]")).click();

        driver.findElement(By.cssSelector("#gc-mini-picker-amount-1"));

        WebElement ucretElementi=driver.findElement(By.xpath("//button[@value='25']"));
        String expectedUcret="25$";
        String actualUcret=ucretElementi.getText();

        if (expectedUcret.equals(actualUcret)){
            System.out.println("ucret testi passed");
        }else {
            System.out.println("ucret testi failed"+actualUcret);
            driver.close();
        }
    }
}
