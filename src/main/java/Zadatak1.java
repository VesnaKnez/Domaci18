import com.github.javafaker.Faker;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;

public class Zadatak1 {
    public static void main(String[] args) {


        String path = "imenaiprezimena.xlsx";

        try {
            readDate(path);
            writeData(path);
            writeData1(path);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }





    public static void readDate(String path) throws  FileNotFoundException,IOException {
        FileInputStream inputStream = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("imenaiprezimena");

        for (int i = 0; i < 5; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < 2; j++) {
                XSSFCell cell = row.getCell(j);
                System.out.print(cell.getStringCellValue() + " ");
            }
            System.out.println();
        }
    }
    public static void writeData(String path) throws IOException {

     FileInputStream inputStream = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("imenaiprezimena");
        Faker faker = new Faker();

        for (int i = 5; i < 10; i++) {
            XSSFRow row = sheet.createRow(i);
            XSSFCell cell = row.createCell(0);
            XSSFCell cell1 = row.createCell(1);

            cell.setCellValue(faker.name().firstName());
            cell1.setCellValue(faker.name().lastName());
            System.out.println(cell.getStringCellValue() + " " + cell1.getStringCellValue() + " ");

            System.out.println();

            FileOutputStream outputStream = new FileOutputStream("imenaiprezimena.xlsx");
            workbook.write(outputStream);
            outputStream.close();


        }
    }

    public static void writeData1(String path) throws IOException {
        FileInputStream inputStream = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("imenaiprezimena");


        for (int i = 0; i < 10; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < 2; j++) {
                XSSFCell cell = row.getCell(j);
                System.out.println(cell.getStringCellValue() + " ");
            }
            System.out.println();
        }


    }
}

