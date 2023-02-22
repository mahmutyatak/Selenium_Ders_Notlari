package day07_actionClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

public class C01_moveToElement extends TestBase {
    @Test
            public void test01(){
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //mouse’u bu menunun ustune getirin
        Actions actions=new Actions(driver);
        WebElement element=driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        actions.moveToElement(element).perform();

        //3- “Create a list” butonuna basin
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();
        bekle(2);
        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        String expected="Your Lists";
        String actualYazi=driver.findElement(By.xpath("(//span[@class='nav-a-content'])[1]")).getText();
        Assert.assertEquals(expected,actualYazi);

    }

}
