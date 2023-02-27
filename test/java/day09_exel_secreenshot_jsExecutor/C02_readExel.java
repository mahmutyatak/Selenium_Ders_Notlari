package day09_exel_secreenshot_jsExecutor;

import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class C02_readExel {
    @Test
    public void test01() throws IOException {
        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        String dosyaYolu="src/test/java/day09_exel_secreenshot_jsExecutor/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
/*
getshhetlerin icine excel sayfasinde sayfa ismine verilen ad kullanılır.
 */
        System.out.println(workbook.//workbook olusturduktan sonra digerlerini direk yapabiliriz.
                getSheet("Sayfa1").
                getRow(0).
                getCell(1));
        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenData=workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();//STRİNGE ATADIK BU HALİYLE CELL HUCRESİ

        System.out.println(istenenData);
        // - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String expectedData="Kabil";
        String actualData=workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();//index hesabına gore gidiyoruz.
        Assert.assertEquals(expectedData,actualData);
        // - Satir sayisini bulalim
        System.out.println("satir sayisi :"+(workbook.getSheet("Sayfa1").getLastRowNum()+1));//indexi verdigi icin + 1 dedik.
        // -sayfa2 deki satır sayisi ve  Fiziki olarak kullanilan satir sayisini bulun
        System.out.println("sayfa2 deki satir sayisi :"+workbook.getSheet("Sayfa2").getLastRowNum()+1);//24
        System.out.println("fiziki kullanılan satir sayisi :"+workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());//8 BOS SATİRLARİ SAYMADİ.
        // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        Map<String,String> ulkelerMap=new TreeMap<>();
        int sonSatirIndex=workbook.getSheet("Sayfa1").getLastRowNum();
        for (int i = 1; i <=sonSatirIndex ; i++) {//basligi almamak icin bir den basladık
            String key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            ulkelerMap.put(key,value);
        }
        System.out.println(ulkelerMap);
        Set<Map.Entry<String,String>> ulkelerEntrySet=ulkelerMap.entrySet();
        for (Map.Entry<String,String> each: ulkelerEntrySet
             ) {
            System.out.println(each);
        }
    }
}
