package day06_window_iframe_actionsclass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utulities.TestBase;

public class C01_BasicAuthentication extends TestBase {

    @Test
    public void test01(){
        //1- Bir class olusturun : BasicAuthentication
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //ilk gittigimizde direk şifre istiyor o yuzden once kullanıcı adi ve sifreyi yazıyoruz
        //kullnaıcı adı ve sifrenin bize nasıl yazılacagını önceden söylemesi lazım.

        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //Html komutu : https://username:password@URL
        // Username    : admin
        //  password     : admin
        //4- Basarili sekilde sayfaya girildigini dogrulayin

        String actualGirisYazisi=driver.findElement(By.tagName("p")).getText();
        String expectedIcerik="Congratulations";
        Assert.assertTrue(actualGirisYazisi.contains(expectedIcerik));
        bekle(3);
        //basarili bir sekilde gittigini cıkan yazıyı kontrol ederek yaptık.
    }
}
