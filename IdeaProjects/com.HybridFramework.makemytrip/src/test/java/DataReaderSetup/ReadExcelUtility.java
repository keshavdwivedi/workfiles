package DataReaderSetup;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadExcelUtility {

    XSSFWorkbook wb = null;
    XSSFSheet sheet = null;
    XSSFRow row = null;
    XSSFCell cell = null;
    String excelfilePath;
    FileInputStream fis = null;

    public ReadExcelUtility(String filepath, String sheetname) {

        try {
            this.excelfilePath = filepath;
            fis = new FileInputStream(filepath);
            wb = new XSSFWorkbook(fis);
            sheet = wb.getSheet(sheetname);
            fis.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    //method to fetch data from the cell based on type of value in cell.

    public String getcellData(String sheetname, int rowNum, int colNum) {

        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);
        int index = wb.getSheetIndex(sheetname);

        if (rowNum <= 0) {
            return "";
        } else if (index == -1) {
            return "";
        } else if (cell == null) {
            return "";
        } else if (row == null) {
            return "";
        } else if (cell.getCellTypeEnum() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
            String cellValue = String.valueOf(cell.getNumericCellValue());
            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                DateFormat df = new SimpleDateFormat("dd/mm/yy");
                Date date = cell.getDateCellValue();
                cellValue = df.format(date);
            }
            return cellValue;
        } else if (cell.getCellTypeEnum() == CellType.BLANK) {
            return "";
        } else return String.valueOf(cell.getBooleanCellValue());
    }

    //this method is used to get count of total rows

    public int getRowcount() {

        int row = sheet.getLastRowNum() + 1;
        return row;
    }

    //this method is used to get count of total columns

    public int getColumncount() {

        int columncount = 0;
        try {
            row = sheet.getRow(0);
            columncount = row.getLastCellNum();

        } catch (Exception e) {
            System.out.println("the error occurred is as " + e.getMessage());
            e.printStackTrace();
        }
        return columncount;
    }
 }


