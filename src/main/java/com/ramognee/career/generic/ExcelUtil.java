package com.ramognee.career.generic;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelUtil extends BaseTestClass {

    public void writeDataExcelSheet(ArrayList<String> stationName) {
        String dest = "src/main/resources/ActualStationName.xlsx";
        XSSFWorkbook myWorkBook;
        Sheet mySheet;
        myWorkBook = new XSSFWorkbook();
        mySheet = myWorkBook.createSheet();
        Row myRow;
        Cell myCell;

        int cellNum = 0;

        for (int i = 0; i <= stationName.size(); i++) {
            if (i == 0) {
                myRow = mySheet.createRow(i);
                myCell = myRow.createCell((short) cellNum);
                myCell.setCellValue("Actual_StationName");
            } else {
                myRow = mySheet.createRow(i);
                myCell = myRow.createCell((short) cellNum);
                myCell.setCellValue(stationName.get(i - 1));
            }
        }

        try {
            FileOutputStream out = new FileOutputStream(dest);
            myWorkBook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> readDataExcelSheet(String fileName){
        ArrayList<String> data = new ArrayList<String>();
        FileInputStream fis;
        Workbook myWorkBook;
        Sheet mySheet;
        try {
            fis = new FileInputStream(fileName);
            myWorkBook=WorkbookFactory.create(fis);
            mySheet = myWorkBook.getSheetAt(0);
            int size = mySheet.getLastRowNum();

            for (int i = 1; i < size; i++) {
                String str = mySheet.getRow(i).getCell(0).getStringCellValue();
                data.add(str);

            }
            myWorkBook.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
