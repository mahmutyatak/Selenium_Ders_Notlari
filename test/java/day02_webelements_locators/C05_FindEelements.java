package day02_webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_FindEelements {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //AMAZON ANA SAYFAYA GİDİN
        driver.get("https://www.amazon.com");
        // ARAMA KUTUSUNA JAVA YAZIP ARATIN
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java");
        aramaKutusu.submit();
        //ARAMA SONUCLARINDA CIKAN RESİMLERDEKİ YAZILARI YAZDIRIN.
        List<WebElement> aramasonuclariEelementList=driver.findElements(By.className("sg-col-inner"));
        System.out.println(aramasonuclariEelementList.size());//86

        //bu 86 elemanı yazdıralım
        //web elementler obje oldukları için direk yazdıramayız referans döndürür.
        //for each loop la yapabiliriz.
        System.out.println(aramasonuclariEelementList);//referansdöndürdü.
        int elementno=1;
        for (WebElement each:aramasonuclariEelementList
             ) {
            System.out.println(elementno+"---"+each.getText());
            elementno++;
        }

        Thread.sleep(3000);
        driver.close();
    }
}
