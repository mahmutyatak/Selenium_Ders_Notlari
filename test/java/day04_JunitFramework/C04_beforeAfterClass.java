package day04_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_beforeAfterClass {

    //3 test metodu olusturun
    //1. de amazon anasayfasına gidip amazona gittiginizi test edin
    //2. de nutella aratıp sonucların nutella icerdigini test edin
    //3. ilk isme tıklyın  urun isminde nutella oldugunu test edin.

    // EGER HER BİR TEST METODU İCİN DRİVER OLUSTURUP SONUNDA KAPATMAMIZ GEREKMİYORSA
    // CLASSIN BASINDA BİR KEZ DRİVER OLSTURUP CLASSIN SONUNDA DRİVER I KAPATABİLİRİZ.
    //Bunu before after değil BeforeClass AfterClass notasyonlari ile yaparız
    //sıra ile testleri yapabilmek icin test isimlerini test01 den baslatamlıyız.yoksa sıra ile calismayabilir.

    //BEFORE CLAASS VE AFTERCLASS notasyonu kulanan metodlar static olmalıdır.
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");

        String expecteIcerik="amazon";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expecteIcerik)){
            System.out.println("Amazon testi1 PASSED");
        }else {
            System.out.println("url amzon icermiyor test1 FAİLED");
        }
    }
    @Test
    public void test02(){
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement aramaSonucElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        //yukaridaki aramaz yazısındaki nutella yazısını sorguladık.
        String expectedIcerik="Nutella";
        String actualSonucYazisi=aramaSonucElementi.getText();

        if (actualSonucYazisi.contains(expectedIcerik)){
            System.out.println("Nutella testi PASSED");
        }else {
            System.out.println("Nutella testi failed");
        }
    }
    @Test @Ignore//Test ignored. YAZISI CIKTI ignore ettigimiz zaman yoksaydı testi ve acıklamasını bu sekilde yazdi.
    public void test03(){
      WebElement ilkurun=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
      ilkurun.click();

      WebElement urunisimElemnti=driver.findElement(By.xpath("//span[@id='productTitle']"));

      String expectedIcerik="Nutella";
      String actualUrunIsmi=urunisimElemnti.getText();

      if (actualUrunIsmi.contains(expectedIcerik)){
          System.out.println("ilk urun testi PASSED");
      }else {
          System.out.println("ilk urun testi FAİLED");
      }
    }
}
