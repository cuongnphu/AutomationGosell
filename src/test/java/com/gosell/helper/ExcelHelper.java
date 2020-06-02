package com.gosell.helper;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;



public class ExcelHelper {

    /**
     * @param fileName
     * @param sheetName
     * @param numberColumn
     * @param numberRow
     * @return
     */
    public static String readExcelData(String fileName, String sheetName, int numberColumn, int numberRow) {
        String cellValue = null;
        try {
            // Read the spreadsheet
            FileInputStream fis = new FileInputStream(fileName);

            // Using XSSF for xlsx format, for xls use HSSF
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            cellValue = String.valueOf(sheet.getRow(numberRow).getCell(numberColumn).getStringCellValue());
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cellValue;
    }

    /**
     * @param fileName
     * @param sheetName
     * @param numberColumn
     * @param numberRow
     * @param data
     */
    public static void updateExcelData(String fileName, String sheetName, int numberColumn, int numberRow, String data) {
        try {
            //Read the spreadsheet that needs to be updated
            FileInputStream fis= new FileInputStream(fileName);

            // Using XSSF for xlsx format, for xls use HSSF
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            sheet.getRow(numberRow).getCell(numberColumn).setCellValue(data);

            //write this workbook in excel file.
            FileOutputStream fos = new FileOutputStream(fileName);
            workbook.write(fos);
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
