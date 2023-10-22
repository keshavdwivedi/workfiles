package com.parellelFramework.testDataSetup;

public class DataProviderReader {

    //custom method to fetch call getcelldata() method which fetch data values from excel file.

    public Object[][] fetchSheetData(String workbookpath, String sheetName) {
        ReadExcelUtility excelobj = new ReadExcelUtility(workbookpath, sheetName);
        int totalrow = excelobj.getRowcount();
        int totalcolumn = excelobj.getColumncount();
        Object[][] data = new Object[totalrow - 1][totalcolumn];
        for (int i = 1; i < totalrow; i++) {
            for (int j = 0; j < totalcolumn; j++) {
                String celldata = excelobj.getcellData(sheetName, i, j);
                System.out.print(celldata + " | ");
                data[i - 1][j] = celldata;
            }
            System.out.println();
        }

        return data;
    }

}
