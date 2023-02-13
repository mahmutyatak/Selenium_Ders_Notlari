package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriversMethodlari {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();//tam ekran yapıyor.
        // bir seyleri yonetmek icin manage methodu. window pencere için tam ekrsn max.olan
        //************
        // amazon ana sayfaya gidin gittiğiniz sayfadaki title ve url i yazdırın.
        // amazon ana sayfaya gittiğinizi test edin

        driver.get("https://www.amazon.com");// anasayfaya gitme
        System.out.println("URL :"+driver.getCurrentUrl());// url yi yazdırma.//https://www.amazon.com/
        System.out.println("Baslik :"+driver.getTitle());// başlığı yazdırma.
        // Baslik :Amazon.com. Spend less. Smile more.


        // test expected result ile actual result ın karşılaştırılmasıdır.
        // amazona anasayfaya gitme olayı
        //ornegın url amazon içeriyorsa diyebiliriz
        String expectedIcerik="amazon";
        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.contains(expectedIcerik)){// amazon ansayfaya gittiyse
            System.out.println("Test PASSED");//Test PASSED
        }else {
            System.out.println("Test FAİLED");
        }

    }
}
