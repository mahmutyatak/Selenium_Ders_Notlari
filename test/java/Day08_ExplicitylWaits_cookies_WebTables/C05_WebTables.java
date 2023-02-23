package Day08_ExplicitylWaits_cookies_WebTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

import java.util.List;

public class C05_WebTables extends TestBase {
    @Test
    public void test01(){
        //1.“https://www.amazon.com” adresine gidin
    driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        //3.Web table tum body’sini yazdirin
        WebElement tumbody=driver.findElement(By.xpath("//tbody"));
        System.out.println(tumbody.getText());
        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> liste=driver.findElements(By.xpath("//tbody/tr"));
        System.out.println(liste.size());
        Assert.assertEquals(10,liste.size());
        //5.Tum satirlari yazdirin
        int satirno=1;
        for (WebElement each:liste
             ) {
            System.out.println(satirno+"- "+each.getText());
            satirno++;
        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        //tbody herhangi bir satıra gittik ondan sonra o satır altındaki dataları acagız.
        List<WebElement> ucuncuSatirDatalarList=driver.findElements(By.xpath("//tbody/tr[3]/td"));
        Assert.assertEquals(13,ucuncuSatirDatalarList.size());
        //7. 5.sutunu yazdirin
        //bu defa hangi satır oldugu onemli degil datanın 5 incisi olsun
        List<WebElement> besinciStunListi=driver.findElements(By.xpath("//tbody/tr/td[5]"));
        System.out.println("besinci sutun ==========");
        satirno=1;
        for (WebElement each:besinciStunListi
             ) {
            System.out.println(satirno+"- "+each.getText());
            satirno++;
        }
        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        System.out.println("=====================================");
        System.out.println("istenen data :"+getData(3, 5));
        bekle(2);
        //9. 7. satırın 9. datasının Shoes icerdigini test edin
        String expected="Shoes";
        String actualData=getData(7,9);
        Assert.assertTrue(actualData.contains(expected));

    }
    public  String getData(int satirNo,int sutunNO){
        //3.satır besinci sutundaki bilgiyi yazdırın

        String dataXpath="//tbody/tr["+satirNo+"]/td["+sutunNO+"]";
        String istenenData=driver.findElement(By.xpath(dataXpath)).getText();
        return istenenData;
    }
}
