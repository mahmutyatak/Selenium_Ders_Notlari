package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();//tam ekran yapma.
        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getWindowHandle());//CDwindow-A41BBE52613CE337BE7890A448EE9850
        //CDwindow-459226A222B7EE25DA1798DAD166B31F ikinic yazdırdığımızda bunu yazdırdı.
        //get window handle selenium tarafından her driver sayfasi için üretilen
        // unique handle değerini döndürür.
        //get window handles ise test sırasında birden fazla sayfa açılmışsa bir set olarak
        //tüm sayfaların windor handle değerlerini döndürür.

        System.out.println(driver.getPageSource());//sayfadaki kodların tamamını getirir.

        // sayfa kodları "2 hours weekly meeting with the team" içeriyormu test edin.

        String expectedIcerik="2 hours weekly meeting with the team";
        String actualSayfaKodlari=driver.getPageSource();

        if (actualSayfaKodlari.contains(expectedIcerik)){
            System.out.println("Passed");//Passed döndürdü.
        }else {
            System.out.println("Failed");
        }
        driver.quit();
        //close ve quit ikiside sayfa kapatmak için kullanılır.
        // close sadece bir sayfa kapatırken quit test sırasında açılan tüm sayfaları kapatır.
    }
}
