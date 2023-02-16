package day04_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAfter {
    WebDriver driver;// burda driverı oluşturuyoeuz tüm methodlarda kullanmak icin


    @Before
    public void setup(){//ortak kullanım olanları before notasyunu ile ortak yaptık.test metodundan önce calisir.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("setup calisti");
    }
    @After
    public void teardown(){//kapatmak icin kullanılır. test metodundan sonra calısır.
        driver.close();
        System.out.println("teardown calisti");
    }

    @Test
    public void test01(){
        driver.get("https://www.wisequarter.com");
        System.out.println("test01 calisti");


    }
    @Test
    public void test02() {
        driver.get("https://www.youtube.com");
        System.out.println("test02 calisti");
    }

    //before ve after notasyonlari her test methodundan önce ve sonra calisir.
}
