package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_DriverManageMethodalari {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("maximize size :"+driver.manage().window().getSize());//maximize size :(1552, 840)
        System.out.println("maximize position :"+driver.manage().window().getPosition());//(-8, -8)

        driver.manage().window().fullscreen();

        System.out.println("fullscreen size :"+driver.manage().window().getSize());//fullscreen size :((1536, 864))
        System.out.println("fullscreen position :"+driver.manage().window().getPosition());// fullscren position :(0,0)
    }
}
