package day07_actionClass_fileTestleri;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C09_Waits {

    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //waiti kapattık.
       //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement goneElementi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(goneElementi.isDisplayed());
        driver.close();
        /*
        implicity wait kapalı iken failed verdi acık olduğunda passed yaptı.
        ThreadSleep kodların calısmasını durdurur. implicity wait ise o saniyeye kadar bulmaya calisir.
        iplicitywait maximum yazan süreyi her bir locate icin bekler fakat erken bulursa devam eder.
        Bazı sitelerde gec acılma oldugu icin implicityWait kullanmak gerekir.
         */
    }
}
