package day03_xpath_cssSlector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_XpathText {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        driver.findElement(By.xpath("//*[text()='Add Element']")).click();

        WebElement deleteButtonElement=driver.findElement(By.xpath("//*[text()='Delete']"));

        if (deleteButtonElement.isDisplayed()){
            System.out.println("Passed");
        }else {
            System.out.println("failed");
        }

        deleteButtonElement.click();

        WebElement addRemoveEelemnti=driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));

        if (addRemoveEelemnti.isDisplayed()){
            System.out.println(" ADD Passed");
        }else {
            System.out.println(" ADD failed");
        }
        Thread.sleep(3000);
        driver.close();

    }
    }

