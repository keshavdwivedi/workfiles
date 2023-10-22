package GetRequests;

import RestAssuredUtils.BaseUtils;
import RestAssuredUtils.GetRequestUtils;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.lessThan;

public class GetPortalPage {

    String path="/Pages/Portal.aspx";
    Response response;

    @BeforeClass
    public void getPortalPageRequest(){

        BaseUtils.setHeaderValues(BaseUtils.getHeaderValues());
        response= GetRequestUtils.performSimpleGetRequest(BaseUtils.getPortalEndpoint("qa"),path,BaseUtils.getHeaderValues());
    }

    @Test(priority = 1)
    public void getCustomerParamsRequest(){


        System.out.println("Response is :- " +response.then().extract().body().asPrettyString());
        Assert.assertFalse(response.then().extract().body().asPrettyString().isEmpty());

    }

    @Test(priority = 2)
    public void getCustomerRequest_checkResponseTime(){
        System.out.println("Response time :- "+response.getTimeIn(TimeUnit.MILLISECONDS));
        response.then().time(lessThan(5000L)); //hamcrest assertion for response time
    }

    @Test(priority = 3)
    public void getCustomerRequest_checkStatusCode(){
        Assert.assertEquals(response.getStatusCode(),200);
        //hamcrest assertion response.then().statusCode(is(200));
    }

    @Test(priority = 4)
    public void getCustomerRequest_checkResponseStatusLine(){
        Assert.assertEquals(response.then().extract().statusLine(),"HTTP/1.1 200 OK");
    }

    @Test(priority = 5)
    public void getCheckedSetting_checkHeaderContents(){
        Assert.assertEquals(response.getHeader("Content-Encoding"),"gzip");
        Assert.assertTrue(response.getHeader("Request-Context").contains("appId=cid-v1:d987498e"));
        Assert.assertTrue(response.then().extract().header("X-Content-Type-Options").contentEquals("nosniff"));
        Assert.assertTrue(response.header("Referrer-Policy").contains("no-referrer"));
        Assert.assertTrue(response.then().extract().header("Vary").contains("Accept-Encoding"));
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
    public void getCalendarEventRequest_checkMainResponseHeading() {
        Assert.assertTrue(response.getBody().asString().contains("Landscape CRM User Portal"));
    }

}
