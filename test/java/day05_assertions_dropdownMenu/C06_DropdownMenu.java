package day05_assertions_dropdownMenu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utulities.TestBase;
import utulities.TestBaseClass;

import java.util.List;

public class C06_DropdownMenu extends TestBase {
    /*
    ● https://the-internet.herokuapp.com/dropdown adresine gidin.
 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
 4.Tüm dropdown değerleri(value) yazdırın
 5. Dropdown’un boyutunun 4 oldugunu test edin.
     */
    @Test
    public  void test01(){
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement ddm=driver.findElement(By.id("dropdown"));

        Select select=new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());//bi önce yazilan geliyor get

        bekle(2);
        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");//value degerine bakarız.
        System.out.println(select.getFirstSelectedOption().getText());//son secilen elementi getir anlamına geliyor yazdırmak icin
        bekle(3);

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        bekle(2);
        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> optionElementListesi=select.getOptions();
        System.out.println("========");
        for (WebElement each:optionElementListesi
             ) {
            System.out.println(each.getText());
        }
        int expectedBoyut=4;
        int actualBoyut=optionElementListesi.size();

        Assert.assertEquals(expectedBoyut,actualBoyut);

    }
}
