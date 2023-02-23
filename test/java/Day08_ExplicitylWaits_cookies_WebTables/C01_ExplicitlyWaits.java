package Day08_ExplicitylWaits_cookies_WebTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_ExplicitlyWaits {

    @Test
    public void test01(){
        /*
        İmplicitlyWait test yaparken ihtiyacımız olan beklemelerin cogunu halleder.
        Nadiren de olsa bazı islemler icin İmplicitlyWait icin tanımlanan sureden daha fazla
        zamana ihtiyac olabilir.

        ExpilicitlyWait bir webelement uzerinde gerceklesecek tek bir gorev icin tanimlanir.

        Bunun icin hem webelement tanimlanmali, hem de gorev
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //waiti kapattık.
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        //expilitcitlyWait kullanacaksak
        //A- BİR WAİT OBJESİ olusturacagız.
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));

        //B- EGER kullnacagımız Webelement locate edilebilir ise lOCATE yapalım.
        //WebElement goneElementi=driver.findElement(By.xpath("//p[@id='message']"));
        //C-EGER LOCATE ETMEMİZ icin zamana ihtiyac var ise o zman locate ve gorev tanımalamayı tek satırda yapıyoruz.
        WebElement goneElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        Assert.assertTrue(goneElementi.isDisplayed());
        driver.close();
    }
}
