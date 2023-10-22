package RestAssuredUtils;

import JsonReadUtils.ReadJson;

import java.util.HashMap;
import java.util.Map;

public class BaseUtils extends GetRequestsHeaderUtils {

    static Map<String,Object> jsonData=new HashMap<>();

    public static String getEndpoint(String env){

        jsonData= ReadJson.getJsonDataAsMap("EnvFiles/"+env+"/UAPortalQA.json");
        return (String) jsonData.get("baseURI");
    }

    public static String getLogoutEndpoint(String env){

        jsonData= ReadJson.getJsonDataAsMap("EnvFiles/"+env+"/UAPortalQA.json");
        return (String) jsonData.get("LogoutBaseURI");
    }

    public static String getPortalEndpoint(String env){
        jsonData= ReadJson.getJsonDataAsMap("EnvFiles/"+env+"/UAPortalQA.json");
        return (String) jsonData.get("PortalBaseURI");

    }

}
