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

public class GetCalendarEventPage {

    String path = "/Pages/Leads/Idle/CalendarEvents/Calendar_Events.aspx";
    Response response;

    @BeforeClass
    public void getCalendarEventRequest() {

        BaseUtils.setHeaderValues(BaseUtils.getHeaderValues());
        response = GetRequestUtils.performSimpleGetRequest(BaseUtils.getEndpoint("qa"), path, BaseUtils.getHeaderValues());
    }

    @Test(priority = 1)
    public void getCalendarEventRequest_checkResponse() {
        System.out.println("response body is:- " + response.then().extract().body().asPrettyString());
        response.then().assertThat().body(notNullValue()).assertThat().body(not(emptyArray())); //hamcrest assertion that response body is not null and not empty
    }

    @Test(priority = 2)
    public void getCalendarEventRequest_checkResponseTime() {
        System.out.println("Response time :- " + response.getTimeIn(TimeUnit.MILLISECONDS));
        response.then().time(lessThan(5000L)); //hamcrest assertion for response time
    }


    @Test(priority = 3)
    public void getCalendarEventRequest_checkStatusCode() {
        response.then().statusCode(is(200));  //hamcrest assertion for response code to be 200
    }

    @Test(priority = 4)
    public void getCalendarEventRequest_checkResponseStatusLine() {
        response.then().statusLine(equalTo("HTTP/1.1 200 OK"));
    }

    @Test(priority = 5)
    public void getCalendarEventRequest_checkHeaderContents() {
        Assert.assertEquals(response.getHeader("Content-Encoding"), "gzip");
        Assert.assertTrue(response.header("Connection").contains("keep-alive"));
        Assert.assertEquals(response.header("Access-Control-Allow-Credentials"),"true");
        Assert.assertTrue(response.getHeader("Request-Context").contains("appId=cid-v1:d987498e"));
        Assert.assertTrue(response.getHeader("Content-Security-Policy").contains("base-uri 'self';block-all-mixed-content;default-src 'self' data: https: 'unsafe-inline' 'unsafe-eval'  https://*.landscapecrm.com "));
    }

    @Test(priority = 6)
        public void getCalendarEventRequest_checkContentType(){
            Assert.assertTrue(response.then().extract().contentType().contentEquals("text/html; charset=utf-8"));
        }

    @Test(priority = 7)
     public void getCalendarEventRequest_checkResponseTitleText(){
        XmlPath xmlPath=new XmlPath(XmlPath.CompatibilityMode.HTML,response.getBody().asString());
        Assert.assertEquals(xmlPath.getString("html.head.title"),"Authentication Account Login");
      }

      @Test(priority = 8)
          public void getCalendarEventRequest_checkMainResponseHeading() {
          Assert.assertTrue(response.getBody().asString().contains("Landscape CRM User Portal"));
      }
}

