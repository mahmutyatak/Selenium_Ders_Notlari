package day04_JunitFramework;

import org.junit.Assert;
import org.junit.Test;

public class C06_Assertions {

    /*
    jUnıt TESTLERİN past veya failed olduguna kodları calıstırıken sorun olusup
    olusmamasına göre karar verir.
    Assert methodlari testin failed veya passed oldugunu sonucta gösterir.
     */
    String str1="Ali";
    String str2="ali";

    @Test
    public void test01(){
        //str1 in str2 ye esit oldugunu test edin

        //Assert.assertEquals(str1,str2);//once expected olan sonra actual olan yazilir
        // istersek basına mesaj da yazabiliriz
        Assert.assertEquals("karsilastirilan degerler farkli",str1,str2);
       // if (str1.equals(str2)){
         //   System.out.println("esitlik testi PASSED");
        //}else {
          //  System.out.println("esitlik testi FAİLED");
        //}

    }
    @Test
    public void test02(){
        //str1 in "A" harfini icerdigini test edin
        Assert.assertTrue("str1 istenen harfi icermiyor",str1.contains("A"));//yazılan aciklama failed olma durumunda calisir
   // if (str1.contains("A")){
     //   System.out.println("olumlu test PASSED");
    //}else {
      //  System.out.println("olumlu test FAİLED");
    //}

    }
    @Test
    public void test03(){
        //str 2 nin c harfini icermedigini test edin
        Assert.assertFalse(str2.contains("c"));//Assertfalse olumsuz durumlar icin.
    //if (!str2.contains("c")){
      //  System.out.println("negatif test PASSED");
    //}else {
      //  System.out.println("negatif test FAİLED");
    //}

    }
}
