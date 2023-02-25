package Day08_ExplicitylWaits_cookies_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utulities.TestBase;

import java.util.List;

public class C06_WebTables extends TestBase {
    @Test
    public void test01(){
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        // 2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslik=driver.findElements(By.xpath("//div[@class='rt-tr']"));
        int siraNo=1;
        for (WebElement each:baslik
             ) {
            System.out.println(each.getText());

        }
        // 3. 3.sutunun basligini yazdirin
        System.out.println(driver.findElement(By.xpath("//div[text()='Age']")).getText());
        // 4. Tablodaki tum datalari yazdirin
        System.out.println("===========================");
        List<WebElement> tumbody=driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td']"));
        for (WebElement each:tumbody
             ) {
            System.out.println(siraNo+"- "+each.getText());
            siraNo++;
        }
        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        List<WebElement> birinciSatir=driver.findElements(By.xpath("//div[@class='rt-tr-group'][1]//div[@class='rt-td']"));
        List<WebElement> ikiniciSatir=driver.findElements(By.xpath("//div[@class='rt-tr-group'][2]//div[@class='rt-td']"));
        List<WebElement> ucuncuSatir=driver.findElements(By.xpath("//div[@class='rt-tr-group'][3]//div[@class='rt-td']"));
        System.out.println("Data sayisi :"+(birinciSatir.size()+ikiniciSatir.size()+ucuncuSatir.size()));
        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirSayisi=driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("=======satir sayisi=======");
        System.out.println(satirSayisi.size());
        // 7. Tablodaki sutun sayisini yazdirin
        List<WebElement> sutunSayisi=driver.findElements(By.xpath("//div[@class='rt-tr-group'][1]//div[@class='rt-td']"));
        System.out.println("================sutun sayisi====");
        System.out.println(sutunSayisi.size());
        // 8. Tablodaki 3.kolonu yazdirin
        System.out.println("====3.kolon=====");
        siraNo=1;
        List<WebElement> ucuncuKolon=driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][3]"));
        for (WebElement each:ucuncuKolon
             ) {
            System.out.println(siraNo+"- "+each.getText());
            siraNo++;
        }
        // 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
        WebElement maas=driver.findElement(By.xpath("//div[@class='rt-tr-group'][3]//div[@class='rt-td'][5]"));
        System.out.println(maas.getText());
        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

        ////div[@class='rt-tbody']//div[@class='rt-tr-group']//div[@class='rt-td']
        System.out.println(data(1, 5));
    }
    public String data(int satir,int sutun){
        String veri=driver.findElement
                        (By.xpath("//div[@class='rt-tr-group']["+satir+"]//div[@class='rt-td']["+sutun+"]")).getText();
        return veri;
    }
}
