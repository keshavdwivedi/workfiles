package GetRequests;

import RestAssuredUtils.BaseUtils;
import RestAssuredUtils.GetRequestUtils;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.*;

public class GetCheckSettings {


    String path="/Account/InitialLogIn/CheckSettings.aspx";

    Response response;

    @BeforeClass
    public void callGetCheckedSettingRequest(){
        BaseUtils.setHeaderValues(BaseUtils.getHeaderValues());
        response= GetRequestUtils.performSimpleGetRequest(BaseUtils.getEndpoint("qa"),path,BaseUtils.getHeaderValues());
    }

    @Test(priority = 1)
    public void getCheckedSettingsRequest(){


        System.out.println("Response is :- " +response.then().extract().body().asPrettyString());
        Assert.assertFalse(response.then().extract().body().asPrettyString().isEmpty());

    }

    @Test(priority = 2)
    public void getCheckedSetting_checkResponseTime(){
        System.out.println("Response time :- "+response.getTimeIn(TimeUnit.MILLISECONDS));
        response.then().time(lessThan(5000L)); //hamcrest assertion for response time
    }

    @Test(priority = 3)
    public void getCheckedSetting_checkStatusCode(){
        Assert.assertEquals(response.getStatusCode(),200);
        //hamcrest assertion response.then().statusCode(is(200));
    }

    @Test(priority = 4)
    public void getCheckedSetting_checkResponseStatusLine(){
       Assert.assertEquals(response.then().extract().statusLine(),"HTTP/1.1 200 OK");
    }

    @Test(priority = 5)
    public void getCheckedSetting_checkHeaderContents(){
        Assert.assertEquals(response.getHeader("Content-Encoding"),"gzip");
        Assert.assertEquals(response.getHeader("Connection"),"keep-alive");
    }

    @Test(priority = 6)
    public void getCheckedSetting_checkContentType(){
        Assert.assertTrue(response.getContentType().contains("text/html; charset=utf-8"));
    }

    @Test(priority = 7)
    public void getCheckedSetting_checkResponseTitleText(){
        XmlPath xmlPath=new XmlPath(XmlPath.CompatibilityMode.HTML,response.getBody().asString());
        Assert.assertEquals(xmlPath.getString("html.head.title"),"Authentication Account Login");
    }

    @Test(priority = 8)
    public void getCheckedSetting_checkMainResponseHeading(){
        Assert.assertTrue(response.getBody().asString().contains("Landscape CRM User Portal"));
    }

}













/*get all headers in response
        Headers headers=response.getHeaders();

        for (Header header:headers)
        {
            System.out.println("Key is :-"+header.getName() + " Value is :-"+header.getValue());
        }*/
