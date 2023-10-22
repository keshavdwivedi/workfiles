package DataReaderSetup;

import org.testng.annotations.DataProvider;

//this class defines all the dataproviders

public class ExcelDataProviders {

    DataProviderConfig config=new DataProviderConfig();

    @DataProvider(name = "LoginData")
    public Object[][] createdata()
    {

        Object data[][]=config.fetchSheetData(System.getProperty("user.dir")+"/DataFiles/Data.xlsx","Login");
        return data;
    }

}
