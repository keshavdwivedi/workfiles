package GetRequests;

import RestAssuredUtils.BaseUtils;
import RestAssuredUtils.GetRequestUtils;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class GetDistributorStatusPage {

    String path="/App_WebServices/Private/PortalServices.asmx/Set_DistributorStatus";

    Map<String,String> DistributorParams = new HashMap<>();
    Response response;

    public void setDistributorParams(Map<String,String>distributorParams){
        distributorParams.put("newHookStatus","2");
        distributorParams.put("currentHookStatus","2");
        distributorParams.put("currentCallStatus","1");
        distributorParams.put("pauseDistributor","False");
        distributorParams.put("appRelativeVirtualPath","%2FPages%2FLeads%2FCustomer%2520Record%2FCustomer%2520Record.aspx");
        this.DistributorParams=distributorParams;
    }

    public Map<String,String> getDistributorParams(){
        return DistributorParams;
    }

    @BeforeClass
    public void getDistributorPageRequest(){
        setDistributorParams(DistributorParams);
        response=GetRequestUtils.performGetRequestWithParameters(BaseUtils.getEndpoint("qa"),path,getDistributorParams(),BaseUtils.getHeaderValues());
    }

    @Test(priority = 1)
    public void getDistributorPageRequest_checkResponse() {
        System.out.println("response body is:- " + response.then().extract().body().asPrettyString());
        response.then().assertThat().body(notNullValue()).assertThat().body(not(emptyArray())); //hamcrest assertion that response body is not null and not empty
    }

    @Test(priority = 2)
    public void getDistributorPageRequest_checkResponseTime() {
        System.out.println("Response time :- " + response.getTimeIn(TimeUnit.MILLISECONDS));
        response.then().time(lessThan(5000L)); //hamcrest assertion for response time
    }

    @Test(priority = 3)
    public void getDistributorPageRequest_checkStatusCode() {
        response.then().statusCode(is(200));  //hamcrest assertion for response code to be 200
    }

    @Test(priority = 4)
    public void getDistributorPageRequest_checkResponseStatusLine() {
        response.then().statusLine(equalTo("HTTP/1.1 200 OK"));
    }

    @Test(priority = 5)
    public void getDistributorPageRequest_checkHeaderContents() {
        Assert.assertEquals(response.getHeader("Transfer-Encoding"), "chunked");
        Assert.assertEquals(response.getHeader("Content-Encoding"),"gzip");
        Assert.assertEquals(response.header("Access-Control-Allow-Credentials"),"true");
        Assert.assertTrue(response.then().extract().header("Vary").contains("Accept-Encoding"));
        Assert.assertTrue(response.header("Connection").contains("keep-alive"));
        Assert.assertTrue(response.getHeader("Request-Context").contains("appId=cid-v1:d987498e"));
        Assert.assertTrue(response.getHeader("Content-Security-Policy").contains("base-uri 'self';block-all-mixed-content;default-src 'self' data: https: 'unsafe-inline' 'unsafe-eval'  https://*.landscapecrm.com "));
    }

    @Test(priority = 6)
    public void getDistributorPageRequest_checkContentType(){
        Assert.assertTrue(response.then().extract().contentType().contentEquals("text/html; charset=utf-8"));
    }

    @Test(priority = 7)
    public void getDistributorPageRequest_checkResponseTitleText(){
        XmlPath xmlPath=new XmlPath(XmlPath.CompatibilityMode.HTML,response.getBody().asString());
        Assert.assertEquals(xmlPath.getString("html.head.title"),"Authentication Account Login");
    }

    @Test(priority = 8)
    public void getDistributorPageRequest_checkMainResponseHeading() {
        Assert.assertTrue(response.getBody().asString().contains("Landscape CRM User Portal"));
    }

}
