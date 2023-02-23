package Day08_ExplicitylWaits_cookies_WebTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C03_ExplitcitlyWait {
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        //2. Bir metod olusturun : isEnabled()
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox=driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());
        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        /*
        explicityWait kullanacaksak
        1-Wait objesi olustur.
         */
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(45));
        //2-MUMKUNSE KULLANILACAK WEBELEMENTİ LOCATE ET.TEXT BOX I LOCATE ETTİK
        //3WAİT OBJESİ KULLANARAK BEKLEYİN
        wait.until(ExpectedConditions.elementToBeClickable(textBox));
        Assert.assertTrue(textBox.isEnabled());//wait yapmadıgımız icin hata verdi.
        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnableElementi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsEnableElementi.isDisplayed());
        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
                Assert.assertTrue(textBox.isEnabled());//wait yapmadıgımız icin hata verdi.
        driver.close();
    }
}
