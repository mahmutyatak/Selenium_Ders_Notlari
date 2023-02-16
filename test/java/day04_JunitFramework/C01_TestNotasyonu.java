package day04_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {
    /*
    Framework:ortak calisma cercevesi
                Hangi dosyaları nerede oluşturcağımızı belirler ve boyece
                toplu calıştımayı kolaylaştırır.
                Her framework dosya duzeni oluşturmanın yanında işlerimizi kolaylaşıran
                yeni özellikler sunmuştur.

                Junıt framework en temel test framework dur.
                bize kzzndırdıgı en önemli özellik "testnotasyonu" dur.

                TEST NOTASYONU SAYESİNDE HER BİR METHOD bagımsız olarsk calıstrılabilen
                bir test methodu olur.

                @Test notasyonu sayresinde istersek her bir test metodunu bağımsız
                çalıştırabildiğimiz gbi istenirse class level dan çalıştırıp tüm
                testlerin calişmasini sağlayabiliriz.

                Junit framework de test metodlarının hangi sıra ile calisacağını ongöremeyiz
                ve kontrol edemeyiz.


     */
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://www.wisequarter.com");
        driver.close();
    }
    @Test
    public void test02(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://www.youtube.com");
        driver.close();
    }
}
