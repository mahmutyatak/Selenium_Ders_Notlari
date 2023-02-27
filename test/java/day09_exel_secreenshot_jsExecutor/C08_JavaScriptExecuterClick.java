package day09_exel_secreenshot_jsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utulities.TestBase;

public class C08_JavaScriptExecuterClick extends TestBase {

    @Test
    public void test01(){
        //wiswquarter anasayafaya gidelim
        driver.get("https://www.wisequarter.com");

        //java test otomation a kadar insin
        WebElement otomasyonElementi=driver.findElement(By.xpath("(//img[@alt='Automation Engineer'])[1]"));

        bekle(2);
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",otomasyonElementi);
        // ve fotografı tıklasın.
        bekle(2);
        jse.executeScript("arguments[0].click();",otomasyonElementi);
        bekle(2);
        // ekrana "JUnit bitti" yazdirin.
        jse.executeScript("alert('JUnit bitti')");
        bekle(2);
    }
}
