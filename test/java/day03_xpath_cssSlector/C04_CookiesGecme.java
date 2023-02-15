package day03_xpath_cssSlector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CookiesGecme {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.google.com");

        //cookies i kabul ederek kapatma
       // driver.findElement(By.xpath("//div[text()=‘Accept all’]")).click();
        //HOCADA CIKTI BENDE CIKMADI O YÜZDEN GECERSİZ KILDIM
        // ARAMA CUBUGUNA JAVA YAZIP BULUNAN SONUC SAYISININ 100000 DEN COK OLDUGUNU TEST EDİN

        WebElement aramaCubugu=driver.findElement(By.xpath("//input[@name='q']"));
        aramaCubugu.sendKeys("java"+ Keys.ENTER);

        WebElement sonucSyiELemnti=driver.findElement(By.xpath("//div[@id='result-stats']"));

        System.out.println(sonucSyiELemnti.getText());//Yaklaşık 1.530.000.000 sonuç bulundu (0,33 saniye)
        String sonucYazisi=sonucSyiELemnti.getText();
        String [] sonucYaziArr=sonucYazisi.split(" ");

        String sonucSayisiStr=sonucYaziArr[1];
        sonucSayisiStr=sonucSayisiStr.replaceAll("\\D","");

        int actualSonucSayisi=Integer.parseInt(sonucSayisiStr);
        int expectedSonucSayisi=100000;

        if (actualSonucSayisi>expectedSonucSayisi){
            System.out.println("Arama sonuc sayisi testi Passed");
        }else {
            System.out.println("Arama sonuc sayisi testi Failed");
        }

        driver.close();
    }
}
