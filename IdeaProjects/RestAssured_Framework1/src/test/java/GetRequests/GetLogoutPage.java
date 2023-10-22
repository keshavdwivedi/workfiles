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

public class GetLogoutPage {

  String path1="/Authentication/Account/Logout";

    Map<String,String> LogoutParams = new HashMap<>();

    Response response;

    public void setLogoutParams(Map<String,String>logoutParams){
        logoutParams.put("logoutId","CfDJ8HlrO4VBw5ZGh72ZUnhKAEGG3cYEZ0TqDx7iwHUaF9skAmjNmHPCm0gHajGrU1IyStxkaK3bOVq1Lx29w8sRMr5-6oC0Pi1lAgTOWZQmy2upXLU5AWizxbkh6cAprwDlHOMjt8I5cNXlP0HnXtFTcsBrUOMEbDU3UhZod1dWALunDRGRc21Gwz_fH5DdjOVCyyLbgz0CciRwchRugk9s5z395ZGmrbZmiyHAtfFK26zSsQMTqan5y92hp7VgoXD2RKQplAT9d3KpRI-T1QYObNX4BwCpKOVnUeCZknruMgBfLHxgI84iwVuiQeaR9UFcHB40V-h1b9Um2Co4dU70thdNkNwloqYy-jcWlSYpgzyfeIK3gBrKxH0Z-E9hP9VmZHyxihqPWoKItwB4BTQ5WGPTk2NnnklMrlqbgENKOs_amLhV1QGnEPkliRpAUCFgY0RXXy9PqXrsVW0tCRb1d1o");
        logoutParams.put("sid","5960C83D7171D2E195656984DE09DA62");
        logoutParams.put("iss","https%3A%2F%2Fuatidentity.landscapecrm.com");
        this.LogoutParams=logoutParams;
    }

    public Map<String,String> getLogoutParams(){
        return LogoutParams;
    }

    @BeforeClass
    public void callGetLogoutRequest(){
        setLogoutParams(LogoutParams);
        response= GetRequestUtils.performGetRequestWithParameters(BaseUtils.getLogoutEndpoint("qa"),path1,getLogoutParams(),BaseUtils.getHeaderValues());
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
        Assert.assertEquals(xmlPath.getString("html.head.title"),"Authentication Account Logout");
    }

    @Test(priority = 8)
    public void getDistributorPageRequest_checkMainResponseHeading() {
        Assert.assertTrue(response.getBody().asString().contains("Landscape CRM User Portal"));
    }





}
