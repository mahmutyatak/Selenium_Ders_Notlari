package Day08_ExplicitylWaits_cookies_WebTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utulities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {
    @Test
    public void test01(){
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSeti=driver.manage().getCookies();
        int sıraNo=1;
        for (Cookie each:cookiesSeti
             ) {
            System.out.println(sıraNo+"- "+each.toString());
            sıraNo++;
        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookiesSeti.size()>5);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualvalue=driver.manage().getCookieNamed("i18n-prefs").getValue();//isimlegetirm metodunda bize cookie donduruyor
                                                                 //get value digerek degerini aldık.
        String expectedValue="USD";
        Assert.assertEquals(expectedValue,actualvalue);
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie benimcookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(benimcookie);//add cokkie yapmadan once bir cookie istedi bizden ve olusturduk
        cookiesSeti=driver.manage().getCookies();//yeniden atama yaptık.
        sıraNo=1;
        for (Cookie each:cookiesSeti
        ) {
            System.out.println(sıraNo+"- "+each.toString());
            sıraNo++;
        }

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        String actaulValueBnim=driver.manage().getCookieNamed("en sevdigim cookie").getValue();
        String expectedValueBenim="cikolatali";
        Assert.assertEquals(expectedValueBenim,actaulValueBnim);
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        //olmayan bir eleamanı test edemem
        //bunun yerine foreachloop ile ele aldıgımız her cookie kontrol edelim
        //ismi skin olan varsa test failed
        System.out.println("==========================");
        cookiesSeti=driver.manage().getCookies();//yeniden atama yaptık.

        for (Cookie each:cookiesSeti
        ) {
            Assert.assertFalse(each.getName().equals("skin"));

        }
        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiesSeti=driver.manage().getCookies();
        Assert.assertTrue(cookiesSeti.size()==0);
    }
}
