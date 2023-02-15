package day03_xpath_cssSlector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Xpath {
    public static void main(String[] args) throws InterruptedException {
        /*
        1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
2- Add Element butonuna basin
3- Delete butonu’nun gorunur oldugunu test edin
4- Delete tusuna basin
5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
         */
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

        WebElement deleteButtonElement=driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

        if (deleteButtonElement.isDisplayed()){
            System.out.println("Passed");
        }else {
            System.out.println("failed");
        }

        deleteButtonElement.click();

        WebElement addRemoveEelemnti=driver.findElement(By.xpath("//h3"));

        if (addRemoveEelemnti.isDisplayed()){
            System.out.println(" ADD Passed");
        }else {
            System.out.println(" ADD failed");
        }
        Thread.sleep(3000);
        driver.close();

    }
}
