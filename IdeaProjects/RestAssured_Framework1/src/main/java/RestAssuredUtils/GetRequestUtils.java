package RestAssuredUtils;

import static io.restassured.RestAssured.*;
import ReportingSetup.ReportSetup;
import ReportingSetup.ReportingUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import java.util.Map;

public class GetRequestUtils {

    public static RequestSpecification getRequestRequestSpecification(String endPoint,String path,Map<String,String>headers){
        return given().baseUri(endPoint).basePath(path).headers(headers).contentType(ContentType.HTML).when();
    }

    private static void printRequestLogs(RequestSpecification specification){
        QueryableRequestSpecification queryableRequestSpecification= SpecificationQuerier.query(specification);
        ReportingUtils.logInfoDetails("Endpoint is " + queryableRequestSpecification.getBaseUri());
        ReportingUtils.logInfoDetails("Headers is " +queryableRequestSpecification.getHeaders().asList().toString());
    }

    private static void printResponseLogs(Response response){

        ReportingUtils.logInfoDetails("Response status is " + response.getStatusCode());
        ReportingUtils.logInfoDetails("Response Headers is " + response.getHeaders().asList().toString());
        ReportingUtils.logInfoDetails("Response body is " + response.getBody());

    }

    public static Response performGetRequestWithParameters(String endPoint, String path, Map<String,String> queryParameters,Map<String,String>headers){
        RequestSpecification specification=getRequestRequestSpecification(endPoint,path,headers);
        Response response=specification.queryParams(queryParameters).get();
        //printRequestLoginReport(specification);
        printResponseLogs(response);
        return response;
    }

    public static Response performSimpleGetRequest(String endPoint, String path,Map<String,String>headers){
        RequestSpecification specification=getRequestRequestSpecification(endPoint,path,headers);
        Response response=specification.get();
       // printRequestLoginReport(requestSpecification);
        printResponseLogs(response);
        return response;
    }

}
