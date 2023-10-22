package com.parellelFramework.testDataSetup;

import org.testng.annotations.DataProvider;

public class DataProvidersList {

    DataProviderReader dataProviderReader=new DataProviderReader();

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider(){

        return dataProviderReader.fetchSheetData(System.getProperty("user.dir")+"/src/main/resources/TestData/data.xlsx","Logindata");
    }

    @DataProvider(name = "registerData")
    public Object[][] registerDataProvider(){
        return dataProviderReader.fetchSheetData(System.getProperty("user.dir")+"/src/main/resources/TestData/data.xlsx","RegisterData");
    }
 }
