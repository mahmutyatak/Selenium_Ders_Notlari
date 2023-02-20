package day05_assertions_dropdownMenu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utulities.TestBase;

public class C05_TestBaseIlkTest extends TestBase {
    // amazona gidelim
    // nutella aratalım
    //sonuclarin nutella icerdigini test edelim

    @Test
    public void amazonTest(){
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);

        WebElement actualSonucYaziElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedIcerik="Nutella";
        String actualSonucYazisi=actualSonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
    }
}
