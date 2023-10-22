package GetRequests;

import RestAssuredUtils.BaseUtils;
import RestAssuredUtils.GetRequestUtils;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class GetAuthorizeClientID {
    String path="";
    Response response;

    Map<String,String> params = new HashMap<>();

    public void setParamValues(Map<String,String>params){
        params.put("client_id", "5631FFD7-490A-4BE7-B1E4-54EC0212DC3A");
        params.put("redirect_uri", "https%3A%2F%2Fuatportal.landscapecrm.com%2FAccount%2FInitialLogIn%2FCheckSettings.aspx");
        params.put("response_type","id_token");
        params.put("scope","openid%20profile");
        params.put("state","OpenIdConnect.AuthenticationProperties%3DSFiYfmGZMPdD3kMuxpcKTcUUhoPQah8bGcVR3fCk7y1NNVqz0M5TBXDF6BBIvmN8iutJkDsiZ8UTgzTeZmxWR9sJSz9E72Lh7qQR0gNhNrZQHTbRyiICHWKVF-OKHkLK48q8PcfFa8lzUBXHUQKQCublFoKzxUYj_3MZUo1dsg9ojen25WnPDiHTR1AJwtoSn1UCEF6BnbvV5kDi6bFb4TUFpezdOSkpqantMaYOuuceaxtdBYJgqoCf30LREuXJVsb6HxHiVMX-3awjqhDbqsow9EEgc9GI_ks1_WDvzt9oK2_IubfJ8VjFXFWacf5bFylGww");
        params.put("response_mode","form_post");
        params.put("nonce","638155766718430458.ZjMxY2JjODctMmQyYS00NjE4LTk2YjAtN2Q4MDg3ODI0ZTJiMTQwYTNhZDctMzUzZi00NTkxLWE4NjctNjIwYzY1ZDU5NmFj");
        params.put("x-client-SKU","ID_NET472");
        params.put("x-client-ver","6.25.1.0");
        this.params=params;
    }

    public Map<String, String> getParamsValues(){
        return params;
    }

    @BeforeClass
    public void getClientIdRequest(){
        setParamValues(params);
        response=GetRequestUtils.performGetRequestWithParameters(BaseUtils.getEndpoint("qa"),path,getParamsValues(),BaseUtils.getHeaderValues());

    }

    @Test(priority = 1)
    public void getClientIdRequest_checkResponse(){
        System.out.println("response body is:- " +response.then().extract().body().asPrettyString());
        response.then().assertThat().body(notNullValue()).assertThat().body(not(emptyArray())); //hamcrest assertion that response body is not null and not empty
    }

    @Test(priority = 2)
    public void getClientIdRequest_checkResponseTime(){
        System.out.println("Response time :- "+response.getTimeIn(TimeUnit.MILLISECONDS));
        response.then().time(lessThan(5000L)); //hamcrest assertion for response time
    }

    @Test(priority = 3)
    public void getClientIdRequest_checkStatusCode(){
        response.then().statusCode(is(200));  //hamcrest assertion for response code to be 200
    }

    @Test(priority = 4)
    public void getClientIdRequest_checkResponseStatusLine(){
       response.then().statusLine(equalTo("HTTP/1.1 200 OK"));
    }

    @Test(priority = 5)
    public void getClientIdRequest_checkHeaderContents(){
        Assert.assertEquals(response.getHeader("Content-Encoding"),"gzip");
        Assert.assertTrue(response.getHeader("Request-Context").contains("appId=cid-v1:d987498e"));
        Assert.assertTrue(response.then().extract().header("X-Content-Type-Options").contentEquals("nosniff"));
        Assert.assertTrue(response.then().extract().header("Vary").contains("Accept-Encoding"));
    }

    @Test(priority = 6)
    public void getClientIdRequest_checkContentType(){
        Assert.assertTrue(response.then().extract().contentType().contentEquals("text/html; charset=utf-8"));
    }

    @Test(priority = 7)
    public void getClientIdRequest_checkResponseTitleText(){
        XmlPath xmlPath=new XmlPath(XmlPath.CompatibilityMode.HTML,response.getBody().asString());
        Assert.assertEquals(xmlPath.getString("html.head.title"),"Authentication Account Login");
    }

    @Test(priority = 8)
    public void getClientIdRequest_checkMainResponseHeading(){
        Assert.assertTrue(response.getBody().asString().contains("Landscape CRM User Portal"));
    }

}
