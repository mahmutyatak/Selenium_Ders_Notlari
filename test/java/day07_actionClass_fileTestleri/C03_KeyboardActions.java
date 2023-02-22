package day07_actionClass_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

public class C03_KeyboardActions extends TestBase {
    @Test
    public void test01(){
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isim=driver.findElement(By.name("firstname"));
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String fakeEmeilADress=faker.internet().emailAddress();//aynı emaili 2 kere istedigi icin kaydettik.
        //faker ile rastgele uretim yapıyoruz
        actions.click(isim).
                sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(fakeEmeilADress)
                .sendKeys(Keys.TAB).sendKeys(fakeEmeilADress)
                .sendKeys(Keys.TAB).sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)//TEK BASİSTA GECMEDİ 2 KERE TAB A BASLADIK
                .sendKeys("20")
                .sendKeys(Keys.TAB).sendKeys("Sub")
                .sendKeys(Keys.TAB).sendKeys("1989")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT)//CİSİYET SECİMİ
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        bekle(5);
        //4- Kaydol tusuna basalim
    }
}
