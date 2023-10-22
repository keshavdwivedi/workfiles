package com.Singleton.DataSetup;

import org.testng.annotations.DataProvider;

//this class defines all the dataproviders

public class ExcelDataProviders {

    DataProviderConfig config=new DataProviderConfig();

    @DataProvider(name = "SignupData")
    public Object[][] createinvalidsignupdata()
    {

        Object data[][]=config.fetchSheetData(System.getProperty("user.dir")+"/appconfig/Testdata.xlsx","Dataset");
        return data;
    }
    
    @DataProvider(name = "ValidSignupData")
    public Object[][] createvalidsignupdata()
    {

        Object data[][]=config.fetchSheetData(System.getProperty("user.dir")+"/appconfig/Testdata.xlsx","Validset");
        return data;
    }

}
