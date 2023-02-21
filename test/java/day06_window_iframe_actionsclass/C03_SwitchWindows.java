package day06_window_iframe_actionsclass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utulities.TestBase;

public class C03_SwitchWindows extends TestBase {
    @Test
    public void test01(){
        //amazon ana sayfaya gidip arama kutusunun erisilebilir olduğunu test edin
            driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());
        String amazonWindowHandleDegeri=driver.getWindowHandle();
            bekle(2);
        // yeni bir tab olarak wisequarter.com a gidin url in wise quarter icerdigini test edin.
        /*once yini bir tab olusturup driver ı  oraya
        gecirmeliyiz yani switch.
         */
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        bekle(2);
        //url in wise quarter icerdigini test edin.
        String expectedUrl="wisequarter";
        String actaulUrl=driver.getCurrentUrl();
        Assert.assertTrue(actaulUrl.contains(expectedUrl));
        String wiseWindowHndleDegeri=driver.getWindowHandle();
        // amazonun acik oldugu tab a geri donup
        /*
        Daha once acılmıs olan bir windowa gecis yapmak icin o sayfnın
        windowHandle degerine ihtiyacımız var.
        Testimiz boyle bir gorevi iceriyorsa o sayfa da iken
        windowHandle değerini alıp kayıt yapmalıyız.
         */
        driver.switchTo().window(amazonWindowHandleDegeri);//amazona geri donduk

        //nutella icin arama yapin sonuclarin nutella icerdigini test edin
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        String actualSonucYazisi=driver.
                findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText();
        String expectedIcerik="Nutella";
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
        // yeni bir window olarak youtube gidin url in youtube icerdigini test edin
            driver.switchTo().newWindow(WindowType.WINDOW);
            driver.get("https://www.youtube.com");
            String expectedYoutubeUrl="youtube";
            String actualYoutubeUrl=driver.getCurrentUrl();
            Assert.assertTrue(actualYoutubeUrl.contains(expectedYoutubeUrl));

        // wisequarterın acık oldugu sayfaya dönün ve title ın WiseQuarter İCERDİGİNİ test edin
        driver.switchTo().window(wiseWindowHndleDegeri);
        String expectedWiseTitle="Wise Quarter";
        String actualWİseTitle=driver.getTitle();
        Assert.assertTrue(actualWİseTitle.contains(expectedWiseTitle));

        bekle(3);
    }

}
