package com.Hybrid_framework.DataSetup;

import org.testng.annotations.DataProvider;

//this class defines all the dataproviders

public class ExcelDataProviders {

    DataProviderConfig config=new DataProviderConfig();

    @DataProvider(name = "LoginData")
    public Object[][] createdata()
    {

        Object data[][]=config.fetchSheetData(System.getProperty("user.dir")+"/TestData/Data.xlsx","Login");
        return data;
    }
    
    @DataProvider(name = "PlacesData")
    public Object[][] createplacesData()
    {

        Object data[][]=config.fetchSheetData(System.getProperty("user.dir")+"/TestData/Data.xlsx","Places");
        return data;
    }

}
