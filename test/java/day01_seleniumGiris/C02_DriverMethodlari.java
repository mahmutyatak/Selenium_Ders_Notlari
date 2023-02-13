package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethodlari {
    public static void main(String[] args) throws InterruptedException {
        /*
        jar dosyalarını yükleyerek selenium u kullanılır hale getirdik.
        ancak her bir classın hangi browser ile çalışmasını istiyorsak
        o browser ile ilgili driwerı class da tanımlamamız lazım.

        BROWSER ile ilgili tercihimiz doğrultusunda ilgili ayarları yapmak için
        java dai sistem classından setproperty kullanılır.
        methoda 2 parametre ekleyeceğiz herkes için aynı webdriver.chrome.driver
        2. parametre bu driverın dosya yolu herkesin biligisayarındda farklı olabilir
        windows bilgisaarlarda sonunda .exe yazılmalıddır.mac lerde . exe olmaz.
         */
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        //İSTENEN SAYFAYA GİTMK İÇİN
        driver.get("https://www.wisequarter.com");//https olması lazım www olmasa da olur.
        Thread.sleep(3000);// kac sanşye açık kalacağını belirleriz.
        driver.close();//kapatmak için kullanılır.

    }
}
