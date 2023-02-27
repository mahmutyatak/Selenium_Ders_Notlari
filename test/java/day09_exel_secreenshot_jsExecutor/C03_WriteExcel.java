package day09_exel_secreenshot_jsExecutor;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteExcel {

    @Test
    public void test01() throws IOException {
        //2) Yeni bir test method olusturalim writeExcelTest()
        //3) Adimlari takip ederek 1.satira kadar gidelim
        String dosyaYolu="src/test/java/day09_exel_secreenshot_jsExecutor/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        //4)  1. satir 4.hucreye yeni bir cell olusturalim
        Sheet sayfa1=workbook.getSheet("Sayfa1");
        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        sayfa1.getRow(0).createCell(4).setCellValue("Nufus");
        //1. sayfadaki 0 ıncı satırda 4. hucreye bir yer olusturup nufus olarak kaydettik.
        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        sayfa1.getRow(1).createCell(4).setCellValue("1500000");
        //7) 10.satir nufus kolonuna 250000 yazdiralim
        sayfa1.getRow(9).createCell(4).setCellValue("250000");
        //8) 15.satir nufus kolonuna 54000 yazdiralim
        sayfa1.getRow(14).createCell(4).setCellValue("540000");
        sayfa1.createRow(3);
        sayfa1.getRow(3).createCell(0).setCellValue("Algeria");
        sayfa1.getRow(3).createCell(1).setCellValue("Aljiers");
        sayfa1.getRow(3).createCell(2).setCellValue("Cezayir");
        sayfa1.getRow(3).createCell(3).setCellValue("Cezayir");
        //9) Dosyayi kaydedelim
        FileOutputStream fos=new FileOutputStream(dosyaYolu);//kaydetmek icin
        workbook.write(fos);
        //10)Dosyayi kapatalim
        fis.close();
        fos.close();
        workbook.close();
    }
}
